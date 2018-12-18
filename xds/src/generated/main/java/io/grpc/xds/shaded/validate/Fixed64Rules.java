// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: validate/validate.proto

package io.grpc.xds.shaded.validate;

/**
 * <pre>
 * Fixed64Rules describes the constraints applied to `fixed64` values
 * </pre>
 *
 * Protobuf type {@code validate.Fixed64Rules}
 */
public  final class Fixed64Rules extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:validate.Fixed64Rules)
    Fixed64RulesOrBuilder {
private static final long serialVersionUID = 0L;
  // Use Fixed64Rules.newBuilder() to construct.
  private Fixed64Rules(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private Fixed64Rules() {
    const_ = 0L;
    lt_ = 0L;
    lte_ = 0L;
    gt_ = 0L;
    gte_ = 0L;
    in_ = java.util.Collections.emptyList();
    notIn_ = java.util.Collections.emptyList();
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private Fixed64Rules(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    this();
    if (extensionRegistry == null) {
      throw new java.lang.NullPointerException();
    }
    int mutable_bitField0_ = 0;
    com.google.protobuf.UnknownFieldSet.Builder unknownFields =
        com.google.protobuf.UnknownFieldSet.newBuilder();
    try {
      boolean done = false;
      while (!done) {
        int tag = input.readTag();
        switch (tag) {
          case 0:
            done = true;
            break;
          default: {
            if (!parseUnknownField(
                input, unknownFields, extensionRegistry, tag)) {
              done = true;
            }
            break;
          }
          case 9: {
            bitField0_ |= 0x00000001;
            const_ = input.readFixed64();
            break;
          }
          case 17: {
            bitField0_ |= 0x00000002;
            lt_ = input.readFixed64();
            break;
          }
          case 25: {
            bitField0_ |= 0x00000004;
            lte_ = input.readFixed64();
            break;
          }
          case 33: {
            bitField0_ |= 0x00000008;
            gt_ = input.readFixed64();
            break;
          }
          case 41: {
            bitField0_ |= 0x00000010;
            gte_ = input.readFixed64();
            break;
          }
          case 49: {
            if (!((mutable_bitField0_ & 0x00000020) == 0x00000020)) {
              in_ = new java.util.ArrayList<java.lang.Long>();
              mutable_bitField0_ |= 0x00000020;
            }
            in_.add(input.readFixed64());
            break;
          }
          case 50: {
            int length = input.readRawVarint32();
            int limit = input.pushLimit(length);
            if (!((mutable_bitField0_ & 0x00000020) == 0x00000020) && input.getBytesUntilLimit() > 0) {
              in_ = new java.util.ArrayList<java.lang.Long>();
              mutable_bitField0_ |= 0x00000020;
            }
            while (input.getBytesUntilLimit() > 0) {
              in_.add(input.readFixed64());
            }
            input.popLimit(limit);
            break;
          }
          case 57: {
            if (!((mutable_bitField0_ & 0x00000040) == 0x00000040)) {
              notIn_ = new java.util.ArrayList<java.lang.Long>();
              mutable_bitField0_ |= 0x00000040;
            }
            notIn_.add(input.readFixed64());
            break;
          }
          case 58: {
            int length = input.readRawVarint32();
            int limit = input.pushLimit(length);
            if (!((mutable_bitField0_ & 0x00000040) == 0x00000040) && input.getBytesUntilLimit() > 0) {
              notIn_ = new java.util.ArrayList<java.lang.Long>();
              mutable_bitField0_ |= 0x00000040;
            }
            while (input.getBytesUntilLimit() > 0) {
              notIn_.add(input.readFixed64());
            }
            input.popLimit(limit);
            break;
          }
        }
      }
    } catch (com.google.protobuf.InvalidProtocolBufferException e) {
      throw e.setUnfinishedMessage(this);
    } catch (java.io.IOException e) {
      throw new com.google.protobuf.InvalidProtocolBufferException(
          e).setUnfinishedMessage(this);
    } finally {
      if (((mutable_bitField0_ & 0x00000020) == 0x00000020)) {
        in_ = java.util.Collections.unmodifiableList(in_);
      }
      if (((mutable_bitField0_ & 0x00000040) == 0x00000040)) {
        notIn_ = java.util.Collections.unmodifiableList(notIn_);
      }
      this.unknownFields = unknownFields.build();
      makeExtensionsImmutable();
    }
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return io.grpc.xds.shaded.validate.Validate.internal_static_validate_Fixed64Rules_descriptor;
  }

  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return io.grpc.xds.shaded.validate.Validate.internal_static_validate_Fixed64Rules_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            io.grpc.xds.shaded.validate.Fixed64Rules.class, io.grpc.xds.shaded.validate.Fixed64Rules.Builder.class);
  }

  private int bitField0_;
  public static final int CONST_FIELD_NUMBER = 1;
  private long const_;
  /**
   * <pre>
   * Const specifies that this field must be exactly the specified value
   * </pre>
   *
   * <code>optional fixed64 const = 1;</code>
   */
  public boolean hasConst() {
    return ((bitField0_ & 0x00000001) == 0x00000001);
  }
  /**
   * <pre>
   * Const specifies that this field must be exactly the specified value
   * </pre>
   *
   * <code>optional fixed64 const = 1;</code>
   */
  public long getConst() {
    return const_;
  }

  public static final int LT_FIELD_NUMBER = 2;
  private long lt_;
  /**
   * <pre>
   * Lt specifies that this field must be less than the specified value,
   * exclusive
   * </pre>
   *
   * <code>optional fixed64 lt = 2;</code>
   */
  public boolean hasLt() {
    return ((bitField0_ & 0x00000002) == 0x00000002);
  }
  /**
   * <pre>
   * Lt specifies that this field must be less than the specified value,
   * exclusive
   * </pre>
   *
   * <code>optional fixed64 lt = 2;</code>
   */
  public long getLt() {
    return lt_;
  }

  public static final int LTE_FIELD_NUMBER = 3;
  private long lte_;
  /**
   * <pre>
   * Lte specifies that this field must be less than or equal to the
   * specified value, inclusive
   * </pre>
   *
   * <code>optional fixed64 lte = 3;</code>
   */
  public boolean hasLte() {
    return ((bitField0_ & 0x00000004) == 0x00000004);
  }
  /**
   * <pre>
   * Lte specifies that this field must be less than or equal to the
   * specified value, inclusive
   * </pre>
   *
   * <code>optional fixed64 lte = 3;</code>
   */
  public long getLte() {
    return lte_;
  }

  public static final int GT_FIELD_NUMBER = 4;
  private long gt_;
  /**
   * <pre>
   * Gt specifies that this field must be greater than the specified value,
   * exclusive. If the value of Gt is larger than a specified Lt or Lte, the
   * range is reversed.
   * </pre>
   *
   * <code>optional fixed64 gt = 4;</code>
   */
  public boolean hasGt() {
    return ((bitField0_ & 0x00000008) == 0x00000008);
  }
  /**
   * <pre>
   * Gt specifies that this field must be greater than the specified value,
   * exclusive. If the value of Gt is larger than a specified Lt or Lte, the
   * range is reversed.
   * </pre>
   *
   * <code>optional fixed64 gt = 4;</code>
   */
  public long getGt() {
    return gt_;
  }

  public static final int GTE_FIELD_NUMBER = 5;
  private long gte_;
  /**
   * <pre>
   * Gte specifies that this field must be greater than or equal to the
   * specified value, inclusive. If the value of Gte is larger than a
   * specified Lt or Lte, the range is reversed.
   * </pre>
   *
   * <code>optional fixed64 gte = 5;</code>
   */
  public boolean hasGte() {
    return ((bitField0_ & 0x00000010) == 0x00000010);
  }
  /**
   * <pre>
   * Gte specifies that this field must be greater than or equal to the
   * specified value, inclusive. If the value of Gte is larger than a
   * specified Lt or Lte, the range is reversed.
   * </pre>
   *
   * <code>optional fixed64 gte = 5;</code>
   */
  public long getGte() {
    return gte_;
  }

  public static final int IN_FIELD_NUMBER = 6;
  private java.util.List<java.lang.Long> in_;
  /**
   * <pre>
   * In specifies that this field must be equal to one of the specified
   * values
   * </pre>
   *
   * <code>repeated fixed64 in = 6;</code>
   */
  public java.util.List<java.lang.Long>
      getInList() {
    return in_;
  }
  /**
   * <pre>
   * In specifies that this field must be equal to one of the specified
   * values
   * </pre>
   *
   * <code>repeated fixed64 in = 6;</code>
   */
  public int getInCount() {
    return in_.size();
  }
  /**
   * <pre>
   * In specifies that this field must be equal to one of the specified
   * values
   * </pre>
   *
   * <code>repeated fixed64 in = 6;</code>
   */
  public long getIn(int index) {
    return in_.get(index);
  }

  public static final int NOT_IN_FIELD_NUMBER = 7;
  private java.util.List<java.lang.Long> notIn_;
  /**
   * <pre>
   * NotIn specifies that this field cannot be equal to one of the specified
   * values
   * </pre>
   *
   * <code>repeated fixed64 not_in = 7;</code>
   */
  public java.util.List<java.lang.Long>
      getNotInList() {
    return notIn_;
  }
  /**
   * <pre>
   * NotIn specifies that this field cannot be equal to one of the specified
   * values
   * </pre>
   *
   * <code>repeated fixed64 not_in = 7;</code>
   */
  public int getNotInCount() {
    return notIn_.size();
  }
  /**
   * <pre>
   * NotIn specifies that this field cannot be equal to one of the specified
   * values
   * </pre>
   *
   * <code>repeated fixed64 not_in = 7;</code>
   */
  public long getNotIn(int index) {
    return notIn_.get(index);
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
    if (((bitField0_ & 0x00000001) == 0x00000001)) {
      output.writeFixed64(1, const_);
    }
    if (((bitField0_ & 0x00000002) == 0x00000002)) {
      output.writeFixed64(2, lt_);
    }
    if (((bitField0_ & 0x00000004) == 0x00000004)) {
      output.writeFixed64(3, lte_);
    }
    if (((bitField0_ & 0x00000008) == 0x00000008)) {
      output.writeFixed64(4, gt_);
    }
    if (((bitField0_ & 0x00000010) == 0x00000010)) {
      output.writeFixed64(5, gte_);
    }
    for (int i = 0; i < in_.size(); i++) {
      output.writeFixed64(6, in_.get(i));
    }
    for (int i = 0; i < notIn_.size(); i++) {
      output.writeFixed64(7, notIn_.get(i));
    }
    unknownFields.writeTo(output);
  }

  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (((bitField0_ & 0x00000001) == 0x00000001)) {
      size += com.google.protobuf.CodedOutputStream
        .computeFixed64Size(1, const_);
    }
    if (((bitField0_ & 0x00000002) == 0x00000002)) {
      size += com.google.protobuf.CodedOutputStream
        .computeFixed64Size(2, lt_);
    }
    if (((bitField0_ & 0x00000004) == 0x00000004)) {
      size += com.google.protobuf.CodedOutputStream
        .computeFixed64Size(3, lte_);
    }
    if (((bitField0_ & 0x00000008) == 0x00000008)) {
      size += com.google.protobuf.CodedOutputStream
        .computeFixed64Size(4, gt_);
    }
    if (((bitField0_ & 0x00000010) == 0x00000010)) {
      size += com.google.protobuf.CodedOutputStream
        .computeFixed64Size(5, gte_);
    }
    {
      int dataSize = 0;
      dataSize = 8 * getInList().size();
      size += dataSize;
      size += 1 * getInList().size();
    }
    {
      int dataSize = 0;
      dataSize = 8 * getNotInList().size();
      size += dataSize;
      size += 1 * getNotInList().size();
    }
    size += unknownFields.getSerializedSize();
    memoizedSize = size;
    return size;
  }

  @java.lang.Override
  public boolean equals(final java.lang.Object obj) {
    if (obj == this) {
     return true;
    }
    if (!(obj instanceof io.grpc.xds.shaded.validate.Fixed64Rules)) {
      return super.equals(obj);
    }
    io.grpc.xds.shaded.validate.Fixed64Rules other = (io.grpc.xds.shaded.validate.Fixed64Rules) obj;

    boolean result = true;
    result = result && (hasConst() == other.hasConst());
    if (hasConst()) {
      result = result && (getConst()
          == other.getConst());
    }
    result = result && (hasLt() == other.hasLt());
    if (hasLt()) {
      result = result && (getLt()
          == other.getLt());
    }
    result = result && (hasLte() == other.hasLte());
    if (hasLte()) {
      result = result && (getLte()
          == other.getLte());
    }
    result = result && (hasGt() == other.hasGt());
    if (hasGt()) {
      result = result && (getGt()
          == other.getGt());
    }
    result = result && (hasGte() == other.hasGte());
    if (hasGte()) {
      result = result && (getGte()
          == other.getGte());
    }
    result = result && getInList()
        .equals(other.getInList());
    result = result && getNotInList()
        .equals(other.getNotInList());
    result = result && unknownFields.equals(other.unknownFields);
    return result;
  }

  @java.lang.Override
  public int hashCode() {
    if (memoizedHashCode != 0) {
      return memoizedHashCode;
    }
    int hash = 41;
    hash = (19 * hash) + getDescriptor().hashCode();
    if (hasConst()) {
      hash = (37 * hash) + CONST_FIELD_NUMBER;
      hash = (53 * hash) + com.google.protobuf.Internal.hashLong(
          getConst());
    }
    if (hasLt()) {
      hash = (37 * hash) + LT_FIELD_NUMBER;
      hash = (53 * hash) + com.google.protobuf.Internal.hashLong(
          getLt());
    }
    if (hasLte()) {
      hash = (37 * hash) + LTE_FIELD_NUMBER;
      hash = (53 * hash) + com.google.protobuf.Internal.hashLong(
          getLte());
    }
    if (hasGt()) {
      hash = (37 * hash) + GT_FIELD_NUMBER;
      hash = (53 * hash) + com.google.protobuf.Internal.hashLong(
          getGt());
    }
    if (hasGte()) {
      hash = (37 * hash) + GTE_FIELD_NUMBER;
      hash = (53 * hash) + com.google.protobuf.Internal.hashLong(
          getGte());
    }
    if (getInCount() > 0) {
      hash = (37 * hash) + IN_FIELD_NUMBER;
      hash = (53 * hash) + getInList().hashCode();
    }
    if (getNotInCount() > 0) {
      hash = (37 * hash) + NOT_IN_FIELD_NUMBER;
      hash = (53 * hash) + getNotInList().hashCode();
    }
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static io.grpc.xds.shaded.validate.Fixed64Rules parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static io.grpc.xds.shaded.validate.Fixed64Rules parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static io.grpc.xds.shaded.validate.Fixed64Rules parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static io.grpc.xds.shaded.validate.Fixed64Rules parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static io.grpc.xds.shaded.validate.Fixed64Rules parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static io.grpc.xds.shaded.validate.Fixed64Rules parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static io.grpc.xds.shaded.validate.Fixed64Rules parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static io.grpc.xds.shaded.validate.Fixed64Rules parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static io.grpc.xds.shaded.validate.Fixed64Rules parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static io.grpc.xds.shaded.validate.Fixed64Rules parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static io.grpc.xds.shaded.validate.Fixed64Rules parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static io.grpc.xds.shaded.validate.Fixed64Rules parseFrom(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }

  public Builder newBuilderForType() { return newBuilder(); }
  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  public static Builder newBuilder(io.grpc.xds.shaded.validate.Fixed64Rules prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }
  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE
        ? new Builder() : new Builder().mergeFrom(this);
  }

  @java.lang.Override
  protected Builder newBuilderForType(
      com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
    Builder builder = new Builder(parent);
    return builder;
  }
  /**
   * <pre>
   * Fixed64Rules describes the constraints applied to `fixed64` values
   * </pre>
   *
   * Protobuf type {@code validate.Fixed64Rules}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:validate.Fixed64Rules)
      io.grpc.xds.shaded.validate.Fixed64RulesOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return io.grpc.xds.shaded.validate.Validate.internal_static_validate_Fixed64Rules_descriptor;
    }

    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return io.grpc.xds.shaded.validate.Validate.internal_static_validate_Fixed64Rules_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              io.grpc.xds.shaded.validate.Fixed64Rules.class, io.grpc.xds.shaded.validate.Fixed64Rules.Builder.class);
    }

    // Construct using io.grpc.xds.shaded.validate.Fixed64Rules.newBuilder()
    private Builder() {
      maybeForceBuilderInitialization();
    }

    private Builder(
        com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      super(parent);
      maybeForceBuilderInitialization();
    }
    private void maybeForceBuilderInitialization() {
      if (com.google.protobuf.GeneratedMessageV3
              .alwaysUseFieldBuilders) {
      }
    }
    public Builder clear() {
      super.clear();
      const_ = 0L;
      bitField0_ = (bitField0_ & ~0x00000001);
      lt_ = 0L;
      bitField0_ = (bitField0_ & ~0x00000002);
      lte_ = 0L;
      bitField0_ = (bitField0_ & ~0x00000004);
      gt_ = 0L;
      bitField0_ = (bitField0_ & ~0x00000008);
      gte_ = 0L;
      bitField0_ = (bitField0_ & ~0x00000010);
      in_ = java.util.Collections.emptyList();
      bitField0_ = (bitField0_ & ~0x00000020);
      notIn_ = java.util.Collections.emptyList();
      bitField0_ = (bitField0_ & ~0x00000040);
      return this;
    }

    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return io.grpc.xds.shaded.validate.Validate.internal_static_validate_Fixed64Rules_descriptor;
    }

    public io.grpc.xds.shaded.validate.Fixed64Rules getDefaultInstanceForType() {
      return io.grpc.xds.shaded.validate.Fixed64Rules.getDefaultInstance();
    }

    public io.grpc.xds.shaded.validate.Fixed64Rules build() {
      io.grpc.xds.shaded.validate.Fixed64Rules result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    public io.grpc.xds.shaded.validate.Fixed64Rules buildPartial() {
      io.grpc.xds.shaded.validate.Fixed64Rules result = new io.grpc.xds.shaded.validate.Fixed64Rules(this);
      int from_bitField0_ = bitField0_;
      int to_bitField0_ = 0;
      if (((from_bitField0_ & 0x00000001) == 0x00000001)) {
        to_bitField0_ |= 0x00000001;
      }
      result.const_ = const_;
      if (((from_bitField0_ & 0x00000002) == 0x00000002)) {
        to_bitField0_ |= 0x00000002;
      }
      result.lt_ = lt_;
      if (((from_bitField0_ & 0x00000004) == 0x00000004)) {
        to_bitField0_ |= 0x00000004;
      }
      result.lte_ = lte_;
      if (((from_bitField0_ & 0x00000008) == 0x00000008)) {
        to_bitField0_ |= 0x00000008;
      }
      result.gt_ = gt_;
      if (((from_bitField0_ & 0x00000010) == 0x00000010)) {
        to_bitField0_ |= 0x00000010;
      }
      result.gte_ = gte_;
      if (((bitField0_ & 0x00000020) == 0x00000020)) {
        in_ = java.util.Collections.unmodifiableList(in_);
        bitField0_ = (bitField0_ & ~0x00000020);
      }
      result.in_ = in_;
      if (((bitField0_ & 0x00000040) == 0x00000040)) {
        notIn_ = java.util.Collections.unmodifiableList(notIn_);
        bitField0_ = (bitField0_ & ~0x00000040);
      }
      result.notIn_ = notIn_;
      result.bitField0_ = to_bitField0_;
      onBuilt();
      return result;
    }

    public Builder clone() {
      return (Builder) super.clone();
    }
    public Builder setField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return (Builder) super.setField(field, value);
    }
    public Builder clearField(
        com.google.protobuf.Descriptors.FieldDescriptor field) {
      return (Builder) super.clearField(field);
    }
    public Builder clearOneof(
        com.google.protobuf.Descriptors.OneofDescriptor oneof) {
      return (Builder) super.clearOneof(oneof);
    }
    public Builder setRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        int index, java.lang.Object value) {
      return (Builder) super.setRepeatedField(field, index, value);
    }
    public Builder addRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return (Builder) super.addRepeatedField(field, value);
    }
    public Builder mergeFrom(com.google.protobuf.Message other) {
      if (other instanceof io.grpc.xds.shaded.validate.Fixed64Rules) {
        return mergeFrom((io.grpc.xds.shaded.validate.Fixed64Rules)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(io.grpc.xds.shaded.validate.Fixed64Rules other) {
      if (other == io.grpc.xds.shaded.validate.Fixed64Rules.getDefaultInstance()) return this;
      if (other.hasConst()) {
        setConst(other.getConst());
      }
      if (other.hasLt()) {
        setLt(other.getLt());
      }
      if (other.hasLte()) {
        setLte(other.getLte());
      }
      if (other.hasGt()) {
        setGt(other.getGt());
      }
      if (other.hasGte()) {
        setGte(other.getGte());
      }
      if (!other.in_.isEmpty()) {
        if (in_.isEmpty()) {
          in_ = other.in_;
          bitField0_ = (bitField0_ & ~0x00000020);
        } else {
          ensureInIsMutable();
          in_.addAll(other.in_);
        }
        onChanged();
      }
      if (!other.notIn_.isEmpty()) {
        if (notIn_.isEmpty()) {
          notIn_ = other.notIn_;
          bitField0_ = (bitField0_ & ~0x00000040);
        } else {
          ensureNotInIsMutable();
          notIn_.addAll(other.notIn_);
        }
        onChanged();
      }
      this.mergeUnknownFields(other.unknownFields);
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
      io.grpc.xds.shaded.validate.Fixed64Rules parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (io.grpc.xds.shaded.validate.Fixed64Rules) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }
    private int bitField0_;

    private long const_ ;
    /**
     * <pre>
     * Const specifies that this field must be exactly the specified value
     * </pre>
     *
     * <code>optional fixed64 const = 1;</code>
     */
    public boolean hasConst() {
      return ((bitField0_ & 0x00000001) == 0x00000001);
    }
    /**
     * <pre>
     * Const specifies that this field must be exactly the specified value
     * </pre>
     *
     * <code>optional fixed64 const = 1;</code>
     */
    public long getConst() {
      return const_;
    }
    /**
     * <pre>
     * Const specifies that this field must be exactly the specified value
     * </pre>
     *
     * <code>optional fixed64 const = 1;</code>
     */
    public Builder setConst(long value) {
      bitField0_ |= 0x00000001;
      const_ = value;
      onChanged();
      return this;
    }
    /**
     * <pre>
     * Const specifies that this field must be exactly the specified value
     * </pre>
     *
     * <code>optional fixed64 const = 1;</code>
     */
    public Builder clearConst() {
      bitField0_ = (bitField0_ & ~0x00000001);
      const_ = 0L;
      onChanged();
      return this;
    }

    private long lt_ ;
    /**
     * <pre>
     * Lt specifies that this field must be less than the specified value,
     * exclusive
     * </pre>
     *
     * <code>optional fixed64 lt = 2;</code>
     */
    public boolean hasLt() {
      return ((bitField0_ & 0x00000002) == 0x00000002);
    }
    /**
     * <pre>
     * Lt specifies that this field must be less than the specified value,
     * exclusive
     * </pre>
     *
     * <code>optional fixed64 lt = 2;</code>
     */
    public long getLt() {
      return lt_;
    }
    /**
     * <pre>
     * Lt specifies that this field must be less than the specified value,
     * exclusive
     * </pre>
     *
     * <code>optional fixed64 lt = 2;</code>
     */
    public Builder setLt(long value) {
      bitField0_ |= 0x00000002;
      lt_ = value;
      onChanged();
      return this;
    }
    /**
     * <pre>
     * Lt specifies that this field must be less than the specified value,
     * exclusive
     * </pre>
     *
     * <code>optional fixed64 lt = 2;</code>
     */
    public Builder clearLt() {
      bitField0_ = (bitField0_ & ~0x00000002);
      lt_ = 0L;
      onChanged();
      return this;
    }

    private long lte_ ;
    /**
     * <pre>
     * Lte specifies that this field must be less than or equal to the
     * specified value, inclusive
     * </pre>
     *
     * <code>optional fixed64 lte = 3;</code>
     */
    public boolean hasLte() {
      return ((bitField0_ & 0x00000004) == 0x00000004);
    }
    /**
     * <pre>
     * Lte specifies that this field must be less than or equal to the
     * specified value, inclusive
     * </pre>
     *
     * <code>optional fixed64 lte = 3;</code>
     */
    public long getLte() {
      return lte_;
    }
    /**
     * <pre>
     * Lte specifies that this field must be less than or equal to the
     * specified value, inclusive
     * </pre>
     *
     * <code>optional fixed64 lte = 3;</code>
     */
    public Builder setLte(long value) {
      bitField0_ |= 0x00000004;
      lte_ = value;
      onChanged();
      return this;
    }
    /**
     * <pre>
     * Lte specifies that this field must be less than or equal to the
     * specified value, inclusive
     * </pre>
     *
     * <code>optional fixed64 lte = 3;</code>
     */
    public Builder clearLte() {
      bitField0_ = (bitField0_ & ~0x00000004);
      lte_ = 0L;
      onChanged();
      return this;
    }

    private long gt_ ;
    /**
     * <pre>
     * Gt specifies that this field must be greater than the specified value,
     * exclusive. If the value of Gt is larger than a specified Lt or Lte, the
     * range is reversed.
     * </pre>
     *
     * <code>optional fixed64 gt = 4;</code>
     */
    public boolean hasGt() {
      return ((bitField0_ & 0x00000008) == 0x00000008);
    }
    /**
     * <pre>
     * Gt specifies that this field must be greater than the specified value,
     * exclusive. If the value of Gt is larger than a specified Lt or Lte, the
     * range is reversed.
     * </pre>
     *
     * <code>optional fixed64 gt = 4;</code>
     */
    public long getGt() {
      return gt_;
    }
    /**
     * <pre>
     * Gt specifies that this field must be greater than the specified value,
     * exclusive. If the value of Gt is larger than a specified Lt or Lte, the
     * range is reversed.
     * </pre>
     *
     * <code>optional fixed64 gt = 4;</code>
     */
    public Builder setGt(long value) {
      bitField0_ |= 0x00000008;
      gt_ = value;
      onChanged();
      return this;
    }
    /**
     * <pre>
     * Gt specifies that this field must be greater than the specified value,
     * exclusive. If the value of Gt is larger than a specified Lt or Lte, the
     * range is reversed.
     * </pre>
     *
     * <code>optional fixed64 gt = 4;</code>
     */
    public Builder clearGt() {
      bitField0_ = (bitField0_ & ~0x00000008);
      gt_ = 0L;
      onChanged();
      return this;
    }

    private long gte_ ;
    /**
     * <pre>
     * Gte specifies that this field must be greater than or equal to the
     * specified value, inclusive. If the value of Gte is larger than a
     * specified Lt or Lte, the range is reversed.
     * </pre>
     *
     * <code>optional fixed64 gte = 5;</code>
     */
    public boolean hasGte() {
      return ((bitField0_ & 0x00000010) == 0x00000010);
    }
    /**
     * <pre>
     * Gte specifies that this field must be greater than or equal to the
     * specified value, inclusive. If the value of Gte is larger than a
     * specified Lt or Lte, the range is reversed.
     * </pre>
     *
     * <code>optional fixed64 gte = 5;</code>
     */
    public long getGte() {
      return gte_;
    }
    /**
     * <pre>
     * Gte specifies that this field must be greater than or equal to the
     * specified value, inclusive. If the value of Gte is larger than a
     * specified Lt or Lte, the range is reversed.
     * </pre>
     *
     * <code>optional fixed64 gte = 5;</code>
     */
    public Builder setGte(long value) {
      bitField0_ |= 0x00000010;
      gte_ = value;
      onChanged();
      return this;
    }
    /**
     * <pre>
     * Gte specifies that this field must be greater than or equal to the
     * specified value, inclusive. If the value of Gte is larger than a
     * specified Lt or Lte, the range is reversed.
     * </pre>
     *
     * <code>optional fixed64 gte = 5;</code>
     */
    public Builder clearGte() {
      bitField0_ = (bitField0_ & ~0x00000010);
      gte_ = 0L;
      onChanged();
      return this;
    }

    private java.util.List<java.lang.Long> in_ = java.util.Collections.emptyList();
    private void ensureInIsMutable() {
      if (!((bitField0_ & 0x00000020) == 0x00000020)) {
        in_ = new java.util.ArrayList<java.lang.Long>(in_);
        bitField0_ |= 0x00000020;
       }
    }
    /**
     * <pre>
     * In specifies that this field must be equal to one of the specified
     * values
     * </pre>
     *
     * <code>repeated fixed64 in = 6;</code>
     */
    public java.util.List<java.lang.Long>
        getInList() {
      return java.util.Collections.unmodifiableList(in_);
    }
    /**
     * <pre>
     * In specifies that this field must be equal to one of the specified
     * values
     * </pre>
     *
     * <code>repeated fixed64 in = 6;</code>
     */
    public int getInCount() {
      return in_.size();
    }
    /**
     * <pre>
     * In specifies that this field must be equal to one of the specified
     * values
     * </pre>
     *
     * <code>repeated fixed64 in = 6;</code>
     */
    public long getIn(int index) {
      return in_.get(index);
    }
    /**
     * <pre>
     * In specifies that this field must be equal to one of the specified
     * values
     * </pre>
     *
     * <code>repeated fixed64 in = 6;</code>
     */
    public Builder setIn(
        int index, long value) {
      ensureInIsMutable();
      in_.set(index, value);
      onChanged();
      return this;
    }
    /**
     * <pre>
     * In specifies that this field must be equal to one of the specified
     * values
     * </pre>
     *
     * <code>repeated fixed64 in = 6;</code>
     */
    public Builder addIn(long value) {
      ensureInIsMutable();
      in_.add(value);
      onChanged();
      return this;
    }
    /**
     * <pre>
     * In specifies that this field must be equal to one of the specified
     * values
     * </pre>
     *
     * <code>repeated fixed64 in = 6;</code>
     */
    public Builder addAllIn(
        java.lang.Iterable<? extends java.lang.Long> values) {
      ensureInIsMutable();
      com.google.protobuf.AbstractMessageLite.Builder.addAll(
          values, in_);
      onChanged();
      return this;
    }
    /**
     * <pre>
     * In specifies that this field must be equal to one of the specified
     * values
     * </pre>
     *
     * <code>repeated fixed64 in = 6;</code>
     */
    public Builder clearIn() {
      in_ = java.util.Collections.emptyList();
      bitField0_ = (bitField0_ & ~0x00000020);
      onChanged();
      return this;
    }

    private java.util.List<java.lang.Long> notIn_ = java.util.Collections.emptyList();
    private void ensureNotInIsMutable() {
      if (!((bitField0_ & 0x00000040) == 0x00000040)) {
        notIn_ = new java.util.ArrayList<java.lang.Long>(notIn_);
        bitField0_ |= 0x00000040;
       }
    }
    /**
     * <pre>
     * NotIn specifies that this field cannot be equal to one of the specified
     * values
     * </pre>
     *
     * <code>repeated fixed64 not_in = 7;</code>
     */
    public java.util.List<java.lang.Long>
        getNotInList() {
      return java.util.Collections.unmodifiableList(notIn_);
    }
    /**
     * <pre>
     * NotIn specifies that this field cannot be equal to one of the specified
     * values
     * </pre>
     *
     * <code>repeated fixed64 not_in = 7;</code>
     */
    public int getNotInCount() {
      return notIn_.size();
    }
    /**
     * <pre>
     * NotIn specifies that this field cannot be equal to one of the specified
     * values
     * </pre>
     *
     * <code>repeated fixed64 not_in = 7;</code>
     */
    public long getNotIn(int index) {
      return notIn_.get(index);
    }
    /**
     * <pre>
     * NotIn specifies that this field cannot be equal to one of the specified
     * values
     * </pre>
     *
     * <code>repeated fixed64 not_in = 7;</code>
     */
    public Builder setNotIn(
        int index, long value) {
      ensureNotInIsMutable();
      notIn_.set(index, value);
      onChanged();
      return this;
    }
    /**
     * <pre>
     * NotIn specifies that this field cannot be equal to one of the specified
     * values
     * </pre>
     *
     * <code>repeated fixed64 not_in = 7;</code>
     */
    public Builder addNotIn(long value) {
      ensureNotInIsMutable();
      notIn_.add(value);
      onChanged();
      return this;
    }
    /**
     * <pre>
     * NotIn specifies that this field cannot be equal to one of the specified
     * values
     * </pre>
     *
     * <code>repeated fixed64 not_in = 7;</code>
     */
    public Builder addAllNotIn(
        java.lang.Iterable<? extends java.lang.Long> values) {
      ensureNotInIsMutable();
      com.google.protobuf.AbstractMessageLite.Builder.addAll(
          values, notIn_);
      onChanged();
      return this;
    }
    /**
     * <pre>
     * NotIn specifies that this field cannot be equal to one of the specified
     * values
     * </pre>
     *
     * <code>repeated fixed64 not_in = 7;</code>
     */
    public Builder clearNotIn() {
      notIn_ = java.util.Collections.emptyList();
      bitField0_ = (bitField0_ & ~0x00000040);
      onChanged();
      return this;
    }
    public final Builder setUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.setUnknownFields(unknownFields);
    }

    public final Builder mergeUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.mergeUnknownFields(unknownFields);
    }


    // @@protoc_insertion_point(builder_scope:validate.Fixed64Rules)
  }

  // @@protoc_insertion_point(class_scope:validate.Fixed64Rules)
  private static final io.grpc.xds.shaded.validate.Fixed64Rules DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new io.grpc.xds.shaded.validate.Fixed64Rules();
  }

  public static io.grpc.xds.shaded.validate.Fixed64Rules getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  @java.lang.Deprecated public static final com.google.protobuf.Parser<Fixed64Rules>
      PARSER = new com.google.protobuf.AbstractParser<Fixed64Rules>() {
    public Fixed64Rules parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new Fixed64Rules(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<Fixed64Rules> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<Fixed64Rules> getParserForType() {
    return PARSER;
  }

  public io.grpc.xds.shaded.validate.Fixed64Rules getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}
