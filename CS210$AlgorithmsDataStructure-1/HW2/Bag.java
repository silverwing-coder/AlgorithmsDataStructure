package cu.cs210.hw02;

/******************************************************************************
 * CS 210 Homework #2.
 * Author: Sangmork Park
 * A Bag data structure implementation. May-27-2022
 ******************************************************************************/

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Bag<T> implements Iterable<T> {
	private Node<T> first; // beginning of bag
	private int n; // number of elements in bag

	private static class Node<T> {
		private T data;
		private Node<T> next;
	}

	public Bag() {
		first = null;
		n = 0;
	}

	public boolean isEmpty() {
		return first == null;
	}

	public int size() {
		return n;
	}

	public void add(T data) {
		Node<T> oldfirst = first;
		first = new Node<T>();
		first.data = data;
		first.next = oldfirst;
		n++;
	}

	@Override
	public Iterator<T> iterator() {
		return new LinkedIterator(first);
	}

	private class LinkedIterator implements Iterator<T> {
		private Node<T> current;

		public LinkedIterator(Node<T> first) {
			current = first;
		}

		@Override
		public boolean hasNext() {
			return current != null;
		}

		@Override
		public void remove() { // will not use
			throw new UnsupportedOperationException();
		}

		@Override
		public T next() {
			if (!hasNext()) {
				throw new NoSuchElementException();
			}
			T data = current.data;
			current = current.next;
			return data;
		}
	}

	/**
	 * Test code: print out add() data
	 */
	public static void main(String[] args) {
		System.out.println("Bag implementation and Test.\nEnter data.");
		Bag<Double> bag = new Bag<Double>();

		Scanner inp = new Scanner(System.in);
		while (true) {
			String data = inp.nextLine();

			// if (data.length() == 0) {
			if (data.strip().equals("q")) {// If you want to stop program, enter "q"
				break;
			}
			double dt = Double.parseDouble(data);
			bag.add(dt);
			System.out.println("added : " + dt);
		}

		System.out.println("\nEnd of input.\nSize of bag = " + bag.size());
		System.out.print("Contents of bag: ");
		for (Double s : bag) {
			System.out.print(s + ", ");
		}
	}
}
