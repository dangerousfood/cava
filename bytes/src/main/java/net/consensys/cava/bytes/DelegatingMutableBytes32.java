package net.consensys.cava.bytes;

import static com.google.common.base.Preconditions.checkArgument;

import java.math.BigInteger;
import java.security.MessageDigest;

import io.vertx.core.buffer.Buffer;

final class DelegatingMutableBytes32 implements MutableBytes32 {

  private final MutableBytes delegate;

  private DelegatingMutableBytes32(MutableBytes delegate) {
    this.delegate = delegate;
  }

  static MutableBytes32 delegateTo(MutableBytes value) {
    checkArgument(value.size() == SIZE, "Expected %s bytes but got %s", SIZE, value.size());
    return new DelegatingMutableBytes32(value);
  }

  @Override
  public void set(int i, byte b) {
    delegate.set(i, b);
  }

  @Override
  public void setInt(int i, int value) {
    delegate.setInt(i, value);
  }

  @Override
  public void setLong(int i, long value) {
    delegate.setLong(i, value);
  }

  @Override
  public MutableBytes mutableSlice(int i, int length) {
    return delegate.mutableSlice(i, length);
  }

  @Override
  public void fill(byte b) {
    delegate.fill(b);
  }

  @Override
  public void clear() {
    delegate.clear();
  }

  @Override
  public int size() {
    return delegate.size();
  }

  @Override
  public byte get(int i) {
    return delegate.get(i);
  }

  @Override
  public int getInt(int i) {
    return delegate.getInt(i);
  }

  @Override
  public int intValue() {
    return delegate.intValue();
  }

  @Override
  public long getLong(int i) {
    return delegate.getLong(i);
  }

  @Override
  public long longValue() {
    return delegate.longValue();
  }

  @Override
  public BigInteger bigIntegerValue() {
    return delegate.bigIntegerValue();
  }

  @Override
  public BigInteger unsignedBigIntegerValue() {
    return delegate.unsignedBigIntegerValue();
  }

  @Override
  public boolean isZero() {
    return delegate.isZero();
  }

  @Override
  public int numberOfLeadingZeros() {
    return delegate.numberOfLeadingZeros();
  }

  @Override
  public int numberOfLeadingZeroBytes() {
    return delegate.numberOfLeadingZeroBytes();
  }

  @Override
  public boolean hasLeadingZeroByte() {
    return delegate.hasLeadingZeroByte();
  }

  @Override
  public boolean hasLeadingZero() {
    return delegate.hasLeadingZero();
  }

  @Override
  public int bitLength() {
    return delegate.bitLength();
  }

  @Override
  public Bytes and(Bytes other) {
    return delegate.and(other);
  }

  @Override
  public <T extends MutableBytes> T and(Bytes other, T result) {
    return delegate.and(other, result);
  }

  @Override
  public Bytes or(Bytes other) {
    return delegate.or(other);
  }

  @Override
  public <T extends MutableBytes> T or(Bytes other, T result) {
    return delegate.or(other, result);
  }

  @Override
  public Bytes xor(Bytes other) {
    return delegate.xor(other);
  }

  @Override
  public <T extends MutableBytes> T xor(Bytes other, T result) {
    return delegate.xor(other, result);
  }

  @Override
  public <T extends MutableBytes> T not(T result) {
    return delegate.not(result);
  }

  @Override
  public <T extends MutableBytes> T shiftRight(int distance, T result) {
    return delegate.shiftRight(distance, result);
  }

  @Override
  public <T extends MutableBytes> T shiftLeft(int distance, T result) {
    return delegate.shiftLeft(distance, result);
  }

  @Override
  public Bytes slice(int index) {
    return delegate.slice(index);
  }

  @Override
  public Bytes slice(int index, int length) {
    return delegate.slice(index, length);
  }

  @Override
  public Bytes32 copy() {
    return Bytes32.wrap(delegate.toArray());
  }

  @Override
  public MutableBytes32 mutableCopy() {
    return MutableBytes32.wrap(delegate.toArray());
  }

  @Override
  public void copyTo(MutableBytes destination) {
    delegate.copyTo(destination);
  }

  @Override
  public void copyTo(MutableBytes destination, int destinationOffset) {
    delegate.copyTo(destination, destinationOffset);
  }

  @Override
  public void appendTo(Buffer buffer) {
    delegate.appendTo(buffer);
  }

  @Override
  public int commonPrefixLength(Bytes other) {
    return delegate.commonPrefixLength(other);
  }

  @Override
  public Bytes commonPrefix(Bytes other) {
    return delegate.commonPrefix(other);
  }

  @Override
  public void update(MessageDigest digest) {
    delegate.update(digest);
  }

  @Override
  public byte[] toArray() {
    return delegate.toArray();
  }

  @Override
  public byte[] toArrayUnsafe() {
    return delegate.toArrayUnsafe();
  }

  @Override
  public String toString() {
    return delegate.toString();
  }

  @Override
  public String toHexString() {
    return delegate.toHexString();
  }

  @Override
  public String toShortHexString() {
    return delegate.toShortHexString();
  }

  @Override
  public boolean equals(Object obj) {
    return delegate.equals(obj);
  }

  @Override
  public int hashCode() {
    return delegate.hashCode();
  }
}
