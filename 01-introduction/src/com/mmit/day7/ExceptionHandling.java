package com.mmit.day7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class ExceptionHandling {
	public static void main(String[] args) {
		
//		display(100);
	}

	private static void display(int i) {
		System.out.println("i = " + i);
		display(200);
	}

//	public static void main(String[] args) throws NumberFormatException, IOException {
////		var sc = new Scanner(System.in);
//		BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
//		System.out.print("Enter number1: ");
//		int num1 = Integer.parseInt(sc.readLine());
//		System.out.print("Enter number2: ");
//		int num2 = Integer.parseInt(sc.readLine());
//		
//		int result = num1 / num2;  // 100 / 0
////		create its related its exception object
////		throw the created object
//		System.out.println("Result: " + result);
////		end-users
////		stakeholders
//		sc.close();
//	}

}
