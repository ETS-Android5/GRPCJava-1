// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: grpc/channelz/v1/channelz.proto

package io.grpc.channelz.v1;

public interface ChannelTraceEventOrBuilder extends
    // @@protoc_insertion_point(interface_extends:grpc.channelz.v1.ChannelTraceEvent)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <pre>
   * High level description of the event.
   * </pre>
   *
   * <code>string description = 1;</code>
   */
  java.lang.String getDescription();
  /**
   * <pre>
   * High level description of the event.
   * </pre>
   *
   * <code>string description = 1;</code>
   */
  com.google.protobuf.ByteString
      getDescriptionBytes();

  /**
   * <pre>
   * the severity of the trace event
   * </pre>
   *
   * <code>.grpc.channelz.v1.ChannelTraceEvent.Severity severity = 2;</code>
   */
  int getSeverityValue();
  /**
   * <pre>
   * the severity of the trace event
   * </pre>
   *
   * <code>.grpc.channelz.v1.ChannelTraceEvent.Severity severity = 2;</code>
   */
  io.grpc.channelz.v1.ChannelTraceEvent.Severity getSeverity();

  /**
   * <pre>
   * When this event occurred.
   * </pre>
   *
   * <code>.google.protobuf.Timestamp timestamp = 3;</code>
   */
  boolean hasTimestamp();
  /**
   * <pre>
   * When this event occurred.
   * </pre>
   *
   * <code>.google.protobuf.Timestamp timestamp = 3;</code>
   */
  com.google.protobuf.Timestamp getTimestamp();
  /**
   * <pre>
   * When this event occurred.
   * </pre>
   *
   * <code>.google.protobuf.Timestamp timestamp = 3;</code>
   */
  com.google.protobuf.TimestampOrBuilder getTimestampOrBuilder();

  /**
   * <code>.grpc.channelz.v1.ChannelRef channel_ref = 4;</code>
   */
  boolean hasChannelRef();
  /**
   * <code>.grpc.channelz.v1.ChannelRef channel_ref = 4;</code>
   */
  io.grpc.channelz.v1.ChannelRef getChannelRef();
  /**
   * <code>.grpc.channelz.v1.ChannelRef channel_ref = 4;</code>
   */
  io.grpc.channelz.v1.ChannelRefOrBuilder getChannelRefOrBuilder();

  /**
   * <code>.grpc.channelz.v1.SubchannelRef subchannel_ref = 5;</code>
   */
  boolean hasSubchannelRef();
  /**
   * <code>.grpc.channelz.v1.SubchannelRef subchannel_ref = 5;</code>
   */
  io.grpc.channelz.v1.SubchannelRef getSubchannelRef();
  /**
   * <code>.grpc.channelz.v1.SubchannelRef subchannel_ref = 5;</code>
   */
  io.grpc.channelz.v1.SubchannelRefOrBuilder getSubchannelRefOrBuilder();

  public io.grpc.channelz.v1.ChannelTraceEvent.ChildRefCase getChildRefCase();
}
