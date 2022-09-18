package Assignment_4;

import java.util.Scanner;

public class Demo {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int length;
		int width;
		String color;

		System.out.print("Enter length: ");
		length = sc.nextInt();
		sc.nextLine();
		System.out.print("Enter width: ");
		width = sc.nextInt();
		sc.nextLine();
		System.out.print("Enter color: ");
		color = sc.nextLine();

		Rectangle info = new Rectangle(length, width, color);
		info.displayArea();
	}

}
