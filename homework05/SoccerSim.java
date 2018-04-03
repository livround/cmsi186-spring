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


	private static final double CENTERFIELD_X = 0;

	private static final double CENTERFIELD_Y = 0;

	private static final double OUTOFBOUNDS_X_POS = 50;

	private static final double OUTOFBOUNDS_X_NEG = -50;

	private static final double OUTOFBOUNDS_Y_POS = 70;

	private static final double OUTOFBOUNDS_Y_NEG = -70;

	private static final double DEFAULT_WIDTH = 100;

	private static final double DEFAULT_HEIGHT = 140;

	private static final double POLE_X = 10;

	private static final double POLE_Y = -10;



	private int ballCount = 0;
	
	private double timeSlice = 0;

	private static final double DEFAULT_TIMESLICE = 1.0;
	
	private Ball[] ballArray = null;
	
	private Timer soccerTimer = null;



  public SoccerSim() {

  }

  public void validateArguments(String args[] ) {

	  if( 0 == args.length ) {

         System.out.println( "   Sorry you must enter at least one argument\n" +

                             "   Please try again." );

         System.exit( 0 );

      } else {

		  if ((args.length % 4) == 1) {

		  	double timeSlice = Double.parseDouble(args[4]);

			ballNumber = ((args.length - 1) / 4);

		  }
  	  }
  }

  public void setUpSim(String args[]) {

  	ballCount = (int)(Math.floor(args.length / 4));


  	if( args.length % 4 == 0) {

  		this.timeSlice = DEFAULT_TIMESLICE;

  	} else if( args.length % 4 == 1) {

  		this.timeSlice = Double.parseDouble(args[args.length - 1]);

  	} else if( (args.length % 4) > 1 ) {

  		throw new IllegalArgumentException("Wrong number of arguments!");

  	}

  	this.ballArray = new Ball[this.ballCount];

  	int j = 0;

  	for (int i=0; i < ballArray.length; i += 4) {

  		ballArray[j] = new Ball (

			(Double.parseDouble(args[i + 0])),
			(Double.parseDouble(args[i + 1])),
			(Double.parseDouble(args[i + 2])),
			(Double.parseDouble(args[i + 3])) );

  		j++;
	}
  }

  public void updateSim() {
  	
  	for (int i = 0; i < ballArray.length; i++) {
  		
  		ballArray[i].moveBall();
  		ballArray[i].ballOutOfBounds( DEFAULT_HEIGHT, DEFAULT_WIDTH);
  		
  	}

  }


  public boolean checkCollision() {

    for (int i = 0; i < ballArray.length - 2; i++) {

    	for (int j = i + 1; j < ballArray.length; j++) {

    		if ((Math.sqrt(Math.pow(ballArray[i].getXLocation() - ballArray[j].getXLocation(), 2) + Math.pow(ballArray[i].getYLocation() - ballArray[j].getYLocation(), 2))) <= (8.9/12)) {

    			return true;

    		}

    	}

    } 

	for (int i = 0; i < ballArray.length; i++) {

		if ((Math.sqrt(Math.pow(ballArray[i].getXLocation() - 10, 2) + Math.pow(ballArray[i].getYLocation() - 10, 2))) <= (4.45/12)) {

			return true;

		}

	}

	System.out.println("There were no collisions!");

    return false;

  }


  public boolean outOfBounds() {

    for (int i = 0; i < ballArray.length - 1; i++) {

      if ( ( ballArray[i].getXLocation() > OUTOFBOUNDS_X_POS) || (ballArray[i].getXLocation() < OUTOFBOUNDS_X_NEG) ) {

        System.out.println("Out of bounds!");

        return true;

      } else if ( (ballArray[i].getYLocation() > OUTOFBOUNDS_Y_POS) || (ballArray[i].getYLocation() < OUTOFBOUNDS_Y_NEG) ) {

        System.out.println("Out of bounds!");

        return true;

      } 

    }
    System.out.println("The balls stayed in bounds.");
    return false;
   }

  public boolean ballMoving() {
  	  
   	  for (int i = 0; i < ballArray.length; i++) {

   	  	if( ballArray[i].stillMoving()) {
   	  		return true;
   	  	}

   	  }
   	  System.out.println("The ball is at rest.");
   	  return false;
   }


  public static void main( String args[] ) {

	  System.out.println( "\n   Starting the SoccerSim game!\n\n" );

	  SoccerSim sim = new SoccerSim();

	  sim.validateArguments(args);
	  sim.setUpSim(args);
	  sim.updateSim(); //good
	  sim.checkCollision(); //good
	  sim.outOfBounds();
	  sim.ballMoving(); //good 

  }

}
