package robocode;

import java.io.Serializable;
import java.nio.ByteBuffer;
import net.sf.robocode.security.IHiddenBulletHelper;
import net.sf.robocode.serialization.ISerializableHelper;
import net.sf.robocode.serialization.RbSerializer;



































public class Bullet
  implements Serializable
{
  private static final long serialVersionUID = 1L;
  private final double headingRadians;
  private double x;
  private double y;
  private final double power;
  private final String ownerName;
  private String victimName;
  private boolean isActive;
  private final int bulletId;
  
  public Bullet(double heading, double x, double y, double power, String ownerName, String victimName, boolean isActive, int bulletId)
  {
    headingRadians = heading;
    this.x = x;
    this.y = y;
    this.power = power;
    this.ownerName = ownerName;
    this.victimName = victimName;
    this.isActive = isActive;
    this.bulletId = bulletId;
  }
  
  public boolean equals(Object obj)
  {
    if (this == obj) {
      return true;
    }
    if ((obj == null) || (getClass() != obj.getClass())) {
      return false;
    }
    return bulletId == bulletId;
  }
  
  public int hashCode()
  {
    return bulletId;
  }
  






  public double getHeading()
  {
    return Math.toDegrees(headingRadians);
  }
  






  public double getHeadingRadians()
  {
    return headingRadians;
  }
  




  public String getName()
  {
    return ownerName;
  }
  








  public double getPower()
  {
    return power;
  }
  





  public double getVelocity()
  {
    return Rules.getBulletSpeed(power);
  }
  






  public String getVictim()
  {
    return victimName;
  }
  




  public double getX()
  {
    return x;
  }
  




  public double getY()
  {
    return y;
  }
  





  public boolean isActive()
  {
    return isActive;
  }
  








  private void update(double x, double y, String victimName, boolean isActive)
  {
    this.x = x;
    this.y = y;
    this.victimName = victimName;
    this.isActive = isActive;
  }
  



  int getBulletId()
  {
    return bulletId;
  }
  





  static IHiddenBulletHelper createHiddenHelper()
  {
    return new HiddenBulletHelper(null);
  }
  





  static ISerializableHelper createHiddenSerializer()
  {
    return new HiddenBulletHelper(null);
  }
  
  private static class HiddenBulletHelper implements IHiddenBulletHelper, ISerializableHelper {
    private HiddenBulletHelper() {}
    
    public void update(Bullet bullet, double x, double y, String victimName, boolean isActive) {
      bullet.update(x, y, victimName, isActive);
    }
    
    public int sizeOf(RbSerializer serializer, Object object) {
      Bullet obj = (Bullet)object;
      
      return 33 + serializer.sizeOf(ownerName) + serializer.sizeOf(victimName) + 1 + 4;
    }
    
    public void serialize(RbSerializer serializer, ByteBuffer buffer, Object object)
    {
      Bullet obj = (Bullet)object;
      
      serializer.serialize(buffer, headingRadians);
      serializer.serialize(buffer, x);
      serializer.serialize(buffer, y);
      serializer.serialize(buffer, power);
      serializer.serialize(buffer, ownerName);
      serializer.serialize(buffer, victimName);
      serializer.serialize(buffer, isActive);
      serializer.serialize(buffer, bulletId);
    }
    
    public Object deserialize(RbSerializer serializer, ByteBuffer buffer) {
      double headingRadians = buffer.getDouble();
      double x = buffer.getDouble();
      double y = buffer.getDouble();
      double power = buffer.getDouble();
      String ownerName = serializer.deserializeString(buffer);
      String victimName = serializer.deserializeString(buffer);
      boolean isActive = serializer.deserializeBoolean(buffer);
      int bulletId = serializer.deserializeInt(buffer);
      
      return new Bullet(headingRadians, x, y, power, ownerName, victimName, isActive, bulletId);
    }
  }
}
