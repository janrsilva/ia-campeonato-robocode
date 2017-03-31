package robocode;

import java.awt.Graphics2D;
import java.nio.ByteBuffer;
import net.sf.robocode.peer.IRobotStatics;
import net.sf.robocode.serialization.ISerializableHelper;
import net.sf.robocode.serialization.RbSerializer;
import robocode.robotinterfaces.IBasicEvents;
import robocode.robotinterfaces.IBasicRobot;






















public final class BulletMissedEvent
  extends Event
{
  private static final long serialVersionUID = 1L;
  private static final int DEFAULT_PRIORITY = 60;
  private Bullet bullet;
  
  public BulletMissedEvent(Bullet bullet)
  {
    this.bullet = bullet;
  }
  




  public Bullet getBullet()
  {
    return bullet;
  }
  



  final int getDefaultPriority()
  {
    return 60;
  }
  



  final void dispatch(IBasicRobot robot, IRobotStatics statics, Graphics2D graphics)
  {
    IBasicEvents listener = robot.getBasicEventListener();
    
    if (listener != null) {
      listener.onBulletMissed(this);
    }
  }
  



  byte getSerializationType()
  {
    return 35;
  }
  

  static ISerializableHelper createHiddenSerializer() { return new SerializableHelper(null); }
  
  private static class SerializableHelper implements ISerializableHelper {
    private SerializableHelper() {}
    
    public int sizeOf(RbSerializer serializer, Object object) { return 5; }
    
    public void serialize(RbSerializer serializer, ByteBuffer buffer, Object object)
    {
      BulletMissedEvent obj = (BulletMissedEvent)object;
      
      serializer.serialize(buffer, bullet.getBulletId());
    }
    
    public Object deserialize(RbSerializer serializer, ByteBuffer buffer) {
      Bullet bullet = new Bullet(0.0D, 0.0D, 0.0D, 0.0D, null, null, false, buffer.getInt());
      
      return new BulletMissedEvent(bullet);
    }
  }
}
