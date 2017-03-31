package robocode.util;

import java.util.Random;
import robocode.control.RandomFactory;


























public class Utils
{
  private static final double TWO_PI = 6.283185307179586D;
  private static final double THREE_PI_OVER_TWO = 4.71238898038469D;
  private static final double PI_OVER_TWO = 1.5707963267948966D;
  public static final double NEAR_DELTA = 1.0E-5D;
  
  private Utils() {}
  
  public static double normalAbsoluteAngle(double angle)
  {
    return angle %= 6.283185307179586D >= 0.0D ? angle : angle + 6.283185307179586D;
  }
  







  public static double normalAbsoluteAngleDegrees(double angle)
  {
    return angle %= 360.0D >= 0.0D ? angle : angle + 360.0D;
  }
  







  public static double normalRelativeAngle(double angle)
  {
    return angle >= -3.141592653589793D ? angle : angle %= 6.283185307179586D >= 0.0D ? angle - 6.283185307179586D : angle < 3.141592653589793D ? angle : angle + 6.283185307179586D;
  }
  







  public static double normalRelativeAngleDegrees(double angle)
  {
    return angle >= -180.0D ? angle : angle %= 360.0D >= 0.0D ? angle - 360.0D : angle < 180.0D ? angle : angle + 360.0D;
  }
  













  public static double normalNearAbsoluteAngleDegrees(double angle)
  {
    angle = angle %= 360.0D >= 0.0D ? angle : angle + 360.0D;
    
    if (isNear(angle, 180.0D))
      return 180.0D;
    if (angle < 180.0D) {
      if (isNear(angle, 0.0D))
        return 0.0D;
      if (isNear(angle, 90.0D)) {
        return 90.0D;
      }
    } else {
      if (isNear(angle, 270.0D))
        return 270.0D;
      if (isNear(angle, 360.0D)) {
        return 0.0D;
      }
    }
    return angle;
  }
  













  public static double normalNearAbsoluteAngle(double angle)
  {
    angle = angle %= 6.283185307179586D >= 0.0D ? angle : angle + 6.283185307179586D;
    
    if (isNear(angle, 3.141592653589793D))
      return 3.141592653589793D;
    if (angle < 3.141592653589793D) {
      if (isNear(angle, 0.0D))
        return 0.0D;
      if (isNear(angle, 1.5707963267948966D)) {
        return 1.5707963267948966D;
      }
    } else {
      if (isNear(angle, 4.71238898038469D))
        return 4.71238898038469D;
      if (isNear(angle, 6.283185307179586D)) {
        return 0.0D;
      }
    }
    return angle;
  }
  














  public static boolean isNear(double value1, double value2)
  {
    return Math.abs(value1 - value2) < 1.0E-5D;
  }
  




  public static Random getRandom()
  {
    return RandomFactory.getRandom();
  }
}
