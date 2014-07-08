//**********************************************************************
//Class Name: Ornament.java
//
//Author: Chisheng Li
//
//Supplementary files: TreePanel.java
//**********************************************************************

import javax.swing.JPanel;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class Ornament extends JPanel{
	private int xPos, yPos;
	private Color clr;
	private int WIDTH = 10;
	
	public Ornament(){
		Random r = new Random();
		xPos = r.nextInt(250);
		yPos = r.nextInt(250);
		clr = Color.yellow;		
	}
	
	public Ornament(int x, int y, Color c){
		xPos = x;
		yPos = y;
		clr = c;
	}
	
	public void draw(Graphics g){
		g.setColor(clr);
		g.fillOval (xPos, yPos, WIDTH, WIDTH);
	}
}
