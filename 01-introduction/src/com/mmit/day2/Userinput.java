package com.mmit.day2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Userinput {
	
	public static void main(String[] args)  {
//		readWithBufferReader();
		readWithScanner();
	}

	private static void readWithScanner() {
//		open
		Scanner sc = new Scanner(System.in);
		
		
//		operate
		System.out.print("Enter name: ");
		var name = sc.nextLine();
		System.out.print("Enter salary: ");
		double salary = sc.nextDouble();
		System.out.print("Enter age: ");
		int age = sc.nextInt();
		sc.nextLine();
		System.out.print("Enter city: ");
		String city = sc.nextLine();
		
		
//		close
		sc.close();
		
		System.out.println("____ Information____");
		System.out.println("Name: " + name);
		System.out.println("Salary: " + salary);
		System.out.println("Age: " + age);
		System.out.println("City: " + city);
		
	}

	private static void readWithBufferReader() throws IOException{

//		create or open
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
//		operate
		System.out.print("Enter name");
		String name = reader.readLine();
		System.out.print("Enter salary: ");
		
//		convert from string to any number of data type (Double.parseDouble(stringvalue))
//		convert from any data type to String (String.value(object)
		double salary = Double.parseDouble(reader.readLine());
		
		System.out.print("Enter age: ");
		int age = Integer.parseInt(reader.readLine());
		System.out.print("Enter bonus: ");
		float bonus = Float.parseFloat(reader.readLine());
//		close
		reader.close();
		
		System.out.println("____ Your Infromation ____");
		System.out.println("Name: " + name);
		System.out.println("Salary: " + salary);
		System.out.println("Age: " + age);
		System.out.println("Bonus: " + bonus);
	}
}
