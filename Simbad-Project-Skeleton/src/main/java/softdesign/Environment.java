package main.java.softdesign;

import java.awt.Color;
import javax.vecmath.Color3f;
import javax.vecmath.Vector3d;
import javax.vecmath.Vector3f;
import simbad.sim.Box;
import simbad.sim.EnvironmentDescription;
import simbad.sim.Wall;

public class Environment  extends EnvironmentDescription{
	//Constructor
	public Environment() {
		// turn on the lights
        this.light1IsOn = true;
        this.light2IsOn = true;
        
        // enable the physics engine in order to have better physics effects on the objects
        this.setUsePhysics(true);
        
        // show the axes so that we know where things are
        this.showAxis(true);
        
        // Set the world size
        this.setWorldSize(25);

        Wall w1 = new Wall(new Vector3d(-12.5, 0, 0), 25, 2, this);
        w1.setColor(new Color3f(Color.WHITE));
        w1.rotate90(1);
        add(w1);
        
        Wall w2 = new Wall(new Vector3d(12.5, 0, 0), 25, 2, this);
        w2.setColor(new Color3f(Color.WHITE));
        w2.rotate90(1);
        add(w2);
        
        Wall w3 = new Wall(new Vector3d(0, 0, 12.5), 25, 2, this);
        w3.setColor(new Color3f(Color.WHITE));
        //w1.rotate90(1);
        add(w3);
        
        Wall w4 = new Wall(new Vector3d(0, 0, -12.5), 25, 2, this);
        w4.setColor(new Color3f(Color.WHITE));
        //w4.rotate90(1);
        add(w4);
     
        ///////////////////////MAZE/////////////////////////////
        //								( x  y  z), length, height
        //mw1 stands for maze wall 1 so others are similar
        Wall mw1 = new Wall(new Vector3d(-5, 0, 0), 10, 2, this);
        mw1.setColor(new Color3f(Color.WHITE));
        add(mw1);
        
        Wall mw2 = new Wall(new Vector3d(-5, 0, 10), 10, 2, this);
        mw2.setColor(new Color3f(Color.WHITE));
        add(mw2);
        
        Wall mw3 = new Wall(new Vector3d(-10, 0, 5), 10, 2, this);
        mw3.setColor(new Color3f(Color.WHITE));
        mw3.rotate90(1);//to make it horizontal at the beginning
        add(mw3);
        
        Wall mw4 = new Wall(new Vector3d(0, 0, 3), 6, 2, this);
        mw4.setColor(new Color3f(Color.WHITE));
        mw4.rotate90(1);//to make it horizontal at the beginning
        add(mw4);
        
        Wall mw5 = new Wall(new Vector3d(0, 0, 9), 2, 2, this);
        mw5.setColor(new Color3f(Color.WHITE));
        mw5.rotate90(1);//to make it horizontal at the beginning
        add(mw5);
     
        Wall mw6 = new Wall(new Vector3d(-4, 0, 6), 4, 2, this);
        mw6.setColor(new Color3f(Color.WHITE));
        mw6.rotate90(1);//to make it horizontal at the beginning
        add(mw6);
     
        Wall mw7 = new Wall(new Vector3d(-4, 0, 1), 2, 2, this);
        mw7.setColor(new Color3f(Color.WHITE));
        mw7.rotate90(1);//to make it horizontal at the beginning
        add(mw7);
        
        Wall mw8 = new Wall(new Vector3d(-6, 0, 3), 6, 2, this);
        mw8.setColor(new Color3f(Color.WHITE));
        mw8.rotate90(1);//to make it horizontal at the beginning
        add(mw8);
        
        Wall mw9 = new Wall(new Vector3d(-8, 0, 5), 6, 2, this);
        mw9.setColor(new Color3f(Color.WHITE));
        mw9.rotate90(1);//to make it horizontal at the beginning
        add(mw9); 
        
        Wall mw10 = new Wall(new Vector3d(-2, 0, 7), 2, 2, this);
        mw10.setColor(new Color3f(Color.WHITE));
        mw10.rotate90(1);//to make it horizontal at the beginning
        add(mw10);
        
        Wall mw11 = new Wall(new Vector3d(-1, 0, 2), 2, 2, this);
        mw11.setColor(new Color3f(Color.WHITE));
        add(mw11);
       
        Wall mw12 = new Wall(new Vector3d(-1, 0, 8), 2, 2, this);
        mw12.setColor(new Color3f(Color.WHITE));
        add(mw12);
        
        Wall mw13 = new Wall(new Vector3d(-2, 0, 4), 4, 2, this);
        mw13.setColor(new Color3f(Color.WHITE));
        add(mw13);
        
        Wall mw14 = new Wall(new Vector3d(-7, 0, 8), 2, 2, this);
        mw14.setColor(new Color3f(Color.WHITE));
        add(mw14);
        
        Wall mw15 = new Wall(new Vector3d(-9, 0, 2), 2, 2, this);
        mw15.setColor(new Color3f(Color.WHITE));
        add(mw15);
        
        ////////////////////////////////////////////////////////
        Box b1 = new Box(new Vector3d(-9, 0 , 1), new Vector3f(1, 1, 1), this);
        b1.setColor(new Color3f(Color.RED));
        add(b1);
        
        Box b2 = new Box(new Vector3d(3, 0 , -3), new Vector3f(2, 1, 2), this);
        b2.setColor(new Color3f(Color.GRAY));
        add(b2);
        
        Box b3 = new Box(new Vector3d(3, 0 , 7), new Vector3f(2, 1, 2), this);
        b3.setColor(new Color3f(Color.BLUE));
        add(b3);
        
        Box b4 = new Box(new Vector3d(-5, 0 , -7), new Vector3f(3, 1, 1), this);
        b4.setColor(new Color3f(Color.BLACK));
        add(b4);
        
        Box b5 = new Box(new Vector3d(8, 0 , -7), new Vector3f(2, 1, 5), this);
        b5.setColor(new Color3f(Color.PINK));
        add(b5);
        
        Box b6 = new Box(new Vector3d(8, 0 , 2), new Vector3f(4, 1, 1), this);
        b6.setColor(new Color3f(Color.RED));
        add(b6);
        
        Box b7 = new Box(new Vector3d(8, 0 , 9), new Vector3f(2, 1, 3), this);
        b7.setColor(new Color3f(Color.GREEN));
        add(b7);
        
        Box b8 = new Box(new Vector3d(1, 0 , -7), new Vector3f(1, 1, 2), this);
        b8.setColor(new Color3f(Color.YELLOW));
        add(b8);
        
        Box b9 = new Box(new Vector3d(-9, 0 , -3), new Vector3f(1, 1, 3), this);
        b9.setColor(new Color3f(Color.BLUE));
        add(b9);
        
	}
}
