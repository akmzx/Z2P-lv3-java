package assignments;

import java.util.Scanner;

public class Assignment_2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String exit = null;

		do {
			System.out.print("When do you go to bed? ");
			int bed = sc.nextInt();
			System.out.print("When do you get up? ");
			int awake = sc.nextInt();
			int sleepTime = (12 - bed) + awake;

			if (sleepTime >= 5 && sleepTime <= 8) {
				System.out.println("You take care your health well!");
			} else if (sleepTime < 5) {
				System.out.println("You are very hardworking!");
			} else {
				System.out.println("You are abnormal!");
			}
			System.out.print("If you want to exit, please enter 'Y or y': ");
			exit = sc.next();
		} while (!exit.equalsIgnoreCase("Y"));
		
		sc.close();
	}
}
