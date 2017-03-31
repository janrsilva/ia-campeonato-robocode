package robocode.robotinterfaces;

import robocode.BulletHitBulletEvent;
import robocode.BulletHitEvent;
import robocode.BulletMissedEvent;
import robocode.DeathEvent;
import robocode.HitByBulletEvent;
import robocode.HitRobotEvent;
import robocode.HitWallEvent;
import robocode.RobotDeathEvent;
import robocode.ScannedRobotEvent;
import robocode.StatusEvent;
import robocode.WinEvent;

public abstract interface IBasicEvents
{
  public abstract void onStatus(StatusEvent paramStatusEvent);
  
  public abstract void onBulletHit(BulletHitEvent paramBulletHitEvent);
  
  public abstract void onBulletHitBullet(BulletHitBulletEvent paramBulletHitBulletEvent);
  
  public abstract void onBulletMissed(BulletMissedEvent paramBulletMissedEvent);
  
  public abstract void onDeath(DeathEvent paramDeathEvent);
  
  public abstract void onHitByBullet(HitByBulletEvent paramHitByBulletEvent);
  
  public abstract void onHitRobot(HitRobotEvent paramHitRobotEvent);
  
  public abstract void onHitWall(HitWallEvent paramHitWallEvent);
  
  public abstract void onScannedRobot(ScannedRobotEvent paramScannedRobotEvent);
  
  public abstract void onRobotDeath(RobotDeathEvent paramRobotDeathEvent);
  
  public abstract void onWin(WinEvent paramWinEvent);
}
