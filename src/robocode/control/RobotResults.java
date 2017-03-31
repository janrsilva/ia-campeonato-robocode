package robocode.control;

import robocode.BattleResults;














































public class RobotResults
  extends BattleResults
{
  private static final long serialVersionUID = 2L;
  private final RobotSpecification robot;
  
  public RobotResults(RobotSpecification robot, String teamLeaderName, int rank, double score, double survival, double lastSurvivorBonus, double bulletDamage, double bulletDamageBonus, double ramDamage, double ramDamageBonus, int firsts, int seconds, int thirds)
  {
    super(teamLeaderName, rank, score, survival, lastSurvivorBonus, bulletDamage, bulletDamageBonus, ramDamage, ramDamageBonus, firsts, seconds, thirds);
    
    this.robot = robot;
  }
  








  public RobotResults(RobotSpecification robot, BattleResults results)
  {
    super(results.getTeamLeaderName(), results.getRank(), results.getScore(), results.getSurvival(), results.getLastSurvivorBonus(), results.getBulletDamage(), results.getBulletDamageBonus(), results.getRamDamage(), results.getRamDamageBonus(), results.getFirsts(), results.getSeconds(), results.getThirds());
    


    this.robot = robot;
  }
  




  public RobotSpecification getRobot()
  {
    return robot;
  }
  






  public static RobotResults[] convertResults(BattleResults[] results)
  {
    RobotResults[] resultsConv = new RobotResults[results.length];
    
    for (int i = 0; i < results.length; i++) {
      resultsConv[i] = ((RobotResults)results[i]);
    }
    return resultsConv;
  }
  
  public int hashCode()
  {
    int prime = 31;
    int result = 1;
    

    long temp = Double.doubleToLongBits(bulletDamage);
    result = 31 * result + (int)(temp ^ temp >>> 32);
    temp = Double.doubleToLongBits(bulletDamageBonus);
    result = 31 * result + (int)(temp ^ temp >>> 32);
    result = 31 * result + firsts;
    temp = Double.doubleToLongBits(lastSurvivorBonus);
    result = 31 * result + (int)(temp ^ temp >>> 32);
    temp = Double.doubleToLongBits(ramDamage);
    result = 31 * result + (int)(temp ^ temp >>> 32);
    temp = Double.doubleToLongBits(ramDamageBonus);
    result = 31 * result + (int)(temp ^ temp >>> 32);
    result = 31 * result + rank;
    temp = Double.doubleToLongBits(score);
    result = 31 * result + (int)(temp ^ temp >>> 32);
    result = 31 * result + seconds;
    temp = Double.doubleToLongBits(survival);
    result = 31 * result + (int)(temp ^ temp >>> 32);
    result = 31 * result + (teamLeaderName == null ? 0 : teamLeaderName.hashCode());
    result = 31 * result + thirds;
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
    RobotResults other = (RobotResults)obj;
    
    if (Double.doubleToLongBits(bulletDamage) != Double.doubleToLongBits(bulletDamage)) {
      return false;
    }
    if (Double.doubleToLongBits(bulletDamageBonus) != Double.doubleToLongBits(bulletDamageBonus)) {
      return false;
    }
    if (firsts != firsts) {
      return false;
    }
    if (Double.doubleToLongBits(lastSurvivorBonus) != Double.doubleToLongBits(lastSurvivorBonus)) {
      return false;
    }
    if (Double.doubleToLongBits(ramDamage) != Double.doubleToLongBits(ramDamage)) {
      return false;
    }
    if (Double.doubleToLongBits(ramDamageBonus) != Double.doubleToLongBits(ramDamageBonus)) {
      return false;
    }
    if (rank != rank) {
      return false;
    }
    if (Double.doubleToLongBits(score) != Double.doubleToLongBits(score)) {
      return false;
    }
    if (seconds != seconds) {
      return false;
    }
    if (Double.doubleToLongBits(survival) != Double.doubleToLongBits(survival)) {
      return false;
    }
    if (teamLeaderName == null) {
      if (teamLeaderName != null) {
        return false;
      }
    } else if (!teamLeaderName.equals(teamLeaderName)) {
      return false;
    }
    if (thirds != thirds) {
      return false;
    }
    return true;
  }
}
