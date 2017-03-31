package robocode;












public class MoveCompleteCondition
  extends Condition
{
  private AdvancedRobot robot;
  











  public MoveCompleteCondition(AdvancedRobot robot)
  {
    this.robot = robot;
  }
  









  public MoveCompleteCondition(AdvancedRobot robot, int priority)
  {
    this.robot = robot;
    this.priority = priority;
  }
  






  public boolean test()
  {
    return robot.getDistanceRemaining() == 0.0D;
  }
  





  public void cleanup()
  {
    robot = null;
  }
}
