//**********************************************************************
// Author: Chisheng Li
// Class Name: SpaceShip.java
//
//Description of the class: This class sets the initial x and y position of 
//the spaceship, moves the spaceship and updates its position.
//The class also draws the spaceship and the laser beam.
//
//Supplementary files: SpaceShipGame.java and Asteroid.java
//**********************************************************************

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

public class SpaceShip{
	private int xPos;
	private int yPos;
	private static int height = 50;		//height of the spaceship
	private static int width = 60;		//width of the spaceship
	private boolean shooting;
	
	public SpaceShip()
	{
		xPos = 0;				//initial x position
		yPos = 0;				//initial y position
		shooting = false;
	}
	
	public void move(int x, int y) {
		xPos = x;				//updated x position of the spaceship
		yPos = y;				//updated y position of the spaceship
	}
	
	public void setShooting(boolean value) {
		shooting = value;
	}
	
	public Boolean getShooting() {
		return Boolean.valueOf(shooting);
	}
	
	public Point getPosition() {
		return new Point(xPos, yPos);
	}
	
	public void draw(Graphics g, int laserlength) {
		g.setColor(Color.yellow);
		g.fillOval(xPos, yPos, width, height);		//spaceship body
		g.setColor(Color.red);
		g.fillOval(xPos + 35 , yPos + 10, 20, 8);		//red window on the spaceship
		g.drawLine(xPos, yPos + height/2, xPos + width, yPos + height/2);
		g.setColor(Color.blue);
		g.drawLine(xPos, yPos + height/2 + 3, xPos + width, yPos + height/2 + 3);
		g.drawLine(xPos, yPos + height/2 - 3, xPos + width, yPos + height/2 - 3);
		g.setColor(Color.red);
		
		if (shooting)
			g.drawLine(xPos + width, yPos + height/2, laserlength, yPos + height/2);		//spaceship's laser beam
	}
}