package robocode.control.events;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import robocode.BattleResults;
import robocode.BattleRules;































public class BattleCompletedEvent
  extends BattleEvent
{
  private final BattleRules battleRules;
  private final BattleResults[] results;
  
  public BattleCompletedEvent(BattleRules battleRules, BattleResults[] results)
  {
    this.battleRules = battleRules;
    this.results = results;
  }
  




  public BattleRules getBattleRules()
  {
    return battleRules;
  }
  






  public BattleResults[] getSortedResults()
  {
    List<BattleResults> copy = new ArrayList(Arrays.asList(results));
    
    Collections.sort(copy);
    Collections.reverse(copy);
    return (BattleResults[])copy.toArray(new BattleResults[copy.size()]);
  }
  






  public BattleResults[] getIndexedResults()
  {
    BattleResults[] copy = new BattleResults[results.length];
    
    System.arraycopy(results, 0, copy, 0, results.length);
    return copy;
  }
}
