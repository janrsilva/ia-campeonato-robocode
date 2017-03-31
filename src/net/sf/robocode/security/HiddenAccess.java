package net.sf.robocode.security;

import java.awt.Graphics2D;
import java.io.File;
import java.io.FilenameFilter;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.net.URLClassLoader;
import java.net.URLDecoder;
import java.security.CodeSource;
import java.security.ProtectionDomain;
import java.util.ArrayList;
import net.sf.robocode.core.ContainerBase;
import net.sf.robocode.io.Logger;
import net.sf.robocode.peer.IRobotStatics;
import robocode.BattleRules;
import robocode.Bullet;
import robocode.Event;
import robocode.RobotStatus;
import robocode.control.RobotSpecification;
import robocode.control.events.IBattleListener;
import robocode.robotinterfaces.IBasicRobot;









public class HiddenAccess
{
  private static IHiddenEventHelper eventHelper;
  private static IHiddenBulletHelper bulletHelper;
  private static IHiddenSpecificationHelper specificationHelper;
  private static IHiddenStatusHelper statusHelper;
  private static IHiddenRulesHelper rulesHelper;
  private static Method initContainer;
  private static Method initContainerRe;
  private static Method cleanup;
  private static Method robocodeMain;
  private static boolean initialized;
  
  public HiddenAccess() {}
  
  private static boolean foundCore = false;
  
  public static void init() {
    if (initialized) {
      return;
    }
    
    try
    {
      Method method = Event.class.getDeclaredMethod("createHiddenHelper", new Class[0]);
      method.setAccessible(true);
      eventHelper = (IHiddenEventHelper)method.invoke(null, new Object[0]);
      method.setAccessible(false);
      
      method = Bullet.class.getDeclaredMethod("createHiddenHelper", new Class[0]);
      method.setAccessible(true);
      bulletHelper = (IHiddenBulletHelper)method.invoke(null, new Object[0]);
      method.setAccessible(false);
      
      method = RobotSpecification.class.getDeclaredMethod("createHiddenHelper", new Class[0]);
      method.setAccessible(true);
      specificationHelper = (IHiddenSpecificationHelper)method.invoke(null, new Object[0]);
      method.setAccessible(false);
      
      method = RobotStatus.class.getDeclaredMethod("createHiddenSerializer", new Class[0]);
      method.setAccessible(true);
      statusHelper = (IHiddenStatusHelper)method.invoke(null, new Object[0]);
      method.setAccessible(false);
      
      method = BattleRules.class.getDeclaredMethod("createHiddenHelper", new Class[0]);
      method.setAccessible(true);
      rulesHelper = (IHiddenRulesHelper)method.invoke(null, new Object[0]);
      method.setAccessible(false);
      
      ClassLoader loader = getClassLoader();
      Class<?> main = loader.loadClass("net.sf.robocode.core.RobocodeMainBase");
      
      initContainer = main.getDeclaredMethod("initContainer", new Class[0]);
      initContainer.setAccessible(true);
      
      initContainerRe = main.getDeclaredMethod("initContainerForRobocodeEngine", new Class[] { File.class, IBattleListener.class });
      initContainerRe.setAccessible(true);
      
      cleanup = main.getDeclaredMethod("cleanupForRobocodeEngine", new Class[0]);
      cleanup.setAccessible(true);
      
      robocodeMain = main.getDeclaredMethod("robocodeMain", new Class[] { Object.class });
      robocodeMain.setAccessible(true);
      
      initialized = true;
    } catch (NoSuchMethodException e) {
      Logger.logError(e);
    } catch (InvocationTargetException e) {
      Logger.logError(e);
    } catch (IllegalAccessException e) {
      Logger.logError(e);
    } catch (ClassNotFoundException e) {
      Logger.logError(e);
      if (!foundCore) {
        Logger.logError("Can't find robocode.core-1.x.jar module near to robocode.jar");
        Logger.logError("Class path: " + System.getProperty("robocode.class.path", null));
      }
      System.exit(-1);
    } catch (MalformedURLException e) {
      Logger.logError(e);
    } catch (Error e) {
      Logger.logError(e);
      throw e;
    }
  }
  

  private static ClassLoader getClassLoader()
    throws MalformedURLException
  {
    StringBuilder classPath = new StringBuilder(System.getProperty("java.class.path", null));
    ClassLoader loader = ClassLoader.getSystemClassLoader();
    String path = HiddenAccess.class.getProtectionDomain().getCodeSource().getLocation().getPath();
    try
    {
      path = URLDecoder.decode(path, "UCS2");
    } catch (UnsupportedEncodingException e) {
      path = new File(".", "libs/robocode.jar").toString();
    }
    int i = path.lastIndexOf("robocode.jar");
    
    if (i > 0) {
      loader = createClassLoader(classPath, loader, path.substring(0, i));
    }
    System.setProperty("robocode.class.path", classPath.toString());
    return loader;
  }
  
