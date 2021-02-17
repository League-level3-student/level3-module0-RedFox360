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

	static int toReturn[][];
	static int up;
	static int down;
	static int left;
	static int right;

	public static int[] findWrongWayCow(final char[][] field) {
		// Fill in the code to return the [col, row] coordinate position of the
		// head (letter 'c') of the wrong way cow!
		left = 0;
		right = 0;
		up = 0;
		down = 0;
		toReturn = new int[4][2];
		for (int i = 0; i < field.length; i++) {
			for (int j = 0; j < field[i].length; j++) {
				char currentChar = field[i][j];
				if (j - 2 >= 0) {
					if (currentChar == 'c' && field[i][j - 1] == 'o' && field[i][j - 2] == 'w')
						addLeft(i, j);
					if (currentChar == 'w' && field[i][j - 1] == 'o' && field[i][j - 2] == 'c')
						addRight(i, j - 2);
				}
				if (i - 2 >= 0) {
					if (currentChar == 'c' && field[i - 1][j] == 'o' && field[i - 2][j] == 'w')
						addUp(i, j);
					if (currentChar == 'w' && field[i - 1][j] == 'o' && field[i - 2][j] == 'c')
						addDown(i, j);
				}
			}
		}

		for(int i = 0; i < toReturn.length; i++) {
			for(int j = 0; j < toReturn[i].length; j++) { 
				System.out.print(toReturn[i][j] + " ");
			}
			System.out.println();
		}
		if (up == 1) {
			System.out.println("UP: " + up);
			return toReturn[0];
		} else if (down == 1) {
			System.out.println("DOWN: " +down);
			return toReturn[1];
		} else if (left == 1) {
			System.out.println("LEFT: "+left);
			return toReturn[2];
		}
		else if (right == 1) {
			System.out.println("RIGHT: "+right);
			return toReturn[3];
		} else {
			System.out.println("Reached null");
			return null;
		}
	}

	static void addLeft(int i, int j) {
		left++;
		toReturn[2][0] = j;
		toReturn[2][1] = i;
	}

	static void addRight(int i, int j) {
		right++;
		toReturn[3][0] = j;
		toReturn[3][1] = i;
	}

	static void addUp(int i, int j) {
		up++;
		toReturn[0][0] = j;
		toReturn[0][1] = i;
	}

	static void addDown(int i, int j) {
		down++;
		toReturn[1][0] = j;
		toReturn[1][1] = i-2;
	}
}
