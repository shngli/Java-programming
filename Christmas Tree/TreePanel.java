//************************************************************************
// Author: Chisheng Li
// Class Name: TreePanel.java
//
// Description of the class: This class defines a decorated Holiday tree. 
// The tree is a polygon that can be decorated with ornaments using mouse clicks. 
// The default color for ornaments is red. The number in the top left corner is a count 
// of the ornaments. The buttons labeled Blue and Red determine the color of ornaments. 
// The buttons labeled Start and Stop implement a light show. When “Start” is pressed the 
// lights blink. When “Stop” is pressed the blinking stops. New ornaments can be added 
// during a light show. 
//
// Supplementary files: Ornament.java is needed to plot the ornaments.
//*************************************************************************

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import java.awt.event.MouseListener;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.Color;
import java.awt.Point;
import java.awt.Polygon;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class TreePanel extends JPanel implements ActionListener {
	private int MID_X = 300;
	private int TOP_Y = 100;
	private Color clr;
	private Polygon tree;
	private int[] xArr = {MID_X, MID_X+60, MID_X+30,MID_X+120, MID_X+80, MID_X+180, 
			MID_X-180, MID_X-80, MID_X-120, MID_X-30, MID_X-60};
	private int[] yArr = {TOP_Y, TOP_Y+80, TOP_Y+80, TOP_Y+160, TOP_Y+160, TOP_Y+240, 
			TOP_Y+240, TOP_Y+160, TOP_Y+160, TOP_Y+80, TOP_Y+80};
	private ArrayList<Ornament> orns;
	private JButton blueButton = new JButton("Blue");
	private JButton redButton = new JButton("Red");
	private JButton startButton = new JButton("Start"); //button to start light show
	private JButton stopButton = new JButton("Stop"); //button to stop light show
	private JButton resetButton = new JButton("Reset"); //button to reset the tree panel
	private boolean blink = false;
	private Timer timer;
	private int delay = 500; //200 milliseconds

	public TreePanel() {
		orns = new ArrayList<Ornament>();
		tree = new Polygon(xArr, yArr, xArr.length);
		addMouseListener (new OrnListener());
		
		timer = new Timer(delay, this); //creates timer for the light show
		
	    blueButton.addActionListener(this);
	    blueButton.setBackground(Color.blue);
	    blueButton.setOpaque(true);
	    add(blueButton,BorderLayout.NORTH);
	    
	    redButton.addActionListener(this);
	    redButton.setBackground(Color.red);
	    redButton.setOpaque(true);
	    add(redButton,BorderLayout.NORTH);
	    
	    startButton.addActionListener(this);
	    startButton.setBackground(Color.green);
	    startButton.setOpaque(true);
	    add(startButton,BorderLayout.NORTH);
	    
	    stopButton.addActionListener(this);
	    stopButton.setBackground(Color.orange);
	    stopButton.setOpaque(true);
	    add(stopButton,BorderLayout.NORTH);
	    
	    resetButton.addActionListener(this);
	    resetButton.setBackground(Color.gray);
	    resetButton.setOpaque(true);
	    add(resetButton,BorderLayout.NORTH);
	    
	    setBackground (Color.yellow);
	    setPreferredSize (new Dimension(600, 500));
	 }
	
	public static void main (String[] args) {
		JFrame frame = new JFrame ("Christmas Tree");
		frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
		
		frame.getContentPane().add (new TreePanel());
		
		frame.pack();
		frame.setVisible(true);
	}

	public void paintComponent (Graphics g) {
		
		super.paintComponent(g);
		
		g.setColor (Color.green);
		g.fillPolygon(tree); //draw tree 
		g.setColor (Color.black);
		g.fillRect(MID_X-20, TOP_Y+240, 40, 100); //draw tree trunk

	    if (blink == false){
	    	g.setColor(Color.red);
	    	for (Ornament o : orns) {
	    		o.draw(g);
	    	}
	    }
	    
	    g.drawString ("Count: " + orns.size(), 5, 25); //count the number of ornaments
	   }
	
	public void actionPerformed(ActionEvent event) {
		Object source = event.getSource();
		if (source == blueButton){
			clr = Color.blue;
		}
		if (source == redButton){
			clr = Color.red;
		}
		if (source == startButton){
			timer.start();
		}
		if (source == stopButton){
			timer.stop();
			blink = false;
			repaint();
		}
		if (source == timer){
			if (blink == true){
				blink = false;
				repaint();
			} else {
				blink = true;
				repaint();
			}
		}
		if (source == resetButton){
			orns.clear();
			clr = Color.red;
			repaint();
		}
	}
	
	private class OrnListener implements MouseListener{
		public void mouseClicked (MouseEvent event){
			if (tree.contains(event.getX(),event.getY())) {
				Ornament o = new Ornament(event.getX(), event.getY(), clr);
				orns.add(o);
				repaint();
				}
		}
		public void mouseDragged (MouseEvent event) {}
		public void mousePressed (MouseEvent event) {}
		public void mouseReleased (MouseEvent event) {}
		public void mouseEntered (MouseEvent event) {}
		public void mouseExited (MouseEvent event) {}
		public void mouseMoved (MouseEvent event) {}
	}	
		
}
