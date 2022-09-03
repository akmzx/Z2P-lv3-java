package assignments;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Assignment_5 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String[] townships = { "AA", "BB", "CC", "DD" };
		int[] times = { 15, 30, 10, 45 };
		String[] menus = { "Pizza", "Burger", "Milk Tea", "Spicy Noodle" };

		int menu;
		int township;
		int ordertype;

		LocalDate date = LocalDate.now();
		LocalTime time = LocalTime.now();

//		Menu
		System.out.println("***** Available Menu *****");
		for (int i = 0; i < menus.length; i++) {
			System.out.println((i + 1) + ". " + menus[i]);
		}
		System.out.print("Please choose item: ");
		menu = sc.nextInt();

//		Township for delivery
		System.out.println("***** Deliverable Township *****");
		for (int i = 0; i < townships.length; i++) {
			System.out.println((i + 1) + ". " + townships[i] + " (" + times[i] + " mins)");
		}
		System.out.print("Please choose township: ");
		township = sc.nextInt();

//		Order Type
		System.out.println("***** Order Type *****");
		System.out.println("1. Order Now?");
		System.out.println("2. Preorder?");
		System.out.print("Please choose 1 or 2: ");
		ordertype = sc.nextInt();

//		Result 
		if (ordertype == 1) {
			DateTimeFormatter timeformat = DateTimeFormatter.ofPattern("hh:mm:ss a");

			System.out.println("***** Your Order Imformation *****");
			System.out.println("Item Name: " + menus[menu - 1]);
			System.out.println("Your Address: " + townships[township - 1]);
			System.out.println("Duration: " + times[township - 1] + " mins");
			System.out.println("Arrival Time: " + time.plusMinutes(times[township - 1]).format(timeformat));
		} else {
			DateTimeFormatter dateformat = DateTimeFormatter.ofPattern("EEEE, MMM dd yyyy");

			System.out.print("Enter delivery date (dd): ");
			int deli_date = sc.nextInt();
			System.out.println("***** Your Order Imformation *****");
			System.out.println("Item Name: " + menus[menu - 1]);
			System.out.println("Your Address: " + townships[township - 1]);
			System.out.println("Arrival Date: " + date.plusDays(deli_date).format(dateformat));
		}
		System.out.println("***** Thank you for your ordering *****");
		sc.close();
	}
}
