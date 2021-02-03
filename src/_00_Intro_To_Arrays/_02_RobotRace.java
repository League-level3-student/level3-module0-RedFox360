package _00_Intro_To_Arrays;

import java.util.Random;

import javax.swing.JOptionPane;

import org.jointheleague.graphical.robot.Robot;

public class _02_RobotRace {
	// 1. make a main method
	public static void main(String[] args) {
		// 2. create an array of 5 robots.
		Robot[] r = new Robot[5];
		// 3. use a for loop to initialize the robots.
		int x = 100;
		for (int i = 0; i < r.length; i++) {
			r[i] = new Robot("mini");
			r[i].setY(550);
			r[i].setSpeed(20);
			r[i].setX(x);
			x += 180;
		}
		// 4. make each robot start at the bottom of the screen, side by side, facing up
		// 5. use another for loop to iterate through the array and make each robot move
		// a random amount less than 50.
		boolean raceOver = false;
		int winner = -1;
		while(raceOver == false) {
			for(int i = 0; i < r.length; i++) {
				if (r[i].getY() < 0) {
					raceOver = true;
					winner = i;
				} else {
					r[i].move(new Random().nextInt(50));
				}
			}
		}
		System.out.println("Robot " + winner + " has won the race!");
		// 6. use a while loop to repeat step 5 until a robot has reached the top of the
		// screen.

		// 7. declare that robot the winner and throw it a party!

		// 8. try different races with different amounts of robots.

		// 9. make the robots race around a circular track.
	}
}
