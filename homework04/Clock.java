/** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *  File name     :  Clock.java
 *  Purpose       :  Provides a class defining methods for the ClockSolver class
 *  @author       :  Olivia Round
 *  Date written  :  2018-02-22
 *  Description   :  This class provides a bunch of methods which may be useful for the ClockSolver class
 *                   for Homework 4, part 1.  Includes the following:
 *
 *  Notes         :  None right now.  I'll add some as they occur.
 *  Warnings      :  None
 *  Exceptions    :  IllegalArgumentException when the input arguments are "hinky"
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *  Revision Histor
 *  ---------------
 *            Rev      Date     Modified by:  Reason for change/modification
 *           -----  ----------  ------------  -----------------------------------------------------------
 *  @version 1.0.0  2017-02-28  B.J. Johnson  Initial writing and release
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */

import java.text.DecimalFormat;

public class Clock {
  /**
   *  Class field definintions go here
   */
   private static final double DEFAULT_TIME_SLICE_IN_SECONDS = 60.0;
   private static final double INVALID_ARGUMENT_VALUE = -1.0;
   private static final double MAXIMUM_DEGREE_VALUE = 360.0;
   private static final double MINIMUM_DEGREE_VALUE = 0.0;
   private static final double HOUR_HAND_DEGREES_PER_SECOND = 0.00834;
   private static final double MINUTE_HAND_DEGREES_PER_SECOND = 0.1;

   private double degrees = 0;
   private double totalSeconds = 0;
   private double totalMinutes = 0;
   private double totalHours = 0;
   private double timeSlice = 0;


  /**
   *  Constructor goes here
   */
   public Clock( double nDegrees, double timeSlice ) {

      if (nDegrees > MAXIMUM_DEGREE_VALUE) {
        throw new IllegalArgumentException("There is a maximum of 360.0 degrees.");
      } else if (nDegrees < MINIMUM_DEGREE_VALUE) {
        throw new IllegalArgumentException("There must be at least 0.0 degrees.");
      }  
      if (timeSlice > 1800.0 || timeSlice < 0.0) {
        throw new IllegalArgumentException("timeSlice is out of range.");
      } 
      

      degrees = nDegrees;
      this.timeSlice = timeSlice;
      this.totalSeconds = totalSeconds;
      this.totalMinutes = totalMinutes;
      this.totalHours = totalHours;

   }

   public Clock( String[] args) {
      if (Double.parseDouble(args[0]) > MAXIMUM_DEGREE_VALUE) {
        throw new IllegalArgumentException("There is a maximum of 360.0 degrees.");
      } else if (Double.parseDouble(args[0]) < MINIMUM_DEGREE_VALUE) {
        throw new IllegalArgumentException("There must be at least 0.0 degrees.");
      }  

      if (args.length == 2) {
        if (timeSlice > 1800.0 || timeSlice < 0.0) {
          throw new IllegalArgumentException("timeSlice is out of range.");
        } 
      } 
    }



  /**
   *  Methods go here
   *
   *  Method to calculate the next tick from the time increment
   *  @return double-precision value of the current clock tick
   */
   public double tick() {
      return totalSeconds += timeSlice;
   }

  /**
   *  Method to calculate and return the current position of the hour hand
   *  @return double-precision value of the hour hand location
   */
   public double getHourHandAngle() {
      // totalSeconds converted to hours to find what angle the hours hand is pointing at
      //0.00834 degrees per second
      return (totalSeconds * HOUR_HAND_DEGREES_PER_SECOND);

   }

  /**
   *  Method to calculate and return the current position of the minute hand
   *  @return double-precision value of the minute hand location
   */
   public double getMinuteHandAngle() {
    //1/10 of a degree per minute
    double angle = totalSeconds * MINUTE_HAND_DEGREES_PER_SECOND;
    if (angle <= 360.0) {
      return angle;
    } else {
      return angle - 360.0;
    }
   }

  /**
   *  Method to calculate and return the angle between the hands
   *  @return double-precision value of the angle between the two hands
   */
   public double getHandAngle() {
    //what if the hourhandangle is smaller
    //what if the angle is bigger
    double handAngle = Math.abs(getHourHandAngle() - getMinuteHandAngle());

    if (handAngle > 180) {
      return 360 - handAngle;
    } else {
      return handAngle;
    }
   }

  /**
   *  Method to fetch the total number of seconds
   *   we can use this to tell when 12 hours have elapsed
   *  @return double-precision value the total seconds private variable
   */
   public double getTotalSeconds() {
      return totalSeconds;
   }

  /**
   *  Method to return a String representation of this clock
   *  @return String value of the current clock
   */
   public String toString() {
    //convert to a string with second, minute, hour values
     double hour = Math.floor(totalSeconds / 3600.0);
     double minute = Math.floor((int) ((totalSeconds - (hour * 3600)) / 60));
     double second = Math.floor((totalSeconds) - ((minute * 60) + (hour * 3600)));

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

      System.out.println( "\nCLOCK CLASS TESTER PROGRAM\n" +
                          "--------------------------\n" );
      System.out.println( "  Creating a new clock: " );
      Clock clock = new Clock(90, 60);
      System.out.println(" Total seconds: " + clock.tick());
      System.out.println(" Hour hand: " + clock.getHourHandAngle());
      System.out.println(" Minute hand: " + clock.getMinuteHandAngle());
      System.out.println(" Hand angle: " + clock.getHandAngle());
      System.out.println(" String: " + clock.toString());
   }

  }
