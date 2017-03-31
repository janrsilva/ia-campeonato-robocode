package robocode.control.snapshot;

public abstract interface IRobotSnapshot
{
  public abstract String getName();
  
  public abstract String getShortName();
  
  public abstract String getVeryShortName();
  
  public abstract String getTeamName();
  
  public abstract int getRobotIndex();
  
  public abstract int getTeamIndex();
  
  public abstract int getContestantIndex();
  
  public abstract RobotState getState();
  
  public abstract double getEnergy();
  
  public abstract double getVelocity();
  
  public abstract double getBodyHeading();
  
  public abstract double getGunHeading();
  
  public abstract double getRadarHeading();
  
  public abstract double getGunHeat();
  
  public abstract double getX();
  
  public abstract double getY();
  
  public abstract int getBodyColor();
  
  public abstract int getGunColor();
  
  public abstract int getRadarColor();
  
  public abstract int getScanColor();
  
  public abstract boolean isDroid();
  
  public abstract boolean isSentryRobot();
  
  public abstract boolean isPaintRobot();
  
  public abstract boolean isPaintEnabled();
  
  public abstract boolean isSGPaintEnabled();
  
  public abstract IDebugProperty[] getDebugProperties();
  
  public abstract String getOutputStreamSnapshot();
  
  public abstract IScoreSnapshot getScoreSnapshot();
}
