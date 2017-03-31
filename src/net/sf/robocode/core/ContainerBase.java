package net.sf.robocode.core;



public abstract class ContainerBase
{
  public static ContainerBase instance;
  


  public ContainerBase() {}
  


  protected abstract <T> T getBaseComponent(Class<T> paramClass);
  

  public static <T> T getComponent(Class<T> tClass)
  {
    return instance == null ? null : instance.getBaseComponent(tClass);
  }
}
