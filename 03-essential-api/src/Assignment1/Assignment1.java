package Assignment1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Assignment1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] data = { "Aung Aung", "Kyaw Kyaw", "Gwen", "Su Su", "Kyi Phyu", "Thu Thu" };

		ArrayList<String> names = new ArrayList<>(Arrays.asList(data));

//		Show all student names
		System.out.println(names);

//		Sort the list
		Collections.sort(names);

//		Show the sorted list
		System.out.println("After sorting, " + names);

//		Search specific student and show the position
		String searchName;
		System.out.print("Enter the name of the student: ");
		searchName = sc.nextLine();
		boolean found = false;
		for (String name : names) {
			if (name.equalsIgnoreCase(searchName)) {
				found = true;
				System.out.println(searchName + " is found");
				System.out.println(searchName + "'s position is " + names.indexOf(name));
				break;
			}
		}
		if (!found)
			System.out.println(searchName + " is not found");

//		Insert name if it is not included
		String insertName;
		System.out.print("Enter the name you want to add: ");
		insertName = sc.nextLine();
		boolean exist = false;
		for (String name : names) {
			if (name.equalsIgnoreCase(searchName)) {
				exist = true;
				System.out.println(insertName + " already exists");
				break;
			}
		}
		if (!exist) {
			names.add(insertName);

			System.out.println(insertName + " is added");
			System.out.println("After adding, " + names);
		}

//		Show names that start  with "K" or "k"
		for (String name : names) {
			if (name.startsWith("K") || name.startsWith("k"))
				System.out.println("Name that start with K or k: " + name);
		}

//		Remove names that start with 'G' or'g'
		names.removeIf(str -> str.startsWith("G"));
		names.removeIf(str -> str.startsWith("g"));
		System.out.println("After removing names that starts with G or g: " + names);

//		Clear the list
		names.clear();
		System.out.println("After clear, names: " + names);
	}
}