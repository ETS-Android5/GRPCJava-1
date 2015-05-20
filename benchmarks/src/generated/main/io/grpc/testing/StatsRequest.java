// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: qpstest.proto

package io.grpc.testing;

/**
 * Protobuf type {@code grpc.testing.StatsRequest}
 */
public  final class StatsRequest extends
    com.google.protobuf.GeneratedMessage implements
    // @@protoc_insertion_point(message_implements:grpc.testing.StatsRequest)
    StatsRequestOrBuilder {
  // Use StatsRequest.newBuilder() to construct.
  private StatsRequest(com.google.protobuf.GeneratedMessage.Builder builder) {
    super(builder);
  }
  private StatsRequest() {
    testNum_ = 0;
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return com.google.protobuf.UnknownFieldSet.getDefaultInstance();
  }
  private StatsRequest(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    this();
    int mutable_bitField0_ = 0;
    try {
      boolean done = false;
      while (!done) {
        int tag = input.readTag();
        switch (tag) {
          case 0:
            done = true;
            break;
          default: {
            if (!input.skipField(tag)) {
              done = true;
            }
            break;
          }
          case 8: {

            testNum_ = input.readInt32();
            break;
          }
        }
      }
    } catch (com.google.protobuf.InvalidProtocolBufferException e) {
      throw e.setUnfinishedMessage(this);
    } catch (java.io.IOException e) {
      throw new com.google.protobuf.InvalidProtocolBufferException(
          e.getMessage()).setUnfinishedMessage(this);
    } finally {
      makeExtensionsImmutable();
    }
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return io.grpc.testing.QpsTestProto.internal_static_grpc_testing_StatsRequest_descriptor;
  }

  protected com.google.protobuf.GeneratedMessage.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return io.grpc.testing.QpsTestProto.internal_static_grpc_testing_StatsRequest_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            io.grpc.testing.StatsRequest.class, io.grpc.testing.StatsRequest.Builder.class);
  }

  public static final com.google.protobuf.Parser<StatsRequest> PARSER =
      new com.google.protobuf.AbstractParser<StatsRequest>() {
    public StatsRequest parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new StatsRequest(input, extensionRegistry);
    }
  };

  @java.lang.Override
  public com.google.protobuf.Parser<StatsRequest> getParserForType() {
    return PARSER;
  }

  public static final int TEST_NUM_FIELD_NUMBER = 1;
  private int testNum_;
  /**
   * <code>optional int32 test_num = 1;</code>
   *
   * <pre>
   * run number
   * </pre>
   */
  public int getTestNum() {
    return testNum_;
  }

  private byte memoizedIsInitialized = -1;
  public final boolean isInitialized() {
    byte isInitialized = memoizedIsInitialized;
    if (isInitialized == 1) return true;
    if (isInitialized == 0) return false;

    memoizedIsInitialized = 1;
    return true;
  }

  public void writeTo(com.google.protobuf.CodedOutputStream output)
                      throws java.io.IOException {
    getSerializedSize();
    if (testNum_ != 0) {
      output.writeInt32(1, testNum_);
    }
  }

  private int memoizedSerializedSize = -1;
  public int getSerializedSize() {
    int size = memoizedSerializedSize;
    if (size != -1) return size;

    size = 0;
    if (testNum_ != 0) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt32Size(1, testNum_);
    }
    memoizedSerializedSize = size;
    return size;
  }

  private static final long serialVersionUID = 0L;
  public static io.grpc.testing.StatsRequest parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static io.grpc.testing.StatsRequest parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static io.grpc.testing.StatsRequest parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static io.grpc.testing.StatsRequest parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static io.grpc.testing.StatsRequest parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return PARSER.parseFrom(input);
  }
  public static io.grpc.testing.StatsRequest parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return PARSER.parseFrom(input, extensionRegistry);
  }
  public static io.grpc.testing.StatsRequest parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return PARSER.parseDelimitedFrom(input);
  }
  public static io.grpc.testing.StatsRequest parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return PARSER.parseDelimitedFrom(input, extensionRegistry);
  }
  public static io.grpc.testing.StatsRequest parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return PARSER.parseFrom(input);
  }
  public static io.grpc.testing.StatsRequest parseFrom(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return PARSER.parseFrom(input, extensionRegistry);
  }

  public static Builder newBuilder() { return new Builder(); }
  public Builder newBuilderForType() { return newBuilder(); }
  public static Builder newBuilder(io.grpc.testing.StatsRequest prototype) {
    return newBuilder().mergeFrom(prototype);
  }
  public Builder toBuilder() { return newBuilder(this); }

  @java.lang.Override
  protected Builder newBuilderForType(
      com.google.protobuf.GeneratedMessage.BuilderParent parent) {
    Builder builder = new Builder(parent);
    return builder;
  }
  /**
   * Protobuf type {@code grpc.testing.StatsRequest}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessage.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:grpc.testing.StatsRequest)
      io.grpc.testing.StatsRequestOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return io.grpc.testing.QpsTestProto.internal_static_grpc_testing_StatsRequest_descriptor;
    }

    protected com.google.protobuf.GeneratedMessage.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return io.grpc.testing.QpsTestProto.internal_static_grpc_testing_StatsRequest_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              io.grpc.testing.StatsRequest.class, io.grpc.testing.StatsRequest.Builder.class);
    }

    // Construct using io.grpc.testing.StatsRequest.newBuilder()
    private Builder() {
      maybeForceBuilderInitialization();
    }

    private Builder(
        com.google.protobuf.GeneratedMessage.BuilderParent parent) {
      super(parent);
      maybeForceBuilderInitialization();
    }
    private void maybeForceBuilderInitialization() {
      if (com.google.protobuf.GeneratedMessage.alwaysUseFieldBuilders) {
      }
    }
    public Builder clear() {
      super.clear();
      testNum_ = 0;

      return this;
    }

    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return io.grpc.testing.QpsTestProto.internal_static_grpc_testing_StatsRequest_descriptor;
    }

    public io.grpc.testing.StatsRequest getDefaultInstanceForType() {
      return io.grpc.testing.StatsRequest.getDefaultInstance();
    }

    public io.grpc.testing.StatsRequest build() {
      io.grpc.testing.StatsRequest result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    public io.grpc.testing.StatsRequest buildPartial() {
      io.grpc.testing.StatsRequest result = new io.grpc.testing.StatsRequest(this);
      result.testNum_ = testNum_;
      onBuilt();
      return result;
    }

    public Builder mergeFrom(com.google.protobuf.Message other) {
      if (other instanceof io.grpc.testing.StatsRequest) {
        return mergeFrom((io.grpc.testing.StatsRequest)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(io.grpc.testing.StatsRequest other) {
      if (other == io.grpc.testing.StatsRequest.getDefaultInstance()) return this;
      if (other.getTestNum() != 0) {
        setTestNum(other.getTestNum());
      }
      onChanged();
      return this;
    }

    public final boolean isInitialized() {
      return true;
    }

    public Builder mergeFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      io.grpc.testing.StatsRequest parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (io.grpc.testing.StatsRequest) e.getUnfinishedMessage();
        throw e;
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }

    private int testNum_ ;
    /**
     * <code>optional int32 test_num = 1;</code>
     *
     * <pre>
     * run number
     * </pre>
     */
    public int getTestNum() {
      return testNum_;
    }
    /**
     * <code>optional int32 test_num = 1;</code>
     *
     * <pre>
     * run number
     * </pre>
     */
    public Builder setTestNum(int value) {
      
      testNum_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>optional int32 test_num = 1;</code>
     *
     * <pre>
     * run number
     * </pre>
     */
    public Builder clearTestNum() {
      
      testNum_ = 0;
      onChanged();
      return this;
    }
    public final Builder setUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return this;
    }

    public final Builder mergeUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return this;
    }


    // @@protoc_insertion_point(builder_scope:grpc.testing.StatsRequest)
  }

  // @@protoc_insertion_point(class_scope:grpc.testing.StatsRequest)
  private static final io.grpc.testing.StatsRequest defaultInstance;static {
    defaultInstance = new io.grpc.testing.StatsRequest();
  }

  public static io.grpc.testing.StatsRequest getDefaultInstance() {
    return defaultInstance;
  }

  public io.grpc.testing.StatsRequest getDefaultInstanceForType() {
    return defaultInstance;
  }

}

