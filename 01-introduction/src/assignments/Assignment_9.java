package assignments;

import java.util.Arrays;
import java.util.Scanner;

public class Assignment_9 {

	static String[] stringArr = { "1", "2", "3", "4" };

	public static void main(String[] args) throws ArithmeticException, NumberFormatException {

		Scanner sc = new Scanner(System.in);
		System.out.println("Enter numbers (Eg. 1,2,3,4): ");
		String input = sc.nextLine();
		String[] stringArr = input.split(",");

		data numbers = new data(stringArr);

		System.out.println("Max: " + Arrays.stream(numbers.array).max().getAsInt());
		System.out.println("Min: " + Arrays.stream(numbers.array).min().getAsInt());
		System.out.println("Average: " + Arrays.stream(numbers.array).average().getAsDouble());
		
		sc.close();
	}
}

class data {

	int[] array;

	public data(String[] data) throws IllegalArgumentException {
		array = new int[data.length];
		for (int i = 0; i < data.length; i++) {
			array[i] = Integer.parseInt(data[i]);
		}
	}
}
