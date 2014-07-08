//**********************************************************************
//Class Name: Star.java
//
//Author: Chisheng Li
//
//Supplementary files: StarryNight.java
//**********************************************************************


import java.awt.*;
import java.util.Random;

public class Star {
	
	private int xPos;
	private int yPos;
	private Color starColor;
	
	public Star(){
		Random r = new Random();
		xPos = r.nextInt(100);
		yPos = r.nextInt(100);
		starColor = Color.yellow;
	}
	
	public Star(Point p){
		xPos = p.x;
		yPos = p.y;
		starColor = Color.yellow;
	}
	
	public Star(Point p, Color c){
		xPos = p.x;
		yPos = p.y;
		starColor = c;
	}
	
	public void drawStar(Graphics g){
		int[] xStar = {xPos, xPos+5, xPos+10, xPos+15, xPos+20, xPos+17, xPos+20, xPos+15, xPos+10, xPos+5, xPos, xPos+3};
		int[] yStar = {yPos+10, yPos+10, yPos, yPos+10, yPos+10, yPos+15, yPos+20, yPos+20, yPos+30, yPos+20, yPos+20, yPos+ 15};
		int nPoints = xStar.length;
		
		g.setColor(starColor);
		g.fillPolygon (xStar, yStar, nPoints);
	}
}
