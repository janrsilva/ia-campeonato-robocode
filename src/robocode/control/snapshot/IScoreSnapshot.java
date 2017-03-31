package robocode.control.snapshot;

public abstract interface IScoreSnapshot
  extends Comparable<Object>
{
  public abstract String getName();
  
  public abstract double getTotalScore();
  
  public abstract double getTotalSurvivalScore();
  
  public abstract double getTotalLastSurvivorBonus();
  
  public abstract double getTotalBulletDamageScore();
  
  public abstract double getTotalBulletKillBonus();
  
  public abstract double getTotalRammingDamageScore();
  
  public abstract double getTotalRammingKillBonus();
  
  public abstract int getTotalFirsts();
  
  public abstract int getTotalSeconds();
  
  public abstract int getTotalThirds();
  
  public abstract double getCurrentScore();
  
  public abstract double getCurrentSurvivalScore();
  
  public abstract double getCurrentSurvivalBonus();
  
  public abstract double getCurrentBulletDamageScore();
  
  public abstract double getCurrentBulletKillBonus();
  
  public abstract double getCurrentRammingDamageScore();
  
  public abstract double getCurrentRammingKillBonus();
}
