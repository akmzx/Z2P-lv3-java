package assignments;

import java.util.Scanner;

public class Assignment_3 {

	private static double[][] prices = { { 230.21, 529.483, 552.504, 690.63 }, { 400.21, 920.483, 960.504, 1200.63 },
			{ 294.2, 676.66, 706.08, 882.6 }, { 693.33, 1594.659, 1663.992, 2079.99 },
			{ 340.44, 783.012, 817.056, 1021.32 }, { 691.99, 1591.577, 1660.776, 2075.97 } };

	public static void main(String[] args) {

		showData();
		Scanner sc = new Scanner(System.in);
		String name = null;
		String processor = null;
		int	firstIndex = 0;
		int secondIndex = 0;
		double exchangeRate = 0;
		do {
			System.out.print("Please enter the name of the computer: ");
			name = sc.nextLine().toLowerCase();
		} while (!name.matches("lenovo|hp|samsung|acer|dell|asus"));

		do {
			System.out.print("Please enter the processor's name: ");
			processor = sc.nextLine().toLowerCase();
		} while (!processor.matches("core i3|core i5|core i7|core i9|"));

		switch (name) {
		case "lenovo":
			firstIndex = 0;
			break;
		case "hp":
			firstIndex = 1;
			break;
		case "samsung":
			firstIndex = 2;
			break;
		case "acer":
			firstIndex = 3;
			break;
		case "dell":
			firstIndex = 4;
			break;
		case "asus":
			firstIndex = 5;
			break;
		default:
			break;
		}
		
		switch (processor) {
		case "core i3":
			secondIndex = 0;
			break;
		case "core i5":
			secondIndex = 1;
			break;
		case "core i7":
			secondIndex = 2;
			break;
		case "core i9":
			secondIndex = 3;
			break;

		default:
			break;
		}
		System.out.print("Enter currency exchange rate: ");
		exchangeRate = sc.nextDouble();
		
		System.out.println("The price is " + String.format("%,.2f", prices[firstIndex][secondIndex] * exchangeRate) + " MMK");
	}

	private static void showData() {
		String[] names = { "lenovo", "hp", "samsung", "acer", "dell", "asus" };
		String[] processors = { "core i3", "core i5", "core i7", "core i9" };

		System.out.print("\t \t");
		for (String name : names) {
			System.out.print(name + "\t \t");
		}
		System.out.println();
		System.out.println();

		for (var r = 0; r < 4; r++) { // rows
			System.out.print(processors[r] + "   \t");
			for (var c = 0; c < 6; c++) {

				System.out.print(prices[c][r] + "   \t");
			}
			System.out.println();
		}
	}
}
