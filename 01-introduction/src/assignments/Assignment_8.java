package assignments;

import java.util.Scanner;

public class Assignment_8 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String input;
		String number;
		String[] result;

		System.out.println("Enter user's NCRNO.");
		input = sc.nextLine();
		number = input.substring(input.length() - 6);
		input = input.replace("/", " ").replace("(", " ");
		result = input.split(" ");
		
		System.out.println("Township: " + result[1]);
		System.out.println("Number: " + number);
		sc.close();
	}

}
