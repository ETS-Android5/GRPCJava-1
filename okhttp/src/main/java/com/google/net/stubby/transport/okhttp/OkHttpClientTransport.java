package com.google.net.stubby.transport.okhttp;

import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import com.google.net.stubby.Metadata;
import com.google.net.stubby.MethodDescriptor;
import com.google.net.stubby.Status;
import com.google.net.stubby.transport.AbstractClientTransport;
import com.google.net.stubby.transport.ClientStream;
import com.google.net.stubby.transport.ClientStreamListener;
import com.google.net.stubby.transport.ClientTransport;

import com.squareup.okhttp.internal.spdy.ErrorCode;
import com.squareup.okhttp.internal.spdy.FrameReader;
import com.squareup.okhttp.internal.spdy.Header;
import com.squareup.okhttp.internal.spdy.HeadersMode;
import com.squareup.okhttp.internal.spdy.Http20Draft14;
import com.squareup.okhttp.internal.spdy.Settings;
import com.squareup.okhttp.internal.spdy.Variant;

import okio.Buffer;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.ByteString;
import okio.Okio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;

import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;

/**
 * A okhttp-based {@link ClientTransport} implementation.
 */
public class OkHttpClientTransport extends AbstractClientTransport {
  /** The default initial window size in HTTP/2 is 64 KiB for the stream and connection. */
  @VisibleForTesting
  static final int DEFAULT_INITIAL_WINDOW_SIZE = 64 * 1024;

  private static final Map<ErrorCode, Status> ERROR_CODE_TO_STATUS;
  static {
    Map<ErrorCode, Status> errorToStatus = new HashMap<ErrorCode, Status>();
    errorToStatus.put(ErrorCode.NO_ERROR, Status.OK);
    errorToStatus.put(ErrorCode.PROTOCOL_ERROR,
        Status.INTERNAL.withDescription("Protocol error"));
    errorToStatus.put(ErrorCode.INVALID_STREAM,
        Status.INTERNAL.withDescription("Invalid stream"));
    errorToStatus.put(ErrorCode.UNSUPPORTED_VERSION,
        Status.INTERNAL.withDescription("Unsupported version"));
    errorToStatus.put(ErrorCode.STREAM_IN_USE,
        Status.INTERNAL.withDescription("Stream in use"));
    errorToStatus.put(ErrorCode.STREAM_ALREADY_CLOSED,
        Status.INTERNAL.withDescription("Stream already closed"));
    errorToStatus.put(ErrorCode.INTERNAL_ERROR,
        Status.INTERNAL.withDescription("Internal error"));
    errorToStatus.put(ErrorCode.FLOW_CONTROL_ERROR,
        Status.INTERNAL.withDescription("Flow control error"));
    errorToStatus.put(ErrorCode.STREAM_CLOSED,
        Status.INTERNAL.withDescription("Stream closed"));
    errorToStatus.put(ErrorCode.FRAME_TOO_LARGE,
        Status.INTERNAL.withDescription("Frame too large"));
    errorToStatus.put(ErrorCode.REFUSED_STREAM,
        Status.INTERNAL.withDescription("Refused stream"));
    errorToStatus.put(ErrorCode.CANCEL, Status.CANCELLED.withDescription("Cancelled"));
    errorToStatus.put(ErrorCode.COMPRESSION_ERROR,
        Status.INTERNAL.withDescription("Compression error"));
    errorToStatus.put(ErrorCode.INVALID_CREDENTIALS,
        Status.PERMISSION_DENIED.withDescription("Invalid credentials"));
    ERROR_CODE_TO_STATUS = Collections.unmodifiableMap(errorToStatus);
  }

  private final InetSocketAddress address;
  private final String defaultAuthority;
  private FrameReader frameReader;
  private AsyncFrameWriter frameWriter;
  private OutboundFlowController outboundFlow;
  private final Object lock = new Object();
  @GuardedBy("lock")
  private int nextStreamId;
  private final Map<Integer, OkHttpClientStream> streams =
      Collections.synchronizedMap(new HashMap<Integer, OkHttpClientStream>());
  private final Executor executor;
  private int connectionUnacknowledgedBytesRead;
  private ClientFrameHandler clientFrameHandler;
  // The status used to finish all active streams when the transport is closed.
  @GuardedBy("lock")
  private boolean goAway;
  @GuardedBy("lock")
  private Status goAwayStatus;
  @GuardedBy("lock")
  private boolean stopped;

  OkHttpClientTransport(InetSocketAddress address, Executor executor) {
    this.address = Preconditions.checkNotNull(address);
    defaultAuthority = address.getHostString() + ":" + address.getPort();
    this.executor = Preconditions.checkNotNull(executor);
    // Client initiated streams are odd, server initiated ones are even. Server should not need to
    // use it. We start clients at 3 to avoid conflicting with HTTP negotiation.
    nextStreamId = 3;
  }

