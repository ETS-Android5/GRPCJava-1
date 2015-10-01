/*
 * Copyright 2015, Google Inc. All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are
 * met:
 *
 *    * Redistributions of source code must retain the above copyright
 * notice, this list of conditions and the following disclaimer.
 *    * Redistributions in binary form must reproduce the above
 * copyright notice, this list of conditions and the following disclaimer
 * in the documentation and/or other materials provided with the
 * distribution.
 *
 *    * Neither the name of Google Inc. nor the names of its
 * contributors may be used to endorse or promote products derived from
 * this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
 * "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT
 * LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR
 * A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT
 * OWNER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL,
 * SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT
 * LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE,
 * DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY
 * THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
 * OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

package io.grpc.internal;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.isA;
import static org.mockito.Matchers.same;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.timeout;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

import io.grpc.CallOptions;
import io.grpc.Channel;
import io.grpc.ClientCall;
import io.grpc.ClientInterceptor;
import io.grpc.DecompressorRegistry;
import io.grpc.IntegerMarshaller;
import io.grpc.ManagedChannel;
import io.grpc.Metadata;
import io.grpc.MethodDescriptor;
import io.grpc.Status;
import io.grpc.StringMarshaller;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicLong;

/** Unit tests for {@link ManagedChannelImpl}. */
@RunWith(JUnit4.class)
public class ManagedChannelImplTest {
  private final MethodDescriptor<String, Integer> method = MethodDescriptor.create(
      MethodDescriptor.MethodType.UNKNOWN, "/service/method",
      new StringMarshaller(), new IntegerMarshaller());
  private final ExecutorService executor = Executors.newSingleThreadExecutor();

  @Mock
  private ClientTransport mockTransport;
  @Mock
  private ClientTransportFactory mockTransportFactory;
  private ManagedChannel channel;

  @Mock
  private ClientCall.Listener<Integer> mockCallListener;
  @Mock
  private ClientCall.Listener<Integer> mockCallListener2;
  @Mock
  private ClientCall.Listener<Integer> mockCallListener3;

  private ArgumentCaptor<ClientTransport.Listener> transportListenerCaptor =
      ArgumentCaptor.forClass(ClientTransport.Listener.class);
  private ArgumentCaptor<ClientStreamListener> streamListenerCaptor =
      ArgumentCaptor.forClass(ClientStreamListener.class);

  private void createChannel(List<ClientInterceptor> interceptors) throws Exception {
    channel = new ManagedChannelImpl(new FakeBackoffPolicyProvider(), mockTransportFactory,
        executor, null, interceptors);
  }

  @Before
  public void setUp() throws Exception {
    MockitoAnnotations.initMocks(this);
    createChannel(Collections.<ClientInterceptor>emptyList());
    when(mockTransportFactory.newClientTransport()).thenReturn(mockTransport);
  }

  @After
  public void tearDown() {
    executor.shutdownNow();
  }

  @Test
  public void immediateDeadlineExceeded() {
    ClientCall<String, Integer> call =
        channel.newCall(method, CallOptions.DEFAULT.withDeadlineNanoTime(System.nanoTime()));
    call.start(mockCallListener, new Metadata());
    verify(mockCallListener, timeout(1000)).onClose(
        same(Status.DEADLINE_EXCEEDED), any(Metadata.class));
  }

  @Test
  public void shutdownWithNoTransportsEverCreated() {
    verifyNoMoreInteractions(mockTransportFactory);
    channel.shutdown();
    assertTrue(channel.isShutdown());
    assertTrue(channel.isTerminated());
  }