  private static ClassLoader createClassLoader(StringBuilder classPath, ClassLoader loader, String dir) throws MalformedURLException
  {
    File dirf = new File(dir);
    ArrayList<URL> urls = new ArrayList();
    
    File[] files = dirf.listFiles(new FilenameFilter() {
      public boolean accept(File dir, String name) {
        String test = name.toLowerCase();
        
        return (test.endsWith(".jar")) && (!test.endsWith("robocode.jar"));
      }
    });
    
    if (files != null) {
      for (File file : files) {
        String name = file.toString().toLowerCase();
        
        if (name.contains("robocode.core")) {
          foundCore = true;
          urls.add(file.toURI().toURL());
        }
        if (name.contains("picocontainer")) {
          urls.add(file.toURI().toURL());
        }
        if (name.contains("codesize")) {
          urls.add(file.toURI().toURL());
        }
        classPath.append(File.pathSeparator);
        classPath.append(file.toString());
      }
    }
    return new URLClassLoader((URL[])urls.toArray(new URL[urls.size()]), loader);
  }
  
  public static boolean isCriticalEvent(Event e) {
    return eventHelper.isCriticalEvent(e);
  }
  
  public static void setEventTime(Event e, long newTime) {
    eventHelper.setTime(e, newTime);
  }
  
  public static void setEventPriority(Event e, int newPriority) {
    eventHelper.setPriority(e, newPriority);
  }
  
  public static void dispatch(Event event, IBasicRobot robot, IRobotStatics statics, Graphics2D graphics) {
    eventHelper.dispatch(event, robot, statics, graphics);
  }
  
  public static void setDefaultPriority(Event e) {
    eventHelper.setDefaultPriority(e);
  }
  
  public static byte getSerializationType(Event e) {
    return eventHelper.getSerializationType(e);
  }
  
  public static void update(Bullet bullet, double x, double y, String victimName, boolean isActive) {
    bulletHelper.update(bullet, x, y, victimName, isActive);
  }
  
  public static RobotSpecification createSpecification(Object fileSpecification, String name, String author, String webpage, String version, String robocodeVersion, String jarFile, String fullClassName, String description) {
    return specificationHelper.createSpecification(fileSpecification, name, author, webpage, version, robocodeVersion, jarFile, fullClassName, description);
  }
  
  public static Object getFileSpecification(RobotSpecification specification)
  {
    return specificationHelper.getFileSpecification(specification);
  }
  
  public static String getRobotTeamName(RobotSpecification specification) {
    return specificationHelper.getTeamName(specification);
  }
  
  public static void setTeamId(RobotSpecification specification, String teamName) {
    specificationHelper.setTeamName(specification, teamName);
  }
  

  public static RobotStatus createStatus(double energy, double x, double y, double bodyHeading, double gunHeading, double radarHeading, double velocity, double bodyTurnRemaining, double radarTurnRemaining, double gunTurnRemaining, double distanceRemaining, double gunHeat, int others, int numSentries, int roundNum, int numRounds, long time)
  {
    return statusHelper.createStatus(energy, x, y, bodyHeading, gunHeading, radarHeading, velocity, bodyTurnRemaining, radarTurnRemaining, gunTurnRemaining, distanceRemaining, gunHeat, others, numSentries, roundNum, numRounds, time);
  }
  

  public static BattleRules createRules(int battlefieldWidth, int battlefieldHeight, int numRounds, double gunCoolingRate, long inactivityTime, boolean hideEnemyNames, int sentryBorderSize)
  {
    return rulesHelper.createRules(battlefieldWidth, battlefieldHeight, numRounds, gunCoolingRate, inactivityTime, hideEnemyNames, sentryBorderSize);
  }
  
  public static boolean isSafeThread()
  {
    IThreadManagerBase threadManager = (IThreadManagerBase)ContainerBase.getComponent(IThreadManagerBase.class);
    
    return (threadManager != null) && (threadManager.isSafeThread());
  }
  
  public static void initContainerForRobotEngine(File robocodeHome, IBattleListener listener) {
    
    try {
      initContainerRe.invoke(null, new Object[] { robocodeHome, listener });
    } catch (IllegalAccessException e) {
      Logger.logError(e);
    } catch (InvocationTargetException e) {
      Logger.logError(e.getCause());
      Logger.logError(e);
    }
  }
  
  public static void initContainer() {
    
    try {
      initContainer.invoke(null, new Object[0]);
    } catch (IllegalAccessException e) {
      Logger.logError(e);
    } catch (InvocationTargetException e) {
      Logger.logError(e.getCause());
      Logger.logError(e);
    }
  }
  
  public static void cleanup() {
    
    try {
      cleanup.invoke(null, new Object[0]);
    } catch (IllegalAccessException e) {
      Logger.logError(e);
    } catch (InvocationTargetException e) {
      Logger.logError(e.getCause());
      Logger.logError(e);
    }
  }
  
  public static void robocodeMain(String[] args) {
    
    try {
      robocodeMain.invoke(null, new Object[] { args });
    } catch (IllegalAccessException e) {
      Logger.logError(e);
    } catch (InvocationTargetException e) {
      Logger.logError(e.getCause());
      Logger.logError(e);
    }
  }
}
