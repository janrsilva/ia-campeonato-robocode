package robocode;

import java.io.PrintStream;
import robocode.exception.RobotException;
import robocode.robotinterfaces.IBasicRobot;
import robocode.robotinterfaces.peer.IBasicRobotPeer;

public abstract class _RobotBase implements IBasicRobot, Runnable {
	IBasicRobotPeer peer;
	public PrintStream out;

	_RobotBase() {
	}

	protected final void finalize() throws Throwable {
		super.finalize();
	}

	public final void setOut(PrintStream out) {
		this.out = out;
	}

	public final void setPeer(IBasicRobotPeer peer) {
		this.peer = peer;
	}

	static void uninitializedException() {
		StackTraceElement[] trace = Thread.currentThread().getStackTrace();
		String methodName = trace[2].getMethodName();

		throw new RobotException("You cannot call the " + methodName
				+ "() method before your run() method is called, or you are using a Robot object that the game doesn't know about.");
	}
}
