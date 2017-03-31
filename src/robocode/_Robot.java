package robocode;

import robocode.robotinterfaces.peer.IBasicRobotPeer;
























public abstract class _Robot
  extends _RobotBase
{
  private String robotImageName;
  private String gunImageName;
  private String radarImageName;
  
  _Robot() {}
  
  @Deprecated
  public double getGunCharge()
  {
    if (peer != null) {
      return 5.0D - peer.getGunHeat();
    }
    uninitializedException();
    return 0.0D;
  }
  



  @Deprecated
  public double getLife()
  {
    if (peer != null) {
      return peer.getEnergy();
    }
    uninitializedException();
    return 0.0D;
  }
  



  @Deprecated
  public int getNumBattles()
  {
    if (peer != null) {
      return peer.getNumRounds();
    }
    uninitializedException();
    return 0;
  }
  



  @Deprecated
  public int getBattleNum()
  {
    if (peer != null) {
      return peer.getRoundNum();
    }
    uninitializedException();
    return 0;
  }
  






  public void setInterruptible(boolean interruptible) {}
  





  @Deprecated
  public String getGunImageName()
  {
    return gunImageName;
  }
  



  @Deprecated
  public void setGunImageName(String newGunImageName)
  {
    gunImageName = newGunImageName;
  }
  



  @Deprecated
  public void setRadarImageName(String newRadarImageName)
  {
    radarImageName = newRadarImageName;
  }
  



  @Deprecated
  public void setRobotImageName(String newRobotImageName)
  {
    robotImageName = newRobotImageName;
  }
  



  @Deprecated
  public String getRadarImageName()
  {
    return radarImageName;
  }
  



  @Deprecated
  public String getRobotImageName()
  {
    return robotImageName;
  }
}
