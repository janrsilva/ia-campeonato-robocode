package robocode.robotinterfaces;

public abstract interface ITeamRobot
  extends IAdvancedRobot
{
  public abstract ITeamEvents getTeamEventListener();
}
