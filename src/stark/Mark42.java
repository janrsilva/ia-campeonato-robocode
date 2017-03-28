package stark;

import java.awt.Color;

import robocode.Robot;

public class Mark42 extends Robot {

	@Override
	public void run() {
		setBodyColor(Color.red);
		setGunColor(Color.yellow);
		setRadarColor(Color.white);
		setScanColor(Color.yellow);
		setBulletColor(Color.yellow);

		while (true) {
			turnRadarLeft(360);
		}
	}
}
