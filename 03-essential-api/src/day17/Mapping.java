package day17;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


class Employee {
	private String name;
	private String city;
	private int salary;
	public Employee(String name, String city, int salary) {
		super();
		this.name = name;
		this.city = city;
		this.salary = salary;
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
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	@Override
	public String toString() {
		return "Employee [name=" + name + ", city=" + city + ", salary=" + salary + "]";
	}
	
	
}

public class Mapping {
	
	public static void main(String[] args) {
		
		List<Employee> empList = Arrays.asList(
				new Employee("Kyaw Kyaw", "Yangon", 9800),
				new Employee("Aung Aung", "Mandalay", 6000),
				new Employee("Mg Mg", "Mandalay", 10000),
				new Employee("Yuri", "Yangon", 6000),
				new Employee("Jeon", "Monywa", 7800)
				);
		List<String> distinctCities = empList.stream()
										.map(emp -> emp.getCity())
										.distinct()
										.collect(Collectors.toList());
		System.out.println("cities: " + distinctCities);
		
//		
		int[] salaries = empList.stream()
							.filter(emp -> emp.getSalary() > 6000)
							.mapToInt(emp -> emp.getSalary())
							.toArray();
		System.out.println("---- salary > 6000 ----");
		for (var s : salaries) {
			System.out.println(s);
		}
		
//		salary < 10000
		List<Integer> salaryList = empList.stream()
									.filter(emp -> emp.getSalary() < 10000)
									.map(emp -> emp.getSalary())
									.limit(3)
									.collect(Collectors.toList());
		
		System.out.println("Salary: " + salaryList);
		
//		find max
		int maxSalary = empList.stream()
							.mapToInt(emp -> emp.getSalary())
							.max()
							.getAsInt();
		System.out.println("Max salary: " + maxSalary);
	}

}
