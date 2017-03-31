package robocode;











public final class Rules
{
  public static final double ACCELERATION = 1.0D;
  








  public static final double DECELERATION = 2.0D;
  








  public static final double MAX_VELOCITY = 8.0D;
  








  public static final double RADAR_SCAN_RADIUS = 1200.0D;
  








  public static final double MIN_BULLET_POWER = 0.1D;
  








  public static final double MAX_BULLET_POWER = 3.0D;
  








  public static final double MAX_TURN_RATE = 10.0D;
  








  public static final double MAX_TURN_RATE_RADIANS = Math.toRadians(10.0D);
  










  public static final double GUN_TURN_RATE = 20.0D;
  









  public static final double GUN_TURN_RATE_RADIANS = Math.toRadians(20.0D);
  











  public static final double RADAR_TURN_RATE = 45.0D;
  










  public static final double RADAR_TURN_RATE_RADIANS = Math.toRadians(45.0D);
  



  public static final double ROBOT_HIT_DAMAGE = 0.6D;
  



  public static final double ROBOT_HIT_BONUS = 1.2D;
  




  private Rules() {}
  



  public static double getTurnRate(double velocity)
  {
    return 10.0D - 0.75D * Math.abs(velocity);
  }
  







  public static double getTurnRateRadians(double velocity)
  {
    return Math.toRadians(getTurnRate(velocity));
  }
  






  public static double getWallHitDamage(double velocity)
  {
    return Math.max(Math.abs(velocity) / 2.0D - 1.0D, 0.0D);
  }
  





  public static double getBulletDamage(double bulletPower)
  {
    double damage = 4.0D * bulletPower;
    
    if (bulletPower > 1.0D) {
      damage += 2.0D * (bulletPower - 1.0D);
    }
    return damage;
  }
  






  public static double getBulletHitBonus(double bulletPower)
  {
    return 3.0D * bulletPower;
  }
  





  public static double getBulletSpeed(double bulletPower)
  {
    bulletPower = Math.min(Math.max(bulletPower, 0.1D), 3.0D);
    return 20.0D - 3.0D * bulletPower;
  }
  






  public static double getGunHeat(double bulletPower)
  {
    return 1.0D + bulletPower / 5.0D;
  }
}
