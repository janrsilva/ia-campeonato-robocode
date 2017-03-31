package net.sf.robocode.security;

import java.awt.Component;










public class SafeComponent
  extends Component
{
  private static Component safeEventComponent;
  
  public SafeComponent() {}
  
  public static Component getSafeEventComponent()
  {
    if (safeEventComponent == null) {
      safeEventComponent = new SafeComponent();
    }
    return safeEventComponent;
  }
}
