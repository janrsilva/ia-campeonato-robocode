package robocode;

import java.io.Serializable;
import java.nio.ByteBuffer;
import net.sf.robocode.security.IHiddenStatusHelper;
import net.sf.robocode.serialization.ISerializableHelper;
import net.sf.robocode.serialization.RbSerializer;






















public final class RobotStatus
  implements Serializable
{
  private static final long serialVersionUID = 1L;
  private final double energy;
  private final double x;
  private final double y;
  private final double bodyHeading;
  private final double gunHeading;
  private final double radarHeading;
  private final double velocity;
  private final double bodyTurnRemaining;
  private final double radarTurnRemaining;
  private final double gunTurnRemaining;
  private final double distanceRemaining;
  private final double gunHeat;
  private final int others;
  private final int numSentries;
  private final int roundNum;
  private final int numRounds;
  private final long time;
  
  public double getEnergy()
  {
    return energy;
  }
  






  public double getX()
  {
    return x;
  }
  






  public double getY()
  {
    return y;
  }
  








  public double getHeadingRadians()
  {
    return bodyHeading;
  }
  








  public double getHeading()
  {
    return Math.toDegrees(bodyHeading);
  }
  








  public double getGunHeadingRadians()
  {
    return gunHeading;
  }
  








  public double getGunHeading()
  {
    return Math.toDegrees(gunHeading);
  }
  








  public double getRadarHeadingRadians()
  {
    return radarHeading;
  }
  








  public double getRadarHeading()
  {
    return Math.toDegrees(radarHeading);
  }
  








  public double getVelocity()
  {
    return velocity;
  }
  








  public double getTurnRemainingRadians()
  {
    return bodyTurnRemaining;
  }
  








  public double getTurnRemaining()
  {
    return Math.toDegrees(bodyTurnRemaining);
  }
  








  public double getRadarTurnRemainingRadians()
  {
    return radarTurnRemaining;
  }
  








  public double getRadarTurnRemaining()
  {
    return Math.toDegrees(radarTurnRemaining);
  }
  








  public double getGunTurnRemainingRadians()
  {
    return gunTurnRemaining;
  }
  








  public double getGunTurnRemaining()
  {
    return Math.toDegrees(gunTurnRemaining);
  }
  










  public double getDistanceRemaining()
  {
    return distanceRemaining;
  }
  
















  public double getGunHeat()
  {
    return gunHeat;
  }
  






  public int getOthers()
  {
    return others;
  }
  






  public int getNumSentries()
  {
    return numSentries;
  }
  






  public int getNumRounds()
  {
    return numRounds;
  }
  







  public int getRoundNum()
  {
    return roundNum;
  }
  





  public long getTime()
  {
    return time;
  }
  

  private RobotStatus(double energy, double x, double y, double bodyHeading, double gunHeading, double radarHeading, double velocity, double bodyTurnRemaining, double radarTurnRemaining, double gunTurnRemaining, double distanceRemaining, double gunHeat, int others, int numSentries, int roundNum, int numRounds, long time)
  {
    this.energy = energy;
    this.x = x;
    this.y = y;
    this.bodyHeading = bodyHeading;
    this.gunHeading = gunHeading;
    this.radarHeading = radarHeading;
    this.bodyTurnRemaining = bodyTurnRemaining;
    this.velocity = velocity;
    this.radarTurnRemaining = radarTurnRemaining;
    this.gunTurnRemaining = gunTurnRemaining;
    this.distanceRemaining = distanceRemaining;
    this.gunHeat = gunHeat;
    this.others = others;
    this.numSentries = numSentries;
    this.roundNum = roundNum;
    this.numRounds = numRounds;
    this.time = time;
  }
  

  static ISerializableHelper createHiddenSerializer() { return new SerializableHelper(null); }
  
  private static class SerializableHelper implements ISerializableHelper, IHiddenStatusHelper {
    private SerializableHelper() {}
    
    public int sizeOf(RbSerializer serializer, Object object) { return 121; }
    

    public void serialize(RbSerializer serializer, ByteBuffer buffer, Object object)
    {
      RobotStatus obj = (RobotStatus)object;
      
      serializer.serialize(buffer, energy);
      serializer.serialize(buffer, x);
      serializer.serialize(buffer, y);
      serializer.serialize(buffer, bodyHeading);
      serializer.serialize(buffer, gunHeading);
      serializer.serialize(buffer, radarHeading);
      serializer.serialize(buffer, velocity);
      serializer.serialize(buffer, bodyTurnRemaining);
      serializer.serialize(buffer, radarTurnRemaining);
      serializer.serialize(buffer, gunTurnRemaining);
      serializer.serialize(buffer, distanceRemaining);
      serializer.serialize(buffer, gunHeat);
      serializer.serialize(buffer, others);
      serializer.serialize(buffer, numSentries);
      serializer.serialize(buffer, roundNum);
      serializer.serialize(buffer, numRounds);
      serializer.serialize(buffer, time);
    }
    
    public Object deserialize(RbSerializer serializer, ByteBuffer buffer) {
      double energy = buffer.getDouble();
      double x = buffer.getDouble();
      double y = buffer.getDouble();
      double bodyHeading = buffer.getDouble();
      double gunHeading = buffer.getDouble();
      double radarHeading = buffer.getDouble();
      double velocity = buffer.getDouble();
      double bodyTurnRemaining = buffer.getDouble();
      double radarTurnRemaining = buffer.getDouble();
      double gunTurnRemaining = buffer.getDouble();
      double distanceRemaining = buffer.getDouble();
      double gunHeat = buffer.getDouble();
      int others = buffer.getInt();
      int numSentries = buffer.getInt();
      int roundNum = buffer.getInt();
      int numRounds = buffer.getInt();
      long time = buffer.getLong();
      
      return new RobotStatus(energy, x, y, bodyHeading, gunHeading, radarHeading, velocity, bodyTurnRemaining, radarTurnRemaining, gunTurnRemaining, distanceRemaining, gunHeat, others, numSentries, roundNum, numRounds, time, null);
    }
    



    public RobotStatus createStatus(double energy, double x, double y, double bodyHeading, double gunHeading, double radarHeading, double velocity, double bodyTurnRemaining, double radarTurnRemaining, double gunTurnRemaining, double distanceRemaining, double gunHeat, int others, int numSentries, int roundNum, int numRounds, long time)
    {
      return new RobotStatus(energy, x, y, bodyHeading, gunHeading, radarHeading, velocity, bodyTurnRemaining, radarTurnRemaining, gunTurnRemaining, distanceRemaining, gunHeat, others, numSentries, roundNum, numRounds, time, null);
    }
  }
}
