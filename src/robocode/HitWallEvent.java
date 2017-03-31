package robocode;

import java.awt.Graphics2D;
import java.nio.ByteBuffer;
import net.sf.robocode.peer.IRobotStatics;
import net.sf.robocode.serialization.ISerializableHelper;
import net.sf.robocode.serialization.RbSerializer;
import robocode.robotinterfaces.IBasicEvents;
import robocode.robotinterfaces.IBasicRobot;






















public final class HitWallEvent
  extends Event
{
  private static final long serialVersionUID = 1L;
  private static final int DEFAULT_PRIORITY = 30;
  private final double bearing;
  
  public HitWallEvent(double bearing)
  {
    this.bearing = bearing;
  }
  





  public double getBearing()
  {
    return bearing * 180.0D / 3.141592653589793D;
  }
  



  @Deprecated
  public double getBearingDegrees()
  {
    return getBearing();
  }
  





  public double getBearingRadians()
  {
    return bearing;
  }
  



  final int getDefaultPriority()
  {
    return 30;
  }
  



  final void dispatch(IBasicRobot robot, IRobotStatics statics, Graphics2D graphics)
  {
    IBasicEvents listener = robot.getBasicEventListener();
    
    if (listener != null) {
      listener.onHitWall(this);
    }
  }
  



  byte getSerializationType()
  {
    return 38;
  }
  

  static ISerializableHelper createHiddenSerializer() { return new SerializableHelper(null); }
  
  private static class SerializableHelper implements ISerializableHelper {
    private SerializableHelper() {}
    
    public int sizeOf(RbSerializer serializer, Object object) { return 9; }
    
    public void serialize(RbSerializer serializer, ByteBuffer buffer, Object object)
    {
      HitWallEvent obj = (HitWallEvent)object;
      
      serializer.serialize(buffer, bearing);
    }
    
    public Object deserialize(RbSerializer serializer, ByteBuffer buffer) {
      double bearing = buffer.getDouble();
      
      return new HitWallEvent(bearing);
    }
  }
}
