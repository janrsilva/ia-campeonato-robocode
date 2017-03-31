package robocode.robotinterfaces.peer;

public abstract interface IStandardRobotPeer
  extends IBasicRobotPeer
{
  public abstract void stop(boolean paramBoolean);
  
  public abstract void resume();
  
  public abstract void turnRadar(double paramDouble);
  
  public abstract void setAdjustGunForBodyTurn(boolean paramBoolean);
  
  public abstract void setAdjustRadarForGunTurn(boolean paramBoolean);
  
  public abstract void setAdjustRadarForBodyTurn(boolean paramBoolean);
}