  @Test
  public void twoCallsAndGracefulShutdown() {
    verifyNoMoreInteractions(mockTransportFactory);
    ClientCall<String, Integer> call = channel.newCall(method, CallOptions.DEFAULT);
    verifyNoMoreInteractions(mockTransportFactory);

    // Create transport and call
    ClientTransport mockTransport = mock(ClientTransport.class);
    ClientStream mockStream = mock(ClientStream.class);
    Metadata headers = new Metadata();
    when(mockTransportFactory.newClientTransport()).thenReturn(mockTransport);
    when(mockTransport.newStream(same(method), same(headers), any(ClientStreamListener.class)))
        .thenReturn(mockStream);
    call.start(mockCallListener, headers);
    verify(mockTransportFactory, timeout(1000)).newClientTransport();
    verify(mockTransport, timeout(1000)).start(transportListenerCaptor.capture());
    ClientTransport.Listener transportListener = transportListenerCaptor.getValue();
    verify(mockTransport, timeout(1000))
        .newStream(same(method), same(headers), streamListenerCaptor.capture());
    verify(mockStream).setDecompressionRegistry(isA(DecompressorRegistry.class));
    ClientStreamListener streamListener = streamListenerCaptor.getValue();

    // Second call
    ClientCall<String, Integer> call2 = channel.newCall(method, CallOptions.DEFAULT);
    ClientStream mockStream2 = mock(ClientStream.class);
    Metadata headers2 = new Metadata();
    when(mockTransport.newStream(same(method), same(headers2), any(ClientStreamListener.class)))
        .thenReturn(mockStream2);
    call2.start(mockCallListener2, headers2);
    verify(mockTransport, timeout(1000))
        .newStream(same(method), same(headers2), streamListenerCaptor.capture());
    ClientStreamListener streamListener2 = streamListenerCaptor.getValue();
    Metadata trailers = new Metadata();
    streamListener2.closed(Status.CANCELLED, trailers);
    verify(mockCallListener2, timeout(1000)).onClose(Status.CANCELLED, trailers);

    // Shutdown
    channel.shutdown();
    assertTrue(channel.isShutdown());
    assertFalse(channel.isTerminated());
    verify(mockTransport).shutdown();

    // Further calls should fail without going to the transport
    ClientCall<String, Integer> call3 = channel.newCall(method, CallOptions.DEFAULT);
    call3.start(mockCallListener3, new Metadata());
    ArgumentCaptor<Status> statusCaptor = ArgumentCaptor.forClass(Status.class);
    verify(mockCallListener3, timeout(1000))
        .onClose(statusCaptor.capture(), any(Metadata.class));
    assertSame(Status.Code.UNAVAILABLE, statusCaptor.getValue().getCode());

    // Finish shutdown
    transportListener.transportShutdown(Status.CANCELLED);
    assertFalse(channel.isTerminated());
    streamListener.closed(Status.CANCELLED, trailers);
    verify(mockCallListener, timeout(1000)).onClose(Status.CANCELLED, trailers);
    assertFalse(channel.isTerminated());

    transportListener.transportTerminated();
    assertTrue(channel.isTerminated());

    verify(mockTransportFactory).release();
    verifyNoMoreInteractions(mockTransportFactory);
    verifyNoMoreInteractions(mockTransport);
    verifyNoMoreInteractions(mockStream);
  }

