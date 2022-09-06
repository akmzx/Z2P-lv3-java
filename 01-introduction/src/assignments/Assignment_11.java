package assignments;

import java.util.Scanner;

public class Assignment_11 {

	public static void main(String[] args) throws InvalidMarkException {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter your mark: ");
		int input = sc.nextInt();
		checkInput(input);
	}

	private static void checkInput(int mark) throws InvalidMarkException {
		if (mark < 0 || mark > 100) {
			InvalidMarkException obj = new InvalidMarkException("Invalid input");
			throw obj;
		}
		else {
			System.out.println("Your mark is " + mark);
		}
	}

}

class InvalidMarkException extends Exception {

	private static final long serialVersionUID = 1L;

	public InvalidMarkException() {
		super("Unknow input");
	}

	public InvalidMarkException(String msg) {
		super(msg);
	}

}