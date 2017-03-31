package robocode;

import java.awt.Graphics2D;
import java.nio.ByteBuffer;
import net.sf.robocode.peer.IRobotStatics;
import net.sf.robocode.serialization.ISerializableHelper;
import net.sf.robocode.serialization.RbSerializer;
import robocode.robotinterfaces.IBasicEvents;
import robocode.robotinterfaces.IBasicEvents3;
import robocode.robotinterfaces.IBasicRobot;



























public final class RoundEndedEvent
  extends Event
{
  private static final long serialVersionUID = 1L;
  private static final int DEFAULT_PRIORITY = 110;
  private final int round;
  private final int turns;
  private final int totalTurns;
  
  public RoundEndedEvent(int round, int turns, int totalTurns)
  {
    this.round = round;
    this.turns = turns;
    this.totalTurns = totalTurns;
  }
  




  public int getRound()
  {
    return round;
  }
  




  public int getTurns()
  {
    return turns;
  }
  




  public int getTotalTurns()
  {
    return totalTurns;
  }
  



  final int getDefaultPriority()
  {
    return 110;
  }
  



  public final int getPriority()
  {
    return 110;
  }
  



  final void dispatch(IBasicRobot robot, IRobotStatics statics, Graphics2D graphics)
  {
    if (robot != null) {
      IBasicEvents listener = robot.getBasicEventListener();
      
      if ((listener != null) && (IBasicEvents3.class.isAssignableFrom(listener.getClass()))) {
        ((IBasicEvents3)listener).onRoundEnded(this);
      }
    }
  }
  



  final boolean isCriticalEvent()
  {
    return true;
  }
  



  byte getSerializationType()
  {
    return 55;
  }
  

  static ISerializableHelper createHiddenSerializer() { return new SerializableHelper(null); }
  
  private static class SerializableHelper implements ISerializableHelper {
    private SerializableHelper() {}
    
    public int sizeOf(RbSerializer serializer, Object object) { return 13; }
    
    public void serialize(RbSerializer serializer, ByteBuffer buffer, Object object)
    {
      RoundEndedEvent event = (RoundEndedEvent)object;
      
      serializer.serialize(buffer, round);
      serializer.serialize(buffer, turns);
      serializer.serialize(buffer, totalTurns);
    }
    
    public Object deserialize(RbSerializer serializer, ByteBuffer buffer) {
      int round = serializer.deserializeInt(buffer);
      int turns = serializer.deserializeInt(buffer);
      int totalTurns = serializer.deserializeInt(buffer);
      
      return new RoundEndedEvent(round, turns, totalTurns);
    }
  }
}
