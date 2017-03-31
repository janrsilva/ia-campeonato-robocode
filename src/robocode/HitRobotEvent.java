package robocode;

import java.awt.Graphics2D;
import java.nio.ByteBuffer;
import net.sf.robocode.peer.IRobotStatics;
import net.sf.robocode.serialization.ISerializableHelper;
import net.sf.robocode.serialization.RbSerializer;
import robocode.robotinterfaces.IBasicEvents;
import robocode.robotinterfaces.IBasicRobot;


























public final class HitRobotEvent
  extends Event
{
  private static final long serialVersionUID = 1L;
  private static final int DEFAULT_PRIORITY = 40;
  private final String robotName;
  private final double bearing;
  private final double energy;
  private final boolean atFault;
  
  public HitRobotEvent(String name, double bearing, double energy, boolean atFault)
  {
    robotName = name;
    this.bearing = bearing;
    this.energy = energy;
    this.atFault = atFault;
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
  




  public double getEnergy()
  {
    return energy;
  }
  




  public String getName()
  {
    return robotName;
  }
  



  @Deprecated
  public String getRobotName()
  {
    return robotName;
  }
  












  public boolean isMyFault()
  {
    return atFault;
  }
  



  public final int compareTo(Event event)
  {
    int res = super.compareTo(event);
    
    if (res != 0) {
      return res;
    }
    


    if ((event instanceof HitRobotEvent)) {
      int compare1 = isMyFault() ? -1 : 0;
      int compare2 = ((HitRobotEvent)event).isMyFault() ? -1 : 0;
      
      return compare1 - compare2;
    }
    

    return 0;
  }
  



  final int getDefaultPriority()
  {
    return 40;
  }
  



  final void dispatch(IBasicRobot robot, IRobotStatics statics, Graphics2D graphics)
  {
    IBasicEvents listener = robot.getBasicEventListener();
    
    if (listener != null) {
      listener.onHitRobot(this);
    }
  }
  



  byte getSerializationType()
  {
    return 43;
  }
  

  static ISerializableHelper createHiddenSerializer() { return new SerializableHelper(null); }
  
  private static class SerializableHelper implements ISerializableHelper {
    private SerializableHelper() {}
    
    public int sizeOf(RbSerializer serializer, Object object) { HitRobotEvent obj = (HitRobotEvent)object;
      
      return 1 + serializer.sizeOf(robotName) + 16 + 1;
    }
    
    public void serialize(RbSerializer serializer, ByteBuffer buffer, Object object)
    {
      HitRobotEvent obj = (HitRobotEvent)object;
      
      serializer.serialize(buffer, robotName);
      serializer.serialize(buffer, bearing);
      serializer.serialize(buffer, energy);
      serializer.serialize(buffer, atFault);
    }
    
    public Object deserialize(RbSerializer serializer, ByteBuffer buffer) {
      String robotName = serializer.deserializeString(buffer);
      double bearing = buffer.getDouble();
      double energy = buffer.getDouble();
      boolean atFault = serializer.deserializeBoolean(buffer);
      
      return new HitRobotEvent(robotName, bearing, energy, atFault);
    }
  }
}
