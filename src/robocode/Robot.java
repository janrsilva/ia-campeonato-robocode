package robocode;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;
import robocode.robotinterfaces.IBasicEvents;
import robocode.robotinterfaces.IBasicEvents3;
import robocode.robotinterfaces.IInteractiveEvents;
import robocode.robotinterfaces.IInteractiveRobot;
import robocode.robotinterfaces.IPaintEvents;
import robocode.robotinterfaces.IPaintRobot;
import robocode.robotinterfaces.peer.IBasicRobotPeer;
import robocode.robotinterfaces.peer.IStandardRobotPeer;





































public class Robot
  extends _Robot
  implements IInteractiveRobot, IPaintRobot, IBasicEvents3, IInteractiveEvents, IPaintEvents
{
  private static final int WIDTH = 36;
  private static final int HEIGHT = 36;
  
  public Robot() {}
  
  public final Runnable getRobotRunnable()
  {
    return this;
  }
  


  public final IBasicEvents getBasicEventListener()
  {
    return this;
  }
  


  public final IInteractiveEvents getInteractiveEventListener()
  {
    return this;
  }
  


  public final IPaintEvents getPaintEventListener()
  {
    return this;
  }
  





























  public void ahead(double distance)
  {
    if (peer != null) {
      peer.move(distance);
    } else {
      uninitializedException();
    }
  }
  




























  public void back(double distance)
  {
    if (peer != null) {
      peer.move(-distance);
    } else {
      uninitializedException();
    }
  }
  




  public double getBattleFieldWidth()
  {
    if (peer != null) {
      return peer.getBattleFieldWidth();
    }
    uninitializedException();
    return 0.0D;
  }
  




  public double getBattleFieldHeight()
  {
    if (peer != null) {
      return peer.getBattleFieldHeight();
    }
    uninitializedException();
    return 0.0D;
  }
  










  public double getHeading()
  {
    if (peer != null) {
      double rv = 180.0D * peer.getBodyHeading() / 3.141592653589793D;
      
      while (rv < 0.0D) {
        rv += 360.0D;
      }
      while (rv >= 360.0D) {
        rv -= 360.0D;
      }
      return rv;
    }
    uninitializedException();
    return 0.0D;
  }
  





  public double getHeight()
  {
    if (peer == null) {
      uninitializedException();
    }
    return 36.0D;
  }
  





  public double getWidth()
  {
    if (peer == null) {
      uninitializedException();
    }
    return 36.0D;
  }
  




  public String getName()
  {
    if (peer != null) {
      return peer.getName();
    }
    uninitializedException();
    return null;
  }
  






  public double getX()
  {
    if (peer != null) {
      return peer.getX();
    }
    uninitializedException();
    return 0.0D;
  }
  






  public double getY()
  {
    if (peer != null) {
      return peer.getY();
    }
    uninitializedException();
    return 0.0D;
  }
  






















  public void run() {}
  





















  public void turnLeft(double degrees)
  {
    if (peer != null) {
      peer.turnBody(-Math.toRadians(degrees));
    } else {
      uninitializedException();
    }
  }
  



























  public void turnRight(double degrees)
  {
    if (peer != null) {
      peer.turnBody(Math.toRadians(degrees));
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
  








































  public void fire(double power)
  {
    if (peer != null) {
      peer.setFire(power);
      peer.execute();
    } else {
      uninitializedException();
    }
  }
  

















































  public Bullet fireBullet(double power)
  {
    if (peer != null) {
      return peer.fire(power);
    }
    uninitializedException();
    return null;
  }
  











  public double getGunCoolingRate()
  {
    if (peer != null) {
      return peer.getGunCoolingRate();
    }
    uninitializedException();
    return 0.0D;
  }
  










  public double getGunHeading()
  {
    if (peer != null) {
      return peer.getGunHeading() * 180.0D / 3.141592653589793D;
    }
    uninitializedException();
    return 0.0D;
  }
  
















  public double getGunHeat()
  {
    if (peer != null) {
      return peer.getGunHeat();
    }
    uninitializedException();
    return 0.0D;
  }
  





  public int getNumRounds()
  {
    if (peer != null) {
      return peer.getNumRounds();
    }
    uninitializedException();
    return 0;
  }
  











  public int getSentryBorderSize()
  {
    if (peer != null) {
      return peer.getSentryBorderSize();
    }
    uninitializedException();
    return 0;
  }
  




  public int getOthers()
  {
    if (peer != null) {
      return peer.getOthers();
    }
    uninitializedException();
    return 0;
  }
  






  public int getNumSentries()
  {
    if (peer != null) {
      return peer.getNumSentries();
    }
    uninitializedException();
    return 0;
  }
  










  public double getRadarHeading()
  {
    if (peer != null) {
      return peer.getRadarHeading() * 180.0D / 3.141592653589793D;
    }
    uninitializedException();
    return 0.0D;
  }
  






  public int getRoundNum()
  {
    if (peer != null) {
      return peer.getRoundNum();
    }
    uninitializedException();
    return 0;
  }
  









  public long getTime()
  {
    if (peer != null) {
      return peer.getTime();
    }
    uninitializedException();
    return 0L;
  }
  








  public double getVelocity()
  {
    if (peer != null) {
      return peer.getVelocity();
    }
    uninitializedException();
    return 0.0D;
  }
  





  public void onBulletHit(BulletHitEvent event) {}
  





  public void onBulletHitBullet(BulletHitBulletEvent event) {}
  





  public void onBulletMissed(BulletMissedEvent event) {}
  





  public void onDeath(DeathEvent event) {}
  





  public void onHitByBullet(HitByBulletEvent event) {}
  




  public void onHitRobot(HitRobotEvent event) {}
  




  public void onHitWall(HitWallEvent event) {}
  




  public void onRobotDeath(RobotDeathEvent event) {}
  




  public void onScannedRobot(ScannedRobotEvent event) {}
  




  public void onWin(WinEvent event) {}
  




  public void onRoundEnded(RoundEndedEvent event) {}
  




  public void onBattleEnded(BattleEndedEvent event) {}
  




  public void scan()
  {
    if (peer != null) {
      ((IStandardRobotPeer)peer).rescan();
    } else {
      uninitializedException();
    }
  }
  








































  public void setAdjustGunForRobotTurn(boolean independent)
  {
    if (peer != null) {
      ((IStandardRobotPeer)peer).setAdjustGunForBodyTurn(independent);
    } else {
      uninitializedException();
    }
  }
  






































  public void setAdjustRadarForRobotTurn(boolean independent)
  {
    if (peer != null) {
      ((IStandardRobotPeer)peer).setAdjustRadarForBodyTurn(independent);
    } else {
      uninitializedException();
    }
  }
  







































  public void setAdjustRadarForGunTurn(boolean independent)
  {
    if (peer != null) {
      ((IStandardRobotPeer)peer).setAdjustRadarForGunTurn(independent);
    } else {
      uninitializedException();
    }
  }
  





























  public void setColors(Color bodyColor, Color gunColor, Color radarColor)
  {
    if (peer != null) {
      peer.setBodyColor(bodyColor);
      peer.setGunColor(gunColor);
      peer.setRadarColor(radarColor);
    } else {
      uninitializedException();
    }
  }
  


































  public void setColors(Color bodyColor, Color gunColor, Color radarColor, Color bulletColor, Color scanArcColor)
  {
    if (peer != null) {
      peer.setBodyColor(bodyColor);
      peer.setGunColor(gunColor);
      peer.setRadarColor(radarColor);
      peer.setBulletColor(bulletColor);
      peer.setScanColor(scanArcColor);
    } else {
      uninitializedException();
    }
  }
  






























  public void setAllColors(Color color)
  {
    if (peer != null) {
      peer.setBodyColor(color);
      peer.setGunColor(color);
      peer.setRadarColor(color);
      peer.setBulletColor(color);
      peer.setScanColor(color);
    } else {
      uninitializedException();
    }
  }
  



























  public void setBodyColor(Color color)
  {
    if (peer != null) {
      peer.setBodyColor(color);
    } else {
      uninitializedException();
    }
  }
  



























  public void setGunColor(Color color)
  {
    if (peer != null) {
      peer.setGunColor(color);
    } else {
      uninitializedException();
    }
  }
  



























  public void setRadarColor(Color color)
  {
    if (peer != null) {
      peer.setRadarColor(color);
    } else {
      uninitializedException();
    }
  }
  



























  public void setBulletColor(Color color)
  {
    if (peer != null) {
      peer.setBulletColor(color);
    } else {
      uninitializedException();
    }
  }
  



























  public void setScanColor(Color color)
  {
    if (peer != null) {
      peer.setScanColor(color);
    } else {
      uninitializedException();
    }
  }
  









  public void stop()
  {
    stop(false);
  }
  









  public void stop(boolean overwrite)
  {
    if (peer != null) {
      ((IStandardRobotPeer)peer).stop(overwrite);
    } else {
      uninitializedException();
    }
  }
  







  public void resume()
  {
    if (peer != null) {
      ((IStandardRobotPeer)peer).resume();
    } else {
      uninitializedException();
    }
  }
  





























  public void turnGunLeft(double degrees)
  {
    if (peer != null) {
      peer.turnGun(-Math.toRadians(degrees));
    } else {
      uninitializedException();
    }
  }
  




























  public void turnGunRight(double degrees)
  {
    if (peer != null) {
      peer.turnGun(Math.toRadians(degrees));
    } else {
      uninitializedException();
    }
  }
  






























  public void turnRadarLeft(double degrees)
  {
    if (peer != null) {
      ((IStandardRobotPeer)peer).turnRadar(-Math.toRadians(degrees));
    } else {
      uninitializedException();
    }
  }
  





























  public void turnRadarRight(double degrees)
  {
    if (peer != null) {
      ((IStandardRobotPeer)peer).turnRadar(Math.toRadians(degrees));
    } else {
      uninitializedException();
    }
  }
  




  public double getEnergy()
  {
    if (peer != null) {
      return peer.getEnergy();
    }
    uninitializedException();
    return 0.0D;
  }
  



















  public Graphics2D getGraphics()
  {
    if (peer != null) {
      return peer.getGraphics();
    }
    uninitializedException();
    return null;
  }
  











  public void setDebugProperty(String key, String value)
  {
    if (peer != null) {
      peer.setDebugProperty(key, value);
      return;
    }
    uninitializedException();
  }
  
  public void onPaint(Graphics2D g) {}
  
  public void onKeyPressed(KeyEvent e) {}
  
  public void onKeyReleased(KeyEvent e) {}
  
  public void onKeyTyped(KeyEvent e) {}
  
  public void onMouseClicked(MouseEvent e) {}
  
  public void onMouseEntered(MouseEvent e) {}
  
  public void onMouseExited(MouseEvent e) {}
  
  public void onMousePressed(MouseEvent e) {}
  
  public void onMouseReleased(MouseEvent e) {}
  
  public void onMouseMoved(MouseEvent e) {}
  
  public void onMouseDragged(MouseEvent e) {}
  
  public void onMouseWheelMoved(MouseWheelEvent e) {}
  
  public void onStatus(StatusEvent e) {}
}
