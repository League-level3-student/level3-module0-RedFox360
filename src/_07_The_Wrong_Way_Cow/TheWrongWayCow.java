/*
 * https://www.codewars.com/kata/the-wrong-way-cow
 * 
 * Task
 * Given a field of cows find which one is the Wrong-Way Cow and return her
 * position.
 * 
 * Notes:
 * 
 * There are always at least 3 cows in a herd
 * There is only 1 Wrong-Way Cow!
 * Fields are rectangular
 * The cow position is zero-based [col,row] of her head (i.e. the letter c)
 * Examples
 * Ex1
 * 
 * cow.cow.cow.cow.cow
 * cow.cow.cow.cow.cow
 * cow.woc.cow.cow.cow
 * cow.cow.cow.cow.cow
 * Answer: [6,2]
 * 
 * Ex2
 * 
 * c..........
 * o...c......
 * w...o.c....
 * ....w.o....
 * ......w.cow
 * Answer: [8,4]
 * 
 * Notes
 * The test cases will NOT test any situations where there are "imaginary" cows,
 * so your solution does not need to worry about such things!
 * 
 * To explain - Yes, I recognize that there are certain configurations where an
 * "imaginary" cow may appear that in fact is just made of three other "real" cows.
 * 
 * In the following field you can see there are 4 real cows (3 are facing south and
 * 1 is facing north). There are also 2 imaginary cows (facing east and west). 
 * 
 * ...w...
 * ..cow..  
 * .woco..
 * .ow.c..
 * .c.....
*/

package _07_The_Wrong_Way_Cow;

public class TheWrongWayCow {

	public static int[] findWrongWayCow(final char[][] field) {
		// Fill in the code to return the [col, row] coordinate position of the
		// head (letter 'c') of the wrong way cow!
		int[] toReturn = new int[2];
		int up = 0;
		int down = 0;
		int left = 0;
		int right = 0;
		for (int i = 0; i < field.length; i++) {
			String s = "HELLO";
			for (int j = 0; j < field[i].length; j++) {
				char currentChar = field[i][j];
				if (j - 1 > 0) {
					if (currentChar == 'c' && field[i][j - 1] == 'o' && field[i][j - 2] == 'w')
						left++;
					else if (currentChar == 'w' && field[i][j - 1] == 'o' && field[i][j - 2] == 'c')
						right++;
//					else if (currentChar == 'c' && field[i - 1][j] == 'o' && field[i - 2][j] == 'w')
//						up++;
//					else if (currentChar == 'w' && field[i - 1][j] == 'o' && field[i - 2][j] == 'c')
//						down++;
				} else if (j - 1 < 0) {
					char second = field[i-1][field[i].length - 1];
					char third = field[i-1][field[i].length - 2];
					if (currentChar == 'c' && second == 'o' && third == 'w') left++;
					else if (currentChar == 'w' && second == 'o' && third == 'c') right++;
				} else {
					char second = field[i][j-1];
					char third = field[i-1][field[i].length - 1];
					if (currentChar == 'c' && second == 'o' && third == 'w') left++;
					else if (currentChar == 'w' && second == 'o' && third == 'c') right++;
				}

				if (left == 1 || right == 1 || up == 1 || down == 1) {
					toReturn[0] = i;
					toReturn[1] = j;
				}
			}
		}
		return toReturn;
	}
}
