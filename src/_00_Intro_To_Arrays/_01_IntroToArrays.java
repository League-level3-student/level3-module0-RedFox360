package _00_Intro_To_Arrays;

import java.util.Iterator;
import java.util.Random;

public class _01_IntroToArrays {
    public static void main(String[] args) {
        // 1. declare and Initialize an array 5 Strings
    	String[] arr = {"Java", "Python", "C++", "C", "Swift"};
        // 2. print the third element in the array
    	System.out.println(arr[2]);
        // 3. set the third element to a different value
    	arr[2] = "Ruby";
        // 4. print the third element again
    	System.out.println(arr[2]);
        // 5. use a for loop to set all the elements in the array to a string
        //    of your choice
    	for(int i = 0; i < arr.length; i++) {
    		arr[i] = "Java is the best!";
    	}
        // 6. use a for loop to print all the values in the array
        //    BE SURE TO USE THE ARRAY'S length VARIABLE
    	for(String s : arr) {
    		System.out.println(s);
    	}
        // 7. make an array of 50 integers
    	int[] fiftyInts = new int[50];
        // 8. use a for loop to make every value of the integer array a random
        //    number
    	for(int i = 0; i < fiftyInts.length; i++) {
    		fiftyInts[i] = new Random().nextInt(100 - 1 + 1) + 1;
    	}
        // 9. without printing the entire array, print only the smallest number
        //    on the array
    	int smallestNumber = fiftyInts[0];
    	for(int currentNumber: fiftyInts) {
    		if (currentNumber < smallestNumber)
    			smallestNumber = currentNumber;
    	}
    	System.out.println(smallestNumber);
        // 10 print the entire array to see if step 8 was correct
    	for(int number: fiftyInts) {
    		System.out.println(number);
    	}
        // 11. print the largest number in the array.
    	int largestNumber = fiftyInts[0];
    	for(int currentNumber: fiftyInts) {
    		if (currentNumber > largestNumber)
    			largestNumber = currentNumber;
    	}
        // 12. print only the last element in the array
    	System.out.println(fiftyInts[fiftyInts.length - 1]);
    }
}
