package robocode.control.events;













public class BattleMessageEvent
  extends BattleEvent
{
  private final String message;
  












  public BattleMessageEvent(String message)
  {
    this.message = message;
  }
  




  public String getMessage()
  {
    return message;
  }
}
