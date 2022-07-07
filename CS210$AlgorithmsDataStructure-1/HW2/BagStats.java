package cu.cs210.hw02;

/******************************************************************************
 * CS 210 Homework #2.
 * Author: Sangmork Park
 * A BagStats: print out mean and standard deviation value. May-27-2022
 ******************************************************************************/

public class BagStats {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		System.out.println("BagStat implementation for calculating mean and standard deviation.\nEnter data.");
		Bag<Double> bag = new Bag<Double>();

		/** Test data set */
		double[] data = { 34, 45, 33, 56, 67, 48, 30, 29, 42, 46 };
		for (int i = 0; i < data.length; i++) {
			bag.add(data[i]);
		}

		/*
		 * Scanner inp = new Scanner(System.in); while (true) { String data =
		 * inp.nextLine();
		 * 
		 * // if (data.length() == 0) { if (data.strip().equals("q")) {// At the end of
		 * data input, enter "q" break; } double dt = Double.parseDouble(data);
		 * bag.add(dt); // System.out.println("added : " + dt); }
		 */

		double sum = 0;
		for (Double s : bag) {
			sum += s;
		}
		double mean = sum / bag.size();
		double dev = 0;

		for (Double s : bag) {
			dev += (s - mean) * (s - mean);
		}
		double stdev = Math.sqrt(dev);
		System.out.printf("Mean of data:%.2f", mean);
		System.out.printf("\nStandard deviation:%.2f", stdev);

	}

}
