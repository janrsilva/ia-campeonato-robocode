package robocode.control;

import java.io.File;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import net.sf.robocode.battle.IBattleManagerBase;
import net.sf.robocode.core.ContainerBase;
import net.sf.robocode.gui.IWindowManagerBase;
import net.sf.robocode.io.FileUtil;
import net.sf.robocode.io.Logger;
import net.sf.robocode.manager.IVersionManagerBase;
import net.sf.robocode.repository.IRepositoryManagerBase;
import net.sf.robocode.security.HiddenAccess;
import robocode.control.events.BattleAdaptor;
import robocode.control.events.BattleCompletedEvent;
import robocode.control.events.BattleFinishedEvent;
import robocode.control.events.BattleMessageEvent;
import robocode.control.events.IBattleListener;























public class RobocodeEngine
  implements IRobocodeEngine
{
  private BattleObserver battleObserver;
  private BattleSpecification battleSpecification;
  private List<IBattleListener> listeners = new ArrayList();
  








  public RobocodeEngine()
  {
    init(null, (IBattleListener)null);
  }
  







  public RobocodeEngine(File robocodeHome)
  {
    init(robocodeHome, (IBattleListener)null);
  }
  












  @Deprecated
  public RobocodeEngine(File robocodeHome, RobocodeListener listener)
  {
    init(robocodeHome, listener);
  }
  












  @Deprecated
  public RobocodeEngine(RobocodeListener listener)
  {
    init(null, listener);
  }
  
  public RobocodeEngine(IBattleListener listener) {
    init(null, listener);
  }
  


  protected void finalize()
    throws Throwable
  {
    try
    {
      close();
    } finally {
      super.finalize();
    }
  }
  
  private void init(File robocodeHome, RobocodeListener listener)
  {
    if (listener != null) {
      battleObserver = new BattleObserver(null);
      battleObserver.listener = listener;
    }
    HiddenAccess.initContainerForRobotEngine(robocodeHome, battleObserver);
  }
  
  private void init(File robocodeHome, IBattleListener listener) {
    HiddenAccess.initContainerForRobotEngine(robocodeHome, listener);
  }
  


  public void addBattleListener(IBattleListener listener)
  {
    listeners.add(listener);
    ((IBattleManagerBase)ContainerBase.getComponent(IBattleManagerBase.class)).addListener(listener);
  }
  


  public void removeBattleListener(IBattleListener listener)
  {
    listeners.remove(listener);
    ((IBattleManagerBase)ContainerBase.getComponent(IBattleManagerBase.class)).removeListener(listener);
  }
  


  public void close()
  {
    setVisible(false);
    if (battleObserver != null) {
      ((IBattleManagerBase)ContainerBase.getComponent(IBattleManagerBase.class)).removeListener(battleObserver);
    }
    for (IBattleListener listener : listeners) {
      ((IBattleManagerBase)ContainerBase.getComponent(IBattleManagerBase.class)).removeListener(listener);
    }
    listeners.clear();
    HiddenAccess.cleanup();
  }
  


  public String getVersion()
  {
    return ((IVersionManagerBase)ContainerBase.getComponent(IVersionManagerBase.class)).getVersion();
  }
  






  public static File getCurrentWorkingDir()
  {
    return FileUtil.getCwd();
  }
  






  public static File getRobotsDir()
  {
    return FileUtil.getRobotsDir();
  }
  


  public void setVisible(boolean visible)
  {
    IWindowManagerBase windowManager = (IWindowManagerBase)ContainerBase.getComponent(IWindowManagerBase.class);
    if (windowManager != null) {
      windowManager.setVisibleForRobotEngine(visible);
    } else {
      Logger.logError("setVisible: No window manager was found.\nPerhaps you are missing the robocode.ui-1.x.x.x-jar file or the GUI has been disabled?");
    }
  }
  




  public RobotSpecification[] getLocalRepository()
  {
    IRepositoryManagerBase repository = (IRepositoryManagerBase)ContainerBase.getComponent(IRepositoryManagerBase.class);
    
    repository.refresh();
    return repository.getSpecifications();
  }
  


  public RobotSpecification[] getLocalRepository(String selectedRobots)
  {
    IRepositoryManagerBase repository = (IRepositoryManagerBase)ContainerBase.getComponent(IRepositoryManagerBase.class);
    
    repository.refresh();
    return repository.loadSelectedRobots(selectedRobots);
  }
  


  public void runBattle(BattleSpecification battleSpecification)
  {
    runBattle(battleSpecification, null, false);
  }
  


  public void runBattle(BattleSpecification battleSpecification, boolean waitTillOver)
  {
    runBattle(battleSpecification, null, waitTillOver);
  }
  


  public void runBattle(BattleSpecification battleSpecification, String initialPositions, boolean waitTillOver)
  {
    this.battleSpecification = battleSpecification;
    ((IBattleManagerBase)ContainerBase.getComponent(IBattleManagerBase.class)).startNewBattle(battleSpecification, initialPositions, waitTillOver, false);
  }
  



  public void waitTillBattleOver()
  {
    ((IBattleManagerBase)ContainerBase.getComponent(IBattleManagerBase.class)).waitTillOver();
  }
  


  public void abortCurrentBattle()
  {
    ((IBattleManagerBase)ContainerBase.getComponent(IBattleManagerBase.class)).stop(true);
  }
  




  public static void printRunningThreads()
  {
    ThreadGroup currentGroup = Thread.currentThread().getThreadGroup();
    
    if (currentGroup == null) {
      return;
    }
    
    while (currentGroup.getParent() != null) {
      currentGroup = currentGroup.getParent();
    }
    
    ThreadGroup[] groups = new ThreadGroup['Ā'];
    Thread[] threads = new Thread['Ā'];
    
    int numGroups = currentGroup.enumerate(groups, true);
    
    for (int i = 0; i < numGroups; i++) {
      currentGroup = groups[i];
      if (currentGroup.isDaemon()) {
        Logger.realOut.print("  ");
      } else {
        Logger.realOut.print("* ");
      }
      Logger.realOut.println("In group: " + currentGroup.getName());
      int numThreads = currentGroup.enumerate(threads);
      
      for (int j = 0; j < numThreads; j++) {
        if (threads[j].isDaemon()) {
          Logger.realOut.print("  ");
        } else {
          Logger.realOut.print("* ");
        }
        Logger.realOut.println(threads[j].getName());
      }
      Logger.realOut.println("---------------");
    }
  }
  






  public static void setLogMessagesEnabled(boolean enable)
  {
    System.setProperty("logMessages", "" + enable);
  }
  






  public static void setLogErrorsEnabled(boolean enable)
  {
    System.setProperty("logErrors", "" + enable);
  }
  

  private class BattleObserver
    extends BattleAdaptor
  {
    private RobocodeListener listener;
    
    private BattleObserver() {}
    
    public void onBattleFinished(BattleFinishedEvent event)
    {
      if (event.isAborted()) {
        listener.battleAborted(battleSpecification);
      }
    }
    

    public void onBattleCompleted(BattleCompletedEvent event)
    {
      listener.battleComplete(battleSpecification, RobotResults.convertResults(event.getSortedResults()));
    }
    

    public void onBattleMessage(BattleMessageEvent event)
    {
      listener.battleMessage(event.getMessage());
    }
  }
}
