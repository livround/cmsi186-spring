/** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *  File name     :  CountTheDays.java
 *  Purpose       :  Echos the arguments from the command line one at a time on individual lines
 *  Author        :  Olivia Round
 *  Date          :  2018-01-25
 *  Description   :  
 *  Notes         :  None
 *  Warnings      :  None
 *  Exceptions    :  None
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *  Revision Histor
 *  ---------------
 *            Rev      Date     Modified by:  Reason for change/modification
 *           -----  ----------  ------------  -----------------------------------------------------------
 *  @version 1.0.0  2018-01-18  Olivia Round  Initial writing and release
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */

public class CountTheDays {
   public static void main(String[] args) {
      int month1 = Integer.parseInt(args[0]);
      int day1 = Integer.parseInt(args[1]);
      int year1 = Integer.parseInt(args[2]);
      int month2 = Integer.parseInt(args[3]);
      int day2 = Integer.parseInt(args[4]);
      int year2 = Integer.parseInt(args[5]);
      CalendarStuff.daysBetween(month1, day1, year1, month2, day2, year2);
   }
}
