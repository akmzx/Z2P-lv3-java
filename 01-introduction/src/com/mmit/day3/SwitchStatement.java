package com.mmit.day3;

import java.util.Scanner;

public class SwitchStatement {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter food name: ");
		String name = sc.nextLine().toLowerCase();
		String category = null;

//		category = switch (name) {
//		case "burger", "pizza", "sandwich" -> "Fast Food";
//		case "yogurt", "milk tea" -> "Dessert";
//		case "mohinga" -> "Burmese Food";
//		case "sushi" -> "Japanese Food";
//		default -> "unknown";
//		};

		category = switch (name) {
		case "burger", "pizza", "sandwich" -> {
			name = null;
			if ("pizza".equals(name)) // pizza.equals(null)
				System.out.println("Pizza is an italian food");
			yield "Fast Food";
		}
		case "yogurt", "milk tea" -> {
			yield "Fast Food";
		}
		case "mohinga" -> "Burmese Food";
		case "sushi" -> "Japanese Food";
		default -> "unknown";
		};

//		switch_statement(name);
		sc.close();
		System.out.println(name + " is " + category);
	}

	private static void switch_statement(String name) {
		String category;
		switch (name) {
		case "burger", "pizza", "sandwich":
			category = "Fast Food";
			break;
		case "yogurt", "milk tea":
			category = "Dessert";
			break;
		case "mohinga":
			category = "Burmese Food";
			break;
		case "sushi":
			category = "Japanese Food";
			break;
		default:
			category = "unknown";
		}
		System.out.println(name + " is " + category);
	}
}
