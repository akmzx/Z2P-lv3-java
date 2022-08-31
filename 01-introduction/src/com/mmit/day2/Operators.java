package com.mmit.day2;

public class Operators {

	public static void main(String[] args) {
		var num1 = 100;
		var num2 = 200;
		
//		100 + 200 = 300
		System.out.println(num1 + " + " + num2 + " = " + (num1 + num2));
//		100 - 200 = result
		System.out.format("%d - %d = %d\n", num1, num2, (num1 - num2));
		
		System.out.println("100 > 200: " + (100 > 200));
		System.out.println("100 != 200: " + (100 != 200));
		
		System.out.println(num1 > 50 && num2 < 100);
		
		String result = num1%2 == 1 ? "odd" : "even";
		System.out.println("Result: " + result);
		
		num1 -= 20;
		System.out.println("After using (-=): " + num1);
	}

}
