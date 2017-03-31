package net.sf.robocode.api;

import java.util.List;
import net.sf.robocode.core.IModule;
import net.sf.robocode.serialization.RbSerializer;
import robocode.BattleResults;
import robocode.Bullet;
import robocode.BulletMissedEvent;
import robocode.HitRobotEvent;
import robocode.HitWallEvent;
import robocode.KeyReleasedEvent;
import robocode.MouseEnteredEvent;
import robocode.MouseReleasedEvent;
import robocode.RobotDeathEvent;
import robocode.ScannedRobotEvent;

public class Module implements IModule
{
  public Module() {}
  
  public void afterLoaded(List<IModule> allModules)
  {
    RbSerializer.register(robocode.RobotStatus.class, (byte)6);
    RbSerializer.register(BattleResults.class, (byte)8);
    RbSerializer.register(Bullet.class, (byte)9);
    

    RbSerializer.register(robocode.RoundEndedEvent.class, (byte)55);
    RbSerializer.register(robocode.BattleEndedEvent.class, (byte)32);
    RbSerializer.register(robocode.BulletHitBulletEvent.class, (byte)33);
    RbSerializer.register(robocode.BulletHitEvent.class, (byte)34);
    RbSerializer.register(BulletMissedEvent.class, (byte)35);
    RbSerializer.register(robocode.DeathEvent.class, (byte)36);
    
    RbSerializer.register(robocode.WinEvent.class, (byte)37);
    RbSerializer.register(HitWallEvent.class, (byte)38);
    RbSerializer.register(RobotDeathEvent.class, (byte)39);
    RbSerializer.register(robocode.SkippedTurnEvent.class, (byte)40);
    RbSerializer.register(ScannedRobotEvent.class, (byte)41);
    RbSerializer.register(robocode.HitByBulletEvent.class, (byte)42);
    RbSerializer.register(HitRobotEvent.class, (byte)43);
    RbSerializer.register(robocode.KeyPressedEvent.class, (byte)44);
    RbSerializer.register(KeyReleasedEvent.class, (byte)45);
    RbSerializer.register(robocode.KeyTypedEvent.class, (byte)46);
    RbSerializer.register(robocode.MouseClickedEvent.class, (byte)47);
    RbSerializer.register(robocode.MouseDraggedEvent.class, (byte)48);
    RbSerializer.register(MouseEnteredEvent.class, (byte)49);
    RbSerializer.register(robocode.MouseExitedEvent.class, (byte)50);
    RbSerializer.register(robocode.MouseMovedEvent.class, (byte)51);
    RbSerializer.register(robocode.MousePressedEvent.class, (byte)52);
    RbSerializer.register(MouseReleasedEvent.class, (byte)53);
    RbSerializer.register(robocode.MouseWheelMovedEvent.class, (byte)54);
  }
}
