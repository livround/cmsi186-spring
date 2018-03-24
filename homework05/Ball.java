/** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *  File name     :  Ball.java
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

public class Ball {

  private double radius = 4.45;
  private int weight = 1;
  private int location;
  private int xCoordinate = 0;
  private int yCoordinate = 0;
  private int xVelocity = 0;
  private int yVelocity = 0;
  private int ballSpeed = 0;

//where am i? what's my velocity? where do i go? how do i update my velocity?

	public Ball(int xCoordinate, int yCoordinate, int xDirection, int yDirection) {
		this.xCoordinate = xCoordinate;
		this.yCoordinate = yCoordinate;
		this.xVelocity = xVelocity;
		this.yVelocity = yVelocity;
	}

	public void updateVelocity () {
	// constantly decreasing velocity in x and y direction
		xVelocity -= (xVelocity * 0.01);
		yVelocity -= (yVelocity * 0.01);
	}

	//ball doesn't care about time
	public double[] getVelocity () {

		double[] returnArray = new double[2];
		returnArray[0] = xVelocity;
		returnArray[1] = yVelocity;
		return returnArray;
	}

	public void moveBall () {
		// now at xcoord, ycoord
		// next move xvel, yvel
		xCoordinate += (xCoordinate + xVelocity);
		yCoordinate += (yCoordinate + yVelocity);
	}

	public double[] getLocation () {
	//(3,7)
	// -2 x --> velocity
	// -3 y --> velocity
	// new location: (1,4)
	// (-2 * .99) --> new velocity
	// (-3 * .99) --> new velocity
			double[] returnArray = new double[2];
			returnArray[0] = xCoordinate;
			returnArray[1] = yCoordinate;
			return returnArray;
	}

	public String toString() {
	//should report location and velocity numbers
		String result = "[";
		result += " < " + xCoordinate + ", " + yCoordinate + " > ";
		result += " < " + xVelocity + ", " + yVelocity + " > ";
		result += "]";
		return result;
	}

}
