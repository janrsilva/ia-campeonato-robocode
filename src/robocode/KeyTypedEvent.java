package robocode;

import java.awt.Graphics2D;
import java.nio.ByteBuffer;
import net.sf.robocode.peer.IRobotStatics;
import net.sf.robocode.security.SafeComponent;
import net.sf.robocode.serialization.ISerializableHelper;
import net.sf.robocode.serialization.RbSerializer;
import robocode.robotinterfaces.IBasicRobot;
import robocode.robotinterfaces.IInteractiveEvents;
import robocode.robotinterfaces.IInteractiveRobot;

























public final class KeyTypedEvent
  extends KeyEvent
{
  private static final long serialVersionUID = 1L;
  private static final int DEFAULT_PRIORITY = 98;
  
  public KeyTypedEvent(java.awt.event.KeyEvent source)
  {
    super(source);
  }
  



  final int getDefaultPriority()
  {
    return 98;
  }
  



  final void dispatch(IBasicRobot robot, IRobotStatics statics, Graphics2D graphics)
  {
    if (statics.isInteractiveRobot()) {
      IInteractiveEvents listener = ((IInteractiveRobot)robot).getInteractiveEventListener();
      
      if (listener != null) {
        listener.onKeyTyped(getSourceEvent());
      }
    }
  }
  



  byte getSerializationType()
  {
    return 46;
  }
  
  static ISerializableHelper createHiddenSerializer() {
    return new SerializableHelper(null);
  }
  
  private static class SerializableHelper implements ISerializableHelper {
    private SerializableHelper() {}
    
    public int sizeOf(RbSerializer serializer, Object object) { return 27; }
    

    public void serialize(RbSerializer serializer, ByteBuffer buffer, Object object)
    {
      KeyTypedEvent obj = (KeyTypedEvent)object;
      java.awt.event.KeyEvent src = obj.getSourceEvent();
      
      serializer.serialize(buffer, src.getKeyChar());
      serializer.serialize(buffer, src.getKeyCode());
      serializer.serialize(buffer, src.getKeyLocation());
      serializer.serialize(buffer, src.getID());
      serializer.serialize(buffer, src.getModifiersEx());
      serializer.serialize(buffer, src.getWhen());
    }
    
    public Object deserialize(RbSerializer serializer, ByteBuffer buffer) {
      char keyChar = buffer.getChar();
      int keyCode = buffer.getInt();
      int keyLocation = buffer.getInt();
      int id = buffer.getInt();
      int modifiersEx = buffer.getInt();
      long when = buffer.getLong();
      
      return new KeyTypedEvent(new java.awt.event.KeyEvent(SafeComponent.getSafeEventComponent(), id, when, modifiersEx, keyCode, keyChar, keyLocation));
    }
  }
}
