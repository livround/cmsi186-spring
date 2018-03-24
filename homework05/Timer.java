/** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *  File name     :  Timer.java
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

import java.text.DecimalFormat;

public class Timer {

   private static final double DEFAULT_TIME_SLICE_IN_SECONDS = 60.0;
   private static final double INVALID_ARGUMENT_VALUE = -1.0;

   private double totalSeconds = 0;
   private double totalMinutes = 0;
   private double totalHours = 0;
   private double totalTime = 0;
   private double timeSlice = 0;


  /**
   *  Constructor goes here
   */
   public Timer( double totalTime, double timeSlice ) {
      
      this.timeSlice = timeSlice;
      this.totalSeconds = totalSeconds;
      this.totalMinutes = totalMinutes;
      this.totalHours = totalHours;
      this.totalTime = totalTime;

   }

   public double tick() {
      totalSeconds += timeSlice;
      return totalSeconds;
   }

    public double getHour() {
      double timerHour = Math.floor(totalSeconds / 3600);
      return timerHour;
    }

   public double getMinute() {
    double timerMinute = Math.floor((totalSeconds - (getHour() * 3600)) / 60);
    return timerMinute;
   }

   public double getSecond() {
    double timerSecond = Math.floor((totalSeconds - (getHour() * 3600)) - (totalSeconds - (getMinute() * 60)));
    return timerSecond;
   }

   public String toString() {
     double hour = getHour();
     double minute = getMinute();
     double second = getSecond();

     DecimalFormat df = new DecimalFormat("#.000");
     DecimalFormat df1 = new DecimalFormat("00");
     System.out.println(df1.format(hour) + " : " + df1.format(minute) + " : " + df.format(second));
     return "";

   }

  /**
   *  The main program starts here
   *  remember the constraints from the project description
   *  @see  http://bjohnson.lmu.build/cmsi186web/homework04.html
   *  be sure to make LOTS of tests!!
   *  remember you are trying to BREAK your code, not just prove it works!
   */
   public static void main( String args[] ) {

      System.out.println( "\nTIMER CLASS TESTER PROGRAM\n" +
                          "--------------------------\n" );
      System.out.println( "  Creating a new timer: " );
      Timer timer = new Timer(90, 1800);
      System.out.println();
   }

  }
