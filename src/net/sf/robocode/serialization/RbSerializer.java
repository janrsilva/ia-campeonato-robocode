package net.sf.robocode.serialization;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;
import java.nio.charset.CodingErrorAction;
import java.util.HashMap;
import java.util.Map;
import net.sf.robocode.core.ContainerBase;
import net.sf.robocode.io.Logger;
import net.sf.robocode.manager.IVersionManagerBase;
import net.sf.robocode.security.HiddenAccess;
import robocode.Event;








public final class RbSerializer
{
  public static final int SIZEOF_TYPEINFO = 1;
  public static final int SIZEOF_BYTE = 1;
  public static final int SIZEOF_BOOL = 1;
  public static final int SIZEOF_CHAR = 2;
  public static final int SIZEOF_INT = 4;
  public static final int SIZEOF_LONG = 8;
  public static final int SIZEOF_DOUBLE = 8;
  public static final byte TERMINATOR_TYPE = -1;
  public static final byte ExecCommands_TYPE = 1;
  public static final byte BulletCommand_TYPE = 2;
  public static final byte TeamMessage_TYPE = 3;
  public static final byte DebugProperty_TYPE = 4;
  public static final byte ExecResults_TYPE = 5;
  public static final byte RobotStatus_TYPE = 6;
  public static final byte BulletStatus_TYPE = 7;
  public static final byte BattleResults_TYPE = 8;
  public static final byte Bullet_TYPE = 9;
  public static final byte RobotStatics_TYPE = 10;
  public static final byte BattleEndedEvent_TYPE = 32;
  public static final byte BulletHitBulletEvent_TYPE = 33;
  public static final byte BulletHitEvent_TYPE = 34;
  public static final byte BulletMissedEvent_TYPE = 35;
  public static final byte DeathEvent_TYPE = 36;
  public static final byte WinEvent_TYPE = 37;
  public static final byte HitWallEvent_TYPE = 38;
  public static final byte RobotDeathEvent_TYPE = 39;
  public static final byte SkippedTurnEvent_TYPE = 40;
  public static final byte ScannedRobotEvent_TYPE = 41;
  public static final byte HitByBulletEvent_TYPE = 42;
  public static final byte HitRobotEvent_TYPE = 43;
  public static final byte KeyPressedEvent_TYPE = 44;
  public static final byte KeyReleasedEvent_TYPE = 45;
  public static final byte KeyTypedEvent_TYPE = 46;
  public static final byte MouseClickedEvent_TYPE = 47;
  public static final byte MouseDraggedEvent_TYPE = 48;
  public static final byte MouseEnteredEvent_TYPE = 49;
  public static final byte MouseExitedEvent_TYPE = 50;
  public static final byte MouseMovedEvent_TYPE = 51;
  public static final byte MousePressedEvent_TYPE = 52;
  public static final byte MouseReleasedEvent_TYPE = 53;
  public static final byte MouseWheelMovedEvent_TYPE = 54;
  public static final byte RoundEndedEvent_TYPE = 55;
  private static final ISerializableHelper[] typeToHelper = new ISerializableHelper['Ā'];
  private static Map<Class<?>, Byte> classToType = new HashMap();
  







  private static final Charset charset = Charset.forName("UTF8");
  static { register(null, (byte)-1); }
  
  private final CharsetEncoder encoder;
  private final CharsetDecoder decoder;
  public RbSerializer() { currentVersion = ((IVersionManagerBase)ContainerBase.getComponent(IVersionManagerBase.class)).getVersionAsInt();
    encoder = charset.newEncoder();
    encoder.onMalformedInput(CodingErrorAction.REPORT);
    encoder.onUnmappableCharacter(CodingErrorAction.REPLACE);
    
    ByteBuffer buffer = ByteBuffer.allocate(8);
    
    encoder.encode(CharBuffer.wrap("BOM"), buffer, false);
    
    decoder = charset.newDecoder();
    decoder.onMalformedInput(CodingErrorAction.REPORT);
    decoder.onUnmappableCharacter(CodingErrorAction.REPLACE);
  }
  
  public void serialize(OutputStream target, byte type, Object object) throws IOException {
    int length = sizeOf(type, object);
    

    ByteBuffer buffer = ByteBuffer.allocate(12);
    
    buffer.putInt(-1059135839);
    buffer.putInt(currentVersion);
    buffer.putInt(length);
    target.write(buffer.array());
    

    buffer = ByteBuffer.allocate(length);
    serialize(buffer, type, object);
    if (buffer.remaining() != 0) {
      throw new IOException("Serialization failed: bad size");
    }
    target.write(buffer.array());
  }
  
  public ByteBuffer serialize(byte type, Object object) throws IOException {
    int length = sizeOf(type, object);
    

    ByteBuffer buffer = ByteBuffer.allocateDirect(12 + length);
    
    buffer.putInt(-1059135839);
    buffer.putInt(currentVersion);
    buffer.putInt(length);
    

    serialize(buffer, type, object);
    if (buffer.remaining() != 0) {
      throw new IOException("Serialization failed: bad size");
    }
    return buffer;
  }
  
