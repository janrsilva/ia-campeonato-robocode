package robocode;

import java.awt.Graphics2D;
import net.sf.robocode.peer.IRobotStatics;
import robocode.robotinterfaces.IAdvancedEvents;
import robocode.robotinterfaces.IAdvancedRobot;
import robocode.robotinterfaces.IBasicRobot;

























public class CustomEvent
  extends Event
{
  private static final long serialVersionUID = 1L;
  private static final int DEFAULT_PRIORITY = 80;
  private final transient Condition condition;
  
  public CustomEvent(Condition condition)
  {
    this.condition = condition;
    if (condition != null) {
      setPriority(condition.getPriority());
    }
  }
  











  public CustomEvent(Condition condition, int priority)
  {
    this.condition = condition;
    setPriority(priority);
    if (condition != null) {
      condition.setPriority(getPriority());
    }
  }
  














  public Condition getCondition()
  {
    return condition;
  }
  



  final int getDefaultPriority()
  {
    return 80;
  }
  



  final void dispatch(IBasicRobot robot, IRobotStatics statics, Graphics2D graphics)
  {
    if (statics.isAdvancedRobot()) {
      IAdvancedEvents listener = ((IAdvancedRobot)robot).getAdvancedEventListener();
      
      if (listener != null) {
        listener.onCustomEvent(this);
      }
    }
  }
  




  public final int compareTo(Event event)
  {
    return super.compareTo(event);
  }
  




  final boolean isCriticalEvent()
  {
    return false;
  }
  




  public final int getPriority()
  {
    return super.getPriority();
  }
  



  byte getSerializationType()
  {
    throw new Error("Serialization not supported on this event type");
  }
}
