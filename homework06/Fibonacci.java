/** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

 *  File name     :  BrobInt.java

 *  Purpose       :  The main program for the Soccer class

 *  @see

 *  @author       :  Olivia Round

 *  Date written  :  2018-03-15

 *  Description   :  This class provides a bunch of methods which may be useful for the Soccer class

 *                   for Homework 5, part 1.

 *

 *  Notes         :  None right now.  I'll add some as they occur.

 *  Warnings      :  None

 *  Exceptions    :  IllegalArgumentException when the input arguments are "hinky"

 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

 *  Revision Histor

 *  ---------------

 *            Rev      Date     Modified by:  Reason for change/modification

 *           -----  ----------  ------------  -----------------------------------------------------------

 *  @version 1.0.0  2018-03-15  Olivia Round  Initial writing and release

 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */

public class Fibonacci {



   private static final String usageMessage = "\n  You must enter an integer number....." +

                                              "\n    Please try again!" +

                                              "\n  USAGE: java Fibonacci <required_integer>\n\n";

   private static int    maxCount      = 0;

   private static int    working       = 15000;

   private static String end1          = "st";

   private static String end2          = "nd";

   private static String end3          = "rd";

   private static String endRest       = "th";

   private static String endExceptions = "th";

   private static String cardinality   = "";

   private BrobInt current;
   	
   private BrobInt previous;
   
   private BrobInt sum;




   private static final  int NO_CMD_LINE_ARGS = -1;

   private static final  int BAD_CMD_LINE_ARG = -2;



   public Fibonacci(int number) {

      super();
      fibonacciValue(number);

   }

   public BrobInt fibonacciValue(int number) {

   	 current = new BrobInt("1");
   	 previous = new BrobInt("1");
   	 int nth = 2;

   	 while (nth < number) {
   	 	sum = current.add(previous);
   	 	previous = new BrobInt(current.toString());
   	 	current = new BrobInt(sum.toString());
   	 	nth++;
   	 	System.out.println(sum);
   	 }
   	 return sum;
   }

   public static void main( String[] args ) {

      System.out.println( "\n\n   Welcome to the Fibonacci sequence number finder!\n" );

      if( 0 == args.length ) {

         System.out.println( usageMessage );

         System.exit( NO_CMD_LINE_ARGS );

      }

      try {

         maxCount = Integer.parseInt( args[0] );

      }

      catch( NumberFormatException nfe ) {

         System.out.println( "\n   Sorry, that does not compute!!" + usageMessage );

         System.exit( BAD_CMD_LINE_ARG );

      }

      if( 2 == args.length ) {

         try {

            working = Integer.parseInt( args[1] );

         }

         catch( NumberFormatException nfe ) {

            System.out.println( "\n   Sorry, that does not compute!!" + usageMessage );

            System.exit( BAD_CMD_LINE_ARG );

         }

      }



     // this is just for making the output pretty... no real "fibonacci" functionality

      int lastIndex = args[0].length() - 1;

      switch( args[0].charAt( lastIndex ) ) {

         case '1': if (args[0].length() == 2 && (args.length - 2) == 1) {

         				cardinality = end1;

         			}

                   break;

         case '2': if (args[0].length() == 2 && (args.length - 2) == 1) {

         				cardinality = end2;

         			}

                   break;

         case '3': if (args[0].length() == 2 && (args.length - 2) == 1) {

         				cardinality = end3;

         			}

                   break;

         default : cardinality = endRest;

                   break;

      }



      System.out.println( "\n\n   Starting from zero, the " + maxCount + cardinality + " Fibonacci number is: " );



     // NOTE: you may want to handle the first and second Fibonacc numbers as 'special cases'...



     // NOTE: you WILL need to initialize your BrobInts to keep track of things....



     // NOTE: this section is just a happy notification that lets the user know to be patient.......

      Fibonacci x = new Fibonacci(Integer.parseInt(args[0]));
      if( maxCount > working ) {

         System.out.println( "\n                This may take me a while; please be patient!!\n\n"  );

      }




      System.exit( 0 );

   }

}
