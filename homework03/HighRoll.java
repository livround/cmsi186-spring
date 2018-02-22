
/** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *  File name     :  HighRoll.java
 *  Purpose       :  Dice Game
 *  Author        :  Olivia Round
 *  Date          :  2018-02-22
 *  Description   :  
 *  Notes         :  None
 *  Warnings      :  None
 *  Exceptions    :  None
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *  Revision Histor
 *  ---------------
 *            Rev      Date     Modified by:  Reason for change/modification
 *           -----  ----------  ------------  -----------------------------------------------------------
 *  @version 1.0.0  2018-02-22  Olivia Round  Finalized writing and release
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class HighRoll{
   private static int highScore;

   private static DiceSet dSet;

   public static void main( String args[] ) {

     if (args.length < 2) {
      System.out.println("USAGE: Please enter two arguments.");
      System.exit(-1);

   }

   DiceSet dSet = new DiceSet(Integer.parseInt(args[0]), Integer.parseInt(args[1]));

   BufferedReader input = new BufferedReader( new InputStreamReader( System.in ) );
      
      while( true ) {
         System.out.println( "The following menu contains your options for the game. Please enter the number(s) corresponding to your action of choice." );
         System.out.println(  "\n Option 1: Roll all the dice \n" +
                              "Option 2: Roll a single die \n" +
                              "Option 3: Calculate the sum of the die in this set \n" +
                              "Option 4: Save this score as high score \n" +
                              "Option 5: Display the high score \n" +
                              "Option 6: Enter 'Q' to quit the program " );
         System.out.print(">>");
         String inputLine = null;

         try {
            inputLine = input.readLine();

            if( 0 == inputLine.length() ) {
               System.out.println("Please enter a number for a menu option!");

            } else if( '1' == inputLine.charAt(0) ) {
               dSet.roll();
               System.out.println("Your die have been rolled! Here is what you rolled " + dSet.toString() );

            } else if( '2' == inputLine.charAt(0) ) {
               System.out.println("Your dice set is " + dSet + "Choose which dice you want to roll again. Please enter the number of the corresponding dice.");
               BufferedReader newInput = new BufferedReader( new InputStreamReader( System.in ) );
               String userChoice = newInput.readLine();
               dSet.rollIndividual( Integer.parseInt(userChoice) - 1 );
               System.out.println("Your dice set is: " + dSet);

            } else if( '3' == inputLine.charAt(0) ) {
               System.out.println("The sum of your die is " + dSet.sum());

            } else if( '4' == inputLine.charAt(0) ){
               highScore = dSet.sum();
               System.out.println("Your score " + highScore + " is saved.");

            } else if( '5' == inputLine.charAt(0) ){
               System.out.println("Your high score is " + highScore);
          
            } else if( 'q' == inputLine.charAt(0) || 'Q' == inputLine.charAt(0) || '6' == inputLine.charAt(0) ) {
               System.exit(0);
            }
         }
         catch( IOException ioe ) {
            System.out.println( "Caught IOException" );
         }
      }
   }
}
