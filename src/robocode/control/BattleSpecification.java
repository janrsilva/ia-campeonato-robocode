package robocode.control;

import java.io.Serializable;




















public class BattleSpecification
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
  private final RobotSpecification[] robots;
  private final RobotSetup[] initialSetups;
  
  public BattleSpecification(int numRounds, BattlefieldSpecification battlefieldSize, RobotSpecification[] robots)
  {
    this(numRounds, 450L, 0.1D, battlefieldSize, robots);
  }
  








  public BattleSpecification(int numRounds, long inactivityTime, double gunCoolingRate, BattlefieldSpecification battlefieldSize, RobotSpecification[] robots)
  {
    this(numRounds, inactivityTime, gunCoolingRate, false, battlefieldSize, robots);
  }
  











  public BattleSpecification(int numRounds, long inactivityTime, double gunCoolingRate, boolean hideEnemyNames, BattlefieldSpecification battlefieldSize, RobotSpecification[] robots)
  {
    this(battlefieldSize, numRounds, inactivityTime, gunCoolingRate, 100, hideEnemyNames, robots);
  }
  












  public BattleSpecification(BattlefieldSpecification battlefieldSize, int numRounds, long inactivityTime, double gunCoolingRate, int sentryBorderSize, boolean hideEnemyNames, RobotSpecification[] robots)
  {
    this(battlefieldSize, numRounds, inactivityTime, gunCoolingRate, 100, hideEnemyNames, robots, null);
  }
  













  public BattleSpecification(BattlefieldSpecification battlefieldSize, int numRounds, long inactivityTime, double gunCoolingRate, int sentryBorderSize, boolean hideEnemyNames, RobotSpecification[] robots, RobotSetup[] initialSetups)
  {
    if (battlefieldSize == null) {
      throw new IllegalArgumentException("battlefieldSize cannot be null");
    }
    if (robots == null) {
      throw new IllegalArgumentException("robots cannot be null");
    }
    if (robots.length < 1) {
      throw new IllegalArgumentException("robots.length must be > 0");
    }
    if ((initialSetups != null) && (initialSetups.length != robots.length)) {
      throw new IllegalArgumentException("initialSetups.length must be == robots.length");
    }
    if (numRounds < 1) {
      throw new IllegalArgumentException("numRounds must be >= 1");
    }
    if (inactivityTime < 1L) {
      throw new IllegalArgumentException("inactivityTime must be >= 1");
    }
    if (gunCoolingRate < 0.1D) {
      throw new IllegalArgumentException("inactivityTime must be >= 0.1");
    }
    if (sentryBorderSize < 50) {
      throw new IllegalArgumentException("sentryBorderSize must be >= 50");
    }
    battlefieldWidth = battlefieldSize.getWidth();
    battlefieldHeight = battlefieldSize.getHeight();
    this.numRounds = numRounds;
    this.inactivityTime = inactivityTime;
    this.gunCoolingRate = gunCoolingRate;
    this.sentryBorderSize = sentryBorderSize;
    this.hideEnemyNames = hideEnemyNames;
    this.robots = robots;
    this.initialSetups = initialSetups;
  }
  




  public long getInactivityTime()
  {
    return inactivityTime;
  }
  




  public double getGunCoolingRate()
  {
    return gunCoolingRate;
  }
  




  public BattlefieldSpecification getBattlefield()
  {
    return new BattlefieldSpecification(battlefieldWidth, battlefieldHeight);
  }
  




  public int getNumRounds()
  {
    return numRounds;
  }
  






  public boolean getHideEnemyNames()
  {
    return hideEnemyNames;
  }
  











  public int getSentryBorderSize()
  {
    return sentryBorderSize;
  }
  






  public RobotSpecification[] getRobots()
  {
    if (robots == null) {
      return null;
    }
    RobotSpecification[] robotsCopy = new RobotSpecification[robots.length];
    System.arraycopy(robots, 0, robotsCopy, 0, robots.length);
    return robotsCopy;
  }
  







  public RobotSetup[] getInitialSetups()
  {
    if (initialSetups == null) {
      return null;
    }
    RobotSetup[] setupsCopy = new RobotSetup[initialSetups.length];
    System.arraycopy(initialSetups, 0, setupsCopy, 0, initialSetups.length);
    return setupsCopy;
  }
}
