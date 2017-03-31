package stark;

import java.awt.Color;

import robocode.HitByBulletEvent;
import robocode.HitRobotEvent;
import robocode.Robot;
import robocode.ScannedRobotEvent;

public class Mark42 extends Robot {

	double oldAngle = 360;
	int count = 0;

	@Override
	public void run() {
		setBodyColor(Color.red);
		setGunColor(Color.yellow);
		setRadarColor(Color.white);
		setScanColor(Color.yellow);
		setBulletColor(Color.yellow);

		while (true) {
			turnRadarLeft(360);
			// this.scan();
		}
	}

	@Override
	public void onScannedRobot(ScannedRobotEvent event) {
		// turnGunRight(normalizaAngulo(event.getBearing() + getHeading() -
		// getGunHeading()));
		turnGunRight(normalizaAngulo(getHeading() - getGunHeading()));
		turnRight(normalizaAngulo(event.getBearing()));

		if (event.getVelocity() == 0 || count + 1 % 2 == 1 || oldAngle == 360) {
			double margemA = oldAngle - 3;
			double anguloAtual = event.getBearing() < 0 ? event.getBearing() * -1 : event.getBearing();
			double margemB = oldAngle + 3;
			System.out.println("============>");
			System.out.println(count);
			System.out.println("============>");
			System.out.println(margemA);
			System.out.println(anguloAtual);
			System.out.println(margemB);
			if (margemA <= anguloAtual && margemB >= anguloAtual) {
				if (event.getDistance() < 50) {
					fire(3, event.getEnergy());
				} else if (event.getDistance() < 100) {
					fire(2.49, event.getEnergy());
				} else {
					fire(2, event.getEnergy());
				}
				ahead(event.getDistance());
			}
		}

		if (count++ % 2 == 0 && oldAngle <= 360) {
			oldAngle = event.getBearing() < 0 ? event.getBearing() * -1 : event.getBearing();
		}
	}

	@Override
	public void ahead(double distance) {
		super.ahead(distance / 10);
	}

	/**
	 * Normaliza o angulo de giro para não ser necessário fazer uma volta
	 * completa, ou seja, atinge o angulo desejado virando para o lado mais
	 * curto para atingi-lo
	 * 
	 * @param angle
	 * @return
	 */
	public double normalizaAngulo(double angle) {
		while (angle > 180) {
			angle -= 360;
		}
		while (angle < -180) {
			angle += 360;
		}
		return angle;
	}

	@Override
	public void onHitRobot(HitRobotEvent event) {
		turnGunRight(normalizaAngulo(getHeading() - getGunHeading()));
		turnRight(normalizaAngulo(event.getBearing()));
		fire(3, event.getEnergy());
	}

	public void fire(double power, double energy) {
		if (energy < 12) {
			super.fire((energy / 4) + .1);
		} else {
			super.fire(power);
		}
	}

	@Override
	public void onHitByBullet(HitByBulletEvent event) {
		turnRight(normalizaAngulo(event.getBearing()));
		event.getTime();
		// se faz x segundos e o robo não estava parado, não ativa de volta.
		fire(3);
		super.ahead(50);
	}

}
