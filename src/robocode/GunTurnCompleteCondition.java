package robocode;

















public class GunTurnCompleteCondition
  extends Condition
{
  private AdvancedRobot robot = null;
  






  public GunTurnCompleteCondition(AdvancedRobot robot)
  {
    this.robot = robot;
  }
  









  public GunTurnCompleteCondition(AdvancedRobot robot, int priority)
  {
    this.robot = robot;
    this.priority = priority;
  }
  






  public boolean test()
  {
    return robot.getGunTurnRemaining() == 0.0D;
  }
  





  public final void cleanup()
  {
    robot = null;
  }
}
