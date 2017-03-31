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






























public final class MousePressedEvent
  extends MouseEvent
{
  private static final long serialVersionUID = 1L;
  private static final int DEFAULT_PRIORITY = 98;
  
  public MousePressedEvent(java.awt.event.MouseEvent source)
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
        listener.onMousePressed(getSourceEvent());
      }
    }
  }
  



  byte getSerializationType()
  {
    return 52;
  }
  
  static ISerializableHelper createHiddenSerializer() {
    return new SerializableHelper(null);
  }
  
  private static class SerializableHelper implements ISerializableHelper {
    private SerializableHelper() {}
    
    public int sizeOf(RbSerializer serializer, Object object) { return 33; }
    
    public void serialize(RbSerializer serializer, ByteBuffer buffer, Object object)
    {
      MousePressedEvent obj = (MousePressedEvent)object;
      java.awt.event.MouseEvent src = obj.getSourceEvent();
      
      serializer.serialize(buffer, src.getButton());
      serializer.serialize(buffer, src.getClickCount());
      serializer.serialize(buffer, src.getX());
      serializer.serialize(buffer, src.getY());
      serializer.serialize(buffer, src.getID());
      serializer.serialize(buffer, src.getModifiersEx());
      serializer.serialize(buffer, src.getWhen());
    }
    
    public Object deserialize(RbSerializer serializer, ByteBuffer buffer) {
      int button = buffer.getInt();
      int clickCount = buffer.getInt();
      int x = buffer.getInt();
      int y = buffer.getInt();
      int id = buffer.getInt();
      int modifiersEx = buffer.getInt();
      long when = buffer.getLong();
      
      return new MousePressedEvent(new java.awt.event.MouseEvent(SafeComponent.getSafeEventComponent(), id, when, modifiersEx, x, y, clickCount, false, button));
    }
  }
}
