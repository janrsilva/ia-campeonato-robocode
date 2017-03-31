package robocode;















public class RateControlRobot
  extends TeamRobot
{
  private double velocityRate;
  












  private double turnRate;
  












  private double gunRotationRate;
  












  private double radarRotationRate;
  













  public RateControlRobot() {}
  













  public void setVelocityRate(double velocityRate)
  {
    this.velocityRate = velocityRate;
  }
  









  public double getVelocityRate()
  {
    return velocityRate;
  }
  































  public void setTurnRate(double turnRate)
  {
    this.turnRate = Math.toRadians(turnRate);
  }
  









  public double getTurnRate()
  {
    return Math.toDegrees(turnRate);
  }
  































  public void setTurnRateRadians(double turnRate)
  {
    this.turnRate = turnRate;
  }
  









  public double getTurnRateRadians()
  {
    return turnRate;
  }
  































  public void setGunRotationRate(double gunRotationRate)
  {
    this.gunRotationRate = Math.toRadians(gunRotationRate);
  }
  









  public double getGunRotationRate()
  {
    return Math.toDegrees(gunRotationRate);
  }
  































  public void setGunRotationRateRadians(double gunRotationRate)
  {
    this.gunRotationRate = gunRotationRate;
  }
  









  public double getGunRotationRateRadians()
  {
    return gunRotationRate;
  }
  































  public void setRadarRotationRate(double radarRotationRate)
  {
    this.radarRotationRate = Math.toRadians(radarRotationRate);
  }
  









  public double getRadarRotationRate()
  {
    return Math.toDegrees(radarRotationRate);
  }
  































  public void setRadarRotationRateRadians(double radarRotationRate)
  {
    this.radarRotationRate = radarRotationRate;
  }
  









  public double getRadarRotationRateRadians()
  {
    return radarRotationRate;
  }
  






















  public void execute()
  {
    setMaxVelocity(velocityRate);
    if (velocityRate > 0.0D) {
      setAhead(Double.POSITIVE_INFINITY);
    } else if (velocityRate < 0.0D) {
      setBack(Double.POSITIVE_INFINITY);
    } else {
      setAhead(0.0D);
    }
    
    setTurnGunRightRadians(gunRotationRate);
    setTurnRadarRightRadians(radarRotationRate);
    setTurnRightRadians(turnRate);
    
    super.execute();
  }
}
