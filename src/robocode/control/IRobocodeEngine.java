package robocode.control;

import robocode.control.events.IBattleListener;

public abstract interface IRobocodeEngine
{
  public abstract void addBattleListener(IBattleListener paramIBattleListener);
  
  public abstract void removeBattleListener(IBattleListener paramIBattleListener);
  
  public abstract void close();
  
  public abstract String getVersion();
  
  public abstract void setVisible(boolean paramBoolean);
  
  public abstract RobotSpecification[] getLocalRepository();
  
  public abstract RobotSpecification[] getLocalRepository(String paramString);
  
  public abstract void runBattle(BattleSpecification paramBattleSpecification);
  
  public abstract void runBattle(BattleSpecification paramBattleSpecification, boolean paramBoolean);
  
  public abstract void runBattle(BattleSpecification paramBattleSpecification, String paramString, boolean paramBoolean);
  
  public abstract void waitTillBattleOver();
  
  public abstract void abortCurrentBattle();
}
