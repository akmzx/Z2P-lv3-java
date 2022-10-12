package assignment5;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Assignment {

	public static void main(String[] args) {

		List<Employee> employees = List.of(
				new Employee("Htet Htet", "Yangon", "Electronics", 900000, LocalDate.of(1991, 10, 16)),
				new Employee("Cherry", "Yangon", "Electronics", 820000, LocalDate.of(1994, 8, 14)),
				new Employee("Kyaw Kyaw", "Yangon", "Electronics", 780000, LocalDate.of(1988, 9, 2)),
				new Employee("Aung Aung", "Mandalay", "IT", 600000, LocalDate.of(1995, 1, 11)),
				new Employee("Jeon", "Mandalay", "IT", 600000, LocalDate.of(1997, 9, 1)),
				new Employee("Hsu Hsu", "Pyin Oo Lwin", "IT", 920000, LocalDate.of(1994, 12, 10)),
				new Employee("Aye Aye", "Yangon", "HR", 500000, LocalDate.of(1992, 10, 10)),
				new Employee("Gay Gay", "Taung Gyi", "HR", 400000, LocalDate.of(1996, 05, 12)),
				new Employee("Phway Phway", "Monywa", "HR", 300000, LocalDate.of(1995, 9, 3)),
				new Employee("Ko Ko", "Monywa", "IT", 500000, LocalDate.of(1992, 11, 11)));

//		The minimum salary of employees
		int minSalary = employees.stream()
								.mapToInt(e -> e.getSalary())
								.reduce(Integer::min)
								.getAsInt();
		System.out.println("The minimum salary of employees is " + minSalary);

//		The youngest employee information
		Employee youngest = employees.stream()
									.max(Comparator.comparing(Employee::getBirthday))
									.get();
		System.out.println("\nThe Youngest Employee");
		System.out.println(youngest);

//		Count all employee whose birthday is greater than or equal '1995-02-12'
		long count = employees.stream()
							.filter(emp -> emp.getBirthday().equals(LocalDate.of(1995, 2, 12)) || emp.getBirthday().isBefore(LocalDate.of(1995, 2, 12)))
							.count();
		System.out.println();
		System.out.println("all employee whose birthday is greater than or equal '1995-02-12': " + count);

//		Total salary of all employees
		int total_salary = employees.stream()
									.mapToInt(e -> e.getSalary())
									.sum();
		System.out.println("Total salary of all employees: " + total_salary);

//		Fetch the three max salaries
		System.out.println("\nThree Max Salaries");
		employees.stream()
				.sorted(Comparator.comparingInt(Employee::getSalary).reversed())
				.limit(3)
				.forEach(e -> System.out.println(e));

//		The average salary of department ‘HR’.
		double average = employees.stream()
								.filter(e -> e.getDepartment().equals("HR"))
								.mapToInt(e -> e.getSalary())
								.average()
								.getAsDouble();
		System.out.println("\naverage salary of department 'HR': " + average);

//		Employee which gets smallest salary.
		Employee emp = employees.stream()
								.min(Comparator.comparingInt(Employee::getSalary))
								.get();
		System.out.println("\nEmployee which gets smallest salary\n" + emp);

//		The highest salary of employee in each city
		Map<String, Optional<Employee>> groupByCity = employees.stream()
															.collect(Collectors
																	.groupingBy(Employee::getCity, 
																				Collectors.maxBy(Comparator.comparingInt(Employee::getSalary))));

		groupByCity.forEach((k, v) -> {
			System.out.println("City: " + k);
			System.out.println("Employee with highest salary: " + v);
		});

		Map<Integer, List<String>> groupBySalary = employees.stream()
															.collect(
															Collectors.groupingBy(Employee::getSalary, Collectors.mapping(Employee::getName, Collectors.toList())));
		System.out.println(groupBySalary);

		Map<String, List<String>> groupByDepartment = employees.stream()
															.collect(Collectors
															.groupingBy(Employee::getDepartment, Collectors.mapping(Employee::getName, Collectors.toList())));
		System.out.println(groupByDepartment);
	}
}
