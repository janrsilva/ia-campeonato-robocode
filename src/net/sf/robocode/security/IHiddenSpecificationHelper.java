package net.sf.robocode.security;

import robocode.control.RobotSpecification;

public abstract interface IHiddenSpecificationHelper
{
  public abstract RobotSpecification createSpecification(Object paramObject, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8);
  
  public abstract Object getFileSpecification(RobotSpecification paramRobotSpecification);
  
  public abstract void setTeamName(RobotSpecification paramRobotSpecification, String paramString);
  
  public abstract String getTeamName(RobotSpecification paramRobotSpecification);
}
