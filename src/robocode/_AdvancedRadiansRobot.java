package robocode;

import robocode.robotinterfaces.peer.IAdvancedRobotPeer;
import robocode.robotinterfaces.peer.IBasicRobotPeer;

























public class _AdvancedRadiansRobot
  extends _AdvancedRobot
{
  _AdvancedRadiansRobot() {}
  
  public double getHeadingRadians()
  {
    if (peer != null) {
      return peer.getBodyHeading();
    }
    uninitializedException();
    return 0.0D;
  }
  
  public void setTurnLeftRadians(double radians) {
    if (peer != null) {
      ((IAdvancedRobotPeer)peer).setTurnBody(-radians);
    } else {
      uninitializedException();
    }
  }
  
  public void setTurnRightRadians(double radians) {
    if (peer != null) {
      ((IAdvancedRobotPeer)peer).setTurnBody(radians);
    } else {
      uninitializedException();
    }
  }
  
  public void turnLeftRadians(double radians) {
    if (peer != null) {
      peer.turnBody(-radians);
    } else {
      uninitializedException();
    }
  }
  
  public void turnRightRadians(double radians) {
    if (peer != null) {
      peer.turnBody(radians);
    } else {
      uninitializedException();
    }
  }
  
  public double getGunHeadingRadians() {
    if (peer != null) {
      return peer.getGunHeading();
    }
    uninitializedException();
    return 0.0D;
  }
  
  public double getRadarHeadingRadians() {
    if (peer != null) {
      return peer.getRadarHeading();
    }
    uninitializedException();
    return 0.0D;
  }
  
  public void setTurnGunLeftRadians(double radians) {
    if (peer != null) {
      ((IAdvancedRobotPeer)peer).setTurnGun(-radians);
    } else {
      uninitializedException();
    }
  }
  
  public void setTurnGunRightRadians(double radians) {
    if (peer != null) {
      ((IAdvancedRobotPeer)peer).setTurnGun(radians);
    } else {
      uninitializedException();
    }
  }
  
  public void setTurnRadarLeftRadians(double radians) {
    if (peer != null) {
      ((IAdvancedRobotPeer)peer).setTurnRadar(-radians);
    } else {
      uninitializedException();
    }
  }
  
  public void setTurnRadarRightRadians(double radians) {
    if (peer != null) {
      ((IAdvancedRobotPeer)peer).setTurnRadar(radians);
    } else {
      uninitializedException();
    }
  }
  
  public void turnGunLeftRadians(double radians) {
    if (peer != null) {
      peer.turnGun(-radians);
    } else {
      uninitializedException();
    }
  }
  
  public void turnGunRightRadians(double radians) {
    if (peer != null) {
      peer.turnGun(radians);
    } else {
      uninitializedException();
    }
  }
  
  public void turnRadarLeftRadians(double radians) {
    if (peer != null) {
      ((IAdvancedRobotPeer)peer).turnRadar(-radians);
    } else {
      uninitializedException();
    }
  }
  
  public void turnRadarRightRadians(double radians) {
    if (peer != null) {
      ((IAdvancedRobotPeer)peer).turnRadar(radians);
    } else {
      uninitializedException();
    }
  }
  
  public double getGunTurnRemainingRadians() {
    if (peer != null) {
      return peer.getGunTurnRemaining();
    }
    uninitializedException();
    return 0.0D;
  }
  
  public double getRadarTurnRemainingRadians() {
    if (peer != null) {
      return peer.getRadarTurnRemaining();
    }
    uninitializedException();
    return 0.0D;
  }
  
  public double getTurnRemainingRadians() {
    if (peer != null) {
      return peer.getBodyTurnRemaining();
    }
    uninitializedException();
    return 0.0D;
  }
}
