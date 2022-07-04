package cu.cs210.hw02;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Scanner;

/******************************************************************************
 * CS 210 Homework #2.
 * Author: Sangmork Park
 * A Stack data structure implementation. May-27-2022
 ******************************************************************************/

public class Stack<T> implements Iterable<T> {
	private Node<T> first; // top of stack
	private int n; // size of the stack

	private static class Node<T> {
		private T data;
		private Node<T> next;
	}

	public Stack() {
		first = null;
		n = 0;
	}

	public boolean isEmpty() {
		return first == null;
	}

	public int size() {
		return n;
	}

	public void push(T data) {
		Node<T> oldfirst = first;
		first = new Node<T>();
		first.data = data;
		first.next = oldfirst;
		n++;
	}

	public T pop() {
		if (isEmpty()) {
			throw new NoSuchElementException("Stack underflow");
		}
		T data = first.data; // save data to return
		first = first.next; // delete first node
		n--;
		return data; // return the saved data
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
	 * Test code: print out push() and pop() data
	 */
	public static void main(String[] args) {
		System.out.println("Stack implementation and Test.\nEnter data.");
		Stack<String> stack = new Stack<String>();

		Scanner inp = new Scanner(System.in);
		while (true) {
			String data = inp.nextLine();
			// if (data.length() == 0) {
			if (data.strip().equals("q")) {// If you want to stop program, enter "q"
				break;
			}

			if (!data.equals("-")) {
				stack.push(data);
				System.out.println("push() : " + data);
			} else if (!stack.isEmpty()) {
				System.out.println("pop() : " + stack.pop());
			}
		}

		System.out.println("\nEnd of Stack Test. (" + stack.size() + " left on stack)");
		System.out.print("Contents of stack: ");
		for (String s : stack) {
			System.out.print(stack.pop() + ", ");
		}
	}
}
