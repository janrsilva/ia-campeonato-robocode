package robocode.robotinterfaces;

import robocode.CustomEvent;
import robocode.SkippedTurnEvent;

public abstract interface IAdvancedEvents
{
  public abstract void onSkippedTurn(SkippedTurnEvent paramSkippedTurnEvent);
  
  public abstract void onCustomEvent(CustomEvent paramCustomEvent);
}
