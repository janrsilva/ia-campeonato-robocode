package robocode;












public class RadarTurnCompleteCondition
  extends Condition
{
  private AdvancedRobot robot;
  











  public RadarTurnCompleteCondition(AdvancedRobot robot)
  {
    this.robot = robot;
  }
  









  public RadarTurnCompleteCondition(AdvancedRobot robot, int priority)
  {
    this.robot = robot;
    this.priority = priority;
  }
  






  public boolean test()
  {
    return robot.getRadarTurnRemaining() == 0.0D;
  }
  





  public void cleanup()
  {
    robot = null;
  }
}
