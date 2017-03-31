package robocode.control.snapshot;

public abstract interface IBulletSnapshot
{
  public abstract BulletState getState();
  
  public abstract double getPower();
  
  public abstract double getX();
  
  public abstract double getY();
  
  public abstract double getPaintX();
  
  public abstract double getPaintY();
  
  public abstract int getColor();
  
  public abstract int getFrame();
  
  public abstract boolean isExplosion();
  
  public abstract int getExplosionImageIndex();
  
  public abstract int getBulletId();
  
  public abstract double getHeading();
  
  public abstract int getVictimIndex();
  
  public abstract int getOwnerIndex();
}