  /**
   * Create a transport connected to a fake peer for test.
   */
  @VisibleForTesting
  OkHttpClientTransport(Executor executor, FrameReader frameReader, AsyncFrameWriter frameWriter,
      int nextStreamId) {
    address = null;
    defaultAuthority = "notarealauthority:80";
    this.executor = Preconditions.checkNotNull(executor);
    this.frameReader = Preconditions.checkNotNull(frameReader);
    this.frameWriter = Preconditions.checkNotNull(frameWriter);
    this.outboundFlow = new OutboundFlowController(this, frameWriter);
    this.nextStreamId = nextStreamId;
  }

  @Override
  protected ClientStream newStreamInternal(MethodDescriptor<?, ?> method,
                                           Metadata.Headers headers,
                                           ClientStreamListener listener) {
    OkHttpClientStream clientStream = OkHttpClientStream.newStream(executor, listener,
        frameWriter, this, outboundFlow);
    if (goAway) {
      clientStream.transportReportStatus(goAwayStatus, new Metadata.Trailers());
    } else {
      assignStreamId(clientStream);
    }
    String defaultPath = "/" + method.getName();
    frameWriter.synStream(false, false, clientStream.id(), 0,
        Headers.createRequestHeaders(headers, defaultPath, defaultAuthority));
    return clientStream;
  }

  @Override
  protected void doStart() {
    // We set host to null for test.
    if (address != null) {
      BufferedSource source;
      BufferedSink sink;
      try {
        Socket socket = new Socket(address.getAddress(), address.getPort());
        source = Okio.buffer(Okio.source(socket));
        sink = Okio.buffer(Okio.sink(socket));
      } catch (IOException e) {
        throw new RuntimeException(e);
      }
      Variant variant = new Http20Draft14();
      frameReader = variant.newReader(source, true);
      frameWriter = new AsyncFrameWriter(variant.newWriter(sink, true), this, executor);
      outboundFlow = new OutboundFlowController(this, frameWriter);
      frameWriter.connectionPreface();
      Settings settings = new Settings();
      frameWriter.settings(settings);
    }

    clientFrameHandler = new ClientFrameHandler();
    executor.execute(clientFrameHandler);
    notifyStarted();
  }

  @Override
  protected void doStop() {
    boolean normalClose;
    synchronized (lock) {
      normalClose = !goAway;
    }
    if (normalClose) {
      // Send GOAWAY with lastGoodStreamId of 0, since we don't expect any server-initiated streams.
      // The GOAWAY is part of graceful shutdown.
      frameWriter.goAway(0, ErrorCode.NO_ERROR, new byte[0]);

      onGoAway(0, Status.INTERNAL.withDescription("Transport stopped"), null);
    }
    stopIfNecessary();
  }

  @VisibleForTesting
  ClientFrameHandler getHandler() {
    return clientFrameHandler;
  }

  Map<Integer, OkHttpClientStream> getStreams() {
    return streams;
  }

  /**
   * Finish all active streams due to a failure, then close the transport.
   */
  void abort(Throwable failureCause) {
    onGoAway(0, Status.fromThrowable(failureCause), failureCause);
  }

  private void onGoAway(int lastKnownStreamId, Status status, @Nullable Throwable failureCause) {
    ArrayList<OkHttpClientStream> goAwayStreams = new ArrayList<OkHttpClientStream>();
    synchronized (lock) {
      goAway = true;
      goAwayStatus = status;
      synchronized (streams) {
        Iterator<Map.Entry<Integer, OkHttpClientStream>> it = streams.entrySet().iterator();
        while (it.hasNext()) {
          Map.Entry<Integer, OkHttpClientStream> entry = it.next();
          if (entry.getKey() > lastKnownStreamId) {
            goAwayStreams.add(entry.getValue());
            it.remove();
          }
        }
      }
    }

    // Starting stop, go into STOPPING state so that Channel knows this Transport should not be used
    // further, will become STOPPED once all streams are complete, or become FAILED immediately if
    // the transport is aborted by some error.
    State state = state();
    if (state == State.RUNNING || state == State.NEW) {
      if (failureCause != null) {
        notifyFailed(failureCause);
      } else {
        stopAsync();
      }
    }

    for (OkHttpClientStream stream : goAwayStreams) {
      stream.transportReportStatus(status, new Metadata.Trailers());
    }
  }

  /**
   * Called when a stream is closed.
   *
   * <p> Return false if the stream has already finished.
   */
  boolean finishStream(int streamId, @Nullable Status status) {
    OkHttpClientStream stream;
    stream = streams.remove(streamId);
    if (stream != null) {
      if (status != null) {
        stream.transportReportStatus(status, new Metadata.Trailers());
      }
      return true;
    }
    return false;
  }

