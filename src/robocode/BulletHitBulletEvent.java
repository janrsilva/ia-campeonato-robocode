package robocode;

import java.awt.Graphics2D;
import java.nio.ByteBuffer;
import net.sf.robocode.peer.IRobotStatics;
import net.sf.robocode.serialization.ISerializableHelper;
import net.sf.robocode.serialization.RbSerializer;
import robocode.robotinterfaces.IBasicEvents;
import robocode.robotinterfaces.IBasicRobot;























public final class BulletHitBulletEvent
  extends Event
{
  private static final long serialVersionUID = 1L;
  private static final int DEFAULT_PRIORITY = 55;
  private Bullet bullet;
  private final Bullet hitBullet;
  
  public BulletHitBulletEvent(Bullet bullet, Bullet hitBullet)
  {
    this.bullet = bullet;
    this.hitBullet = hitBullet;
  }
  




  public Bullet getBullet()
  {
    return bullet;
  }
  




  public Bullet getHitBullet()
  {
    return hitBullet;
  }
  



  final int getDefaultPriority()
  {
    return 55;
  }
  



  final void dispatch(IBasicRobot robot, IRobotStatics statics, Graphics2D graphics)
  {
    IBasicEvents listener = robot.getBasicEventListener();
    
    if (listener != null) {
      listener.onBulletHitBullet(this);
    }
  }
  



  byte getSerializationType()
  {
    return 33;
  }
  

  static ISerializableHelper createHiddenSerializer() { return new SerializableHelper(null); }
  
  private static class SerializableHelper implements ISerializableHelper {
    private SerializableHelper() {}
    
    public int sizeOf(RbSerializer serializer, Object object) { BulletHitBulletEvent obj = (BulletHitBulletEvent)object;
      
      return 5 + serializer.sizeOf((byte)9, hitBullet);
    }
    
    public void serialize(RbSerializer serializer, ByteBuffer buffer, Object object)
    {
      BulletHitBulletEvent obj = (BulletHitBulletEvent)object;
      

      serializer.serialize(buffer, bullet.getBulletId());
      serializer.serialize(buffer, (byte)9, hitBullet);
    }
    
    public Object deserialize(RbSerializer serializer, ByteBuffer buffer) {
      Bullet bullet = new Bullet(0.0D, 0.0D, 0.0D, 0.0D, null, null, false, buffer.getInt());
      Bullet hitBullet = (Bullet)serializer.deserializeAny(buffer);
      
      return new BulletHitBulletEvent(bullet, hitBullet);
    }
  }
}