  public ByteBuffer serializeToBuffer(ByteBuffer buffer, byte type, Object object) throws IOException {
    int length = sizeOf(type, object);
    
    buffer.limit(12 + length);
    
    buffer.putInt(-1059135839);
    buffer.putInt(currentVersion);
    buffer.putInt(length);
    

    serialize(buffer, type, object);
    if (buffer.remaining() != 0) {
      throw new IOException("Serialization failed: bad size");
    }
    return buffer;
  }
  
  public Object deserialize(InputStream source) throws IOException
  {
    ByteBuffer buffer = ByteBuffer.allocate(12);
    
    fillBuffer(source, buffer);
    buffer.flip();
    int bo = buffer.getInt();
    
    if (bo != -1059135839) {
      throw new IOException("Different byte order is not supported");
    }
    int version = buffer.getInt();
    
    if (version != currentVersion) {
      throw new IOException("Version of data is not supported. We support only strong match");
    }
    int length = buffer.getInt();
    

    buffer = ByteBuffer.allocate(length);
    fillBuffer(source, buffer);
    buffer.flip();
    Object res = deserializeAny(buffer);
    
    if (buffer.remaining() != 0) {
      throw new IOException("Serialization failed");
    }
    return res;
  }
  
  public Object deserialize(ByteBuffer buffer) throws IOException {
    int bo = buffer.getInt();
    
    if (bo != -1059135839) {
      throw new IOException("Different byte order is not supported");
    }
    
    int version = buffer.getInt();
    
    if (version != currentVersion) {
      throw new IOException("Version of data is not supported. We support only strong match");
    }
    int length = buffer.getInt();
    
    if (length != buffer.remaining()) {
      throw new IOException("Wrong buffer size, " + length + "expected but got " + buffer.remaining());
    }
    

    Object res = deserializeAny(buffer);
    
    if (buffer.remaining() != 0) {
      throw new IOException("Serialization failed");
    }
    return res;
  }
  
  public void serialize(ByteBuffer buffer, byte type, Object object) {
    ISerializableHelper helper = getHelper(type);
    


    if (object != null) {
      buffer.put(type);
      helper.serialize(this, buffer, object);
    } else {
      buffer.put((byte)-1);
    }
  }
  
  private static final int BYTE_ORDER = -1059135839;
  private final int currentVersion;
  public void serialize(ByteBuffer buffer, String data)
  {
    if (data == null) {
      buffer.putInt(-1);
    } else {
      ByteBuffer slice = encode(data);
      
      buffer.putInt(slice.limit());
      buffer.put(slice);
    }
  }
  
  public void serialize(ByteBuffer buffer, byte[] data) {
    if (data == null) {
      buffer.putInt(-1);
    } else {
      buffer.putInt(data.length);
      buffer.put(data);
    }
  }
  
  public void serialize(ByteBuffer buffer, int[] data) {
    if (data == null) {
      buffer.putInt(-1);
    } else {
      buffer.putInt(data.length);
      for (int aData : data) {
        buffer.putInt(aData);
      }
    }
  }
  
  public void serialize(ByteBuffer buffer, char[] data) {
    if (data == null) {
      buffer.putInt(-1);
    } else {
      buffer.putInt(data.length);
      for (char aData : data) {
        buffer.putChar(aData);
      }
    }
  }
  
  public void serialize(ByteBuffer buffer, double[] data) {
    if (data == null) {
      buffer.putInt(-1);
    } else {
      buffer.putInt(data.length);
      for (double aData : data) {
        buffer.putDouble(aData);
      }
    }
  }
  
  public void serialize(ByteBuffer buffer, float[] data) {
    if (data == null) {
      buffer.putInt(-1);
    } else {
      buffer.putInt(data.length);
      for (float aData : data) {
        buffer.putFloat(aData);
      }
    }
  }
  
  public void serialize(ByteBuffer buffer, boolean value) {
    buffer.put((byte)(value ? 1 : 0));
  }
  
  public void serialize(ByteBuffer buffer, double value) {
    buffer.putDouble(value);
  }
  
  public void serialize(ByteBuffer buffer, char value) {
    buffer.putChar(value);
  }
  
  public void serialize(ByteBuffer buffer, long value) {
    buffer.putLong(value);
  }
  
  public void serialize(ByteBuffer buffer, int value) {
    buffer.putInt(value);
  }
  
  public void serialize(ByteBuffer buffer, Event event) {
    byte type = HiddenAccess.getSerializationType(event);
    
    serialize(buffer, type, event);
  }
  
  public Object deserializeAny(ByteBuffer buffer) {
    byte type = buffer.get();
    
    if (type == -1) {
      return null;
    }
    return getHelper(type).deserialize(this, buffer);
  }
  
  public String deserializeString(ByteBuffer buffer) {
    int bytes = buffer.getInt();
    
    if (bytes == -1) {
      return null;
    }
    ByteBuffer slice = buffer.slice();
    
    slice.limit(bytes);
    String res;
    try
    {
      res = decoder.decode(slice).toString();
    } catch (CharacterCodingException e) {
      throw new Error("Bad character", e);
    }
    buffer.position(buffer.position() + bytes);
    return res;
  }
  
