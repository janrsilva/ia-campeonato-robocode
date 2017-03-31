package robocode;

import java.awt.Graphics2D;
import java.nio.ByteBuffer;
import net.sf.robocode.peer.IRobotStatics;
import net.sf.robocode.serialization.ISerializableHelper;
import net.sf.robocode.serialization.RbSerializer;
import robocode.robotinterfaces.IBasicEvents;
import robocode.robotinterfaces.IBasicRobot;




























public class ScannedRobotEvent
  extends Event
{
  private static final long serialVersionUID = 1L;
  private static final int DEFAULT_PRIORITY = 10;
  private final String name;
  private final double energy;
  private final double heading;
  private final double bearing;
  private final double distance;
  private final double velocity;
  private final boolean isSentryRobot;
  
  /**
   * @deprecated
   */
  public ScannedRobotEvent()
  {
    this(null, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, false);
  }
  








  /**
   * @deprecated
   */
  public ScannedRobotEvent(String name, double energy, double bearing, double distance, double heading, double velocity)
  {
    this(name, energy, bearing, distance, heading, velocity, false);
  }
  













  public ScannedRobotEvent(String name, double energy, double bearing, double distance, double heading, double velocity, boolean isSentryRobot)
  {
    this.name = name;
    this.energy = energy;
    this.bearing = bearing;
    this.distance = distance;
    this.heading = heading;
    this.velocity = velocity;
    this.isSentryRobot = isSentryRobot;
  }
  





  public double getBearing()
  {
    return bearing * 180.0D / 3.141592653589793D;
  }
  





  public double getBearingRadians()
  {
    return bearing;
  }
  




  public double getDistance()
  {
    return distance;
  }
  




  public double getEnergy()
  {
    return energy;
  }
  




  public double getHeading()
  {
    return heading * 180.0D / 3.141592653589793D;
  }
  




  public double getHeadingRadians()
  {
    return heading;
  }
  



  @Deprecated
  public double getLife()
  {
    return energy;
  }
  




  public String getName()
  {
    return name;
  }
  



  @Deprecated
  public double getRobotBearing()
  {
    return getBearing();
  }
  



  @Deprecated
  public double getRobotBearingDegrees()
  {
    return getBearing();
  }
  



  @Deprecated
  public double getRobotBearingRadians()
  {
    return getBearingRadians();
  }
  



  @Deprecated
  public double getRobotDistance()
  {
    return getDistance();
  }
  



  @Deprecated
  public double getRobotHeading()
  {
    return getHeading();
  }
  



  @Deprecated
  public double getRobotHeadingDegrees()
  {
    return getHeading();
  }
  



  @Deprecated
  public double getRobotHeadingRadians()
  {
    return getHeadingRadians();
  }
  



  @Deprecated
  public double getRobotLife()
  {
    return getEnergy();
  }
  



  @Deprecated
  public String getRobotName()
  {
    return getName();
  }
  



  @Deprecated
  public double getRobotVelocity()
  {
    return getVelocity();
  }
  




  public double getVelocity()
  {
    return velocity;
  }
  





  public boolean isSentryRobot()
  {
    return isSentryRobot;
  }
  



  public final int compareTo(Event event)
  {
    int res = super.compareTo(event);
    if (res != 0) {
      return res;
    }
    

    if ((event instanceof ScannedRobotEvent)) {
      return (int)(getDistance() - ((ScannedRobotEvent)event).getDistance());
    }
    
    return 0;
  }
  



  final int getDefaultPriority()
  {
    return 10;
  }
  



  final void dispatch(IBasicRobot robot, IRobotStatics statics, Graphics2D graphics)
  {
    IBasicEvents listener = robot.getBasicEventListener();
    if (listener != null) {
      listener.onScannedRobot(this);
    }
  }
  



  byte getSerializationType()
  {
    return 41;
  }
  

  static ISerializableHelper createHiddenSerializer() { return new SerializableHelper(null); }
  
  private static class SerializableHelper implements ISerializableHelper {
    private SerializableHelper() {}
    
    public int sizeOf(RbSerializer serializer, Object object) { ScannedRobotEvent obj = (ScannedRobotEvent)object;
      return 1 + serializer.sizeOf(name) + 40 + 1;
    }
    
    public void serialize(RbSerializer serializer, ByteBuffer buffer, Object object)
    {
      ScannedRobotEvent obj = (ScannedRobotEvent)object;
      serializer.serialize(buffer, name);
      serializer.serialize(buffer, energy);
      serializer.serialize(buffer, heading);
      serializer.serialize(buffer, bearing);
      serializer.serialize(buffer, distance);
      serializer.serialize(buffer, velocity);
      serializer.serialize(buffer, isSentryRobot);
    }
    
    public Object deserialize(RbSerializer serializer, ByteBuffer buffer) {
      String name = serializer.deserializeString(buffer);
      double energy = buffer.getDouble();
      double heading = buffer.getDouble();
      double bearing = buffer.getDouble();
      double distance = buffer.getDouble();
      double velocity = buffer.getDouble();
      boolean isSentryRobot = serializer.deserializeBoolean(buffer);
      
      return new ScannedRobotEvent(name, energy, bearing, distance, heading, velocity, isSentryRobot);
    }
  }
}
