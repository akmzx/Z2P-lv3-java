package Assignment3;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Set_Assignment {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		boolean exit = false;

		Set<Student> students = new HashSet<>();

		students.add(new Student(1001, "Aung Aung", 15));
		students.add(new Student(1002, "Ma Ma", 17));
		students.add(new Student(1003, "Kyaw Kyaw", 18));

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

	private static void displayAllstudents(Set<Student> students) {
		TreeSet<Student> sorted = new TreeSet<>(students);

		sorted.forEach(s -> {
			System.out.println(String.format("""
					Roll no: %d
					Name   : %s
					Age    : %d \n""", s.getRollno(), s.getName(), s.getAge()));
		});
	}

	private static void deleteStudent(Scanner sc, Set<Student> students) {
		int rollno;

		System.out.print("Enter Roll No: ");
		rollno = sc.nextInt();
		sc.nextLine();

		students.removeIf(s -> s.getRollno() == rollno);

		System.out.println("Student(" + rollno + ") is deleted");
	}

	private static void searchStudent(Scanner sc, Set<Student> students) {
		int rollno;
		boolean exist = false;

		System.out.print("Enter Roll no: ");
		rollno = sc.nextInt();
		sc.nextLine();

		for (Student student : students) {
			if (student.getRollno() == rollno) {
				exist = true;
				System.out.println(String.format("Roll No: %d \nName: %s \nAge: %d \n", student.getRollno(),
						student.getName(), student.getAge()));
			}
		}

		if (!exist)
			System.err.println("Student does not exist");
	}

	private static void updateStudentData(Scanner sc, Set<Student> students) {

		int rollno;
		String name;
		int age;
		boolean exist = false;

		System.out.print("Enter the roll no of the student you want to change: ");
		rollno = sc.nextInt();
		sc.nextLine();

		for (Student student : students) {

			if (student.getRollno() == rollno) {

				System.out.print("Update student's name: ");
				name = sc.nextLine();
				System.out.print("Update student's age: ");
				age = sc.nextInt();
				sc.nextLine();

				student.setName(name);
				student.setAge(age);
				System.out.println("Student Data Updated");
				exist = true;
				break;
			}
		}
		if (!exist) {
			System.err.println("This roll no does not exist");
		}

	}

	private static void addStudent(Set<Student> students, Scanner sc) {

		int rollno;
		String name;
		int age;
		boolean exist = false;

		TreeSet<Student> sorted = new TreeSet<>(students);
		rollno = sorted.last().getRollno() + 1;

//		insert a new student
		System.out.print("Enter student's name: ");
		name = sc.nextLine();
		System.out.print("Enter student's age: ");
		age = sc.nextInt();
		sc.nextLine();
		students.add(new Student(rollno, name, age));
		System.out.println("Student Added");
	}
}
