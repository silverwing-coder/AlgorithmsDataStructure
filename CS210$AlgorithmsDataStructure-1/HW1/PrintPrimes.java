package HW1;
/**
 * CS 210 class Homework #1.
 * Receive two numbers, and find all the prime numbers between the two numbers.
 * Created by Sangmork Park. 2022-May-20.
 * */

// package cs210.hw01;

public class PrintPrimes {

	public static boolean isPrime(int n) {

		for (int i = 2; i < (n / 2); i++) {
			if ((n % i) == 0) {
				return false;
			}
		}

		return true;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

//		int lo = 1000;
//		int hi = 2000;

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

		int cnt = 0;

		for (int i = lo; i < (hi + 1); i++) {
			if (isPrime(i)) {
				System.out.printf("%10d", i);
				cnt++;
				/** Print a new line after 5 prime numbers are printed */
				if ((cnt % 5) == 0) {
					System.out.println();
					cnt = 0;
				}
			}
		}

	}

}