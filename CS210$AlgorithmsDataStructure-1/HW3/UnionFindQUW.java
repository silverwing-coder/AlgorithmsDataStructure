/******************************************************************************
 * CS 210 Homework #3.
 * Author: Sangmork Park
 * QuickUnion with weighted tree algorithm implementation. June-3-2022
 ******************************************************************************/
package cu.cs210.hw03;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class UnionFindQUW {

	private int[] id;
	private int[] sz;
	private int count;

	public UnionFindQUW(int n) { // constructor() initializes number of sets = n, set id = itself
		count = n;
		id = new int[n];
		sz = new int[n];
		for (int i = 0; i < n; i++) {
			id[i] = i;
			sz[i] = 1;
		}
	}

	public int count() { // return number of sets
		return count;
	}

	public boolean connected(int p, int q) { // check if two objects are connected
		return (find(p) == find(q));
	}

	public int find(int p) { // return set id of an object
		while (p != id[p]) {
			p = id[p];
		}
		return p;
	}

	public void union(int p, int q) { // union two sets
		int pID = find(p);
		int qID = find(q);

		if (pID == qID) {
			return;
		}

		if (sz[pID] < sz[qID]) {

			id[pID] = q;
			sz[qID] += sz[pID];
		} else {
			id[qID] = p;
			sz[pID] += sz[qID];
		}

		count--;
	}

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub

//		String fname = "data/sec1$5/tinyUF.txt";
//		String fname = "data/sec1$5/mediumUF.txt";
//		String fname = "data/sec1$5/largeUF.txt";
		String fname = "data/sec1$5/s100000UF.txt";

		Scanner dinput = new Scanner(new File(fname));
		int n = dinput.nextInt();
		System.out.println("Quick Union with Weighted Tree.");
		System.out.println("data size(n): " + n); // printout initial number of sets == data size

		UnionFindQF uf = new UnionFindQF(n);

		Stopwatch wa = new Stopwatch();
		while (dinput.hasNext()) {
			int p = dinput.nextInt();
			int q = dinput.nextInt();
			if (uf.connected(p, q)) {
				continue;
			}

			uf.union(p, q);

//			System.out.println(p + "   " + q);
		}
		double et = wa.elapsedTime();
		System.out.println("time of operation: " + et + " mili-seconds");
		System.out.println(uf.count() + " components(sets) left.");
	}

}
