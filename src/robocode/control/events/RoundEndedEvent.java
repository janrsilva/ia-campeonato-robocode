package robocode.control.events;








public class RoundEndedEvent
  extends BattleEvent
{
  private final int round;
  






  private final int turns;
  





  private final int totalTurns;
  






  public RoundEndedEvent(int round, int turns, int totalTurns)
  {
    this.round = round;
    this.turns = turns;
    this.totalTurns = totalTurns;
  }
  




  public int getRound()
  {
    return round;
  }
  






  public int getTurns()
  {
    return turns;
  }
  








  public int getTotalTurns()
  {
    return totalTurns;
  }
}
