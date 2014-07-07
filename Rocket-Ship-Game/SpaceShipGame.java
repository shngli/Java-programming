//**********************************************************************
//Class Name: SpaceShipGame.java
//
//Author: Chisheng Li
//
//Description of the class: This class creates a spaceship, updates the
//position of the space ship and render the ship. It also creates 5 asteroids
//and add a new asteroid whenever one is removed from the screen. The score,
//life left and time remaining are always updated. The game ends after 10 seconds
// or 3 collisions.
//
//Supplementary files: SpaceShip.java and Asteroid.java
//**********************************************************************

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.Timer;


public class SpaceShipGame extends JPanel
{
   private SpaceShip s = new SpaceShip();
   private ArrayList<Asteroid> aster;		//Array list to store the asteroids
   private int score = 0;					//Initial score = 0
   private int lifeleft = 3;				//Player starts with 3 lives
   private int timeleft = 10;				//Player starts with 10 seconds of time
   private int x, y;
   private Timer countTimer;				//Count down timer for the time remaining
   private Timer asterTimer;				//Timer to move the asteroids
   private int delay = 1000;
   private int delay2 = 90;
   private int shootX, shootY;				//Get coordinates of asteroids when shot by laser
   private int collideX, collideY;			//Get coordinates of asteroids when collided with the space ship


   public SpaceShipGame()
   {
      SpaceshipListener monitor = new SpaceshipListener();
      aster = new ArrayList<Asteroid>();
      
      for(int i=0; i<5; i++){
		   aster.add(new Asteroid(x,y));
	   }
      addMouseMotionListener(monitor);
      addMouseListener(monitor);
      
      countTimer = new Timer(delay, new CountdownTimer());
      asterTimer = new Timer(delay2, new AsteroidTimer());

      setCursor(Cursor.getPredefinedCursor(Cursor.CROSSHAIR_CURSOR));
      setBackground (Color.white);
      setPreferredSize(new Dimension(800, 800));
      
      countTimer.start();		//Starts the count down timer from 10 seconds
      asterTimer.start();		//Starts the timer to move the asteroids
   }
   
   public static void main (String[] args)
   {
      JFrame frame = new JFrame ("SpaceShip Game");
      frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);

      frame.getContentPane().add (new SpaceShipGame());

      frame.pack();
      frame.setVisible(true);
   }

   public void paintComponent(Graphics g)
   {
	  //draws the spaceship
      super.paintComponent(g);
      s.draw(g,800);
      
      //draws the asteroids
      for (Asteroid a : aster)
    	  a.draw(g);
      
      g.setColor(Color.red);
      //prints 'OH NO!!!' when the spaceship collides with an asteroid
      if(lifeleft>0 && timeleft>0 && s.getPosition().x==0 && s.getPosition().y==0){
   	   g.drawString("OH NO!!!", collideX, collideY);
      } else {
       	   g.drawString("", collideX, collideY);
      }
      
      //prints 'Score!!!' when the spaceship destroys an asteroid
      if(lifeleft>0 && timeleft>0 && s.getShooting()){
      	   g.drawString("Score!!!", shootX, shootY);
         } else {
          	   g.drawString("", shootX, shootY);
         }
      
      if (lifeleft == 0 ){
    	  g.drawString("Score: " + score, 20, 40);
    	  g.drawString("Life: " + lifeleft, 20, 60);
    	  g.drawString("Time Remain: " + timeleft, 20, 80);
    	  g.drawString("Game Over", 400, 400);
      } else if (timeleft > 0){
    	  g.drawString("Score: " + score, 20, 40);
    	  g.drawString("Life: " + lifeleft, 20, 60);
    	  g.drawString("Time Remain: "+ timeleft, 20, 80);
      }  else {
    	  g.drawString("Score: " + score, 20, 40);
    	  g.drawString("Life: " + lifeleft, 20, 60);
    	  g.drawString("Time Remain: " + timeleft, 20, 80);
    	  g.drawString("Game Over", 400, 400);
      }      
   }
   
   //Timer counting down from 10 seconds by every 1 second. Timer stops when time remaining = 0.
   private class CountdownTimer implements ActionListener{
	   public void actionPerformed (ActionEvent event){
		   if (timeleft > 0){
			timeleft --;   
		   } 
		   
		   if (timeleft==0) {
			   countTimer.stop();
			   asterTimer.stop();
			   aster.clear();
		   }
		   repaint();
	   }
   }
   
   private class AsteroidTimer implements ActionListener{
	   public void actionPerformed (ActionEvent event){
		   for(int i=0; i<5; i++){
			   aster.get(i).move();		//moves all 5 asteroids
			   
			   if(aster.get(i).getPosition().x < 0){
				   aster.remove(i);
				   aster.add(i, new Asteroid(x,y));		//removes and adds a new asteroid when 1 asteroid leaves the screen
			   }
			   if(aster.get(i).getPosition().x < s.getPosition().x+55 
					   && aster.get(i).getPosition().y + 30 > s.getPosition().y
					   && aster.get(i).getPosition().y < s.getPosition().y + 50){
				   collideX = aster.get(i).getPosition().x;
				   collideY = aster.get(i).getPosition().y;
				   aster.remove(i);				//removes asteroid when collides with spaceship
				   s.move(0,0);					//moves spaceship back to (0,0) after it collides with an asteroid
				   lifeleft--;					//life remaining - 1 after the collision
				   aster.add(i, new Asteroid(x,y));		//adds a new asteroid after the collision 
			   }
			   if(aster.get(i).getPosition().y < s.getPosition().y + 25 
					   && aster.get(i).getPosition().y + 30 > s.getPosition().y + 25
					   && s.getShooting()){
				   shootX = aster.get(i).getPosition().x;
				   shootY = aster.get(i).getPosition().y;
				   
				   aster.remove(i);				//removes asteroid after it is shot by the laser
				   score = score + 1;			//updates the score when spaceship destroys an asteroid
				   aster.add(i, new Asteroid(x,y));		//adds a new asteroid after 1 asteroid is destroyed
			   }
		   }
		   if (lifeleft == 0){
			   asterTimer.stop();
			   countTimer.stop();
			   aster.clear();
		   }
		   repaint();
	   }
   }

   private class SpaceshipListener implements MouseListener, MouseMotionListener
   {
      public void mouseMoved(MouseEvent event)
      {
         s.move(event.getX(), event.getY());		//gets and updates the spaceship's position
         repaint();
      }
      
      public void mousePressed(MouseEvent event)
      {
         s.setShooting(true);					//draws the laser
         repaint();
      }

      public void mouseReleased(MouseEvent event)
      {
         s.setShooting(false);				
         shootX =0;
         shootY =0;
         repaint();
      }
      public void mouseDragged(MouseEvent event){}
      public void mouseClicked(MouseEvent event) {}
      public void mouseEntered(MouseEvent event) {}
      public void mouseExited(MouseEvent event) {}
   }
}
