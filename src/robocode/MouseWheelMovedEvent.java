package robocode;

import java.awt.Graphics2D;
import java.awt.event.MouseWheelEvent;
import java.nio.ByteBuffer;
import net.sf.robocode.peer.IRobotStatics;
import net.sf.robocode.security.SafeComponent;
import net.sf.robocode.serialization.ISerializableHelper;
import net.sf.robocode.serialization.RbSerializer;
import robocode.robotinterfaces.IBasicRobot;
import robocode.robotinterfaces.IInteractiveEvents;
import robocode.robotinterfaces.IInteractiveRobot;





























public final class MouseWheelMovedEvent
  extends MouseEvent
{
  private static final long serialVersionUID = 1L;
  private static final int DEFAULT_PRIORITY = 98;
  
  public MouseWheelMovedEvent(java.awt.event.MouseEvent source)
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
        listener.onMouseWheelMoved((MouseWheelEvent)getSourceEvent());
      }
    }
  }
  



  byte getSerializationType()
  {
    return 54;
  }
  
  static ISerializableHelper createHiddenSerializer() {
    return new SerializableHelper(null);
  }
  
  private static class SerializableHelper implements ISerializableHelper {
    private SerializableHelper() {}
    
    public int sizeOf(RbSerializer serializer, Object object) { return 41; }
    
    public void serialize(RbSerializer serializer, ByteBuffer buffer, Object object)
    {
      MouseWheelMovedEvent obj = (MouseWheelMovedEvent)object;
      MouseWheelEvent src = (MouseWheelEvent)obj.getSourceEvent();
      
      serializer.serialize(buffer, src.getClickCount());
      serializer.serialize(buffer, src.getX());
      serializer.serialize(buffer, src.getY());
      serializer.serialize(buffer, src.getScrollType());
      serializer.serialize(buffer, src.getScrollAmount());
      serializer.serialize(buffer, src.getWheelRotation());
      serializer.serialize(buffer, src.getID());
      serializer.serialize(buffer, src.getModifiersEx());
      serializer.serialize(buffer, src.getWhen());
    }
    
    public Object deserialize(RbSerializer serializer, ByteBuffer buffer) {
      int clickCount = buffer.getInt();
      int x = buffer.getInt();
      int y = buffer.getInt();
      int scrollType = buffer.getInt();
      int scrollAmount = buffer.getInt();
      int wheelRotation = buffer.getInt();
      int id = buffer.getInt();
      int modifiersEx = buffer.getInt();
      long when = buffer.getLong();
      
      return new MouseWheelMovedEvent(new MouseWheelEvent(SafeComponent.getSafeEventComponent(), id, when, modifiersEx, x, y, clickCount, false, scrollType, scrollAmount, wheelRotation));
    }
  }
}