  @Test
  public void transportFailsOnStart() {
    Status goldenStatus = Status.INTERNAL.withDescription("wanted it to fail");

    // mockTransport2 shuts immediately during start
    ClientCall<String, Integer> call = channel.newCall(method, CallOptions.DEFAULT);
    ClientTransport mockTransport2 = mock(ClientTransport.class);
    ClientStream mockStream2 = mock(ClientStream.class);
    Metadata headers2 = new Metadata();
    doAnswer(new Answer<Void>() {
      @Override
      public Void answer(InvocationOnMock invocation) {
        final ClientTransport.Listener listener =
            (ClientTransport.Listener) invocation.getArguments()[0];
        executor.execute(new Runnable() {
          @Override public void run() {
            listener.transportShutdown(Status.INTERNAL);
            listener.transportTerminated();
          }
        });
        return null;
      }
    }).when(mockTransport2).start(any(ClientTransport.Listener.class));
    when(mockTransport2.newStream(same(method), same(headers2), any(ClientStreamListener.class)))
        .thenReturn(mockStream2);
    // The factory returns the immediately shut-down transport first, then the normal one
    when(mockTransportFactory.newClientTransport()).thenReturn(mockTransport2, mockTransport);

    call.start(mockCallListener2, headers2);
    verify(mockTransportFactory, timeout(1000).times(2)).newClientTransport();
    verify(mockTransport2, timeout(1000)).start(any(ClientTransport.Listener.class));
    verify(mockTransport2, timeout(1000))
        .newStream(same(method), same(headers2), streamListenerCaptor.capture());
    verify(mockStream2).setDecompressionRegistry(isA(DecompressorRegistry.class));
    Metadata trailers2 = new Metadata();
    streamListenerCaptor.getValue().closed(Status.CANCELLED, trailers2);
    verify(mockCallListener2, timeout(1000)).onClose(Status.CANCELLED, trailers2);

    // The second call will go through on mockTransport
    call = channel.newCall(method, CallOptions.DEFAULT);
    ClientStream mockStream = mock(ClientStream.class);
    Metadata headers = new Metadata();
    when(mockTransport.newStream(same(method), same(headers), any(ClientStreamListener.class)))
        .thenReturn(mockStream);
    call.start(mockCallListener, headers);
    verify(mockTransport, timeout(1000)).start(transportListenerCaptor.capture());
    verify(mockTransport, timeout(1000))
        .newStream(same(method), same(headers), streamListenerCaptor.capture());
    verify(mockStream).setDecompressionRegistry(isA(DecompressorRegistry.class));
    Metadata trailers = new Metadata();
    streamListenerCaptor.getValue().closed(Status.CANCELLED, trailers);
    verify(mockCallListener, timeout(1000)).onClose(Status.CANCELLED, trailers);

    // Make sure shutdown still works
    channel.shutdown();
    assertTrue(channel.isShutdown());
    assertFalse(channel.isTerminated());
    verify(mockTransport).shutdown();
    transportListenerCaptor.getValue().transportShutdown(Status.CANCELLED);
    assertFalse(channel.isTerminated());

    transportListenerCaptor.getValue().transportTerminated();
    assertTrue(channel.isTerminated());

    verify(mockTransportFactory, times(2)).newClientTransport();
    verifyNoMoreInteractions(mockTransport);
    verifyNoMoreInteractions(mockTransport2);
    verifyNoMoreInteractions(mockStream2);
  }

  @Test
  public void interceptor() throws Exception {
    final AtomicLong atomic = new AtomicLong();
    ClientInterceptor interceptor = new ClientInterceptor() {
      @Override
      public <RequestT, ResponseT> ClientCall<RequestT, ResponseT> interceptCall(
          MethodDescriptor<RequestT, ResponseT> method, CallOptions callOptions,
          Channel next) {
        atomic.set(1);
        return next.newCall(method, callOptions);
      }
    };
    createChannel(Arrays.asList(interceptor));
    assertNotNull(channel.newCall(method, CallOptions.DEFAULT));
    assertEquals(1, atomic.get());
  }

  @Test
  public void testNoDeadlockOnShutdown() {
    // Force creation of transport
    ClientCall<String, Integer> call = channel.newCall(method, CallOptions.DEFAULT);
    Metadata headers = new Metadata();
    ClientStream mockStream = mock(ClientStream.class);
    when(mockTransport.newStream(same(method), same(headers), any(ClientStreamListener.class)))
        .thenReturn(mockStream);
    call.start(mockCallListener, headers);
    call.cancel();

    verify(mockTransport, timeout(1000)).start(transportListenerCaptor.capture());
    final ClientTransport.Listener transportListener = transportListenerCaptor.getValue();
    final Object lock = new Object();
    final CyclicBarrier barrier = new CyclicBarrier(2);
    new Thread() {
      @Override
      public void run() {
        synchronized (lock) {
          try {
            barrier.await();
          } catch (Exception ex) {
            throw new AssertionError(ex);
          }
          // To deadlock, a lock would be needed for this call to proceed.
          transportListener.transportShutdown(Status.CANCELLED);
        }
      }
    }.start();
    doAnswer(new Answer<Void>() {
      @Override
      public Void answer(InvocationOnMock invocation) {
        // To deadlock, a lock would need to be held while this method is in progress.
        try {
          barrier.await();
        } catch (Exception ex) {
          throw new AssertionError(ex);
        }
        // If deadlock is possible with this setup, this sychronization completes the loop because
        // the transportShutdown needs a lock that Channel is holding while calling this method.
        synchronized (lock) {
        }
        return null;
      }
    }).when(mockTransport).shutdown();
    channel.shutdown();

    transportListener.transportTerminated();
  }

  private static class FakeBackoffPolicyProvider implements BackoffPolicy.Provider {
    @Override
    public BackoffPolicy get() {
      return new BackoffPolicy() {
        @Override
        public long nextBackoffMillis() {
          return 1;
        }
      };
    }
  }
}
