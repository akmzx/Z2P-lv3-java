package Assignment_2;

import java.util.Arrays;
import java.util.Scanner;

public class Testing {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

//		input data
		Student[] students = new Student[4];
		int arrayLength = students.length;
		for (int i = 0; i < arrayLength; i++) {
			System.out.print("Enter Student Id: ");
			int studentId = sc.nextInt();
			sc.nextLine();
			System.out.print("Enter your name: ");
			String name = sc.nextLine();
			System.out.print("Enter your mark: ");
			int mark = sc.nextInt();
			sc.nextLine();

			students[i] = new Student(studentId, name, mark);
		}

		System.out.println("---------------------------");
		for (Student student : students) {
			student.display();
		}

//		search with id
		int searchId;
		boolean found = false;

		System.out.print("Enter the id of the student: ");
		searchId = sc.nextInt();
		sc.nextLine();

		for (Student student : students) {
			if (searchId == student.getStudentId()) {
				student.display();
				found = true;
				break;
			}
		}
		if (found == false) {
			System.out.println("Student Id - " + searchId + "is not found");
		}

//		find maximum and average
		int[] marks = new int[arrayLength];
		for (int i = 0; i < arrayLength; i++) {
			marks[i] = students[i].getMark();
		}

		int maxMark = Arrays.stream(marks).max().getAsInt();
		for (Student student : students) {
			if (student.getMark() == maxMark) {
				System.out.println(student.getName() + " has maximum mark.");
				break;
			}
		}
		System.out.println("Average Mark: " + Arrays.stream(marks).average().getAsDouble());

		sc.close();
	}
}
