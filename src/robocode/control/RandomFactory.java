package robocode.control;

import java.lang.reflect.Field;
import java.util.Random;
import net.sf.robocode.io.Logger;


























public class RandomFactory
{
  private static Random randomNumberGenerator = new Random();
  
  public RandomFactory() {}
  
  public boolean isDeterministic() { return isDeterministic; }
  


  private static boolean warningNotSupportedLogged;
  

  private static boolean isDeterministic;
  
  public static Random getRandom()
  {
    if (randomNumberGenerator == null) {
      try {
        Math.random();
        Field field = Math.class.getDeclaredField("randomNumberGenerator");
        boolean savedFieldAccessible = field.isAccessible();
        
        field.setAccessible(true);
        randomNumberGenerator = (Random)field.get(null);
        field.setAccessible(savedFieldAccessible);
      } catch (NoSuchFieldException e) {
        logWarningNotSupported();
        randomNumberGenerator = new Random();
      } catch (IllegalAccessException e) {
        Logger.logError(e);
        randomNumberGenerator = new Random();
      }
    }
    return randomNumberGenerator;
  }
  






  public static void setRandom(Random random)
  {
    randomNumberGenerator = random;
    try {
      Math.random();
      Field field = Math.class.getDeclaredField("randomNumberGenerator");
      boolean savedFieldAccessible = field.isAccessible();
      
      field.setAccessible(true);
      field.set(null, randomNumberGenerator);
      field.setAccessible(savedFieldAccessible);
    } catch (NoSuchFieldException e) {
      logWarningNotSupported();
    } catch (IllegalAccessException e) {
      Logger.logError(e);
    }
  }
  







  public static void resetDeterministic(long seed)
  {
    setRandom(new Random(seed));
    isDeterministic = true;
  }
  


  private static void logWarningNotSupported()
  {
    if ((!warningNotSupportedLogged) && (!System.getProperty("RANDOMSEED", "none").equals("none"))) {
      Logger.logWarning("The deterministic random generator feature is not supported by this JVM:\n" + System.getProperty("java.vm.vendor") + " " + System.getProperty("java.vm.name") + " " + System.getProperty("java.vm.version"));
      



      warningNotSupportedLogged = true;
    }
  }
}
