package robocode;

import java.awt.Graphics2D;
import java.io.Serializable;
import net.sf.robocode.peer.IRobotStatics;
import robocode.robotinterfaces.IBasicRobot;
import robocode.robotinterfaces.ITeamEvents;
import robocode.robotinterfaces.ITeamRobot;






















public final class MessageEvent
  extends Event
{
  private static final long serialVersionUID = 1L;
  private static final int DEFAULT_PRIORITY = 75;
  private final String sender;
  private final Serializable message;
  
  public MessageEvent(String sender, Serializable message)
  {
    this.sender = sender;
    this.message = message;
  }
  




  public String getSender()
  {
    return sender;
  }
  




  public Serializable getMessage()
  {
    return message;
  }
  



  final int getDefaultPriority()
  {
    return 75;
  }
  



  final void dispatch(IBasicRobot robot, IRobotStatics statics, Graphics2D graphics)
  {
    if (statics.isTeamRobot()) {
      ITeamEvents listener = ((ITeamRobot)robot).getTeamEventListener();
      
      if (listener != null) {
        listener.onMessageReceived(this);
      }
    }
  }
  



  byte getSerializationType()
  {
    throw new Error("Serialization of event type not supported");
  }
}
