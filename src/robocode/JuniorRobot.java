package robocode;

import java.awt.Color;
import robocode.robotinterfaces.IBasicEvents;
import robocode.robotinterfaces.IJuniorRobot;
import robocode.robotinterfaces.peer.IBasicRobotPeer;
import robocode.robotinterfaces.peer.IJuniorRobotPeer;
import robocode.util.Utils;



















































































































































public class JuniorRobot
  extends _RobotBase
  implements IJuniorRobot
{
  public static final int black = 0;
  public static final int white = 16777215;
  public static final int red = 16711680;
  public static final int orange = 16753920;
  public static final int yellow = 16776960;
  public static final int green = 32768;
  public static final int blue = 255;
  public static final int purple = 8388736;
  public static final int brown = 9127187;
  public static final int gray = 8421504;
  public int fieldWidth;
  public int fieldHeight;
  public int others;
  public int energy;
  public int robotX;
  public int robotY;
  public int heading;
  public int gunHeading;
  public int gunBearing;
  public boolean gunReady;
  public int scannedDistance;
  public int scannedAngle;
  public int scannedBearing;
  public int scannedVelocity;
  public int scannedHeading;
  public int scannedEnergy;
  public int hitByBulletAngle;
  public int hitByBulletBearing;
  public int hitRobotAngle;
  public int hitRobotBearing;
  public int hitWallAngle;
  public int hitWallBearing;
  private InnerEventHandler innerEventHandler;
  
  public JuniorRobot()
  {
    scannedDistance = -1;
    












    scannedAngle = -1;
    













    scannedBearing = -1;
    















    scannedVelocity = -99;
    












    scannedHeading = -1;
    











    scannedEnergy = -1;
    








    hitByBulletAngle = -1;
    









    hitByBulletBearing = -1;
    








    hitRobotAngle = -1;
    









    hitRobotBearing = -1;
    








    hitWallAngle = -1;
    









    hitWallBearing = -1;
  }
  











  public void ahead(int distance)
  {
    if (peer != null) {
      peer.move(distance);
    } else {
      uninitializedException();
    }
  }
  







  public void back(int distance)
  {
    ahead(-distance);
  }
  










  public void bearGunTo(int angle)
  {
    if (peer != null) {
      peer.turnGun(Utils.normalRelativeAngle(peer.getBodyHeading() + Math.toRadians(angle) - peer.getGunHeading()));
    } else {
      uninitializedException();
    }
  }
  




  public void doNothing()
  {
    if (peer != null) {
      peer.execute();
    } else {
      uninitializedException();
    }
  }
  





  public void doNothing(int turns)
  {
    if (turns <= 0) {
      return;
    }
    if (peer != null) {
      for (int i = 0; i < turns; i++) {
        peer.execute();
      }
    } else {
      uninitializedException();
    }
  }
  






  public void fire()
  {
    fire(1.0D);
  }
  








  public void fire(double power)
  {
    if (peer != null) {
      getEventHandlerjuniorFirePower = power;
      peer.execute();
    } else {
      uninitializedException();
    }
  }
  




  public final IBasicEvents getBasicEventListener()
  {
    return getEventHandler();
  }
  




  public final Runnable getRobotRunnable()
  {
    return getEventHandler();
  }
  










  public void onHitByBullet() {}
  










  public void onHitRobot() {}
  










  public void onHitWall() {}
  










  public void onScannedRobot() {}
  









  public void run() {}
  









  public void setColors(int bodyColor, int gunColor, int radarColor)
  {
    if (peer != null) {
      peer.setBodyColor(new Color(bodyColor));
      peer.setGunColor(new Color(gunColor));
      peer.setRadarColor(new Color(radarColor));
    } else {
      uninitializedException();
    }
  }
  










  public void setColors(int bodyColor, int gunColor, int radarColor, int bulletColor, int scanArcColor)
  {
    if (peer != null) {
      peer.setBodyColor(new Color(bodyColor));
      peer.setGunColor(new Color(gunColor));
      peer.setRadarColor(new Color(radarColor));
      peer.setBulletColor(new Color(bulletColor));
      peer.setScanColor(new Color(scanArcColor));
    } else {
      uninitializedException();
    }
  }
  




















  public void turnAheadLeft(int distance, int degrees)
  {
    turnAheadRight(distance, -degrees);
  }
  




















  public void turnAheadRight(int distance, int degrees)
  {
    if (peer != null) {
      ((IJuniorRobotPeer)peer).turnAndMove(distance, Math.toRadians(degrees));
    } else {
      uninitializedException();
    }
  }
  




















  public void turnBackLeft(int distance, int degrees)
  {
    turnAheadRight(-distance, degrees);
  }
  




















  public void turnBackRight(int distance, int degrees)
  {
    turnAheadRight(-distance, -degrees);
  }
  









  public void turnGunLeft(int degrees)
  {
    turnGunRight(-degrees);
  }
  









  public void turnGunRight(int degrees)
  {
    if (peer != null) {
      peer.turnGun(Math.toRadians(degrees));
    } else {
      uninitializedException();
    }
  }
  











  public void turnGunTo(int angle)
  {
    if (peer != null) {
      peer.turnGun(Utils.normalRelativeAngle(Math.toRadians(angle) - peer.getGunHeading()));
    } else {
      uninitializedException();
    }
  }
  











  public void turnLeft(int degrees)
  {
    turnRight(-degrees);
  }
  











  public void turnRight(int degrees)
  {
    if (peer != null) {
      peer.turnBody(Math.toRadians(degrees));
    } else {
      uninitializedException();
    }
  }
  













  public void turnTo(int angle)
  {
    if (peer != null) {
      peer.turnBody(Utils.normalRelativeAngle(Math.toRadians(angle) - peer.getBodyHeading()));
    } else {
      uninitializedException();
    }
  }
  


  private InnerEventHandler getEventHandler()
  {
    if (innerEventHandler == null) {
      innerEventHandler = new InnerEventHandler(null);
    }
    return innerEventHandler;
  }
  
  private final class InnerEventHandler
    implements IBasicEvents, Runnable
  {
    private double juniorFirePower;
    private long currentTurn;
    
    private InnerEventHandler() {}
    
    public void onBulletHit(BulletHitEvent event) {}
    
    public void onBulletHitBullet(BulletHitBulletEvent event) {}
    
    public void onBulletMissed(BulletMissedEvent event) {}
    
    public void onDeath(DeathEvent event) {}
    
    public void onHitByBullet(HitByBulletEvent event)
    {
      double angle = peer.getBodyHeading() + event.getBearingRadians();
      
      hitByBulletAngle = ((int)(Math.toDegrees(Utils.normalAbsoluteAngle(angle)) + 0.5D));
      hitByBulletBearing = ((int)(event.getBearing() + 0.5D));
      onHitByBullet();
    }
    
    public void onHitRobot(HitRobotEvent event) {
      double angle = peer.getBodyHeading() + event.getBearingRadians();
      
      hitRobotAngle = ((int)(Math.toDegrees(Utils.normalAbsoluteAngle(angle)) + 0.5D));
      hitRobotBearing = ((int)(event.getBearing() + 0.5D));
      onHitRobot();
    }
    
    public void onHitWall(HitWallEvent event) {
      double angle = peer.getBodyHeading() + event.getBearingRadians();
      
      hitWallAngle = ((int)(Math.toDegrees(Utils.normalAbsoluteAngle(angle)) + 0.5D));
      hitWallBearing = ((int)(event.getBearing() + 0.5D));
      onHitWall();
    }
    
    public void onRobotDeath(RobotDeathEvent event) {
      others = peer.getOthers();
    }
    
    public void onScannedRobot(ScannedRobotEvent event) {
      scannedDistance = ((int)(event.getDistance() + 0.5D));
      scannedEnergy = Math.max(1, (int)(event.getEnergy() + 0.5D));
      scannedAngle = ((int)(Math.toDegrees(Utils.normalAbsoluteAngle(peer.getBodyHeading() + event.getBearingRadians())) + 0.5D));
      

      scannedBearing = ((int)(event.getBearing() + 0.5D));
      scannedHeading = ((int)(event.getHeading() + 0.5D));
      scannedVelocity = ((int)(event.getVelocity() + 0.5D));
      
      onScannedRobot();
    }
    
    public void onStatus(StatusEvent e) {
      RobotStatus s = e.getStatus();
      
      others = peer.getOthers();
      energy = Math.max(1, (int)(s.getEnergy() + 0.5D));
      robotX = ((int)(s.getX() + 0.5D));
      robotY = ((int)(s.getY() + 0.5D));
      heading = ((int)(s.getHeading() + 0.5D));
      gunHeading = ((int)(s.getGunHeading() + 0.5D));
      gunBearing = ((int)(Utils.normalRelativeAngle(s.getGunHeading() - s.getHeading()) + 0.5D));
      gunReady = (s.getGunHeat() <= 0.0D);
      
      currentTurn = e.getTime();
      

      if ((juniorFirePower > 0.0D) && (gunReady) && (peer.getGunTurnRemaining() == 0.0D) && 
        (peer.setFire(juniorFirePower) != null)) {
        gunReady = false;
        juniorFirePower = 0.0D;
      }
      


      scannedDistance = -1;
      scannedAngle = -1;
      scannedBearing = -1;
      scannedVelocity = -99;
      scannedHeading = -1;
      scannedEnergy = -1;
      hitByBulletAngle = -1;
      hitByBulletBearing = -1;
      hitRobotAngle = -1;
      hitRobotBearing = -1;
      hitWallAngle = -1;
      hitWallBearing = -1;
    }
    
    public void onWin(WinEvent event) {}
    
    public void run() {
      fieldWidth = ((int)(peer.getBattleFieldWidth() + 0.5D));
      fieldHeight = ((int)(peer.getBattleFieldHeight() + 0.5D));
      
      for (;;)
      {
        long lastTurn = currentTurn;
        
        JuniorRobot.this.run();
        



        if (lastTurn == currentTurn) {
          peer.rescan();
        }
      }
    }
  }
}
