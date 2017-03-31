package robocode;

import java.awt.Graphics2D;
import java.nio.ByteBuffer;
import net.sf.robocode.peer.IRobotStatics;
import net.sf.robocode.serialization.ISerializableHelper;
import net.sf.robocode.serialization.RbSerializer;
import robocode.robotinterfaces.IBasicEvents;
import robocode.robotinterfaces.IBasicRobot;






















public final class RobotDeathEvent
  extends Event
{
  private static final long serialVersionUID = 1L;
  private static final int DEFAULT_PRIORITY = 70;
  private final String robotName;
  
  public RobotDeathEvent(String robotName)
  {
    this.robotName = robotName;
  }
  




  public String getName()
  {
    return robotName;
  }
  



  @Deprecated
  public String getRobotName()
  {
    return robotName;
  }
  



  final int getDefaultPriority()
  {
    return 70;
  }
  



  final void dispatch(IBasicRobot robot, IRobotStatics statics, Graphics2D graphics)
  {
    IBasicEvents listener = robot.getBasicEventListener();
    
    if (listener != null) {
      listener.onRobotDeath(this);
    }
  }
  



  byte getSerializationType()
  {
    return 39;
  }
  

  static ISerializableHelper createHiddenSerializer() { return new SerializableHelper(null); }
  
  private static class SerializableHelper implements ISerializableHelper {
    private SerializableHelper() {}
    
    public int sizeOf(RbSerializer serializer, Object object) { RobotDeathEvent obj = (RobotDeathEvent)object;
      
      return 1 + serializer.sizeOf(robotName);
    }
    
    public void serialize(RbSerializer serializer, ByteBuffer buffer, Object object) {
      RobotDeathEvent obj = (RobotDeathEvent)object;
      
      serializer.serialize(buffer, robotName);
    }
    
    public Object deserialize(RbSerializer serializer, ByteBuffer buffer) {
      String name = serializer.deserializeString(buffer);
      
      return new RobotDeathEvent(name);
    }
  }
}
