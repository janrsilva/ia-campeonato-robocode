package robocode.control.events;















public class BattleFinishedEvent
  extends BattleEvent
{
  private final boolean isAborted;
  














  public BattleFinishedEvent(boolean isAborted)
  {
    this.isAborted = isAborted;
  }
  




  public boolean isAborted()
  {
    return isAborted;
  }
}
