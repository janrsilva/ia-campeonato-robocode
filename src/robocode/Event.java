package robocode;

import java.awt.Graphics2D;
import java.io.Serializable;
import net.sf.robocode.io.Logger;
import net.sf.robocode.peer.IRobotStatics;
import net.sf.robocode.security.IHiddenEventHelper;
import robocode.robotinterfaces.IBasicRobot;

public abstract class Event implements Comparable<Event>, Serializable {
	private static final long serialVersionUID = 1L;
	private static final int DEFAULT_PRIORITY = 80;
	private long time;
	private int priority;
	private transient boolean addedToQueue;

	public Event() {
	}

	public int compareTo(Event event) {
		int timeDiff = (int) (time - time);

		if (timeDiff != 0) {
			return timeDiff;
		}

		int priorityDiff = event.getPriority() - getPriority();

		if (priorityDiff != 0) {
			return priorityDiff;
		}

		return 0;
	}

	public long getTime() {
		return time;
	}

	public void setTime(long newTime) {
		if (addedToQueue) {
			Logger.printlnToRobotsConsole(
					"SYSTEM: The time of an event cannot be changed after it has been added the event queue.");
		} else {
			time = newTime;
		}
	}

	public int getPriority() {
		return priority;
	}

	public final void setPriority(int newPriority) {
		if (addedToQueue) {
			Logger.printlnToRobotsConsole(
					"SYSTEM: The priority of an event cannot be changed after it has been added the event queue.");
		} else {
			setPriorityHidden(newPriority);
		}
	}

	private void setTimeHidden(long time) {
		if (this.time < time) {
			this.time = time;
		}

		addedToQueue = true;
	}

	private void setPriorityHidden(int newPriority) {
		if (newPriority < 0) {
			Logger.printlnToRobotsConsole("SYSTEM: Priority must be between 0 and 99");
			Logger.printlnToRobotsConsole("SYSTEM: Priority for " + getClass().getName() + " will be 0");
			newPriority = 0;
		} else if (newPriority > 99) {
			Logger.printlnToRobotsConsole("SYSTEM: Priority must be between 0 and 99");
			Logger.printlnToRobotsConsole("SYSTEM: Priority for " + getClass().getName() + " will be 99");
			newPriority = 99;
		}
		priority = newPriority;
	}

	void dispatch(IBasicRobot robot, IRobotStatics statics, Graphics2D graphics) {
	}

	int getDefaultPriority() {
		return 80;
	}

	boolean isCriticalEvent() {
		return false;
	}

	byte getSerializationType() {
		throw new Error("Serialization not supported on this event type");
	}

	static IHiddenEventHelper createHiddenHelper() {
		return new HiddenEventHelper(null);
	}

	private static class HiddenEventHelper implements IHiddenEventHelper {
		private HiddenEventHelper() {
		}

		public void setTime(Event event, long newTime) {
			event.setTimeHidden(newTime);
		}

		public void setDefaultPriority(Event event) {
			event.setPriority(event.getDefaultPriority());
		}

		public void setPriority(Event event, int newPriority) {
			event.setPriorityHidden(newPriority);
		}

		public boolean isCriticalEvent(Event event) {
			return event.isCriticalEvent();
		}

		public void dispatch(Event event, IBasicRobot robot, IRobotStatics statics, Graphics2D graphics) {
			event.dispatch(robot, statics, graphics);
		}

		public byte getSerializationType(Event event) {
			return event.getSerializationType();
		}
	}
}
