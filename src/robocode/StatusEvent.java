package robocode;

import java.awt.Graphics2D;
import net.sf.robocode.peer.IRobotStatics;
import robocode.robotinterfaces.IBasicEvents;
import robocode.robotinterfaces.IBasicRobot;

























public final class StatusEvent
  extends Event
{
  private static final long serialVersionUID = 1L;
  private static final int DEFAULT_PRIORITY = 99;
  private final RobotStatus status;
  
  public StatusEvent(RobotStatus status)
  {
    this.status = status;
  }
  





  public RobotStatus getStatus()
  {
    return status;
  }
  



  final int getDefaultPriority()
  {
    return 99;
  }
  



  final void dispatch(IBasicRobot robot, IRobotStatics statics, Graphics2D graphics)
  {
    IBasicEvents listener = robot.getBasicEventListener();
    
    if (listener != null) {
      listener.onStatus(this);
    }
  }
  



  byte getSerializationType()
  {
    throw new Error("Serialization of this type is not supported");
  }
}
