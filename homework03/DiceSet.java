/** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *  File name     :  DiceSet.java
 *  Purpose       :  Provides a class describing a set of dice
 *  Author        :  Olivia Round
 *  Date          :  2018-02-22
 *  Description   :  This class provides everything needed (pretty much) to describe a set of dice.  The
 *                   idea here is to have an implementing class that uses the Die.java class.  Includes
 *                   the following:
 *                   public DiceSet( int k, int n );                  // Constructor for a set of k dice each with n-sides
 *                   public int sum();                                // Returns the present sum of this set of dice
 *                   public void roll();                              // Randomly rolls all of the dice in this set
 *                   public void rollIndividual( int i );             // Randomly rolls only the ith die in this set
 *                   public int getIndividual( int i );               // Gets the value of the ith die in this set
 *                   public String toString();                        // Returns a stringy representation of this set of dice
 *                   public static String toString( DiceSet ds );     // Classwide version of the preceding instance method
 *                   public boolean isIdentical( DiceSet ds );        // Returns true iff this set is identical to the set ds
 *                   public static void main( String[] args );        // The built-in test program for this class
 *
 *  Notes         :  Stolen from Dr. Dorin pretty much verbatim, then modified to show some interesting
 *                   things about Java, and to add this header block and some JavaDoc comments.
 *  Warnings      :  None
 *  Exceptions    :  IllegalArgumentException when the number of sides or pips is out of range
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *  Revision Histor
 *  ---------------
 *            Rev      Date     Modified by:  Reason for change/modification
 *           -----  ----------  ------------  -----------------------------------------------------------
 *  @version 1.0.0  2018-02-22  Olivia Round  Finalized writing and release
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */
public class DiceSet {

  /**
   * private instance data
   */
   private int count;
   private int sides;
   private Die[] ds = null;

   // public constructor:
  /**
   * constructor
   * @param  count int value containing total dice count
   * @param  sides int value containing the number of pips on each die
   * @throws IllegalArgumentException if one or both arguments don't make sense
   * @note   parameters are checked for validity; invalid values throw "IllegalArgumentException"
   */
   public DiceSet( int count, int sides ) {
      if (count < 1) {
        throw new IllegalArgumentException("There must be at least one die.");
      }

      this.count = count;
      this.sides = sides;
      ds = new Die[ count ];

      for (int i = 0; i < count; i++) {
        ds[i] = new Die(sides);
      }
   }

  /**
   * @return the sum of all the dice values in the set
   * HOW DO YOU GET VALUES? PIPS?
   */
   public int sum() {
      int totalValue = 0;
      for (int i = 0; i < count; i++) {
        totalValue += ds[i].getValue();
      }

      return totalValue;
   }

  /**
   * Randomly rolls all of the dice in this set
   *  NOTE: you will need to use one of the "toString()" methods to obtain
   *  the values of the dice in the set
   */
   public void roll() {
      for (int i = 0; i < count; i++) {
        ds[i].roll();
      }
   }

  /**
   * Randomly rolls a single die of the dice in this set indexed by 'dieIndex'
   * @param  dieIndex int of which die to roll
   * @return the integer value of the newly rolled die
   * @trhows IllegalArgumentException if the index is out of range
   */
   public int rollIndividual( int dieIndex ) {
      if (dieIndex < 1 || dieIndex > ds.length) {
        throw new IllegalArgumentException("This is an invalid index number.");
      }

      return ds[dieIndex].roll();
   }

  /**
   * Gets the value of the die in this set indexed by 'dieIndex'
   * @param  dieIndex int of which die to roll
   * @trhows IllegalArgumentException if the index is out of range
   */
   public int getIndividual( int dieIndex ) {
      return ds[dieIndex].getValue();
   }

  /**
   * @return Public Instance method that returns a String representation of the DiceSet instance
   */
   public String toString() {
      String result = "[";
      for (int i = 0; i < count; i++) {
        result += ds[i].toString();
      }
      result += "]";
      return result;
   }

  /**
   * @return Class-wide version of the preceding instance method
   * WHAT'S THE DIFFERENCE
   */
   public static String toString( DiceSet ddss ) {
      return ddss.toString();
   }

  /**
   * @return  tru iff this set is identical to the set passed as an argument
   */
   public boolean isIdentical( DiceSet ddss ) {
      boolean[] visited = new boolean[ddss.count];
      if (ddss.count == this.count) {
        for (int i = 0; i < ds.length; i++) {
          for (int j= 0; j < ddss.count; j++) {
            if (ds[i] == ddss.ds[j]) {
              visited[j] = true;
            } 
          }
        }
        return true;
      } 
      return false;
    }
  /**
   * A little test main to check things out
   */
   public static void main( String[] args ) {

   DiceSet test = new DiceSet(4, 5);
   test.roll();
   System.out.println(test.toString());
   System.out.println(test.isIdentical(test));
   System.out.println(test.isIdentical(new DiceSet (5, 7)));
   System.out.println(test.getIndividual(3));
   
   test = new DiceSet(17, 8);
   test.roll();
   System.out.println(test.toString());
   System.out.println(test.isIdentical(test));
   System.out.println(test.isIdentical(new DiceSet (5, 7)));
   System.out.println(test.getIndividual(10));
   System.out.println(test.sum());
   System.out.println(test.rollIndividual(5));

   test = new DiceSet(1, 3);
   }

}
