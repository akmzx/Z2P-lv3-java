package Assignment_1;

import java.util.Scanner;

public class Assignment_1Demo {

	public static void main(String[] args) throws InsufficientAmountException {

		Scanner sc = new Scanner(System.in);
		int accountNo = 0;
		String holderName = null;
		String pinNo = null;
		String password = null;
		int balance;

		System.out.print("Enter Account No: ");
		accountNo = sc.nextInt();
		sc.nextLine();
		System.out.print("Enter Holder's Name: ");
		holderName = sc.nextLine();
		System.out.print("Enter PinNo: ");
		pinNo = sc.nextLine();
		System.out.print("Enter password: ");
		password = sc.nextLine();

		Assignment_1 bankAccount = new Assignment_1(accountNo, holderName, pinNo, password);

		dostuff(bankAccount, sc);

		sc.close();
	}

	private static void dostuff(Assignment_1 bankAccount, Scanner sc) throws InsufficientAmountException {

		int key;
		System.out.println("--------------------------");
		System.out.println("1. Deposit Money");
		System.out.println("2. Withdraw Money");
		System.out.println("3. Change Passoword");
		System.out.println("4. Show Info");
		System.out.println("5. Exit");
		System.out.print("Enter the number of the action you want to take: ");
		key = sc.nextInt();
		sc.nextLine();
		System.out.println("-----------------------------");

		switch (key) {
		case 1: {
			System.out.print("Enter deposit Amount: ");
			bankAccount.deposit(sc.nextInt());
			sc.nextLine();
			dostuff(bankAccount, sc);
			break;
		}
		case 2: {
			System.out.print("Enter withdraw Amount: ");
			bankAccount.withdraw(sc.nextInt());
			sc.nextLine();
			dostuff(bankAccount, sc);
			break;
		}
		case 3: {
			System.out.print("Change Password: ");
			bankAccount.changePassword(sc.nextLine());
			dostuff(bankAccount, sc);
			break;
		}
		case 4: {
			bankAccount.showInfo();
			dostuff(bankAccount, sc);
			break;
		}
		case 5: {
			System.out.println("Thanks for using our service.");
			break;
		}
		default:
			throw new IllegalArgumentException("Unexpected value: " + key);
		}
	}
}
