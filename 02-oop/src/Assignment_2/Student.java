package Assignment_2;

public class Student {

	private int studentId;
	private String name;
	private int mark;

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getMark() {
		return mark;
	}

	public void setMark(int mark) {
		this.mark = mark;
	}

	public Student(int studentId, String name, int mark) {
		super();
		this.studentId = studentId;
		this.name = name;
		this.mark = mark;
	}

	public void display() {
		System.out.println("Student Id: " + studentId);
		System.out.println("Name: " + name);
		System.out.println("Mark: " + mark);
	}

}
