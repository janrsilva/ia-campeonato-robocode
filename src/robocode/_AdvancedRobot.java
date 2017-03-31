package robocode;

import robocode.robotinterfaces.peer.IAdvancedRobotPeer;
import robocode.robotinterfaces.peer.IBasicRobotPeer;































public class _AdvancedRobot
  extends Robot
{
  _AdvancedRobot() {}
  
  @Deprecated
  public void setTurnGunLeftDegrees(double degrees)
  {
    if (peer != null) {
      ((IAdvancedRobotPeer)peer).setTurnGun(-Math.toRadians(degrees));
    } else {
      uninitializedException();
    }
  }
  







  @Deprecated
  public void setTurnGunRightDegrees(double degrees)
  {
    if (peer != null) {
      ((IAdvancedRobotPeer)peer).setTurnGun(Math.toRadians(degrees));
    } else {
      uninitializedException();
    }
  }
  







  @Deprecated
  public void turnRadarRightDegrees(double degrees)
  {
    turnRadarRight(degrees);
  }
  







  @Deprecated
  public void setTurnRightDegrees(double degrees)
  {
    if (peer != null) {
      ((IAdvancedRobotPeer)peer).setTurnBody(Math.toRadians(degrees));
    } else {
      uninitializedException();
    }
  }
  







  @Deprecated
  public void setTurnRadarLeftDegrees(double degrees)
  {
    if (peer != null) {
      ((IAdvancedRobotPeer)peer).setTurnRadar(-Math.toRadians(degrees));
    } else {
      uninitializedException();
    }
  }
  







  @Deprecated
  public void setTurnLeftDegrees(double degrees)
  {
    if (peer != null) {
      ((IAdvancedRobotPeer)peer).setTurnBody(-Math.toRadians(degrees));
    } else {
      uninitializedException();
    }
  }
  



  @Deprecated
  public double getHeadingDegrees()
  {
    return getHeading();
  }
  






  @Deprecated
  public void turnLeftDegrees(double degrees)
  {
    turnLeft(degrees);
  }
  






  @Deprecated
  public void turnRightDegrees(double degrees)
  {
    turnRight(degrees);
  }
  


  @Deprecated
  public void endTurn()
  {
    if (peer != null) {
      peer.execute();
    } else {
      uninitializedException();
    }
  }
  



  @Deprecated
  public double getGunHeadingDegrees()
  {
    return getGunHeading();
  }
  



  @Deprecated
  public double getRadarHeadingDegrees()
  {
    return getRadarHeading();
  }
  




  @Deprecated
  public int getWaitCount()
  {
    if (peer != null) {
      peer.getCall();
    }
    return 0;
  }
  







  @Deprecated
  public void setTurnRadarRightDegrees(double degrees)
  {
    if (peer != null) {
      ((IAdvancedRobotPeer)peer).setTurnRadar(Math.toRadians(degrees));
    } else {
      uninitializedException();
    }
  }
  






  @Deprecated
  public void turnGunLeftDegrees(double degrees)
  {
    turnGunLeft(degrees);
  }
  






  @Deprecated
  public void turnGunRightDegrees(double degrees)
  {
    turnGunRight(degrees);
  }
  






  @Deprecated
  public void turnRadarLeftDegrees(double degrees)
  {
    turnRadarLeft(degrees);
  }
  




  @Deprecated
  public int getMaxWaitCount()
  {
    if (peer != null) {
      peer.getCall();
    }
    return 0;
  }
}
