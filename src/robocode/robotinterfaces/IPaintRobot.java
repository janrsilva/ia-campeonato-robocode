package robocode.robotinterfaces;

public abstract interface IPaintRobot
  extends IBasicRobot
{
  public abstract IPaintEvents getPaintEventListener();
}
