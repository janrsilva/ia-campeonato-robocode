package robocode;

import java.io.File;
import java.util.Vector;
import robocode.robotinterfaces.IAdvancedEvents;
import robocode.robotinterfaces.IAdvancedRobot;
import robocode.robotinterfaces.peer.IAdvancedRobotPeer;
import robocode.robotinterfaces.peer.IBasicRobotPeer;

public class AdvancedRobot extends _AdvancedRadiansRobot implements IAdvancedRobot, IAdvancedEvents {
	public AdvancedRobot() {
	}

	public double getDistanceRemaining() {
		if (peer != null) {
			return peer.getDistanceRemaining();
		}
		uninitializedException();
		return 0.0D;
	}

	public double getTurnRemaining() {
		if (peer != null) {
			return Math.toDegrees(peer.getBodyTurnRemaining());
		}
		uninitializedException();
		return 0.0D;
	}

	public double getGunTurnRemaining() {
		if (peer != null) {
			return Math.toDegrees(peer.getGunTurnRemaining());
		}
		uninitializedException();
		return 0.0D;
	}

	public double getRadarTurnRemaining() {
		if (peer != null) {
			return Math.toDegrees(peer.getRadarTurnRemaining());
		}
		uninitializedException();
		return 0.0D;
	}

	public void setAhead(double distance) {
		if (peer != null) {
			((IAdvancedRobotPeer) peer).setMove(distance);
		} else {
			uninitializedException();
		}
	}

	public void setBack(double distance) {
		if (peer != null) {
			((IAdvancedRobotPeer) peer).setMove(-distance);
		} else {
			uninitializedException();
		}
	}

	public void setTurnLeft(double degrees) {
		if (peer != null) {
			((IAdvancedRobotPeer) peer).setTurnBody(-Math.toRadians(degrees));
		} else {
			uninitializedException();
		}
	}

	public void setTurnRight(double degrees) {
		if (peer != null) {
			((IAdvancedRobotPeer) peer).setTurnBody(Math.toRadians(degrees));
		} else {
			uninitializedException();
		}
	}

	public void setFire(double power) {
		if (peer != null) {
			peer.setFire(power);
		} else {
			uninitializedException();
		}
	}

	public Bullet setFireBullet(double power) {
		if (peer != null) {
			return peer.setFire(power);
		}
		uninitializedException();
		return null;
	}

	public void addCustomEvent(Condition condition) {
		if (condition == null) {
			throw new NullPointerException("the condition cannot be null");
		}
		if (peer != null) {
			((IAdvancedRobotPeer) peer).addCustomEvent(condition);
		} else {
			uninitializedException();
		}
	}

	public void removeCustomEvent(Condition condition) {
		if (condition == null) {
			throw new NullPointerException("the condition cannot be null");
		}
		if (peer != null) {
			((IAdvancedRobotPeer) peer).removeCustomEvent(condition);
		} else {
			uninitializedException();
		}
	}

	public void clearAllEvents() {
		if (peer != null) {
			((IAdvancedRobotPeer) peer).clearAllEvents();
		} else {
			uninitializedException();
		}
	}

	public void execute() {
		if (peer != null) {
			peer.execute();
		} else {
			uninitializedException();
		}
	}

	public Vector<Event> getAllEvents() {
		if (peer != null) {
			return new Vector(((IAdvancedRobotPeer) peer).getAllEvents());
		}
		uninitializedException();
		return null;
	}

	public Vector<BulletHitBulletEvent> getBulletHitBulletEvents() {
		if (peer != null) {
			return new Vector(((IAdvancedRobotPeer) peer).getBulletHitBulletEvents());
		}
		uninitializedException();
		return null;
	}

	public Vector<BulletHitEvent> getBulletHitEvents() {
		if (peer != null) {
			return new Vector(((IAdvancedRobotPeer) peer).getBulletHitEvents());
		}
		uninitializedException();
		return null;
	}

	public Vector<BulletMissedEvent> getBulletMissedEvents() {
		if (peer != null) {
			return new Vector(((IAdvancedRobotPeer) peer).getBulletMissedEvents());
		}
		uninitializedException();
		return null;
	}

	public File getDataDirectory() {
		if (peer != null) {
			return ((IAdvancedRobotPeer) peer).getDataDirectory();
		}
		uninitializedException();
		return null;
	}

	public File getDataFile(String filename) {
		if (peer != null) {
			return ((IAdvancedRobotPeer) peer).getDataFile(filename);
		}
		uninitializedException();
		return null;
	}

	public long getDataQuotaAvailable() {
		if (peer != null) {
			return ((IAdvancedRobotPeer) peer).getDataQuotaAvailable();
		}
		uninitializedException();
		return 0L;
	}

	public int getEventPriority(String eventClass) {
		if (peer != null) {
			return ((IAdvancedRobotPeer) peer).getEventPriority(eventClass);
		}
		uninitializedException();
		return 0;
	}

	public Vector<HitByBulletEvent> getHitByBulletEvents() {
		if (peer != null) {
			return new Vector(((IAdvancedRobotPeer) peer).getHitByBulletEvents());
		}
		uninitializedException();
		return null;
	}

	public Vector<HitRobotEvent> getHitRobotEvents() {
		if (peer != null) {
			return new Vector(((IAdvancedRobotPeer) peer).getHitRobotEvents());
		}
		uninitializedException();
		return null;
	}

	public Vector<HitWallEvent> getHitWallEvents() {
		if (peer != null) {
			return new Vector(((IAdvancedRobotPeer) peer).getHitWallEvents());
		}
		uninitializedException();
		return null;
	}

