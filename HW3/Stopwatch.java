/******************************************************************************
 * CS 210 Homework #3.
 * Author: Sangmork Park
 * Measurement of the time of operation implementation. June-3-2022
 ******************************************************************************/

package cu.cs210.hw03;

public class Stopwatch {
	private final long start;

	public Stopwatch() {
		start = System.currentTimeMillis();
	}

	public double elapsedTime() {
		long now = System.currentTimeMillis();
		return (now - start);
	}
}
