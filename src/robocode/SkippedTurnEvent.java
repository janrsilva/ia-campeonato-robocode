package robocode;

import java.awt.Graphics2D;
import java.nio.ByteBuffer;
import net.sf.robocode.peer.IRobotStatics;
import net.sf.robocode.serialization.ISerializableHelper;
import net.sf.robocode.serialization.RbSerializer;
import robocode.robotinterfaces.IAdvancedEvents;
import robocode.robotinterfaces.IAdvancedRobot;
import robocode.robotinterfaces.IBasicRobot;

















































public final class SkippedTurnEvent
  extends Event
{
  private static final long serialVersionUID = 1L;
  private static final int DEFAULT_PRIORITY = 100;
  private final long skippedTurn;
  
  public SkippedTurnEvent(long skippedTurn)
  {
    this.skippedTurn = skippedTurn;
  }
  






  public long getSkippedTurn()
  {
    return skippedTurn;
  }
  



  public final int getPriority()
  {
    return 100;
  }
  



  final int getDefaultPriority()
  {
    return 100;
  }
  



  final void dispatch(IBasicRobot robot, IRobotStatics statics, Graphics2D graphics)
  {
    if (statics.isAdvancedRobot()) {
      IAdvancedEvents listener = ((IAdvancedRobot)robot).getAdvancedEventListener();
      
      if (listener != null) {
        listener.onSkippedTurn(this);
      }
    }
  }
  



  final boolean isCriticalEvent()
  {
    return true;
  }
  



  byte getSerializationType()
  {
    return 40;
  }
  

  static ISerializableHelper createHiddenSerializer() { return new SerializableHelper(null); }
  
  private static class SerializableHelper implements ISerializableHelper {
    private SerializableHelper() {}
    
    public int sizeOf(RbSerializer serializer, Object object) { return 9; }
    
    public void serialize(RbSerializer serializer, ByteBuffer buffer, Object object)
    {
      SkippedTurnEvent obj = (SkippedTurnEvent)object;
      
      serializer.serialize(buffer, skippedTurn);
    }
    
    public Object deserialize(RbSerializer serializer, ByteBuffer buffer) {
      long skippedTurn = buffer.getLong();
      
      return new SkippedTurnEvent(skippedTurn);
    }
  }
}
