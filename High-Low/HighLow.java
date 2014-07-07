
import java.text.DecimalFormat;
import java.util.*;

public class HiLo
{
   public static void main (String[] args)
   {
      final int MAX = 100;
      int answer, guess;

      Scanner scan = new Scanner (System.in);
      
      System.out.println ("Welcome to the Guessing Game. I will pick a secret number between 1.. " + MAX);
      System.out.println ("You job is to guess numbers until you pick the secret number. Enter -999 at any time " +
      		"during the game to end the program.");
      
      double bestScore = 0; //what's your best score
      double worstScore = 110; //what's your worst score
      
      boolean continuegame = true;	//while the user continues the game and not quit 
      while (continuegame) 
      {
      		Random generator = new Random();		//Random generator from 1 to 100
         	answer = generator.nextInt(MAX) + 1;
         	
         	System.out.println ("Enter your guess: ");
         	guess = scan.nextInt();
		      		      
		      int counter = 0;
		      
		      while (guess != -999)		//if input guess is not answer or -999, continue game
		      {
		      	counter++;
				   while (guess < 1 || guess > 100)		//if the input is not within the valid range
				   {
				       System.out.println ("Enter a number in the valid range of 1..100");
				       System.out.println ("Enter your guess: " );
				       guess = scan.nextInt();
				   }
			      if (guess > answer && guess != -999)			//if input guess is higher than the answer
			      {
			      	System.out.println ("Too high");
			      	System.out.println ("Enter your guess: " );
			      	guess = scan.nextInt();
			      }
			      else
			      {
			      	if (guess < answer && guess != -999)		//if input guess is lower than the answer
			      	{
			      	System.out.println("Too low");
			      	System.out.println ("Enter your guess: " );
			      	guess = scan.nextInt();
			      	}
			      	else if (guess == answer)					//if guess equals to answer, prints correct
			      	{	
			      		System.out.println("Correct!");
			      		break;
			      	}
			      	else if (guess == -999)						//ends game if user inputs -999
			      	{
			      		System.out.println("Goodbye.");
			      		break;
			      	}
			      }
		      }
		      if (guess == -999) 		//quits if user inputs -999
		      {														
		      	System.out.println("Goodbye.");
		      	break;
		      }
		      if (guess == answer) 
		      {
		      	//System.out.println("Correct!");
		      	DecimalFormat fmt = new DecimalFormat("###.##");
		      	double score = (double) 100 / counter;				//calculates the score once the user makes the right guess
		      	double wScore;
		      	if (worstScore == 110) 
		      	{
		      		wScore = 0;
		      	}
		      	else
		      		wScore = worstScore;
		      	System.out.println("You took " + counter + " guesses for a score of " + fmt.format(score) + "%.");
		      	System.out.println("Your previous best attempt was " + fmt.format(bestScore) + "%."); 
		      	System.out.println("Your previous worst attempt was " + fmt.format(wScore) + "%.");
		      	if (bestScore == 0 || score > bestScore)		//updates the best score
		      	{
		      		bestScore = score;
		      	}
		      	if (worstScore == 110 || score < worstScore) 	//updates the worst score
		      	{
		      		worstScore = score;
		      	}
		      }    
		      
		      //Ask if the user wants to repeat the game. End the game if input is not Yes/yes/Y/y 
		      System.out.println("Play again? (Yes/yes/Y/y to repeat game):" );
		      String repeat = scan.next();
		      if (!repeat.equalsIgnoreCase("Yes") && !repeat.equalsIgnoreCase("Y")) 
		      {
		      	continuegame = false;
		      	break;
		      }
      }
   }
 }
