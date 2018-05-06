/** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

 * File name  :  DynamicChangeMaker.java

 * Purpose    :  Program to represent a tuple of integers, indexed from zero

 * @author    :  Olivia Round

 * Date       :  2018-4-22

 * Description:  This program solves the general problem of making change. It takes a sequence of coin
 				 denominations as input arguments, followed by an arbitrary amount of money, and outputs
 				 the optimal way of making change for that amount using those denominations. If change
 				 cannot be made, the program outputs the message "IMPOSSIBLE."

 * Notes      :  None

 * Warnings   :  None

 *

 *  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

 * Revision History

 * ================

 *   Ver      Date     Modified by:  Reason for change or modification

 *  -----  ----------  ------------  ---------------------------------------------------------------------

 *  1.0.0  2018-04-22  Olivia Round  Initial release.

 *

 *  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */

import java.io.*;
import java.util.*;

public class DynamicChangeMaker {


	/**
   * Method to output optimum way of making change for given target amount
   * @param  int array of denominations and integer containing target amount
   * @return a tuple of the optimal combination of denominations
   * @throws IllegalArgumentException if the arguments contain bad data
   */

	public static Tuple makeChangeWithDynamicProgramming(int[] denoms, int targetCents) {

		int rowCount = denoms.length;
		int columnCount = targetCents + 1;

		Tuple[][] theTable = new Tuple[rowCount][columnCount];

		//check no zeros or negatives or repeats

		for( int i = 0; i < rowCount; i++ ) {

			if (denoms[i] <= 0 ) {

				throw new IllegalArgumentException ( "BAD DATA" );

			} 

		} 

		if ( targetCents <= 0 ) {

			throw new IllegalArgumentException ( "BAD DATA" );

		}

		for( int i = 0; i < denoms.length; i++ ) {
			for ( int j = i + 1; j < denoms.length; j++ ) {

				if( denoms[i] == denoms[j]) {

					throw new IllegalArgumentException ( "BAD DATA" );

				}

			}
		}

		//algorithm

      	for( int i = 0; i < rowCount; i++ ) {

         for( int j = 0; j < columnCount; j++ ) {

           // Special case for column zero for all rows

            if( j == 0 ) {
            	
            	theTable[i][j] = new Tuple(denoms.length);

           // Otherwise, this is NOT column zero

            } else {

            	if( j >= denoms[i] ) {

               	  	theTable[i][j] = new Tuple(denoms.length);
               	  	theTable[i][j].setElement(i, 1);

               	  	if ( (theTable[i][j - denoms[i]]).isImpossible() ) {

               	  		theTable[i][j] = Tuple.IMPOSSIBLE;

               	  	} else if (!theTable[i][j - denoms[i]].isImpossible()) {

               	  		theTable[i][j] = theTable[i][j].add(theTable[i][j - denoms[i]]);

               	  	}

               	  } else {

               	  	theTable[i][j] = Tuple.IMPOSSIBLE;

               	  }

               } 

               if ( i != 0 ) {

               	  if (!theTable[i][j].isImpossible()) {

               	  	if( theTable[i - 1][j].isImpossible()) {

               	  	} else if ( !theTable[i - 1][j].isImpossible()) {

               	  		if( theTable[i - 1][j].total() < theTable[i][j].total()) {

               	  			theTable[i][j] = theTable[i-1][j];

               	  		} else {

               	  		}

               	  	}

               	  } else {

               	  	if ( !theTable[i - 1][j].isImpossible()) {

               	  		theTable[i][j] = theTable[i - 1][j];

               	  	}

               	  }

			   }

		    }

		}

	return theTable[rowCount - 1][columnCount - 1];

}





	public static void main(String[] args) {

		String[] denomStr = args[0].split(",");

	}

}