	public Vector<RobotDeathEvent> getRobotDeathEvents() {
		if (peer != null) {
			return new Vector(((IAdvancedRobotPeer) peer).getRobotDeathEvents());
		}
		uninitializedException();
		return null;
	}

	public Vector<ScannedRobotEvent> getScannedRobotEvents() {
		if (peer != null) {
			return new Vector(((IAdvancedRobotPeer) peer).getScannedRobotEvents());
		}
		uninitializedException();
		return null;
	}

	public Vector<StatusEvent> getStatusEvents() {
		if (peer != null) {
			return new Vector(((IAdvancedRobotPeer) peer).getStatusEvents());
		}
		uninitializedException();
		return null;
	}

	public boolean isAdjustGunForRobotTurn() {
		if (peer != null) {
			return ((IAdvancedRobotPeer) peer).isAdjustGunForBodyTurn();
		}
		uninitializedException();
		return false;
	}

	public boolean isAdjustRadarForRobotTurn() {
		if (peer != null) {
			return ((IAdvancedRobotPeer) peer).isAdjustRadarForBodyTurn();
		}
		uninitializedException();
		return false;
	}

	public boolean isAdjustRadarForGunTurn() {
		if (peer != null) {
			return ((IAdvancedRobotPeer) peer).isAdjustRadarForGunTurn();
		}
		uninitializedException();
		return false;
	}

	public void onCustomEvent(CustomEvent event) {
	}

	public void setEventPriority(String eventClass, int priority) {
		if (peer != null) {
			((IAdvancedRobotPeer) peer).setEventPriority(eventClass, priority);
		} else {
			uninitializedException();
		}
	}

	public void setInterruptible(boolean interruptible) {
		if (peer != null) {
			((IAdvancedRobotPeer) peer).setInterruptible(interruptible);
		} else {
			uninitializedException();
		}
	}

	public void setMaxTurnRate(double newMaxTurnRate) {
		if (peer != null) {
			((IAdvancedRobotPeer) peer).setMaxTurnRate(Math.toRadians(newMaxTurnRate));
		} else {
			uninitializedException();
		}
	}

	public void setMaxVelocity(double newMaxVelocity) {
		if (peer != null) {
			((IAdvancedRobotPeer) peer).setMaxVelocity(newMaxVelocity);
		} else {
			uninitializedException();
		}
	}

	public void setResume() {
		if (peer != null) {
			((IAdvancedRobotPeer) peer).setResume();
		} else {
			uninitializedException();
		}
	}

	public void setStop() {
		setStop(false);
	}

	public void setStop(boolean overwrite) {
		if (peer != null) {
			((IAdvancedRobotPeer) peer).setStop(overwrite);
		} else {
			uninitializedException();
		}
	}

	public void setTurnGunLeft(double degrees) {
		if (peer != null) {
			((IAdvancedRobotPeer) peer).setTurnGun(-Math.toRadians(degrees));
		} else {
			uninitializedException();
		}
	}

	public void setTurnGunRight(double degrees) {
		if (peer != null) {
			((IAdvancedRobotPeer) peer).setTurnGun(Math.toRadians(degrees));
		} else {
			uninitializedException();
		}
	}

	public void setTurnRadarLeft(double degrees) {
		if (peer != null) {
			((IAdvancedRobotPeer) peer).setTurnRadar(-Math.toRadians(degrees));
		} else {
			uninitializedException();
		}
	}

	public void setTurnRadarRight(double degrees) {
		if (peer != null) {
			((IAdvancedRobotPeer) peer).setTurnRadar(Math.toRadians(degrees));
		} else {
			uninitializedException();
		}
	}

	public void waitFor(Condition condition) {
		if (peer != null) {
			((IAdvancedRobotPeer) peer).waitFor(condition);
		} else {
			uninitializedException();
		}
	}

	public void onDeath(DeathEvent event) {
	}

	public void onSkippedTurn(SkippedTurnEvent event) {
	}

	public double getHeadingRadians() {
		return super.getHeadingRadians();
	}

	public void setTurnLeftRadians(double radians) {
		super.setTurnLeftRadians(radians);
	}

	public void setTurnRightRadians(double radians) {
		super.setTurnRightRadians(radians);
	}

	public void turnLeftRadians(double radians) {
		super.turnLeftRadians(radians);
	}

	public void turnRightRadians(double radians) {
		super.turnRightRadians(radians);
	}

	public double getGunHeadingRadians() {
		return super.getGunHeadingRadians();
	}

	public double getRadarHeadingRadians() {
		return super.getRadarHeadingRadians();
	}

	public void setTurnGunLeftRadians(double radians) {
		super.setTurnGunLeftRadians(radians);
	}

	public void setTurnGunRightRadians(double radians) {
		super.setTurnGunRightRadians(radians);
	}

	public void setTurnRadarLeftRadians(double radians) {
		super.setTurnRadarLeftRadians(radians);
	}

	public void setTurnRadarRightRadians(double radians) {
		super.setTurnRadarRightRadians(radians);
	}

	public void turnGunLeftRadians(double radians) {
		super.turnGunLeftRadians(radians);
	}

	public void turnGunRightRadians(double radians) {
		super.turnGunRightRadians(radians);
	}

	public void turnRadarLeftRadians(double radians) {
		super.turnRadarLeftRadians(radians);
	}

	public void turnRadarRightRadians(double radians) {
		super.turnRadarRightRadians(radians);
	}

	public double getGunTurnRemainingRadians() {
		return super.getGunTurnRemainingRadians();
	}

	public double getRadarTurnRemainingRadians() {
		return super.getRadarTurnRemainingRadians();
	}

	public double getTurnRemainingRadians() {
		return super.getTurnRemainingRadians();
	}

	public final IAdvancedEvents getAdvancedEventListener() {
		return this;
	}
}
