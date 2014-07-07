// ****************************************************************
// DrawPerson.java
//
// A program that uses the Graphics draw methods to draw a person.
// Copyright Sheng         
// ****************************************************************

import javax.swing.JFrame;

public class DrawPerson
{
    //---------------------------------------------
    // Creates the main frame for the draw program.
    //---------------------------------------------
    public static void main (String[] args)
    {
		JFrame frame = new JFrame ("Draw Person");
		frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);

		DrawPersonPanel panel = new DrawPersonPanel();

		frame.getContentPane().add(panel);
		frame.pack();
		frame.setVisible(true);
    }
}
