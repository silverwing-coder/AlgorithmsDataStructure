package HW1;
/**
 * CS 210 class Homework #1. Receive two numbers, and find the GCD of the two
 * numbers. Created by Sangmork Park. 2022-May-20.
 */

//package cs210.hw01;

public class FindGcd {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// int lo = 1000;
		// int hi = 2000;

		int lo = Integer.parseInt(args[0]);
		int hi = Integer.parseInt(args[1]);

		/**
		 * If the first input number is greater than the second one, swap the two
		 * numbers
		 */
		if (lo > hi) {
			int tmp = lo;
			lo = hi;
			hi = tmp;
		}

		int gcd = 1;
		for (int i = 2; i < (hi / 2); i++) {
			if (((lo % i) == 0) && ((hi % i) == 0)) {
				gcd = i;
			}

			/** In case: low number is less than half of high number */
			if (i >= lo) {
				break;
			}

		}
		System.out.println("gcd of " + lo + " and " + hi + " is " + gcd);
	}

}
