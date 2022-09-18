package day9;

public class Employee {
	static int noOfEmployee = 3;
	static int nextId = 1;
	final int empId;
	String name;
	int salary;
//	static final int BONUS;
	
	
	public Employee() throws AppException {
		if (nextId > noOfEmployee) 
			throw new AppException("Sorry! Limited number has been reached");
		empId = nextId;
		nextId++;
//		BONUS = 1;
		
	}
	
	public void initData(String name, int salary) {
		this.name = name;
		this.salary = salary;
	}
	
	public void changeData(String newName, int newSalary) {
		if (!newName.equals(this.name))
			this.name = newName;
		if (newSalary != this.salary)
			this.salary  = newSalary;
	}
	
	public void showData() {
		System.out.println(this.empId + "\t" + this.name + "\t" + this.salary);
	}
	

	
	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", name=" + name + ", salary=" + salary + "]";
	}
	
	public void viewInformation() {
		System.out.println("Total emp: " + noOfEmployee);
		System.out.println("--- current emp info ---");
		this.showData();
		System.out.println("Next emp's id: " + nextId);
	}

	public static void main(String[] args) {
		try {
			Employee emp1 = new Employee();
			emp1.initData("Kyaw Kyaw", 500000);
			emp1.viewInformation();
			Employee emp2 = new Employee();
			emp2.initData("Naung Naung", 600000);
			Employee emp3 = new Employee();
			emp3.initData("Nilar", 700000);
			
			System.out.println("ID\t Name \t Salary");
			System.out.println("-----------------------");
			emp1.showData();
			emp2.showData();
			emp3.showData();
			
			emp1.changeData("Kyaw Kyaw", 1000000);
			emp1.name = "Jeon";
//			emp1.empId = 4;
			System.out.println("After change, " + emp1);
			
			Employee.noOfEmployee = 5;
			Employee emp4 = new Employee();
		} 
		catch (AppException e) {
			System.err.println(e.getMessage());
		}
	}
}

