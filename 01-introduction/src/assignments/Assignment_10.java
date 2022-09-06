package assignments;

import java.util.Scanner;

public class Assignment_10 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String input;
		String number;
		String[] result;
		String[] division = { "AA", "BB", "CC", "DD", "EE", "FF", "HH", "JJ", "KK", "LL", "MM", "NN" };

		System.out.println("Enter user's NRC: ");
		input = sc.nextLine();

		number = input.substring(input.length() - 6);
		input = input.replace("/", " ").replace("(", " ");
		result = input.split(" ");
		int divNo = Integer.parseInt(result[0]);

//		output result
		try {
			for (int i = 0; i < division.length; i++) {
				if (divNo == i + 1) {
					System.out.println("Division/state = " + division[i]);
				} else {
					IndexOutOfBoundsException obj = new IndexOutOfBoundsException("Division/State number does not exist");
					throw obj;
				}
			}
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}

		System.out.println("Township: " + result[1]);
		System.out.println("Number: " + number);

		sc.close();
	}

}
