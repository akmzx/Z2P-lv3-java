package com.mmit.day8;

import java.util.Scanner;

public class ThrowingException {
	
	private static void checkMark(int mark) throws ArithmeticException {
		if (mark < 0 || mark > 100) {
			ArithmeticException obj = new ArithmeticException("Invaild Mark");
			throw obj;
		}
	}
	
	public static void main(String[] args) {
		try {
			checkMark(1000);
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	
/*
	public static void main(String[] args) {
		try(Scanner sc = new Scanner(System.in)) {
			int[] numbers = {100, 200, 300};
			
			System.out.print("Enter position: ");
			var index = sc.nextInt();
			
			if(index >= numbers.length) {
				IndexOutOfBoundsException obj = new IndexOutOfBoundsException();
				throw obj;
			}
		} catch (Exception e) {
			System.out.println("Your input value is out of range");
		}
	}
*/
}

