// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: qpstest.proto

package io.grpc.testing;

public interface ClientConfigOrBuilder extends
    // @@protoc_insertion_point(interface_extends:grpc.testing.ClientConfig)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>repeated string server_targets = 1;</code>
   */
  com.google.protobuf.ProtocolStringList
      getServerTargetsList();
  /**
   * <code>repeated string server_targets = 1;</code>
   */
  int getServerTargetsCount();
  /**
   * <code>repeated string server_targets = 1;</code>
   */
  java.lang.String getServerTargets(int index);
  /**
   * <code>repeated string server_targets = 1;</code>
   */
  com.google.protobuf.ByteString
      getServerTargetsBytes(int index);

  /**
   * <code>optional .grpc.testing.ClientType client_type = 2;</code>
   */
  int getClientTypeValue();
  /**
   * <code>optional .grpc.testing.ClientType client_type = 2;</code>
   */
  io.grpc.testing.ClientType getClientType();

  /**
   * <code>optional bool enable_ssl = 3;</code>
   */
  boolean getEnableSsl();

  /**
   * <code>optional int32 outstanding_rpcs_per_channel = 4;</code>
   */
  int getOutstandingRpcsPerChannel();

  /**
   * <code>optional int32 client_channels = 5;</code>
   */
  int getClientChannels();

  /**
   * <code>optional int32 payload_size = 6;</code>
   */
  int getPayloadSize();

  /**
   * <code>optional int32 async_client_threads = 7;</code>
   *
   * <pre>
   * only for async client:
   * </pre>
   */
  int getAsyncClientThreads();

  /**
   * <code>optional .grpc.testing.RpcType rpc_type = 8;</code>
   */
  int getRpcTypeValue();
  /**
   * <code>optional .grpc.testing.RpcType rpc_type = 8;</code>
   */
  io.grpc.testing.RpcType getRpcType();
}
