// args 0 : x loc
		//1 : y loc
		//2 : x move
		//3 : y move
		//4 : x loc
		//5 : y loc
		//6 : x move
		//7 : y move
		//8 : timeSlice (optional)

// vf = v0 - ((v0 * 0.01) * timeSlice)
// java SoccerSim x1 y1 xv1 yv1 (one ball) x2 y2 xv2 yv2 (two balls)
//if (args.length % 4 == 1)

/** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *  File name     :  SoccerSim.java
 *  Purpose       :  The main program for the Soccer class
 *  @see
 *  @author       :  Olivia Round
 *  Date written  :  2018-03-15
 *  Description   :  This class provides a bunch of methods which may be useful for the Soccer class
 *                   for Homework 5, part 2.
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


public class SoccerSim {

	private static Ball[] balls = null;

	private static int ballNumber = 0;

	private Timer stopWatch = null;

	private static int j = 0;



	private static final double CENTERFIELD_X = 0;

	private static final double CENTERFIELD_Y = 0;

	private static final double OUTOFBOUNDS_X_POS = 50;

	private static final double OUTOFBOUNDS_X_NEG = -50;

	private static final double OUTOFBOUNDS_Y_POS = 70;

	private static final double OUTOFBOUNDS_Y_NEG = -70;

	private static final double POLE_X = 10;

	private static final double POLE_Y = -10;

	

	private static final double DEFAULT_TIMESLICE = 1;
	
	private int ballCount = 0;
	
	private Ball[] ballArray = null;
	
	private Timer soccerTimer = null;

  public class SoccerSim9 {

  	Timer soccerTimer = new Timer(90, 60);

  }



  public boolean checkCollision() {

    for (int i = 0; i < ballArray.length - 1; i++) {

      if ( (ballArray[i].getXPosition() - POLE_X <=  ) && ( ballArray[i].getYPosition() - POLE_Y <=  ) ) {

        System.out.println("the ball hit the pole!");

        return true;

      }

      for (int j = i + 1; j < ballArray.length; j++) {

        double collision1 = Math.sqrt( (ballArray[i].getXPosition() - ballArray[j]) * (ballArray[i].getXPosition() - ballArray[j]));

        double collision2 = Math.sqrt( (ballArray[i].getYPosition() - ballArray[j]) * (ballArray[i].getYPosition() - ballArray[j]));

        if ((collision1 + collision2) * 12 <=1) {

          return true;

        }       

       }

     }

   }


   public boolean outOfBounds() {

    for (int i = 0; i < ballArray.length - 1; i++) {

      if ( ( ballArray[i].UgetXPosition() > OUTOFBOUNDS_X_POS) || (ballArray[i].getXPosition() < OUTOFBOUNDS_X_NEG) ) {

        System.out.println("ob from the y direction");

        return true;

      } else if ( (ballArray[i].getYPosition() > OUTOFBOUNDS_Y_POS) || (ballArray[i].getYPosition() < OUTOFBOUNDS_Y_NEG) ) {

        System.out.println("ob from the x direction");

        return true;

      } else {

        return false;

      }

    }

   }


	public static void main( String args[] ) {

	  //SoccerSim ballArray = new SoccerSim();

	  System.out.println( "\n   Starting the SoccerSim game!\n\n" );

	  

	  Timer a = new Timer(60);

	  Ball b1 = new Ball(0, 0, 0, 0);

	  Ball b2 = new Ball(1, 1, 0, 0);

	  Ball pole = new Ball(10, 10, 0, 0);

	  

	  if( 0 == args.length ) {

         System.out.println( "   Sorry you must enter at least one argument\n" +

                             "   Please try again..........." );

         System.exit( 1 );

      } 

      

	  if ((args.length % 4) == 0) {

	  	ballNumber = args.length/4;

	  	System.out.println("you've created " + ballNumber + " balls");

	  }



	  if ((args.length % 4) == 1) {

	  	double timeSlice = Double.parseDouble(args[4]);

		ballCount = ((args.length - 1)/4);

	  }

	  
/** 
* Ball[] balls = null;
* balls = new Ball [3];
* for (---);
* 	ball[j] = new Ball (Double.parseDouble(args[i + 0]));
*         ""			""				  (args[i + 1]));
* 		  ""			""				  (args[i + 2]));
*/


	  for (int i = 0; i < args.length; i+=4) { 

		double xPosition = Double.parseDouble(args[i + 0]);

		System.out.println("x posiiton: " + xPosition);

	  	double yPosition = Double.parseDouble(args[i + 1]);

	  	double xSpeed = Double.parseDouble(args[i + 2]);

	  	double ySpeed = Double.parseDouble(args[i + 3]);

		//Ball ball = new Ball(xPosition, yPosition, xSpeed, ySpeed);



		j++; 

		ballArray[j] = new Ball(xPosition, yPosition, xSpeed, ySpeed);

		//balls[j] = new Ball(Double.parseDouble(args[i + 0]), Double.parseDouble(args[i + 1]), Double.parseDouble(args[i + 2]), Double.parseDouble(args[i + 3]));//j keeps count of how many balls there are

		//Ball ball = new Ball [j];

		//System.out.println(j);

	  }

	  System.out.println("balll array: " + ballArray);

	  

	}
}

