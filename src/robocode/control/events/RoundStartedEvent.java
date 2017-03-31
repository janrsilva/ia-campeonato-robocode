package robocode.control.events;

import robocode.control.snapshot.ITurnSnapshot;



























public class RoundStartedEvent
  extends BattleEvent
{
  private final ITurnSnapshot startSnapshot;
  private final int round;
  
  public RoundStartedEvent(ITurnSnapshot startSnapshot, int round)
  {
    this.startSnapshot = startSnapshot;
    this.round = round;
  }
  





  public ITurnSnapshot getStartSnapshot()
  {
    return startSnapshot;
  }
  




  public int getRound()
  {
    return round;
  }
}
