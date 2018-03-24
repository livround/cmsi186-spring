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

private static int location;

/** 
* Ball[] balls = null;
* balls = new Ball [3];
* for (---);
* 	ball[j] = new Ball (Double.parseDouble(args[i + 0]));
*         ""			""				  (args[i + 1]));
* 		  ""			""				  (args[i + 2]));
*/
