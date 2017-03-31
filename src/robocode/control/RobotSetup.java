package robocode.control;

import java.io.Serializable;




















public class RobotSetup
  implements Serializable
{
  private static final long serialVersionUID = 1L;
  private final Double x;
  private final Double y;
  private final Double heading;
  
  public RobotSetup(Double x, Double y, Double heading)
  {
    this.x = x;
    this.y = y;
    this.heading = heading;
  }
  



  public Double getX()
  {
    return x;
  }
  



  public Double getY()
  {
    return y;
  }
  



  public Double getHeading()
  {
    return heading;
  }
}
