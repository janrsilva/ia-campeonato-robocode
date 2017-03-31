package robocode.control.events;

public abstract interface IBattleListener
{
  public abstract void onBattleStarted(BattleStartedEvent paramBattleStartedEvent);
  
  public abstract void onBattleFinished(BattleFinishedEvent paramBattleFinishedEvent);
  
  public abstract void onBattleCompleted(BattleCompletedEvent paramBattleCompletedEvent);
  
  public abstract void onBattlePaused(BattlePausedEvent paramBattlePausedEvent);
  
  public abstract void onBattleResumed(BattleResumedEvent paramBattleResumedEvent);
  
  public abstract void onRoundStarted(RoundStartedEvent paramRoundStartedEvent);
  
  public abstract void onRoundEnded(RoundEndedEvent paramRoundEndedEvent);
  
  public abstract void onTurnStarted(TurnStartedEvent paramTurnStartedEvent);
  
  public abstract void onTurnEnded(TurnEndedEvent paramTurnEndedEvent);
  
  public abstract void onBattleMessage(BattleMessageEvent paramBattleMessageEvent);
  
  public abstract void onBattleError(BattleErrorEvent paramBattleErrorEvent);
}
