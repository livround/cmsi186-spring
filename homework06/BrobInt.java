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

import java.util.Arrays;



public class BrobInt {



   public static final BrobInt ZERO     = new BrobInt(  "0" );      /// Constant for "zero"

   public static final BrobInt ONE      = new BrobInt(  "1" );      /// Constant for "one"

   public static final BrobInt TWO      = new BrobInt(  "2" );      /// Constant for "two"

   public static final BrobInt THREE    = new BrobInt(  "3" );      /// Constant for "three"

   public static final BrobInt FOUR     = new BrobInt(  "4" );      /// Constant for "four"

   public static final BrobInt FIVE     = new BrobInt(  "5" );      /// Constant for "five"

   public static final BrobInt SIX      = new BrobInt(  "6" );      /// Constant for "six"

   public static final BrobInt SEVEN    = new BrobInt(  "7" );      /// Constant for "seven"

   public static final BrobInt EIGHT    = new BrobInt(  "8" );      /// Constant for "eight"

   public static final BrobInt NINE     = new BrobInt(  "9" );      /// Constant for "nine"

   public static final BrobInt TEN      = new BrobInt( "10" );      /// Constant for "ten"



  /// Some constants for other intrinsic data types

  ///  these can help speed up the math if they fit into the proper memory space

   public static final int CHARS_THAT_FIT = 6;

   private int[] intArray = null;

   private int[] resultArray = null;


   /**public static final BrobInt MAX_INT  = new BrobInt( new Integer( Integer.MAX_VALUE ).toString() );

   public static final BrobInt MIN_INT  = new BrobInt( new Integer( Integer.MIN_VALUE ).toString() );

   public static final BrobInt MAX_LONG = new BrobInt( new Long( Long.MAX_VALUE ).toString() );

   public static final BrobInt MIN_LONG = new BrobInt( new Long( Long.MIN_VALUE ).toString() );
   */



  /// These are the internal fields

   private String internalValue = "";        // internal String representation of this BrobInt

   private String reversed      = "";        // the backwards version of the internal String representation



  /**
   *  Constructor takes a string and assigns it to the internal storage, checks for a sign character
   *   and handles that accordingly;  it then checks to see if it's all valid digits, and reverses it
   *   for later use
   *  @param  value  String value to make into a BrobInt
   */

   public BrobInt( String value ) {

      int i = 0;
      int length = value.length();
      int start = length - CHARS_THAT_FIT;
      int size = (int)(Math.ceil(length / CHARS_THAT_FIT) + 1);
      intArray = new int[size];
      //StringBuffer sb = new StringBuffer();
      System.out.println("value: " + value);
      System.out.println("length: " + length + " start: " + start);
      while( length >= CHARS_THAT_FIT ) {
        //split into the sections of 6
        intArray[i] = Integer.parseInt(value.substring(start, length));
        length -= CHARS_THAT_FIT;
        start -= CHARS_THAT_FIT;
        i++;
      }
      if( length > 0 ) {
        //handle whatever is left over
        intArray[i] = Integer.parseInt(value.substring(0, length));
      }     
      toArray(intArray);

   }



  /** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

   *  Method to validate that all the characters in the value are valid decimal digits

   *  @return  boolean  true if all digits are good

   *  @throws  IllegalArgumentException if something is hinky

   *  note that there is no return false, because of throwing the exception

   *  note also that this must check for the '+' and '-' sign digits

   *  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */

   public boolean validateDigits( String value ) {

      try {
        double d = Double.parseDouble( value );
      }
      catch(NumberFormatException nfe) {
        return false;
      }
      return true;
   }



  /** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

   *  Method to reverse the value of this BrobInt

   *  @return BrobInt that is the reverse of the value of this BrobInt

   *  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */

   public BrobInt reverser() {

      String original = "";    
      String reversed = new StringBuilder(original).reverse().toString();

      return new BrobInt(reversed); 

   }



  /** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

   *  Method to reverse the value of a BrobInt passed as argument

   *  Note: static method

   *  @param  gint         BrobInt to reverse its value

   *  @return BrobInt that is the reverse of the value of the BrobInt passed as argument

   * NOTE: assumes that the BrobInt being passed is in proper order

   *  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */

   public static BrobInt reverser( BrobInt gint ) {

    System.out.println(gint.toString());


     String original = gint.toString();    
     String reversed = new StringBuilder(original).reverse().toString();

     return new BrobInt(reversed);

   }


   public int getLength() {

    return intArray.length;

   }

   public int[] getArray() {
    return intArray;
   }

  /** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

   *  Method to add the value of a BrobIntk passed as argument to this BrobInt using int array

   *  @param  gint         BrobInt to add to this

   *  @return BrobInt that is the sum of the value of this BrobInt and the one passed in

   *  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */

