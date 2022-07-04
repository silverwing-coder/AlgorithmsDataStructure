// package cu.cs210.hw02;

/******************************************************************************
 * CS 210 Homework #2.
 * Author: Sangmork Park
 * A Queue data structure implementation. May-27-2022
 ******************************************************************************/

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Queue<T> implements Iterable<T> {
	private Node<T> first; // beginning of queue
	private Node<T> last; // end of queue
	private int n; // number of elements on queue

	private static class Node<T> {
		private T data;
		private Node<T> next;
	}

	public Queue() {
		first = null;
		last = null;
		n = 0;
	}

	public boolean isEmpty() {
		return first == null;
	}

	public int size() {
		return n;
	}

	public void enqueue(T data) {
		Node<T> oldlast = last;
		last = new Node<T>();
		last.data = data;
		last.next = null;
		if (isEmpty()) {
			first = last;
		} else {
			oldlast.next = last;
		}
		n++;
	}

	public T dequeue() {
		if (isEmpty()) {
			throw new NoSuchElementException("Queue underflow");
		}
		T data = first.data;
		first = first.next;
		n--;
		if (isEmpty()) {
			last = null; // to avoid loitering
		}
		return data;
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
		public void remove() // will not use
		{
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
	 * Test code: print out enqueue() and dequeue() data
	 */
	public static void main(String[] args) {
		System.out.println("Queue implementation and Test.\nEnter data.");
		Queue<String> queue = new Queue<String>();

		Scanner inp = new Scanner(System.in);
		while (true) {
			String data = inp.nextLine();
			// if (data.length() == 0) {
			if (data.strip().equals("q")) { // If you want to stop program, enter "q"
				break;
			}

			if (!data.equals("-")) {
				System.out.println("enqueue() : " + data);
				queue.enqueue(data);
			} else if (!queue.isEmpty()) {
				System.out.println("dequeue() : " + queue.dequeue());
			}
		}

		System.out.println("\nEnd of Queue Test. (" + queue.size() + " left on stack)");
		System.out.print("Contents of stack: ");
		for (String s : queue) {
			System.out.print(queue.dequeue() + ", ");
		}
	}
}