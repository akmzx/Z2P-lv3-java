package com.mmit.day8;

import java.util.Scanner;

public class Try_with_Resource {

	public static void main(String[] args) {
		
		try(Scanner sc = new Scanner(System.in)) {
			System.out.println("Enter your name: ");
			System.out.println("Name is " + sc.nextLine());
			
//			sc.close();
		} catch (Exception e) {

		}
	}

}
