package Assignment_3;

import java.util.Scanner;

public class Demo {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String name;
		String nrcno;
		String address;
		String phone;
		boolean teacher = false;

		System.out.print("If you are a teacher, enter 'Y' or else 'N': ");
		teacher = sc.nextLine() != "Y" ? true : false;

		System.out.print("Enter your name: ");
		name = sc.nextLine();
		System.out.print("Enter your nrcno: ");
		nrcno = sc.nextLine();
		System.out.print("Enter your address: ");
		address = sc.nextLine();
		System.out.print("Enter your phone number: ");
		phone = sc.nextLine();

		if (teacher == true) {
			String position;
			String department;
			int salary;

			System.out.print("Enter your position: ");
			position = sc.nextLine();
			System.out.print("Enter your department: ");
			department = sc.nextLine();
			System.out.print("Enter your salary: ");
			salary = sc.nextInt();
			sc.nextLine();

			Teacher user = new Teacher(name, nrcno, address, phone, position, department, salary);
			user.showTeacherInfo();
		} else {
			Person user = new Person(name, nrcno, address, phone);
			user.showInfo();
			user.showIdentificationInfo();
		}
		sc.close();
	}
}
