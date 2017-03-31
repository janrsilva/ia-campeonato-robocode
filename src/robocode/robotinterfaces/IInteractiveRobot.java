package robocode.robotinterfaces;

public abstract interface IInteractiveRobot
  extends IBasicRobot
{
  public abstract IInteractiveEvents getInteractiveEventListener();
}
