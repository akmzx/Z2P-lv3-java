package com.mmit.day3;

import java.util.Scanner;

public class ConditionalStatement {
	
	enum Role {
		Admin, Staff, Customer, Merchant
	};
	
	private static Role role;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
//		if_statement(sc);
//		if_else(sc);
//		if_elseif(sc);	
		
		Student obj = new Student();
		obj.name = "Kyaw Kyaw";
		obj.gender = Gender.valueOf("abc");
		System.out.println("Name: " + obj.name);
		System.out.println("Gender: " + obj.gender);
		sc.close();
	}

	private static void if_elseif(Scanner sc) {
		System.out.print("Enter your bmi value: ");
		var bmi = Float.parseFloat(sc.nextLine());
		if(bmi < 18.5)
			System.out.println("Underweight");
			else if(bmi >= 18.5 && bmi <= 24.9)
				System.out.println("Normal Weight");
			else if(bmi >= 25 && bmi <= 29.9)
				System.out.println("Overweight");
			else {
				System.out.println("Obesity");
			}
	}

	private static void if_else(Scanner sc) {
//		login
		System.out.println("-------------");
		System.out.println("Enter email: ");
		var email = sc.nextLine();
		System.out.println("Enter password: ");
		var pass = sc.nextLine();
		if (email.equals("admin@gmail.com") && pass.equals("123")) {
			System.out.println("Login Success");
		} 
		else {
			System.err.println("Login fail");
		}
	}

	private static void if_statement(Scanner sc) {
		System.out.println("Enter language name: ");
		String name = sc.nextLine();
		if (name.equalsIgnoreCase("Java")) {
			System.out.println("Java is a compiled language");
		} else {
			System.out.println("other");
		}
	}
}

class Student {
	String name;
	Gender gender;
}
