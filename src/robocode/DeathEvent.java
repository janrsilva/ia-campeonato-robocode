package robocode;

import java.awt.Graphics2D;
import java.nio.ByteBuffer;
import net.sf.robocode.peer.IRobotStatics;
import net.sf.robocode.serialization.ISerializableHelper;
import net.sf.robocode.serialization.RbSerializer;
import robocode.robotinterfaces.IBasicEvents;
import robocode.robotinterfaces.IBasicRobot;
























public final class DeathEvent
  extends Event
{
  private static final long serialVersionUID = 1L;
  private static final int DEFAULT_PRIORITY = -1;
  
  public DeathEvent() {}
  
  public final int getPriority()
  {
    return -1;
  }
  



  final int getDefaultPriority()
  {
    return -1;
  }
  



  final void dispatch(IBasicRobot robot, IRobotStatics statics, Graphics2D graphics)
  {
    IBasicEvents listener = robot.getBasicEventListener();
    
    if (listener != null) {
      listener.onDeath(this);
    }
  }
  



  final boolean isCriticalEvent()
  {
    return true;
  }
  



  byte getSerializationType()
  {
    return 36;
  }
  

  static ISerializableHelper createHiddenSerializer() { return new SerializableHelper(null); }
  
  private static class SerializableHelper implements ISerializableHelper {
    private SerializableHelper() {}
    
    public int sizeOf(RbSerializer serializer, Object object) { return 1; }
    
    public void serialize(RbSerializer serializer, ByteBuffer buffer, Object object) {}
    
    public Object deserialize(RbSerializer serializer, ByteBuffer buffer)
    {
      return new DeathEvent();
    }
  }
}
