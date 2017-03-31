package net.sf.robocode.serialization;

import java.nio.ByteBuffer;

public abstract interface ISerializableHelper
{
  public abstract int sizeOf(RbSerializer paramRbSerializer, Object paramObject);
  
  public abstract void serialize(RbSerializer paramRbSerializer, ByteBuffer paramByteBuffer, Object paramObject);
  
  public abstract Object deserialize(RbSerializer paramRbSerializer, ByteBuffer paramByteBuffer);
}
