package robocode;

import java.io.IOException;
import java.io.Serializable;
import java.util.Vector;
import robocode.robotinterfaces.ITeamEvents;
import robocode.robotinterfaces.ITeamRobot;
import robocode.robotinterfaces.peer.ITeamRobotPeer;








































public class TeamRobot
  extends AdvancedRobot
  implements ITeamRobot, ITeamEvents
{
  public TeamRobot() {}
  
  public void broadcastMessage(Serializable message)
    throws IOException
  {
    if (peer != null) {
      ((ITeamRobotPeer)peer).broadcastMessage(message);
    } else {
      uninitializedException();
    }
  }
  
















  public Vector<MessageEvent> getMessageEvents()
  {
    if (peer != null) {
      return new Vector(((ITeamRobotPeer)peer).getMessageEvents());
    }
    uninitializedException();
    return null;
  }
  




  public final ITeamEvents getTeamEventListener()
  {
    return this;
  }
  























  public String[] getTeammates()
  {
    if (peer != null) {
      return ((ITeamRobotPeer)peer).getTeammates();
    }
    uninitializedException();
    return null;
  }
  



















  public boolean isTeammate(String name)
  {
    if (peer != null) {
      return ((ITeamRobotPeer)peer).isTeammate(name);
    }
    uninitializedException();
    return false;
  }
  









  public void onMessageReceived(MessageEvent event) {}
  









  public void sendMessage(String name, Serializable message)
    throws IOException
  {
    if (peer != null) {
      ((ITeamRobotPeer)peer).sendMessage(name, message);
    } else {
      uninitializedException();
    }
  }
}
