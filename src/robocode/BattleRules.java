package robocode;

import java.io.Serializable;
import net.sf.robocode.security.IHiddenRulesHelper;


























public final class BattleRules
  implements Serializable
{
  private static final long serialVersionUID = 1L;
  private final int battlefieldWidth;
  private final int battlefieldHeight;
  private final int numRounds;
  private final double gunCoolingRate;
  private final long inactivityTime;
  private final boolean hideEnemyNames;
  private final int sentryBorderSize;
  
  public int getBattlefieldWidth()
  {
    return battlefieldWidth;
  }
  




  public int getBattlefieldHeight()
  {
    return battlefieldHeight;
  }
  




  public int getNumRounds()
  {
    return numRounds;
  }
  










  public double getGunCoolingRate()
  {
    return gunCoolingRate;
  }
  















  public long getInactivityTime()
  {
    return inactivityTime;
  }
  




  public boolean getHideEnemyNames()
  {
    return hideEnemyNames;
  }
  











  public int getSentryBorderSize()
  {
    return sentryBorderSize;
  }
  
  private BattleRules(int battlefieldWidth, int battlefieldHeight, int numRounds, double gunCoolingRate, long inactivityTime, boolean hideEnemyNames, int sentryBorderSize)
  {
    this.battlefieldWidth = battlefieldWidth;
    this.battlefieldHeight = battlefieldHeight;
    this.numRounds = numRounds;
    this.gunCoolingRate = gunCoolingRate;
    this.inactivityTime = inactivityTime;
    this.hideEnemyNames = hideEnemyNames;
    this.sentryBorderSize = sentryBorderSize;
  }
  
  static IHiddenRulesHelper createHiddenHelper() {
    return new HiddenHelper(null);
  }
  
  private static class HiddenHelper implements IHiddenRulesHelper {
    private HiddenHelper() {}
    
    public BattleRules createRules(int battlefieldWidth, int battlefieldHeight, int numRounds, double gunCoolingRate, long inactivityTime, boolean hideEnemyNames, int sentryBorderSize) { return new BattleRules(battlefieldWidth, battlefieldHeight, numRounds, gunCoolingRate, inactivityTime, hideEnemyNames, sentryBorderSize, null); }
  }
}
