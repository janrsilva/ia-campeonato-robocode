package robocode.robotinterfaces.peer;

import java.io.File;
import java.util.List;
import robocode.BulletHitBulletEvent;
import robocode.BulletHitEvent;
import robocode.BulletMissedEvent;
import robocode.Condition;
import robocode.Event;
import robocode.HitByBulletEvent;
import robocode.HitRobotEvent;
import robocode.HitWallEvent;
import robocode.RobotDeathEvent;
import robocode.ScannedRobotEvent;
import robocode.StatusEvent;

public abstract interface IAdvancedRobotPeer
  extends IStandardRobotPeer
{
  public abstract boolean isAdjustGunForBodyTurn();
  
  public abstract boolean isAdjustRadarForGunTurn();
  
  public abstract boolean isAdjustRadarForBodyTurn();
  
  public abstract void setStop(boolean paramBoolean);
  
  public abstract void setResume();
  
  public abstract void setMove(double paramDouble);
  
  public abstract void setTurnBody(double paramDouble);
  
  public abstract void setTurnGun(double paramDouble);
  
  public abstract void setTurnRadar(double paramDouble);
  
  public abstract void setMaxTurnRate(double paramDouble);
  
  public abstract void setMaxVelocity(double paramDouble);
  
  public abstract void waitFor(Condition paramCondition);
  
  public abstract void setInterruptible(boolean paramBoolean);
  
  public abstract void setEventPriority(String paramString, int paramInt);
  
  public abstract int getEventPriority(String paramString);
  
  public abstract void addCustomEvent(Condition paramCondition);
  
  public abstract void removeCustomEvent(Condition paramCondition);
  
  public abstract void clearAllEvents();
  
  public abstract List<Event> getAllEvents();
  
  public abstract List<StatusEvent> getStatusEvents();
  
  public abstract List<BulletMissedEvent> getBulletMissedEvents();
  
  public abstract List<BulletHitBulletEvent> getBulletHitBulletEvents();
  
  public abstract List<BulletHitEvent> getBulletHitEvents();
  
  public abstract List<HitByBulletEvent> getHitByBulletEvents();
  
  public abstract List<HitRobotEvent> getHitRobotEvents();
  
  public abstract List<HitWallEvent> getHitWallEvents();
  
  public abstract List<RobotDeathEvent> getRobotDeathEvents();
  
  public abstract List<ScannedRobotEvent> getScannedRobotEvents();
  
  public abstract File getDataDirectory();
  
  public abstract File getDataFile(String paramString);
  
  public abstract long getDataQuotaAvailable();
}
