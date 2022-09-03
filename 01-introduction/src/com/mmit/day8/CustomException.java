package com.mmit.day8;

import java.util.Scanner;

public class CustomException {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			System.out.print("Enter your age: ");
			var age = sc.nextInt();
			validateAge(age);

		} catch (Exception e) {
			System.out.println("Message: " + e.getMessage());
		}
	}

	private static void validateAge(int age) throws InvalidAgeException {
		if (age < 18) {
			InvalidAgeException obj = new InvalidAgeException("Invaild Age");
			throw obj;
		} else {
			System.out.println("You can smoke!");
		}
	}

}

class InvalidAgeException extends Exception {

	private static final long serialVersionUID = 1L;

	public InvalidAgeException() {
		super("Unknow message");
		System.out.println("...default constructor...");
	}

	public InvalidAgeException(String msg) {
		super(msg);
	}

}
