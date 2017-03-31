package robocode;

import java.awt.Graphics2D;
import net.sf.robocode.peer.IRobotStatics;
import robocode.robotinterfaces.IBasicRobot;
import robocode.robotinterfaces.IPaintEvents;
import robocode.robotinterfaces.IPaintRobot;



























public final class PaintEvent
  extends Event
{
  private static final long serialVersionUID = 1L;
  private static final int DEFAULT_PRIORITY = 5;
  
  public PaintEvent() {}
  
  final int getDefaultPriority()
  {
    return 5;
  }
  



  final void dispatch(IBasicRobot robot, IRobotStatics statics, Graphics2D graphics)
  {
    if (statics.isPaintRobot()) {
      IPaintEvents listener = ((IPaintRobot)robot).getPaintEventListener();
      
      if (listener != null) {
        listener.onPaint(graphics);
      }
    }
  }
  



  byte getSerializationType()
  {
    throw new Error("Serialization of this type is not supported");
  }
}
