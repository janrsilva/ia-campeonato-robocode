package robocode;

import java.awt.Graphics2D;
import java.nio.ByteBuffer;
import net.sf.robocode.peer.IRobotStatics;
import net.sf.robocode.serialization.ISerializableHelper;
import net.sf.robocode.serialization.RbSerializer;
import robocode.robotinterfaces.IBasicEvents;
import robocode.robotinterfaces.IBasicEvents2;
import robocode.robotinterfaces.IBasicRobot;





























public final class BattleEndedEvent
  extends Event
{
  private static final long serialVersionUID = 1L;
  private static final int DEFAULT_PRIORITY = 100;
  private final boolean aborted;
  private final BattleResults results;
  
  public BattleEndedEvent(boolean aborted, BattleResults results)
  {
    this.aborted = aborted;
    this.results = results;
  }
  




  public boolean isAborted()
  {
    return aborted;
  }
  




  public BattleResults getResults()
  {
    return results;
  }
  



  final int getDefaultPriority()
  {
    return 100;
  }
  



  public final int getPriority()
  {
    return 100;
  }
  



  final void dispatch(IBasicRobot robot, IRobotStatics statics, Graphics2D graphics)
  {
    if (robot != null) {
      IBasicEvents listener = robot.getBasicEventListener();
      
      if ((listener != null) && (IBasicEvents2.class.isAssignableFrom(listener.getClass()))) {
        ((IBasicEvents2)listener).onBattleEnded(this);
      }
    }
  }
  



  final boolean isCriticalEvent()
  {
    return true;
  }
  



  byte getSerializationType()
  {
    return 32;
  }
  

  static ISerializableHelper createHiddenSerializer() { return new SerializableHelper(null); }
  
  private static class SerializableHelper implements ISerializableHelper {
    private SerializableHelper() {}
    
    public int sizeOf(RbSerializer serializer, Object object) { BattleEndedEvent obj = (BattleEndedEvent)object;
      
      return 2 + serializer.sizeOf((byte)8, results);
    }
    
    public void serialize(RbSerializer serializer, ByteBuffer buffer, Object object)
    {
      BattleEndedEvent obj = (BattleEndedEvent)object;
      
      serializer.serialize(buffer, aborted);
      serializer.serialize(buffer, (byte)8, results);
    }
    
    public Object deserialize(RbSerializer serializer, ByteBuffer buffer) {
      boolean aborted = serializer.deserializeBoolean(buffer);
      BattleResults results = (BattleResults)serializer.deserializeAny(buffer);
      
      return new BattleEndedEvent(aborted, results);
    }
  }
}
