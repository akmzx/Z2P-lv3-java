package assignments;

import java.util.Scanner;

public class Assignment_7 {

	public static void main(String[] args) {
		String input;
		Boolean question;

		Scanner sc = new Scanner(System.in);
		System.out.println("Please give one sentence");
		input = sc.nextLine();
		question = input.contains("?");
		if (question == true) {
			System.out.println("The sentence is a question.");
			if (input.toLowerCase().contains("did")) {
				System.out.println("The sentence is not simple present tense.");
			} else {
				System.out.println("The sentence is simple present tense.");
			}
		} else {
			System.out.println("The sentence is not a question.");
		}
		sc.close();
	}

}
