package robocode.control.snapshot;

public abstract interface ITurnSnapshot
{
  public abstract IRobotSnapshot[] getRobots();
  
  public abstract IBulletSnapshot[] getBullets();
  
  public abstract int getTPS();
  
  public abstract int getRound();
  
  public abstract int getTurn();
  
  public abstract IScoreSnapshot[] getSortedTeamScores();
  
  public abstract IScoreSnapshot[] getIndexedTeamScores();
}
