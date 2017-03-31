package robocode;

import java.awt.Graphics2D;
import java.nio.ByteBuffer;
import net.sf.robocode.peer.IRobotStatics;
import net.sf.robocode.serialization.ISerializableHelper;
import net.sf.robocode.serialization.RbSerializer;
import robocode.robotinterfaces.IBasicEvents;
import robocode.robotinterfaces.IBasicRobot;
























public final class WinEvent
  extends Event
{
  private static final long serialVersionUID = 1L;
  private static final int DEFAULT_PRIORITY = 100;
  
  public WinEvent() {}
  
  public final int getPriority()
  {
    return 100;
  }
  



  final int getDefaultPriority()
  {
    return 100;
  }
  



  final void dispatch(IBasicRobot robot, IRobotStatics statics, Graphics2D graphics)
  {
    IBasicEvents listener = robot.getBasicEventListener();
    
    if (listener != null) {
      listener.onWin(this);
    }
  }
  



  final boolean isCriticalEvent()
  {
    return true;
  }
  



  byte getSerializationType()
  {
    return 37;
  }
  

  static ISerializableHelper createHiddenSerializer() { return new SerializableHelper(null); }
  
  private static class SerializableHelper implements ISerializableHelper {
    private SerializableHelper() {}
    
    public int sizeOf(RbSerializer serializer, Object object) { return 1; }
    
    public void serialize(RbSerializer serializer, ByteBuffer buffer, Object object) {}
    
    public Object deserialize(RbSerializer serializer, ByteBuffer buffer)
    {
      return new WinEvent();
    }
  }
}
