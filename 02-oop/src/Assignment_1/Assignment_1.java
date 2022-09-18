package Assignment_1;

import java.util.Scanner;

public class Assignment_1 {
	int accountNo;
	String holderName;
	String pinNo;
	String password;
	int balance = 1000000;

	public Assignment_1(int accountNo, String holderName, String pinNo, String password) {
		super();
		this.accountNo = accountNo;
		this.holderName = holderName;
		this.pinNo = pinNo;
		this.password = password;
	}

	public void deposit(int addedAmount) {
		this.balance += addedAmount;
		System.out.println("Your balance is " + balance + "Kyats");
	}

	public void withdraw(int withdrawAmount) throws InsufficientAmountException {
		try {
			if (withdrawAmount > this.balance) {
				throw new InsufficientAmountException();
			} else {
				this.balance -= withdrawAmount;
				System.out.println("Your balance is " + balance + "Kyats");
			}
		} catch (InsufficientAmountException e) {
			System.err.println(e.getMessage());
		}
	}

	public void changePassword(String psw) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter PinNo: ");
		String checkPinNo = sc.next();

		if (checkPinNo.equals(this.pinNo)) {
			this.password = psw;
			System.out.println("Your password has been changed");
		} else {
			System.err.println("Invalid pin number!");
		}
	}

	public void showInfo() {
		System.out.println("Account No: " + this.accountNo);
		System.out.println("Holder Name: " + this.holderName);
		System.out.println("PinNo: " + this.pinNo);
		System.out.println("Password: " + this.password);
		System.out.println("Balance: " + this.balance);
	}
}

class InsufficientAmountException extends Exception {

	private static final long serialVersionUID = 1L;

	public InsufficientAmountException() {
		super("You do not have enough balance");
	}

	public InsufficientAmountException(String msg) {
		super(msg);
	}
}
