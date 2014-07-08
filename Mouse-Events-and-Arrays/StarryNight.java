//**********************************************************************
//Class Name: StarryNight.java
//
//Author: Chisheng Li
//
//Supplementary files: Star.java
//*********************************************************************

import java.util.ArrayList;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class StarryNight extends JPanel implements ActionListener{
	
	//count is off by 1!!!!!!
	private int count;
	private ArrayList<Star> starList;
	private JButton resetButton = new JButton("Reset");
	private Color clr;
	
	public StarryNight() {
		starList = new ArrayList<Star>();
		addMouseListener (new StarListener());
		resetButton.addActionListener(this);

		JPanel northPanel = new JPanel();
		northPanel.add(resetButton);
		add(northPanel,"North");

	    setBackground (Color.black);
	    setPreferredSize (new Dimension(500, 500));
	 }
	
	public static void main (String[] args) {
	      JFrame frame = new JFrame ("I Create Stars");
	      frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);

	      frame.getContentPane().add (new StarryNight());

	      frame.pack();
	      frame.setVisible(true);
	}

	public void paintComponent (Graphics g){
		super.paintComponent(g);
		
		g.setColor(clr);
		for (Star s : starList)
			s.drawStar(g);
		
		g.setColor(Color.red);
		g.drawString("Count: " + starList.size(), 10, 20);
	}
	
	public void actionPerformed(ActionEvent event){
		if(event.getSource()==resetButton){
			count = 0;
			starList.clear();
			repaint();
		}
	}
	
	//1) green --> 2) red --> 3) yellow
	private class StarListener implements MouseListener{
		public void mousePressed (MouseEvent event)
		{	
//			for(int i=0; i<100; i++){
//				   starList.add(i, new Star(event.getPoint(),clr));
//				   count++;
//				   repaint();
//			   }
			
			if (starList.size()<100){
				starList.add(new Star(event.getPoint(),clr));
				repaint();
				count = count+1;
			}
			if ((count-1)%3 == 0){
				clr = Color.green;
			} else if ((count-2)%3 == 0){
				clr = Color.red;
			} else {
				clr = Color.yellow;
			}
		}
		public void mouseClicked (MouseEvent event) {}
		public void mouseReleased (MouseEvent event) {}
		public void mouseEntered (MouseEvent event) {}
		public void mouseExited (MouseEvent event) {}
	}	
}
