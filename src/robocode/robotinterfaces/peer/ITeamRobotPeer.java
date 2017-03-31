package robocode.robotinterfaces.peer;

import java.io.IOException;
import java.io.Serializable;
import java.util.List;
import robocode.MessageEvent;

public abstract interface ITeamRobotPeer
  extends IAdvancedRobotPeer
{
  public abstract String[] getTeammates();
  
  public abstract boolean isTeammate(String paramString);
  
  public abstract void broadcastMessage(Serializable paramSerializable)
    throws IOException;
  
  public abstract void sendMessage(String paramString, Serializable paramSerializable)
    throws IOException;
  
  public abstract List<MessageEvent> getMessageEvents();
}
