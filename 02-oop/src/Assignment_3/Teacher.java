package Assignment_3;

public class Teacher extends Person {
	private String position;
	private String department;
	private int salary;

//	Constructor
	public Teacher(String name, String ncrno, String address, String phone, String position, String department,
			int salary) {
		super(name, ncrno, address, phone);
		this.position = position;
		this.department = department;
		this.salary = salary;
	}

//	Getters and Setters
	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

//	Methods
	public void promote(String position, int salary) {
		this.position = position;
		this.salary = salary;
		System.out.println("Position and Salary updated");
	}

	public void transfer(String department) {
		this.department = department;
		System.out.println("Department updated");
	}

	public void showTeacherInfo() {
		super.showInfo();
		super.showIdentificationInfo();
		System.out.println("Department: " + department);
		System.out.println("Position: " + position);
		System.out.println("Salary: " + salary);
	}
}