  /**
   * When the transport is in goAway states, we should stop it once all active streams finish.
   */
  void stopIfNecessary() {
    boolean shouldStop;
    synchronized (lock) {
      shouldStop = (goAway && streams.size() == 0);
      if (shouldStop) {
        if (stopped) {
          // We've already stopped, don't stop again.
          shouldStop = false;
        }
        stopped = true;
      }
    }
    if (shouldStop) {
      // Wait for the frame writer to close.
      frameWriter.close();
      try {
        frameReader.close();
      } catch (IOException e) {
        throw new RuntimeException(e);
      }
      notifyStopped();
    }
  }

  /**
   * Returns a Grpc status corresponding to the given ErrorCode.
   */
  @VisibleForTesting
  static Status toGrpcStatus(ErrorCode code) {
    return ERROR_CODE_TO_STATUS.get(code);
  }

  /**
   * Runnable which reads frames and dispatches them to in flight calls
   */
  @VisibleForTesting
  class ClientFrameHandler implements FrameReader.Handler, Runnable {
    ClientFrameHandler() {}

    @Override
    public void run() {
      String threadName = Thread.currentThread().getName();
      Thread.currentThread().setName("OkHttpClientTransport");
      try {
        // Read until the underlying socket closes.
        while (frameReader.nextFrame(this)) {
        }
      } catch (IOException ioe) {
        abort(ioe);
      } finally {
        // Restore the original thread name.
        Thread.currentThread().setName(threadName);
      }
    }

    /**
     * Handle a HTTP2 DATA frame
     */
    @Override
    public void data(boolean inFinished, int streamId, BufferedSource in, int length)
        throws IOException {
      final OkHttpClientStream stream;
      stream = streams.get(streamId);
      if (stream == null) {
        frameWriter.rstStream(streamId, ErrorCode.INVALID_STREAM);
        return;
      }

      // Wait until the frame is complete.
      in.require(length);

      Buffer buf = new Buffer();
      buf.write(in.buffer(), length);
      stream.transportDataReceived(buf, inFinished);

      // connection window update
      connectionUnacknowledgedBytesRead += length;
      if (connectionUnacknowledgedBytesRead >= DEFAULT_INITIAL_WINDOW_SIZE / 2) {
        frameWriter.windowUpdate(0, connectionUnacknowledgedBytesRead);
        connectionUnacknowledgedBytesRead = 0;
      }
    }

    /**
     * Handle HTTP2 HEADER and CONTINUATION frames
     */
    @Override
    public void headers(boolean outFinished,
        boolean inFinished,
        int streamId,
        int associatedStreamId,
        List<Header> headerBlock,
        HeadersMode headersMode) {
      OkHttpClientStream stream;
      stream = streams.get(streamId);
      if (stream == null) {
        frameWriter.rstStream(streamId, ErrorCode.INVALID_STREAM);
        return;
      }
      stream.transportHeadersReceived(headerBlock, inFinished);
    }

    @Override
    public void rstStream(int streamId, ErrorCode errorCode) {
      if (finishStream(streamId, toGrpcStatus(errorCode))) {
        stopIfNecessary();
      }
    }

    @Override
    public void settings(boolean clearPrevious, Settings settings) {
      // not impl
      try {
        frameWriter.ackSettings(settings);
      } catch (IOException e) {
        abort(e);
      }
    }

    @Override
    public void ping(boolean ack, int payload1, int payload2) {
      if (!ack) {
        frameWriter.ping(true, payload1, payload2);
      }
    }

    @Override
    public void ackSettings() {
      // Do nothing currently.
    }

    @Override
    public void goAway(int lastGoodStreamId, ErrorCode errorCode, ByteString debugData) {
      onGoAway(lastGoodStreamId, Status.UNAVAILABLE.withDescription("Go away"), null);
    }

    @Override
    public void pushPromise(int streamId, int promisedStreamId, List<Header> requestHeaders)
        throws IOException {
      // We don't accept server initiated stream.
      frameWriter.rstStream(streamId, ErrorCode.PROTOCOL_ERROR);
    }

    @Override
    public void windowUpdate(int streamId, long delta) {
      outboundFlow.windowUpdate(streamId, (int) delta);
    }

    @Override
    public void priority(int streamId, int streamDependency, int weight, boolean exclusive) {
      // Ignore priority change.
      // TODO(user): log
    }

    @Override
    public void alternateService(int streamId, String origin, ByteString protocol, String host,
        int port, long maxAge) {
      // TODO(user): Deal with alternateService propagation
    }
  }

  @GuardedBy("lock")
  private void assignStreamId(OkHttpClientStream stream) {
    Preconditions.checkState(stream.id() == null, "StreamId already assigned");
    stream.id(nextStreamId);
    streams.put(stream.id(), stream);
    if (nextStreamId >= Integer.MAX_VALUE - 2) {
      onGoAway(Integer.MAX_VALUE, Status.INTERNAL.withDescription("Stream ids exhausted"), null);
    } else {
      nextStreamId += 2;
    }
  }
}