  public byte[] deserializeBytes(ByteBuffer buffer) {
    int len = buffer.getInt();
    
    if (len == -1) {
      return null;
    }
    byte[] res = new byte[len];
    
    buffer.get(res);
    return res;
  }
  
  public int[] deserializeIntegers(ByteBuffer buffer) {
    int len = buffer.getInt();
    
    if (len == -1) {
      return null;
    }
    int[] res = new int[len];
    
    for (int i = 0; i < len; i++) {
      res[i] = buffer.getInt();
    }
    return res;
  }
  
  public float[] deserializeFloats(ByteBuffer buffer) {
    int len = buffer.getInt();
    
    if (len == -1) {
      return null;
    }
    float[] res = new float[len];
    
    for (int i = 0; i < len; i++) {
      res[i] = buffer.getFloat();
    }
    return res;
  }
  
  public char[] deserializeChars(ByteBuffer buffer) {
    int len = buffer.getInt();
    
    if (len == -1) {
      return null;
    }
    char[] res = new char[len];
    
    for (int i = 0; i < len; i++) {
      res[i] = buffer.getChar();
    }
    return res;
  }
  
  public double[] deserializeDoubles(ByteBuffer buffer) {
    int len = buffer.getInt();
    
    if (len == -1) {
      return null;
    }
    double[] res = new double[len];
    
    for (int i = 0; i < len; i++) {
      res[i] = buffer.getDouble();
    }
    return res;
  }
  
  public boolean deserializeBoolean(ByteBuffer buffer) {
    return buffer.get() != 0;
  }
  
  public char deserializeChar(ByteBuffer buffer) {
    return buffer.getChar();
  }
  
  public int deserializeInt(ByteBuffer buffer) {
    return buffer.getInt();
  }
  
  public Float deserializeFloat(ByteBuffer buffer) {
    return Float.valueOf(buffer.getFloat());
  }
  
  public double deserializeDouble(ByteBuffer buffer) {
    return buffer.getDouble();
  }
  
  public long deserializeLong(ByteBuffer buffer) {
    return buffer.getLong();
  }
  
  public int sizeOf(String data) {
    return data == null ? 4 : 4 + encode(data).limit();
  }
  
  public int sizeOf(byte[] data) {
    return data == null ? 4 : 4 + data.length;
  }
  
  public int sizeOf(byte type, Object object) {
    return getHelper(type).sizeOf(this, object);
  }
  
  public int sizeOf(Event event) {
    return sizeOf(HiddenAccess.getSerializationType(event), event);
  }
  
  private ISerializableHelper getHelper(byte type) {
    ISerializableHelper helper = typeToHelper[type];
    
    if (helper == null) {
      throw new Error("Unknownd or unsupported data type");
    }
    return helper;
  }
  
  private ByteBuffer encode(String data) {
    ByteBuffer slice = ByteBuffer.allocate(data.length() * 3);
    
    encoder.encode(CharBuffer.wrap(data), slice, false);
    slice.flip();
    return slice;
  }
  
  private void fillBuffer(InputStream source, ByteBuffer buffer) throws IOException
  {
    do
    {
      int res = source.read(buffer.array(), buffer.position(), buffer.remaining());
      if (res == -1) {
        throw new IOException("Unexpected EOF");
      }
      buffer.position(buffer.position() + res);
    } while (buffer.remaining() != 0);
  }
  
  public static void register(Class<?> realClass, byte type) {
    try {
      if (realClass != null) {
        Method method = realClass.getDeclaredMethod("createHiddenSerializer", new Class[0]);
        
        method.setAccessible(true);
        ISerializableHelper helper = (ISerializableHelper)method.invoke(null, new Object[0]);
        
        method.setAccessible(false);
        typeToHelper[type] = helper;
        classToType.put(realClass, Byte.valueOf(type));
      }
    } catch (NoSuchMethodException e) {
      Logger.logError(e);
    } catch (InvocationTargetException e) {
      Logger.logError(e);
    } catch (IllegalAccessException e) {
      Logger.logError(e);
    }
  }
  
  public static ByteBuffer serializeToBuffer(Object src) throws IOException {
    RbSerializer rbs = new RbSerializer();
    Byte type = (Byte)classToType.get(src.getClass());
    
    return rbs.serialize(type.byteValue(), src);
  }
  
  public static <T> T deserializeFromBuffer(ByteBuffer buffer) throws IOException
  {
    RbSerializer rbs = new RbSerializer();
    Object res = rbs.deserialize(buffer);
    
    return res;
  }
  
  public static Object deepCopy(byte type, Object src) {
    ByteArrayOutputStream out = new ByteArrayOutputStream(1024);
    RbSerializer rbs = new RbSerializer();
    try
    {
      rbs.serialize(out, type, src);
      ByteArrayInputStream in = new ByteArrayInputStream(out.toByteArray());
      
      return rbs.deserialize(in);
    } catch (IOException e) {
      Logger.logError(e); }
    return null;
  }
}
