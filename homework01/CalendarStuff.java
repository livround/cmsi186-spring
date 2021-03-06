/** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *  File name     :  CalendarStuff.java
 *  Purpose       :  Uses a set of methods to analyze inputted calendar dates.
 *  Author        :  Olivia Round
 *  Date          :  2018-01-16
 *  Description   :  This file provides the supporting methods for the CountTheDays program which will
 *                   calculate the number of days between two dates.
 *  Notes         :  None
 *  Warnings      :  None
 *  Exceptions    :  None
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *  Revision History
 *  ----------------
 *            Rev      Date     Modified by:  Reason for change/modification
 *           -----  ----------  ------------  -----------------------------------------------------------
 *  @version 1.0.0  2018-01-18  Olivia Round  Initial writing 
 */

public class CalendarStuff {

    /**
   * A listing of the days of the week, assigning numbers; Note that the week arbitrarily starts on Sunday
   */
   private static final int SUNDAY       = 0;
   private static final int MONDAY       = SUNDAY    + 1;
   private static final int TUESDAY      = SUNDAY    + 2;
   private static final int WEDNESDAY    = SUNDAY    + 3;
   private static final int THURSDAY     = SUNDAY    + 4;
   private static final int FRIDAY       = SUNDAY    + 5;
   private static final int SATURDAY     = SUNDAY    + 6;
  
  /**
   * A listing of the months of the year, assigning numbers; I suppose these could be ENUMs instead, but whatever
   */
   private static final int JANUARY     = 1;
   private static final int FEBRUARY    = JANUARY   + 1;
   private static final int MARCH       = JANUARY   + 2;
   private static final int APRIL       = JANUARY   + 3;
   private static final int MAY         = JANUARY   + 4;
   private static final int JUNE        = JANUARY   + 5;
   private static final int JULY        = JANUARY   + 6;
   private static final int AUGUST      = JANUARY   + 7;
   private static final int SEPTEMBER   = JANUARY   + 8;
   private static final int OCTOBER     = JANUARY   + 9;
   private static final int NOVEMBER    = JANUARY   + 10;
   private static final int DECEMBER    = JANUARY   + 11;
  
