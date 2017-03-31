package net.sf.robocode.security;

import java.awt.Graphics2D;
import net.sf.robocode.peer.IRobotStatics;
import robocode.Event;
import robocode.robotinterfaces.IBasicRobot;

public abstract interface IHiddenEventHelper
{
  public abstract void setDefaultPriority(Event paramEvent);
  
  public abstract void setPriority(Event paramEvent, int paramInt);
  
  public abstract void setTime(Event paramEvent, long paramLong);
  
  public abstract boolean isCriticalEvent(Event paramEvent);
  
  public abstract void dispatch(Event paramEvent, IBasicRobot paramIBasicRobot, IRobotStatics paramIRobotStatics, Graphics2D paramGraphics2D);
  
  public abstract byte getSerializationType(Event paramEvent);
}
