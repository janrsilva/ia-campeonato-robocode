package robocode;

import java.awt.Graphics2D;
import java.nio.ByteBuffer;
import net.sf.robocode.peer.IRobotStatics;
import net.sf.robocode.serialization.ISerializableHelper;
import net.sf.robocode.serialization.RbSerializer;
import robocode.robotinterfaces.IBasicEvents;
import robocode.robotinterfaces.IBasicRobot;
























public final class HitByBulletEvent
  extends Event
{
  private static final long serialVersionUID = 1L;
  private static final int DEFAULT_PRIORITY = 20;
  private final double bearing;
  private final Bullet bullet;
  
  public HitByBulletEvent(double bearing, Bullet bullet)
  {
    this.bearing = bearing;
    this.bullet = bullet;
  }
  









  public double getBearing()
  {
    return bearing * 180.0D / 3.141592653589793D;
  }
  









  public double getBearingRadians()
  {
    return bearing;
  }
  




  public Bullet getBullet()
  {
    return bullet;
  }
  









  public double getHeading()
  {
    return bullet.getHeading();
  }
  



  @Deprecated
  public double getHeadingDegrees()
  {
    return getHeading();
  }
  









  public double getHeadingRadians()
  {
    return bullet.getHeadingRadians();
  }
  




  public String getName()
  {
    return bullet.getName();
  }
  






  public double getPower()
  {
    return bullet.getPower();
  }
  




  public double getVelocity()
  {
    return bullet.getVelocity();
  }
  



  final int getDefaultPriority()
  {
    return 20;
  }
  



  final void dispatch(IBasicRobot robot, IRobotStatics statics, Graphics2D graphics)
  {
    IBasicEvents listener = robot.getBasicEventListener();
    
    if (listener != null) {
      listener.onHitByBullet(this);
    }
  }
  



  byte getSerializationType()
  {
    return 42;
  }
  

  static ISerializableHelper createHiddenSerializer() { return new SerializableHelper(null); }
  
  private static class SerializableHelper implements ISerializableHelper {
    private SerializableHelper() {}
    
    public int sizeOf(RbSerializer serializer, Object object) { HitByBulletEvent obj = (HitByBulletEvent)object;
      
      return 1 + serializer.sizeOf((byte)9, bullet) + 8;
    }
    
    public void serialize(RbSerializer serializer, ByteBuffer buffer, Object object)
    {
      HitByBulletEvent obj = (HitByBulletEvent)object;
      
      serializer.serialize(buffer, (byte)9, bullet);
      serializer.serialize(buffer, bearing);
    }
    
    public Object deserialize(RbSerializer serializer, ByteBuffer buffer) {
      Bullet bullet = (Bullet)serializer.deserializeAny(buffer);
      double bearing = buffer.getDouble();
      
      return new HitByBulletEvent(bearing, bullet);
    }
  }
}
