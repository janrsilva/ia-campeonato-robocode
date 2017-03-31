package robocode.control.events;













public class BattleErrorEvent
  extends BattleEvent
{
  private final String error;
  












  public BattleErrorEvent(String error)
  {
    this.error = error;
  }
  




  public String getError()
  {
    return error;
  }
}
