package robocode.control.events;

import robocode.BattleRules;






























public class BattleStartedEvent
  extends BattleEvent
{
  private final BattleRules battleRules;
  private final boolean isReplay;
  private final int robotsCount;
  
  public BattleStartedEvent(BattleRules battleRules, int robotsCount, boolean isReplay)
  {
    this.battleRules = battleRules;
    this.isReplay = isReplay;
    this.robotsCount = robotsCount;
  }
  




  public BattleRules getBattleRules()
  {
    return battleRules;
  }
  




  public int getRobotsCount()
  {
    return robotsCount;
  }
  




  public boolean isReplay()
  {
    return isReplay;
  }
}
