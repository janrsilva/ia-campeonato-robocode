package robocode;












public class TurnCompleteCondition
  extends Condition
{
  private AdvancedRobot robot;
  











  public TurnCompleteCondition(AdvancedRobot robot)
  {
    this.robot = robot;
  }
  









  public TurnCompleteCondition(AdvancedRobot robot, int priority)
  {
    this.robot = robot;
    this.priority = priority;
  }
  






  public boolean test()
  {
    return robot.getTurnRemaining() == 0.0D;
  }
  





  public void cleanup()
  {
    robot = null;
  }
}
