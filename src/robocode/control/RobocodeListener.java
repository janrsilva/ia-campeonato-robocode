package robocode.control;

@Deprecated
public abstract interface RobocodeListener
{
  @Deprecated
  public abstract void battleComplete(BattleSpecification paramBattleSpecification, RobotResults[] paramArrayOfRobotResults);
  
  @Deprecated
  public abstract void battleAborted(BattleSpecification paramBattleSpecification);
  
  @Deprecated
  public abstract void battleMessage(String paramString);
}
