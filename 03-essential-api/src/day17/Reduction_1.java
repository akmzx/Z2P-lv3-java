package day17;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Reduction_1 {

	public static void main(String[] args) {
		List<Employee> empList = Arrays.asList(
				new Employee("Kyaw Kyaw", "Yangon", 9800),
				new Employee("Aung Aung", "Mandalay", 6000),
				new Employee("Mg Mg", "Mandalay", 10000),
				new Employee("Yuri", "Yangon", 6000),
				new Employee("Jeon", "Monywa", 7800)
				);
		
		int total  = empList.stream().mapToInt(e -> e.getSalary()).sum();
		double avg = empList.stream().mapToDouble(Employee::getSalary).average().getAsDouble();
		int max = empList.stream().mapToInt(Employee::getSalary).max().getAsInt();
		long count = empList.stream().filter(e -> e.getSalary() > 6000).count();
		
		Employee max_emp = empList.stream().max(Comparator.comparingInt(e -> e.getSalary())).get();
		Employee min_emp = empList.stream().min((e1, e2) -> e1.getSalary() - e2.getSalary()).get();
		
		System.out.println("Total: " + total);
		System.out.println("Average salary: " + avg);
		System.out.println("Maximun salary: " + max);
		System.out.println("Count = " + count);
		System.out.println("Employee got the max salary: " + max_emp);
		System.out.println("Employee got the min salary: " + min_emp);
		
//		custom reduction
		
		int totalSalary = empList.stream().map(e -> e.getSalary())
											.reduce(0, (s1, s2) -> s1 + s2);
		
		int minSalary = empList.stream()
						.map(e -> e.getSalary())
						.reduce(Integer::min)
						.get();
		Employee maxEmployee = empList.stream()
								.reduce((e1, e2) -> e1.getSalary() < e2.getSalary() ? e2: e1)
								.get();
		System.out.println("Total: " + totalSalary);
		System.out.println("Min Salary: " + minSalary);
		System.out.println("Employee got the max salary: " + maxEmployee);
		
	}
}
