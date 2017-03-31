package robocode;

import java.awt.Graphics2D;
import java.nio.ByteBuffer;
import net.sf.robocode.peer.IRobotStatics;
import net.sf.robocode.serialization.ISerializableHelper;
import net.sf.robocode.serialization.RbSerializer;
import robocode.robotinterfaces.IBasicEvents;
import robocode.robotinterfaces.IBasicRobot;
























public final class BulletHitEvent
  extends Event
{
  private static final long serialVersionUID = 1L;
  private static final int DEFAULT_PRIORITY = 50;
  private final String name;
  private final double energy;
  private Bullet bullet;
  
  public BulletHitEvent(String name, double energy, Bullet bullet)
  {
    this.name = name;
    this.energy = energy;
    this.bullet = bullet;
  }
  




  public Bullet getBullet()
  {
    return bullet;
  }
  





  public double getEnergy()
  {
    return energy;
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
  public double getRobotLife()
  {
    return energy;
  }
  



  @Deprecated
  public String getRobotName()
  {
    return name;
  }
  



  final int getDefaultPriority()
  {
    return 50;
  }
  



  final void dispatch(IBasicRobot robot, IRobotStatics statics, Graphics2D graphics)
  {
    IBasicEvents listener = robot.getBasicEventListener();
    
    if (listener != null) {
      listener.onBulletHit(this);
    }
  }
  



  byte getSerializationType()
  {
    return 34;
  }
  

  static ISerializableHelper createHiddenSerializer() { return new SerializableHelper(null); }
  
  private static class SerializableHelper implements ISerializableHelper {
    private SerializableHelper() {}
    
    public int sizeOf(RbSerializer serializer, Object object) { BulletHitEvent obj = (BulletHitEvent)object;
      
      return 5 + serializer.sizeOf(name) + 8;
    }
    
    public void serialize(RbSerializer serializer, ByteBuffer buffer, Object object)
    {
      BulletHitEvent obj = (BulletHitEvent)object;
      
      serializer.serialize(buffer, bullet.getBulletId());
      serializer.serialize(buffer, name);
      serializer.serialize(buffer, energy);
    }
    
    public Object deserialize(RbSerializer serializer, ByteBuffer buffer) {
      Bullet bullet = new Bullet(0.0D, 0.0D, 0.0D, 0.0D, null, null, false, buffer.getInt());
      String name = serializer.deserializeString(buffer);
      double energy = buffer.getDouble();
      
      return new BulletHitEvent(name, energy, bullet);
    }
  }
}
