package net.sf.robocode.battle;

import robocode.control.BattleSpecification;
import robocode.control.events.IBattleListener;

public abstract interface IBattleManagerBase
{
  public abstract void addListener(IBattleListener paramIBattleListener);
  
  public abstract void removeListener(IBattleListener paramIBattleListener);
  
  public abstract void waitTillOver();
  
  public abstract void stop(boolean paramBoolean);
  
  public abstract void startNewBattle(BattleSpecification paramBattleSpecification, String paramString, boolean paramBoolean1, boolean paramBoolean2);
}
