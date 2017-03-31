package net.sf.robocode.core;

import java.util.List;

public abstract interface IModule
{
  public abstract void afterLoaded(List<IModule> paramList);
}
