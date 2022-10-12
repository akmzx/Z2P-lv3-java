package assignment3;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.TreeSet;

public class Map_Assignment {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		boolean exit = false;

		Map<Integer, Student> students = new HashMap<>();

		students.put(1001, new Student(1001, "Aung Aung", 15));
		students.put(1002, new Student(1002, "Ma Ma", 17));
		students.put(1003, new Student(1003, "Kyaw Kyaw", 18));

		do {
			int actionNo;
			String input = """
					1. Add new student
					2. Display All students
					3. Update student data
					4. Search student
					5. Delete a student
					6. Exit
					Enter the number of the action you want to take: """;

			System.out.print(input);
			actionNo = sc.nextInt();
			sc.nextLine();

			switch (actionNo) {
			case 1: {
				addStudent(students, sc);
				break;
			}
			case 2:
				displayAllstudents(students);
				break;
			case 3:
				updateStudentData(sc, students);
				break;
			case 4:
				searchStudent(sc, students);
				break;
			case 5:
				deleteStudent(sc, students);
				break;
			case 6:
				exit = true;
				System.out.println("Thanks for using our service");
				sc.close();
				break;
			default:
				throw new IllegalArgumentException("Unexpected value: " + actionNo);
			}
		} while (!exit);

	}

	private static void deleteStudent(Scanner sc, Map<Integer, Student> students) {
		int rollno;

		System.out.print("Enter Roll No: ");
		rollno = sc.nextInt();
		sc.nextLine();

		students.keySet().removeIf(k -> k == rollno);
		System.out.println("Student deleted");
	}

	private static void searchStudent(Scanner sc, Map<Integer, Student> students) {
		int rollno;

		System.out.print("Enter Roll No: ");
		rollno = sc.nextInt();
		sc.nextLine();

		if (students.containsKey(rollno)) {
			System.out.println(students.get(rollno));
		} else {
			System.err.println("This Roll No does not exist");
		}
	}

	private static void updateStudentData(Scanner sc, Map<Integer, Student> students) {
		int rollno;
		String name;
		int age;

		System.out.print("Enter Roll No: ");
		rollno = sc.nextInt();
		sc.nextLine();

		if (students.containsKey(rollno)) {
			System.out.print("Update student's name: ");
			name = sc.nextLine();
			System.out.print("Update student's age: ");
			age = sc.nextInt();
			sc.nextLine();
			students.replace(rollno, new Student(rollno, name, age));
			System.out.println("Student Data Updated");
		} else {
			System.err.println("Student does not exist");
		}
	}

	private static void displayAllstudents(Map<Integer, Student> students) {
		students.forEach((k, v) -> {
			System.out.println(String.format("""
					Roll no: %d
					Name   : %s
					Age    : %d \n""", v.getRollno(), v.getName(), v.getAge()));
		});
	}

	private static void addStudent(Map<Integer, Student> students, Scanner sc) {

		int rollno;
		String name;
		int age;

		TreeMap<Integer, Student> sorted = new TreeMap<>(students);
		rollno = sorted.lastKey() + 1;

		System.out.print("Enter student's name: ");
		name = sc.nextLine();
		System.out.print("Enter student's age: ");
		age = sc.nextInt();
		sc.nextLine();
		students.put(rollno, new Student(rollno, name, age));
		System.out.println("Student added");
	}

}
