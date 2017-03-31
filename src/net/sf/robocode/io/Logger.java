package net.sf.robocode.io;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import net.sf.robocode.security.HiddenAccess;
import net.sf.robocode.util.StringUtil;
import robocode.control.events.BattleErrorEvent;
import robocode.control.events.BattleMessageEvent;
import robocode.control.events.IBattleListener;














public class Logger
{
  public Logger() {}
  
  public static final PrintStream realOut = System.out;
  public static final PrintStream realErr = System.err;
  
  private static IBattleListener logListener;
  
  private static final StringBuffer logBuffer = new StringBuffer();
  
  public static void setLogListener(IBattleListener logListener) {
    logListener = logListener;
  }
  
  public static void logMessage(String s) {
    logMessage(s, true);
  }
  
  public static void logMessage(String s, boolean newline) {
    if (logListener == null) {
      if (System.getProperty("logMessages", "true").equalsIgnoreCase("true")) {
        s = StringUtil.toBasicLatin(s);
        if (newline) {
          realOut.println(s);
        } else {
          realOut.print(s);
          realOut.flush();
        }
      }
    } else {
      synchronized (logBuffer) {
        if (!HiddenAccess.isSafeThread())
        {
          logBuffer.append(s);
          logBuffer.append("\n");
        } else if (newline) {
          logListener.onBattleMessage(new BattleMessageEvent(logBuffer + s));
          logBuffer.setLength(0);
        } else {
          logBuffer.append(s);
        }
      }
    }
  }
  
  public static void logWarning(String s) {
    logMessage("Warning: " + s, true);
  }
  
  public static void logError(String message, Throwable t) {
    logError(message + ":\n" + toStackTraceString(t));
  }
  
  public static void logError(Throwable t) {
    logError(toStackTraceString(t));
  }
  
  public static void logError(String s) {
    if (logListener == null) {
      if (System.getProperty("logErrors", "true").equalsIgnoreCase("true")) {
        s = StringUtil.toBasicLatin(s);
        realErr.println(s);
      }
    } else {
      logListener.onBattleError(new BattleErrorEvent(s));
    }
  }
  
  private static String toStackTraceString(Throwable t) {
    if (t == null) {
      return "";
    }
    ByteArrayOutputStream baos = new ByteArrayOutputStream();
    PrintStream ps = new PrintStream(baos);
    
    t.printStackTrace(ps);
    ps.close();
    return baos.toString();
  }
  
  public static void printlnToRobotsConsole(String s)
  {
    System.out.println(s);
  }
}
