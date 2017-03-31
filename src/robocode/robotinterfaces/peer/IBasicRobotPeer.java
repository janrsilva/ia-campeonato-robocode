package robocode.robotinterfaces.peer;

import java.awt.Color;
import java.awt.Graphics2D;
import robocode.Bullet;

public abstract interface IBasicRobotPeer
{
  public abstract String getName();
  
  public abstract long getTime();
  
  public abstract double getEnergy();
  
  public abstract double getX();
  
  public abstract double getY();
  
  public abstract double getVelocity();
  
  public abstract double getBodyHeading();
  
  public abstract double getGunHeading();
  
  public abstract double getRadarHeading();
  
  public abstract double getGunHeat();
  
  public abstract double getBattleFieldWidth();
  
  public abstract double getBattleFieldHeight();
  
  public abstract int getOthers();
  
  public abstract int getNumSentries();
  
  public abstract int getNumRounds();
  
  public abstract int getRoundNum();
  
  public abstract int getSentryBorderSize();
  
  public abstract double getGunCoolingRate();
  
  public abstract double getDistanceRemaining();
  
  public abstract double getBodyTurnRemaining();
  
  public abstract double getGunTurnRemaining();
  
  public abstract double getRadarTurnRemaining();
  
  public abstract void execute();
  
  public abstract void move(double paramDouble);
  
  public abstract void turnBody(double paramDouble);
  
  public abstract void turnGun(double paramDouble);
  
  public abstract Bullet fire(double paramDouble);
  
  public abstract Bullet setFire(double paramDouble);
  
  public abstract void setBodyColor(Color paramColor);
  
  public abstract void setGunColor(Color paramColor);
  
  public abstract void setRadarColor(Color paramColor);
  
  public abstract void setBulletColor(Color paramColor);
  
  public abstract void setScanColor(Color paramColor);
  
  public abstract void getCall();
  
  public abstract void setCall();
  
  public abstract Graphics2D getGraphics();
  
  public abstract void setDebugProperty(String paramString1, String paramString2);
  
  public abstract void rescan();
}
