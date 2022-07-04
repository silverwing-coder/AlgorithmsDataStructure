package cu.cs210.hw02;

public class StackPrint {
	/******************************************************************************
	 * CS 210 Homework #2.
	 * Author: Sangmork Park
	 * StackPrint : Set the order of push()/pop() as required. May-27-2022
	 ******************************************************************************/
	public static void main(String[] args) {

		// TODO Auto-generated method stub
		System.out.println("StackPrint implementation");
		Stack<Integer> stack = new Stack<Integer>();
		stack.push(0);
		stack.push(1);
		stack.push(2);
		stack.push(3);
		for (int i : stack) {
			System.out.print(stack.pop() + ", ");
		}
		stack.push(4);
		stack.push(5);
		for (int i : stack) {
			System.out.print(stack.pop() + ", ");
		}
		stack.push(6);
		stack.push(7);
		stack.push(8);
		for (int i : stack) {
			System.out.print(stack.pop() + ", ");
		}
		stack.push(9);
		for (int i : stack) {
			System.out.print(stack.pop() + ", ");
		}
	}
}
