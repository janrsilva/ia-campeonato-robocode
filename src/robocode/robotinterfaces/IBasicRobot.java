package robocode.robotinterfaces;

import java.io.PrintStream;
import robocode.robotinterfaces.peer.IBasicRobotPeer;

public abstract interface IBasicRobot
{
  public abstract Runnable getRobotRunnable();
  
  public abstract IBasicEvents getBasicEventListener();
  
  public abstract void setPeer(IBasicRobotPeer paramIBasicRobotPeer);
  
  public abstract void setOut(PrintStream paramPrintStream);
}
