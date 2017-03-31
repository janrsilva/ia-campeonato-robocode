package robocode;

import java.io.Serializable;
import java.nio.ByteBuffer;
import net.sf.robocode.serialization.ISerializableHelper;
import net.sf.robocode.serialization.RbSerializer;

















































public class BattleResults
  implements Serializable, Comparable<BattleResults>
{
  protected static final long serialVersionUID = 1L;
  protected String teamLeaderName;
  protected int rank;
  protected double score;
  protected double survival;
  protected double lastSurvivorBonus;
  protected double bulletDamage;
  protected double bulletDamageBonus;
  protected double ramDamage;
  protected double ramDamageBonus;
  protected int firsts;
  protected int seconds;
  protected int thirds;
  
  public BattleResults(String teamLeaderName, int rank, double score, double survival, double lastSurvivorBonus, double bulletDamage, double bulletDamageBonus, double ramDamage, double ramDamageBonus, int firsts, int seconds, int thirds)
  {
    this.teamLeaderName = teamLeaderName;
    this.rank = rank;
    this.score = score;
    this.survival = survival;
    this.lastSurvivorBonus = lastSurvivorBonus;
    this.bulletDamage = bulletDamage;
    this.bulletDamageBonus = bulletDamageBonus;
    this.ramDamage = ramDamage;
    this.ramDamageBonus = ramDamageBonus;
    this.firsts = firsts;
    this.seconds = seconds;
    this.thirds = thirds;
  }
  





  public String getTeamLeaderName()
  {
    return teamLeaderName;
  }
  




  public int getRank()
  {
    return rank;
  }
  




  public int getScore()
  {
    return (int)(score + 0.5D);
  }
  




  public int getSurvival()
  {
    return (int)(survival + 0.5D);
  }
  




  public int getLastSurvivorBonus()
  {
    return (int)(lastSurvivorBonus + 0.5D);
  }
  




  public int getBulletDamage()
  {
    return (int)(bulletDamage + 0.5D);
  }
  




  public int getBulletDamageBonus()
  {
    return (int)(bulletDamageBonus + 0.5D);
  }
  




  public int getRamDamage()
  {
    return (int)(ramDamage + 0.5D);
  }
  




  public int getRamDamageBonus()
  {
    return (int)(ramDamageBonus + 0.5D);
  }
  




  public int getFirsts()
  {
    return firsts;
  }
  




  public int getSeconds()
  {
    return seconds;
  }
  




  public int getThirds()
  {
    return thirds;
  }
  


  public int compareTo(BattleResults o)
  {
    return Double.valueOf(score).compareTo(Double.valueOf(score));
  }
  
  public int hashCode()
  {
    int prime = 31;
    int result = 1;
    

    long temp = Double.doubleToLongBits(score);
    result = 31 * result + (int)(temp ^ temp >>> 32);
    return result;
  }
  
  public boolean equals(Object obj)
  {
    if (this == obj) {
      return true;
    }
    if (obj == null) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    BattleResults other = (BattleResults)obj;
    
    if (Double.doubleToLongBits(score) != Double.doubleToLongBits(score)) {
      return false;
    }
    return true;
  }
  

  static ISerializableHelper createHiddenSerializer() { return new SerializableHelper(null); }
  
  private static class SerializableHelper implements ISerializableHelper {
    private SerializableHelper() {}
    
    public int sizeOf(RbSerializer serializer, Object object) { BattleResults obj = (BattleResults)object;
      
      return 1 + serializer.sizeOf(teamLeaderName) + 16 + 56;
    }
    
    public void serialize(RbSerializer serializer, ByteBuffer buffer, Object object)
    {
      BattleResults obj = (BattleResults)object;
      
      serializer.serialize(buffer, teamLeaderName);
      serializer.serialize(buffer, rank);
      serializer.serialize(buffer, score);
      serializer.serialize(buffer, survival);
      serializer.serialize(buffer, lastSurvivorBonus);
      serializer.serialize(buffer, bulletDamage);
      serializer.serialize(buffer, bulletDamageBonus);
      serializer.serialize(buffer, ramDamage);
      serializer.serialize(buffer, ramDamageBonus);
      serializer.serialize(buffer, firsts);
      serializer.serialize(buffer, seconds);
      serializer.serialize(buffer, thirds);
    }
    
    public Object deserialize(RbSerializer serializer, ByteBuffer buffer) {
      String teamLeaderName = serializer.deserializeString(buffer);
      int rank = buffer.getInt();
      double score = buffer.getDouble();
      double survival = buffer.getDouble();
      double lastSurvivorBonus = buffer.getDouble();
      double bulletDamage = buffer.getDouble();
      double bulletDamageBonus = buffer.getDouble();
      double ramDamage = buffer.getDouble();
      double ramDamageBonus = buffer.getDouble();
      int firsts = buffer.getInt();
      int seconds = buffer.getInt();
      int thirds = buffer.getInt();
      
      return new BattleResults(teamLeaderName, rank, score, survival, lastSurvivorBonus, bulletDamage, bulletDamageBonus, ramDamage, ramDamageBonus, firsts, seconds, thirds);
    }
  }
}
