package cs210.ch00;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class FindGCD {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		System.out.println("This is the first program in CS 210");
//		System.out.println(args[0]);
//		System.out.println(args[1]);
		
/** Input data from the console */
		
/** 1. Scanner class */
//		Scanner in  = new Scanner(System.in);
		
//		int m, n, r;
//		System.out.println("Enter the first number");
//		m = in.nextInt();
//		System.out.println("Enter the second number");
//		n = in.nextInt();
//		
//		System.out.println("You entered " + m  + " and " + n + "\n");

/** 2. BufferedReader class */		
		System.out.println("Enter data: ");
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));		
		String inp = reader.readLine();
		System.out.println("You entered \"" + inp + "\"");			
	}
}
