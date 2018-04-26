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

//check validity in theTable or check it beforehand?
	Tuple denoms = Tuple.IMPOSSIBLE;

	public 

	public Tuple makeChangeWithDynamicProgramming(String[] denominations, String targetCents) {

		int rows = denominations.length;
		int columns = Integer.parseInt(targetCents + 1);

		Tuple[][] theTable = new Tuple[rows][columns];

//when to use t[i][j-denoms[i]]
		for(int i = 0; i < rows; i ++) {
			for(int j = 0; j < columns; j++) {
				//if denoms[i] > columns[i] than = IMPOSSIBLE
			}
		}

		new Tuple optimalChange;

		return optimalChange;

	}

	public static void main(String[] args) {

		String[] denomStr = args[0].split(",");

	}

}
