//**********************************************************************
//Class Name: Asteroid.java
//
//Author: Chisheng Li
//
//Description of the class: This class sets the initial x and y position of 
//the asteroid, moves the asteroid towards the left and updates its position.
//The class also draws the asteroid.
//
//Supplementary files: SpaceShipGame.java and SpaceShip.java
//**********************************************************************

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.Random;

public class Asteroid {
	private int xPos;
	private int yPos;
	private static int height = 30;		//height of the asteroid
	private static int width = 35;		//width of the asteroid
	
	public Asteroid(int x, int y)
	{
		Random r = new Random();
		xPos = 800 + r.nextInt(50);		//initial x position of the asteroid
		yPos = 50 + r.nextInt(700);		//initial y position of the asteroid
	}
	
	public void move() {
		xPos = xPos - 15;				//move the asteroid to the left by 15
	}
	
	public void draw(Graphics g) {
		g.setColor(Color.gray);
		g.fillOval(xPos, yPos, width, height);	//draws the asteroid as a gray oval	
	}
	
	public Point getPosition() {
		return new Point(xPos, yPos);		//returns the position of the asteroid
	}
}