   public BrobInt add( BrobInt gint ) {

    int length1 = gint.getLength();
    int length2 = intArray.length;
    int sumArray[];
    int carry = 0;
    int gintArray[] = gint.getArray();

    if(length1 >= length2) {

      sumArray = new int[length1];

      for (int i = 0; i < sumArray.length; i++) {

        sumArray[i] = gintArray[i] + intArray[i] + carry;

        System.out.println("sumArray: " + sumArray[i]);
        System.out.println("gintArray: " + gintArray[i]);
        System.out.println("intArray: " + intArray[i]);

        if (sumArray[i] > 999999) {

        carry = sumArray[i] / 1000000;
        sumArray[i] = sumArray[i] % 1000000;

        }

      }

      for (int j = length2; j < length1; j++) {

        sumArray[j] = gintArray[j];

      } 

    } else {

      sumArray = new int[length2];

      for (int i = 0; i < sumArray.length; i++) {

          sumArray[i] = gintArray[i] + intArray[i] + carry;

          System.out.println("sumArray: " + sumArray[i]);
          System.out.println("gintArray: " + gintArray[i]);
          System.out.println("intArray: " + intArray[i]);

           if (sumArray[i] > 999999) {

            carry = sumArray[i] / 1000000;
            sumArray[i] = sumArray[i] % 1000000;

           }

           for (int j = length2; j < length1; j++) {
            
            sumArray[j] = gintArray[j];

           } 

       } 
    /**for (int i = 0; i < sumArray.length; i++) {

      sumArray[i] = gintArray[i] + intArray[i] + carry;

      if (sumArray[i] > 9) {

        carry = sumArray[i] / 1000000;
        sumArray[i] = sumArray[i] % 1000000;

      } */

    } 

    String sum = "";

    for (int i = 0; i < sumArray.length; i++) {
      String sumString = Integer.toString(sumArray[i]);

      sum += sumString;

    }

    return new BrobInt(sum);

   }



  /** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

   *  Method to subtract the value of a BrobIntk passed as argument to this BrobInt using int array

   *  @param  gint         BrobInt to subtract from this

   *  @return BrobInt that is the difference of the value of this BrobInt and the one passed in

   *  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */

   public BrobInt subtract( BrobInt gint ) {

    int length1 = gint.getLength();
    int length2 = intArray.length;
    int sumArray[];
    int carry = 0;
    int gintArray[] = gint.getArray();

    

      throw new UnsupportedOperationException( "\n         Sorry, that operation is not yet implemented." );

   }



  /** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

   *  Method to multiply the value of a BrobIntk passed as argument to this BrobInt

   *  @param  gint         BrobInt to multiply by this

   *  @return BrobInt that is the product of the value of this BrobInt and the one passed in

   * four arrays: carry, i, j, k

   *  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */

   public BrobInt multiply( BrobInt gint ) {



      throw new UnsupportedOperationException( "\n         Sorry, that operation is not yet implemented." );

   }



  /** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

   *  Method to divide the value of this BrobIntk by the BrobInt passed as argument

   *  @param  gint         BrobInt to divide this by

   *  @return BrobInt that is the dividend of this BrobInt divided by the one passed in

   *  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */

   public BrobInt divide( BrobInt gint ) {

      throw new UnsupportedOperationException( "\n         Sorry, that operation is not yet implemented." );

   }



  /** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

   *  Method to get the remainder of division of this BrobInt by the one passed as argument

   *  @param  gint         BrobInt to divide this one by

   *  @return BrobInt that is the remainder of division of this BrobInt by the one passed in

   *  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */

   public BrobInt remainder( BrobInt gint ) {

       throw new UnsupportedOperationException( "\n         Sorry, that operation is not yet implemented." );     

   }



  /** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

   *  Method to compare a BrobInt passed as argument to this BrobInt

   *  @param  gint  BrobInt to add to this

   *  @return int   that is one of neg/0/pos if this BrobInt precedes/equals/follows the argument

   *  NOTE: this method performs a lexicographical comparison using the java String "compareTo()" method

   *        THAT was easy.....

   *  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */

   public int compareTo( BrobInt gint ) {

      return (internalValue.compareTo( gint.toString() )); //done

   }



  /** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

   *  Method to check if a BrobInt passed as argument is equal to this BrobInt

   *  @param  gint     BrobInt to compare to this

   *  @return boolean  that is true if they are equal and false otherwise

   *  NOTE: this method performs a similar lexicographical comparison as the "compareTo()" method above

   *        also using the java String "equals()" method -- THAT was easy, too..........

   *  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */

   public boolean equals( BrobInt gint ) {

      return (internalValue.equals( gint.toString() ));

   }



  /** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

   *  Method to return a BrobInt given a long value passed as argument

   *  @param  value         long type number to make into a BrobInt

   *  @return BrobInt  which is the BrobInt representation of the long

   *  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */

   public static BrobInt valueOf( long value ) throws NumberFormatException {

      BrobInt gi = null;

      try {

         gi = new BrobInt( new Long( value ).toString() );

      }

      catch( NumberFormatException nfe ) {

         System.out.println( "\n  Sorry, the value must be numeric of type long." );

      }

      return gi;

   }



  /** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

   *  Method to return a String representation of this BrobInt

   *  @return String  which is the String representation of this BrobInt

   *  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */

   public String toString() {

      String output = "";

      for( int i = intArray.length - 1; i >= 0; i-- ) {

         String blah = new String(Integer.valueOf(intArray[i]).toString());

         if (blah.length() < 6) {

            while (blah.length() < 6) {

                blah = "0" + blah;

            }
            System.out.println("blah: " + blah);
            output += blah;
         } else {
         
         output = output.concat( Integer.toString( intArray[i] ) );

         }

      }

      while (output.charAt(0) == '0' && output.length() > 1) {
        output = output.substring(1, output.length());
      }
      return output;
    //parse out the leading 0's

   }



  /** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

   *  Method to display an Array representation of this BrobInt as its bytes

   *  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */

   public void toArray( int[] d ) {

      System.out.println( Arrays.toString( d ) ); //done

   }



  /** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

   *  the main method redirects the user to the test class

   *  @param  args  String array which contains command line arguments

   *  note:  we don't really care about these

   *  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */

   public static void main( String[] args ) {

      System.out.println( "\n  Hello, world, from the BrobInt program!!\n" );

      System.out.println( "\n   You should run your tests from the BrobIntTester...\n" );


      System.exit( 0 );

   }

}
