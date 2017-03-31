package robocode.robotinterfaces;

import robocode.BattleEndedEvent;

public abstract interface IBasicEvents2
  extends IBasicEvents
{
  public abstract void onBattleEnded(BattleEndedEvent paramBattleEndedEvent);
}
