package assignments;

import java.util.Scanner;

public class Assignment_1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("How many numbers you want to type: ");
		int total = sc.nextInt();
		int[] numbers = new int[total];
		for (var i = 0; i < total; i++) {
			System.out.print("Enter any number: ");
			numbers[i] = sc.nextInt();
		}
		int zeros = 0;
		int positives = 0;
		int negatives = 0;

		for (int number : numbers) {
			if (number > 0) {
				positives++;
			} else if (number < 0) {
				negatives++;
			} else {
				zeros++;
			}
		}
		System.out.println("Number of zero: " + zeros);
		System.out.println("Number of positive number: " + positives);
		System.out.println("Number of negative number: " + negatives);
		sc.close();
	}

}
