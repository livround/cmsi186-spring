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

   private boolean negative;

  /**
   *  Constructor takes a string and assigns it to the internal storage, checks for a sign character
   *   and handles that accordingly;  it then checks to see if it's all valid digits, and reverses it
   *   for later use
   *  @param  value  String value to make into a BrobInt
   */

   public BrobInt( String value ) {



    if(value.charAt(0) == '-') {
      negative = true;
      value = value.substring(1);
    }

    while (value.charAt(0) == '0' && value.length() > 1)
      value = value.substring(1);

    internalValue = value;

    int size = value.length();
    intArray = new int[size];

    int x = 0;
    for (int i = size - 1; i >= 0; i--) {
      intArray[i] = value.charAt(x) - 48;
      x++;
    }

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

   /**public BrobInt reverser() {

      String original = "";    
      String reversed = new StringBuilder(original).reverse().toString();

      return new BrobInt(reversed); 

   }*/



  /** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

   *  Method to reverse the value of a BrobInt passed as argument

   *  Note: static method

   *  @param  gint         BrobInt to reverse its value

   *  @return BrobInt that is the reverse of the value of the BrobInt passed as argument

   * NOTE: assumes that the BrobInt being passed is in proper order

   *  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */

   /**public static BrobInt reverser( BrobInt gint ) {

    System.out.println(gint.toString());


     String original = gint.toString();    
     String reversed = new StringBuilder(original).reverse().toString();

     return new BrobInt(reversed);

   } */


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
    int length2 = this.getLength();
    int[] array1 = gint.getArray();
    int sum[];
    int carry = 0;

    if(!this.isNegative() && gint.isNegative()) {
      BrobInt tempA = new BrobInt(this.toString());
      BrobInt tempB = new BrobInt(gint.toString());
      tempB.makePositive();
      return tempA.subtract(tempB);
    }

    if(this.isNegative() && !gint.isNegative()) {
      BrobInt tempA = new BrobInt(this.toString());
      BrobInt tempB = new BrobInt(gint.toString());
      tempA.makePositive();
      return tempA.subtract(tempB);
    }


    if (length1 > length2) {
      sum = new int[length1 + 1];
      for (int i = 0; i < length2; i++){
        sum[i] = array1[i] + intArray[i] + carry;
        carry = sum[i] / 10;
        sum[i] = sum[i] % 10;
      }
      for (int i = length2; i < length1; i++){
        sum[i] = array1[i] + carry;
        carry = sum[i] / 10;
        sum[i] = sum[i] % 10;
      }
      sum[sum.length - 1] = carry;
    }

    else if (length1 < length2) {
      sum = new int[length2 + 1];
      for (int i = 0; i < length1; i++){
        sum[i] = array1[i] + intArray[i] + carry;
        carry = sum[i] / 10;
        sum[i] = sum[i] % 10;
      }
      for (int i = length1; i < length2; i++){
        sum[i] = intArray[i] + carry;
        carry = sum[i] / 10;
        sum[i] = sum[i] % 10;
      }
      sum[sum.length - 1] = carry;
    }

    else {
      sum = new int[length2 + 1];
      for (int i = 0; i < length1; i++){
        sum[i] = array1[i] + intArray[i] + carry;
        carry = sum[i] / 10;
        sum[i] = sum[i] % 10;
      }
      sum[sum.length - 1] = carry;
    }

    if(this.isNegative() && gint.isNegative()) {
      String value = "-";
      for (int i = sum.length - 1; i >= 0; i--)
        value += sum[i];
      return new BrobInt(value);
    }

    String value = "";
    for (int i = sum.length - 1; i >= 0; i--)
      value += sum[i];
    return new BrobInt(value);
  }




  /** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

   *  Method to subtract the value of a BrobIntk passed as argument to this BrobInt using int array

   *  @param  gint         BrobInt to subtract from this

   *  @return BrobInt that is the difference of the value of this BrobInt and the one passed in

   *  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */

   public BrobInt subtract( BrobInt gint ) {

    //test code is only for bytes and not ints

    int length1 = gint.getLength();
    int length2 = this.getLength();
    int[] array1 = gint.getArray();
    int difference[];

    if(!this.isNegative() && gint.isNegative()) {
      BrobInt tempA = new BrobInt(this.toString());
      BrobInt tempB = new BrobInt(gint.toString());
      tempB.makePositive();
      return tempA.add(tempB);
    }

    if(this.isNegative() && !gint.isNegative()) {
      BrobInt tempA = new BrobInt(this.toString());
      BrobInt tempB = new BrobInt(gint.toString());
      tempB.makeNegative();
      return tempA.add(tempB);
    }

    if(this.isNegative() && gint.isNegative()) {
        BrobInt tempA = new BrobInt(this.toString());
        BrobInt tempB = new BrobInt(gint.toString());
        tempA.makePositive();
        tempB.makePositive();
        return tempB.subtract(tempA);
    }

    //System.out.println("this: " + this.isNegative() + "gint: " + gint.isNegative() + "length1 > length2: " + (length1 > length2));
    if(this.isNegative() && !gint.isNegative() && length1 > length2) {
      this.makePositive();
      difference = new int[length1];
      for(int i = 0; i < length2; i++) {
        difference[i] = array1[i] - intArray[i];
        if(difference[i] < 0 ) {
          array1[i+1]--;
          difference[i] = (array1[i] + 10) - intArray[i];
        }

      }
      for(int i = length2; i < length1; i++) {
        difference[i] = array1[i];
         if(difference[i] < 0 ) {
          array1[i+1]--;
          difference[i] = (array1[i] + 10);
        }
      }
      String value = "";
      for (int i = difference.length - 1; i >= 0; i--)
        value += difference[i];
      return new BrobInt(value);
    }

    if(length1 > length2) {
      difference = new int[length1];
      for(int i = 0; i < length2; i++) {
        difference[i] = array1[i] - intArray[i];
        if(difference[i] < 0 ) {
          array1[i+1]--;
          difference[i] = (array1[i] + 10) - intArray[i];
        }

      }
      for(int i = length2; i < length1; i++) {
        difference[i] = array1[i];
          if(difference[i] < 0 ) {
            array1[i+1]--;
            difference[i] = (array1[i] + 10);
          }
      }
      String value = "-";
      for (int i = difference.length - 1; i >= 0; i--)
        value += difference[i];
      return new BrobInt(value);
    }

    else if (length2 > length1) {
      difference = new int[length2];
      for(int i = 0; i < length1; i++) {
        difference[i] = intArray[i] - array1[i];
        if(difference[i] < 0 ) {
          intArray[i+1]--;
          difference[i] = (intArray[i] + 10) - array1[i];
        }

      }
      for(int i = length1; i < length2; i++) {
        difference[i] = intArray[i];
        if(difference[i] < 0 ) {
          intArray[i+1]--;
          difference[i] = (intArray[i] + 10);
        }
      }
      String value = "";
      for (int i = difference.length - 1; i >= 0; i--)
        value += difference[i];
      return new BrobInt(value);
    } 

    else {
      difference = new int[length2];
      if(gint.compareTo(this) > 0) {
        for(int i = 0; i < length1; i++) {
          difference[i] = array1[i] - intArray[i];
          if(difference[i] < 0 ) {
            array1[i+1]--;
            difference[i] = (array1[i] + 10) - intArray[i];
          }
        }
        String value = "-";
        for (int i = difference.length - 1; i >= 0; i--)
          value += difference[i];
        return new BrobInt(value);
      }

      if(gint.compareTo(this) < 0) {
        for(int i = 0; i < length1; i++) {
          difference[i] = intArray[i] - array1[i];
          if(difference[i] < 0 ) {
            intArray[i+1]--;
            difference[i] = (intArray[i] + 10) - array1[i];
          }
        }

        String value = "";
        for (int i = difference.length - 1; i >= 0; i--)
          value += difference[i];
        return new BrobInt(value);

      } else {
        return new BrobInt("0");
      }
    }
  }


  /** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

   *  Method to multiply the value of a BrobIntk passed as argument to this BrobInt

   *  @param  gint         BrobInt to multiply by this

   *  @return BrobInt that is the product of the value of this BrobInt and the one passed in

   * four arrays: carry, i, j, k

   *  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */

   public BrobInt multiply( BrobInt gint ) {

    //put the arrays back in normal order
    //hal

    throw new UnsupportedOperationException( "\n         Sorry, that operation is not yet implemented." );

   }



  /** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

   *  Method to divide the value of this BrobIntk by the BrobInt passed as argument

   *  @param  gint         BrobInt to divide this by

   *  @return BrobInt that is the dividend of this BrobInt divided by the one passed in

   *  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */

   public BrobInt divide( BrobInt gint ) {

    int length1 = gint.getLength();
    int length2 = this.getLength();
    int[] array1 = new int[length1]; //gint
    int[] array2 = new int[length2]; //this

    if(this.compareTo(gint) == -1) {
      return new BrobInt("0");
    } 

    if(this.compareTo(gint) == 0) {
      return new BrobInt("1");
    }


    int[] quotient = new int[length2];
    String d3 = ""; 
    int count = 0;
    int index = 0;

    try {
      for(int i = 0; i < length2; i++) {
        d3 += internalValue.charAt(i);
        BrobInt temp = new BrobInt(d3);
        count = 0;
    
        if (this.compareTo(temp) <= 0) {
          while (gint.compareTo(temp) <= 0) {
            temp = temp.subtract(gint);
            count++;
            index = i;
          }
        }

        else

          count = 0;

        d3 = temp.toString();
        
        if(d3.charAt(0) == '0')
          d3 = d3.substring(1);
        quotient[i] = count;
      }
    }

    catch(IndexOutOfBoundsException e) {
      if(d3.charAt(0) == '0')
        d3 = d3.substring(1);
      quotient[index] = count;
    };


    String quotientString = "";
    for(int y : quotient) {
      quotientString += y;
    }

    return new BrobInt(quotientString);
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

      NOTE: this compareTo method works for my code because we only call it when the two BrobInts are the same length. 

            further, compareTo is not called when the values are integer.

   *  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */

   public int compareTo( BrobInt gint ) {

    //-1 if gint is bigger and 1 if this is bigger, 0 if they are the same

      if(this.isNegative() && !gint.isNegative()) 
        return -1;
      else if(!this.isNegative() && gint.isNegative()) 
        return 1;

      if(this.isNegative() && gint.isNegative() && this.getLength() > gint.getLength()) 
        return -1;
      if(this.isNegative() && gint.isNegative() && this.getLength() < gint.getLength())
        return 1;

      if(!this.isNegative() && !gint.isNegative() && this.getLength() > gint.getLength())
        return 1;
      if(!this.isNegative() && !gint.isNegative() && this.getLength() < gint.getLength())
        return -1;

      if(this.isNegative() && gint.isNegative() && this.getLength() == gint.getLength()) {
        for (int i = 0; i < gint.getLength(); i++) {
          if(this.toString().charAt(i) > gint.toString().charAt(i)) {
            return -1;
          } else if(this.toString().charAt(i) < gint.toString().charAt(i)) {
            return 1;
          }
        }
      }


      if(!this.isNegative() && !gint.isNegative() && this.getLength() == gint.getLength()) {
          for (int i = 0; i < gint.getLength(); i++) {
            if(this.toString().charAt(i) > gint.toString().charAt(i)) {
              return 1;
            } else if(this.toString().charAt(i) < gint.toString().charAt(i)) {
              return -1;
            }
          }
      }
  
      return 0;

   }

   public boolean isNegative() {

    return negative;

   }

   public void isPositive() {

    negative = false;

   }

   public void makePositive() {

    negative = false;

   }

   public void makeNegative() {

    negative = true;

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

    if(internalValue.charAt(0) == '0' && internalValue.length() > 1)
      internalValue = internalValue.substring(1);

    if(this.isNegative()) 
      return "-" + internalValue;

    return internalValue;
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
