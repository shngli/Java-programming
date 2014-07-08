//**********************************************************************
//Class Name: TreePanel.java
//
//Author: Chisheng Li
//
//Supplementary files: Ornament.java
//**********************************************************************

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

//Correction needed: TreePanel doesn't blink when lightsOn!!!!//

public class TreePanel extends JPanel implements ActionListener {
	private int MID_X = 250;
	private int TOP_Y = 100;
	private int count;
	private Color clr;
	private Polygon tree;
	private int[] xArr = {MID_X, MID_X+50, MID_X + 25,MID_X+100, MID_X + 75, MID_X+ 150, 
			MID_X - 150, MID_X-75, MID_X - 100, MID_X -25, MID_X - 50};
	private int[] yArr = {TOP_Y, TOP_Y + 50, TOP_Y + 50, TOP_Y + 100, TOP_Y+100, TOP_Y+150, 
			TOP_Y + 150, TOP_Y+100, TOP_Y+100, TOP_Y+50, TOP_Y+50};
	private ArrayList<Ornament> orns;
	private boolean lightsOn = true;
	private JButton blueButton = new JButton("Blue");
	private JButton redButton = new JButton("Red");
	private JButton startButton = new JButton("Start");
	private JButton stopButton = new JButton("Stop");
	private Timer timer;
	private int delay = 200;

	public TreePanel() {
		orns = new ArrayList<Ornament>();
		tree = new Polygon(xArr, yArr, xArr.length);
		addMouseListener (new OrnListener());
		
		timer = new Timer(delay, this);
		
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

	    setBackground (Color.yellow);
	    setPreferredSize (new Dimension(500, 500));
	 }
	
	public static void main (String[] args) {
	      JFrame frame = new JFrame ("Christmas Tree");
	      frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);

	      frame.getContentPane().add (new TreePanel());

	      frame.pack();
	      frame.setVisible(true);
	}

	   public void paintComponent (Graphics g)
	   {
	      super.paintComponent(g);

	      g.setColor (Color.green);
	      g.fillPolygon(tree);

//	      for (int i=1; i<=orns.size(); i++) {
//	    	  orns.get(i-1).draw(g);
//	      }
	      
	      g.setColor (Color.black);
	      g.fillRect(MID_X-15, TOP_Y+150, 30, 50);

	      g.setColor(Color.red);
	      for (Ornament o : orns)
	      	o.draw(g);
	      
	      g.drawString ("Count: " + orns.size(), 5, 15);
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
			   lightsOn = true;
			   repaint();
		   }
//		   if (source == timer){
//			   if (clr.equals(Color.white)){
//				   clr = Color.blue;
//			   } else {
//				   clr = Color.white;
//			   }
//		   } 	   		   
	   }

		private class OrnListener implements MouseListener{
			public void mouseClicked (MouseEvent event)
			{
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
