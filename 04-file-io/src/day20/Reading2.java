package day20;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

class Employee {
	private int id;
	private String name;
	private String city;

	public Employee() {

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public static Employee getEmployeeFromLine(String line) {
		Employee emp = new Employee();
		String[] data = line.split("\t");
		emp.setName(data[1]);
		emp.setCity(data[2]);
		emp.setId(Integer.parseInt(data[0]));
		return emp;
	}

}

public class Reading2 {

	public static void main(String[] args) throws IOException {

		List<String> lines = Files.readAllLines(Path.of("src/employee.txt"));

		List<Employee> empList = lines.stream()
									.map(Employee::getEmployeeFromLine)
									.toList();

		System.out.println("----- Employee List -----");
		empList.forEach(emp -> {
			System.out.println("Id: " + emp.getId());
			System.out.println("Name: " + emp.getName());
			System.out.println("City: " + emp.getCity());
			System.out.println("----------------------------");
		});

//		readAll Bytes
		byte[] byteArray = Files.readAllBytes(Path.of("src/employee.txt"));
		String data = new String(byteArray);
		System.out.println(data);
		
//		readString
		
		String input = Files.readString(Path.of("src/employee.txt"));
		System.out.println("----- Reading with readString -----");
		System.out.println(input);
	}
}
