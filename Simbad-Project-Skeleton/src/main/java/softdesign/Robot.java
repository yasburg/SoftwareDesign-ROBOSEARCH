package main.java.softdesign;


import javax.vecmath.Vector3d;
import simbad.sim.Agent;
import simbad.sim.CameraSensor;
import simbad.sim.RangeSensorBelt;
import simbad.sim.RobotFactory;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

public class Robot extends Agent {
	
	RangeSensorBelt sonar;
	RangeSensorBelt bumper;
	CameraSensor camera;

	public Robot(Vector3d position, String name) {
        super(position, name);
		// TODO Auto-generated constructor stub
        // Add sonar sensor
        sonar = RobotFactory.addSonarBeltSensor(this, 4);
        // Add bumper sensor
        bumper = RobotFactory.addBumperBeltSensor(this, 8);
        // Add camera sensor
        camera = RobotFactory.addCameraSensor(this);
	}
	
	private void distance() {
		// Get distance from sonar in every 20 frames
		if(getCounter() % 20 == 0) {
			for(int i = 0; i < sonar.getNumSensors(); i++) {
				double range = sonar.getMeasurement(i);
			}
		}
	}
	
	private void hit() {
		// detects hit from bumper in every 20 frames
		if(getCounter() % 20 == 0) {
			for(int i = 0; i < bumper.getNumSensors(); i++) {
				//double range = bumper.getMeasurement(i);
				boolean hit = bumper.hasHit(i);
			}
		}
	}
	private void bumperhit() {
		// detects hit from bumper in every 20 frames
		if(getCounter() % 20 == 0) {
			for(int i = 0; i < bumper.getNumSensors(); i++) {
				//double range = bumper.getMeasurement(i);
				boolean hit = bumper.hasHit(i);
				if(hit == true) {
					hit();
					//stays and rotates until it gets a way out!
					//this.setTranslationalVelocity(0);
					int randomNum = ThreadLocalRandom.current().nextInt(0, 1 + 1);
					if(randomNum % 2 == 0) {
						this.rotateY(5*Math.random());//Math.random()
					}
					else {
						this.rotateY(5*-Math.random());//Math.random()
					}
					//this.setRotationalVelocity(Math.PI /2);
					break;
					
				}
				else if(this.collisionDetected()) {//This is false even there is wall in front of the rover!!
					hit();
					//stays and rotates until it gets a way out!
					//this.setTranslationalVelocity(0);
					int randomNum = ThreadLocalRandom.current().nextInt(0, 1 + 1);
					if(randomNum % 2 == 0) {
						this.rotateY(5*Math.random());//Math.random()
					}
					else {
						this.rotateY(5*-Math.random());//Math.random()
					}
					//this.setRotationalVelocity(Math.PI /2);
					break;
				}
				else {
					//System.out.println("No Obstacles");
					//move the robots
					move();
				}
			}
		}
	}
	private void move() {
		// set speed 0.5 m/s
		this.setTranslationalVelocity(0.5);
		this.setRotationalVelocity(0);
		// change the orientation
		/*
		if(getCounter() % 10 == 0) {
			this.setRotationalVelocity(Math.PI /2 * (0.5 - Math.random()));
		}
		*/
	}

	@Override
	protected void initBehavior() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void performBehavior() {
		if (getCounter () % 60 == 0)
		{
			System.out.println("hi");
		}
		// TODO Auto-generated method stub
		distance();
		if(this.getVeryNearAgent() != null) {
			hit();
			//stays and rotates until it gets a way out!
			this.setTranslationalVelocity(0);
			this.rotateY(Math.random());//Math.random()
			this.setRotationalVelocity(Math.PI /2);
		}
		
		bumperhit();
	}

}
