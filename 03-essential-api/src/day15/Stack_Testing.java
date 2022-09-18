package day15;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Stack_Testing {

	public static void main(String[] args) {

		Stack<String> stack = new Stack<>();

		stack.add("Aung Aung");
		stack.push("Hla Hla");
		stack.push("Thu Thu");
		stack.push("Kyaw Kyaw");

		System.out.println(stack);
		System.out.println("stack[2]: " + stack.get(2));

		stack.pop(); // remove top
		System.out.println("After remove, " + stack);

//		please queue up (First-in-first-out)
		Queue<String> queue = new LinkedList<String>();
		queue.add("Apple");
		queue.add("Orange");
		queue.add("Mango");

		System.out.println("Queue: " + queue);

		queue.poll(); // remove
		System.out.println("After remove, " + queue);
	}

}
