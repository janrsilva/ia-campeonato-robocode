package net.sf.robocode.io;















public final class RobocodeProperties
{
  private static final boolean NO_SECURITY = System.getProperty("NOSECURITY", "false").equals("true");
  private static final boolean DEBUG = System.getProperty("debug", "false").equals("true");
  


  private RobocodeProperties() {}
  

  public static boolean isSecurityOff()
  {
    return NO_SECURITY;
  }
  



  public static boolean isSecurityOn()
  {
    return !NO_SECURITY;
  }
  



  public static boolean isDebuggingOff()
  {
    return !DEBUG;
  }
  



  public static boolean isDebuggingOn()
  {
    return DEBUG;
  }
  



  public static void setTesting(boolean enabled)
  {
    System.setProperty("TESTING", "" + enabled);
  }
  



  public static boolean isTestingOff()
  {
    return !isTestingOn();
  }
  



  public static boolean isTestingOn()
  {
    return System.getProperty("TESTING", "false").equals("true");
  }
}
