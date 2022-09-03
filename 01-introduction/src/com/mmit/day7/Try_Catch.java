package com.mmit.day7;

import java.util.Scanner;

public class Try_Catch {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		try {
			System.out.print("Enter number1: ");
			var num1 = sc.nextInt();
			System.out.print("Enter number2: ");
			var num2 = sc.nextInt();

			// 1. ArithmeticException e = new ArithmeticExcpetion
			// 2. throw e
			var result = num1 / num2; // 100/0
			if (num2 == 0) {
				ArithmeticException obj = new ArithmeticException();
				// obj.set
				throw obj;
			}
			System.out.println("Result: " + result);
			sc.close();
		}

		catch (NullPointerException | ArithmeticException obj2) {// obj = e
			System.err.println(obj2.toString());
		}

		catch (Exception e) {
			System.out.println("exception occurred");
		}
		System.out.println("outside the try catch block");
	}

}
