package net.sf.robocode.manager;

public abstract interface IVersionManagerBase
{
  public abstract String getVersion();
  
  public abstract String getVersionN();
  
  public abstract int getVersionAsInt();
  
  public abstract boolean isLastRunVersionChanged();
}
