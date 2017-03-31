package net.sf.robocode.repository;

import robocode.control.RobotSpecification;

public abstract interface IRepositoryManagerBase
{
  public abstract boolean refresh();
  
  public abstract RobotSpecification[] getSpecifications();
  
  public abstract RobotSpecification[] loadSelectedRobots(String paramString);
}
