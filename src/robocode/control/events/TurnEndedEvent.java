package robocode.control.events;

import robocode.control.snapshot.ITurnSnapshot;


























public class TurnEndedEvent
  extends BattleEvent
{
  private final ITurnSnapshot turnSnapshot;
  
  public TurnEndedEvent(ITurnSnapshot turnSnapshot)
  {
    this.turnSnapshot = turnSnapshot;
  }
  




  public ITurnSnapshot getTurnSnapshot()
  {
    return turnSnapshot;
  }
}
