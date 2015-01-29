//************************************************************************
// Author: Chisheng Li
// Class Name: Ornament.java
//
// Description of the class: This class defines an ornament as a decorative oval. 
// Each ornament will be the same shape, but the color and placement can vary. 
//
// Supplementary files: TreePanel.java is needed to plot the ornaments.
//*************************************************************************

import javax.swing.JPanel;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class Ornament extends JPanel{
	private int xPos, yPos;
	private Color clr;
	private int WIDTH = 12;
	
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