package Assignment_5;

import java.util.Scanner;

public class PolymorphismTest {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Shape[] shapes = new Shape[2];
		shapes[0] = new Circle();
		shapes[1] = new Cube();
		int num;
		String input = """
				Choose a shape.
				1. Circle
				2. Cube
				Enter number: """;
		System.out.print(input);
		num = sc.nextInt();
		sc.nextLine();
		if (num == 1) {
			int radius;
			System.out.print("Enter radius: ");
			radius = sc.nextInt();
			sc.nextLine();
			System.out.println("Area of circle: " + shapes[0].area(radius));
			System.out.println("Volume of circle: " + shapes[0].volume(radius));
		} else {
			int x;
			System.out.print("Enter length: ");
			x = sc.nextInt();
			sc.nextLine();
			System.out.println("Area of cube: " + shapes[1].area(x));
			System.out.println("Volume of cube: " + shapes[1].volume(x));
		}
	}

}