  /**
   * An array containing the number of days in each month
   *  NOTE: this excludes leap years, so those will be handled as special cases
   *  NOTE: this is optional, but suggested
   *  NOTE: an if statement that changes the february numberOfDays to 29 if isLeapYear
   */
   private static int[]    days        = { 0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

  /**
   * The constructor for the class
   */
   public CalendarStuff() {
      System.out.println( "Calculating Leap Year." );  
   }

  /**
   * A method to determine if the year argument is a leap year or not<br />
   *  Leap years are every four years, except for even-hundred years, except for every 400
   * @param    year  long containing four-digit year
   * @return         boolean which is true if the parameter is a leap year
   */
   public static boolean isLeapYear( long year ) {
   	return ((year % 4 == 0) && (year % 100 != 0) || (year % 400 == 0));
   }

  /**
   * A method to calculate the days in a month, including leap years
   * @param    month long containing month number, starting with "1" for "January"
   * @param    year  long containing four-digit year; required to handle Feb 29th
   * @return         long containing number of days in referenced month of the year
   * notes: remember that the month variable is used as an indix, and so must
   *         be decremented to make the appropriate index value
   */
   public static long daysInMonth( long month, long year ) {

      if ( month == 2 ) {
         if (isLeapYear (year)) {
            return 29;
         } 
         return 28;
      }
      return days[ (int)month]; 
   }

  /**
   * A method to determine if two dates are exactly equal
   * @param    month1 long    containing month number, starting with "1" for "January"
   * @param    day1   long    containing day number
   * @param    year1  long    containing four-digit year
   * @param    month2 long    containing month number, starting with "1" for "January"
   * @param    day2   long    containing day number
   * @param    year2  long    containing four-digit year
   * @return          boolean which is true if the two dates are exactly the same
   */
   public static boolean dateEquals( long month1, long day1, long year1, long month2, long day2, long year2 ) {
   	if (year1 != year2) {
   		return false;
   	} else if (month1 != month2) {
   		return false;
      } else if (day1 != day2) {
    	   return false;
      } 
      return true;  
   }

  /**
   * A method to compare the ordering of two dates
   * @param    month1 long   containing month number, starting with "1" for "January"
   * @param    day1   long   containing day number
   * @param    year1  long   containing four-digit year
   * @param    month2 long   containing month number, starting with "1" for "January"
   * @param    day2   long   containing day number
   * @param    year2  long   containing four-digit year
   * @return          int    -1/0/+1 if first date is less than/equal to/greater than second
   */
   public static int compareDate( long month1, long day1, long year1, long month2, long day2, long year2 ) {
      if ( year1 == year2 && day1 == day2 && month1 == month2 ) {
         return 0;
      }
      if (year1 > year2) {
         return 1;
      } else if (year1 < year2) {
         return -1;
      } else {
         if (month1 > month2) {
            return 1;
         } else if (month1 < month2) {
            return -1;
         } else {
            if (day1 > day2) {
               return 1;
            } else if (day1 < day2) {
               return -1;
            } else {
               return 0;
            }
         }
      }
         // if ( year1 > year2 ) {
         //    return +1;
         // } else if ( year1 < year2 ) {
         //    return -1;
         // } else {
         //    if ( month1 < month2 ) {
         //       return -1;
         //    } else if ( month1 > month2 ) {
         //       return +1;
         //    } else {
         //       if ( day1 < day2 ) {
         //          return +1;
         //       } else {
         //          return -1;
         //       }
         //    }
         // }
   }

  /**
   * A method to return whether a date is a valid date
   * @param    month long    containing month number, starting with "1" for "January"
   * @param    day   long    containing day number
   * @param    year  long    containing four-digit year
   * @return         boolean which is true if the date is valid
   * notes: remember that the month and day variables are used as indices, and so must
   *         be decremented to make the appropriate index value
   */
   public static boolean isValidDate( int month, long day, long year ) {
      
      try {
        Long.parseLong( String.valueOf(month) );
        Long.parseLong( String.valueOf(day));
        Long.parseLong( String.valueOf(year));
      }
      catch(NumberFormatException ex)
      {
         return false;
      }
      // return true;

   	if ( month >= 1 && month <= 12 ) {    
           if ( day >= 1 && day <= days[month]) {
               if ( String.valueOf(year).length() == 4 ) { 
                  return true;
               } 
           }               
   	}
      return false;
   }

  /**
   * A method to return a string version of the month name
   * @param    month long   containing month number, starting with "1" for "January"
   * @return         String containing the string value of the month (no spaces)
   */
   public static String toMonthString( int month ) {
      switch( month - 1) {
         case 1: 
            return "January"; 
         case 2: 
            return "February";
         case 3: 
            return "March";
         case 4: 
            return "April";
         case 5: 
            return "May";
         case 6: 
            return "June";
         case 7: 
            return "July";
         case 8: 
            return "August";
         case 9: 
            return "September";
         case 10: 
            return "October";
         case 11: 
            return "November";
         case 12: 
            return "December";
         default: throw new IllegalArgumentException( "Illegal month value given to 'toMonthString()'." );
      }
   }

  /**
   * A method to return a string version of the day of the week name
   * @param    day int    containing day number, starting with "1" for "Sunday"
   * @return       String containing the string value of the day (no spaces)
   */
   public static String toDayOfWeekString( int day ) {
      switch( day ) { 
          case 1: 
            return "Sunday";
         case 2: 
            return "Monday";
         case 3: 
            return "Tuesday";
         case 4: 
            return "Wednesday";
         case 5: 
            return "Thursday";
         case 6: 
            return "Friday";
         case 7: 
            return "Saturday";
         default       : throw new IllegalArgumentException( "Illegal day value given to 'toDayOfWeekString()'." );
      }

   }

  /**
   * A method to return a count of the total number of days between two valid dates
   * @param    month1 long   containing month number, starting with "1" for "January"
   * @param    day1   long   containing day number
   * @param    year1  long   containing four-digit year
   * @param    month2 long   containing month number, starting with "1" for "January"
   * @param    day2   long   containing day number
   * @param    year2  long   containing four-digit year
   * @return          long   count of total number of days
   */
   public static long daysBetween( long month1, long day1, long year1, long month2, long day2, long year2 ) {
      
      int dayCount = 0;
      int numberOfLeaps = 0;
      int firstYear = 0;
      int secondYear = 0;
      int firstMonth = 0;
      int secondMonth = 0;
      int firstDay = 0;
      int secondDay = 0;

      if ( 0 == compareDate( month1, day1, year1, month2, day2, year2 ) ) {
         return 0;

      } else if ( -1 == compareDate( month1, day1, year1, month2, day2, year2 ) ) { //first date is earlier than second date
         secondYear = (int)year2;
         secondMonth = (int)month2;
         secondDay = (int)day2;
         firstYear = (int)year1;
         firstMonth = (int)month1;
         firstDay = (int)day1;

      } else if ( 1 == compareDate( month1, day1, year1, month2, day2, year2 ) ) { //second date is earlier than first date
         firstYear = (int)year2;
         firstMonth = (int)month2;
         firstDay = (int)day2;
         secondYear = (int)year1;
         secondMonth = (int)month1;
         secondDay = (int)day1;
      }

      for (int i = firstYear; i <= secondYear; i++) {
         if (isLeapYear(i) == true) {
            numberOfLeaps++;
         }
      }

      int differenceYear = 0;

      if (compareDate(firstMonth, firstDay, secondYear, secondMonth, secondDay, secondYear) == -1) {
         differenceYear = secondYear - firstYear;
      } else {
         differenceYear = secondYear - firstYear - 1;
      }

      dayCount += (differenceYear * 365) + numberOfLeaps;

      if (compareDate(firstMonth, firstDay, secondYear, secondMonth, secondDay, secondYear) == -1) {
         for (int i = firstMonth; i < secondMonth - 1; i++) {
            dayCount += daysInMonth(i, secondYear);
         }
         // if (isLeapYear(firstYear)) {
         //    dayCount += 1;
         // }
      } else {
         for (int i = firstMonth; i < 12; i++) {
            dayCount += daysInMonth(i, secondYear);
         }
         for (int i = 1; i < secondMonth; i++) {
            dayCount += daysInMonth(i, secondYear);
         }
         // if (isLeapYear(secondYear)) {
         //    dayCount -= 1;
         // }
      }

      if (compareDate(secondMonth, firstDay, secondYear, secondMonth, secondDay, secondYear) == -1) {
         for (int i = firstDay; i < secondDay; i++) {
            dayCount += 1;
         }
      } else {
         // for (int i = firstDay; i < daysInMonth(firstMonth, firstYear); i++) {
         //    // System.out.println("6.4");
         //    dayCount += 1;
         // }
         dayCount += daysInMonth(firstMonth, firstYear) - firstDay;
         // System.out.println("6.5");
         dayCount += secondDay;
      }
   
      return dayCount;
   }
}
