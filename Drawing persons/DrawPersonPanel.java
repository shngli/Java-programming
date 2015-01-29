// ****************************************************************
// Author: Chisheng Li
// DrawPersonPanel.java
//
// The panel for a program that uses the Graphics draw methods to 
// draw a person.         
// ****************************************************************
import javax.swing.JPanel;
import java.awt.*;

public class DrawPersonPanel extends JPanel {
    private final int WIDTH = 800;
    private final int HEIGHT = 500;

    private int[] shirtX = {60,0,20,60,50,130,120,160,180,120};
    private int[] shirtY = {100,150,180,160,250,250,160,180,150,100};
    private int[] pantsX = {50,40,80,90,100,140,130};
    private int[] pantsY = {250,400,400,290,400,400,250};
    private int headX = 65;
    private int headY = 40;
    private int[] hairX = {62,70,75,80,85,90,95,100,105,110,118,
			   112, 102, 93, 81, 73, 62};
    private int[] hairY = {55,28,32,26,30,26,31,25,32,28,55,
			   48, 44, 40, 42, 44, 55};
    private int[] zigzagX = {60, 70, 80, 90, 100, 110, 120};
    private int[] zigzagY = {130,140,130,140,130,140,130};

    //--------------------------------------
    // Constructor:  Set up the panel.
    //--------------------------------------
    public DrawPersonPanel () {
    	setBackground (Color.white);
    	setPreferredSize(new Dimension(WIDTH, HEIGHT));
    }

    //--------------------------------------
    //   Draw person
    //--------------------------------------
    public void paintComponent (Graphics page) {
    	super.paintComponent(page); 
		for (int i = 0; i < 3; i++)
		    {
			// Draw shirt
			page.setColor (Color.red);
			page.fillPolygon (shirtX, shirtY, shirtX.length);
			
			// Draw the zigzag on the shirt
			page.setColor (Color.blue);
			page.drawPolyline (zigzagX, zigzagY, zigzagX.length);
			
			// Draw pants
			page.setColor (Color.black);
			page.fillPolygon (pantsX, pantsY, pantsX.length);
						
			// Draw a head
			page.setColor (Color.gray);
			page.fillOval (headX, headY, 45, 65);
			
			// Draw hair
			page.setColor (Color.yellow);
			page.fillPolygon (hairX, hairY, hairX.length);
			
			movePerson(200, 0);
		    }
    }

//    --------------------------------------------------------------
//      Moves the person over by x pixels and down by y.
//    --------------------------------------------------------------
    public void movePerson(int x, int y) {
        for(int i=0; i < shirtX.length; i++) {
        	shirtX[i] += 200;	//can replace 200 with x
        }
        for(int i=0; i < pantsX.length; i++) {
        	pantsX[i] += 200;
        }
        for(int i=0; i < zigzagX.length; i++) {
        	zigzagX[i] += 200;
        }
        for(int i=0; i < hairX.length; i++) {
        	hairX[i] += 200;
        }
        headX += 200;
    }
}