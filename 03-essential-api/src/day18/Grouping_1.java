package day18;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Grouping_1 {

	public static void main(String[] args) {

		List<Employee> empList = Arrays.asList(
				new Employee("Kyaw Kyaw", "Yangon", 9800),
				new Employee("Aung Aung", "Mandalay", 6000), 
				new Employee("Mg Mg", "Mandalay", 10000),
				new Employee("Yuri", "Yangon", 6000), 
				new Employee("Jeon", "Monywa", 7800));
//		count
		Map<String, Long> groupByCity = empList.stream()
											.collect(
													Collectors.groupingBy(
															Employee::getCity, // key
															Collectors.counting() // val
															)
											);
//		sum
		Map<String, Integer> totalsalaryByCity = 
				empList.stream()
				.collect(Collectors.groupingBy(
						emp -> emp.getCity(),
						Collectors.summingInt(emp -> emp.getSalary())
						));
		
//		avg
		Map<String, Double> avgSalaryByCity = 
				empList.stream()
				.collect(Collectors.groupingBy(
						Employee::getCity, // key
						Collectors.averagingDouble(Employee::getSalary) // val
						));
		
		System.out.println("same city: " + groupByCity);
		System.out.println("total salary in each city: " + totalsalaryByCity);
		System.out.println("average salary in each city: " + avgSalaryByCity);
		
//		employee list in each city 
		
		Map<Integer, List<Employee>> empListBySalary = 
				empList.stream()
				.collect(Collectors.groupingBy(emp -> emp.getSalary()));
		
		System.out.println("----- employee who gets the same salary -----");
		empListBySalary.forEach((key, value) -> {
			System.out.println(key + "ks");
			value.forEach(obj -> {
				System.out.println("\t" + obj.getName() + " - " + obj.getCity());
			});
		});
		
//		employee name list group by city
		
		Map<String, List<String>> nameListByCity = 
				empList.stream()
				.collect(Collectors.groupingBy(Employee::getCity, // key
						Collectors.mapping(Employee::getName, // convert emp object to string
								Collectors.toList() // convert list
								)
						));
		
		System.out.println("Employee name in the same city: " + nameListByCity);
		
//		employee who stay in the same city
		
		Map<String, List<Employee>> sameCityList = 
				empList.stream()
				.collect(Collectors.collectingAndThen(
						Collectors.groupingBy(Employee::getCity), // key
						map -> map.entrySet() // Map<String, List<emp>>
								.stream()
								.filter(m -> m.getValue().size() > 1)
								.collect(Collectors.toMap(m -> m.getKey(), m -> m.getValue()))
						));
		System.out.println("--- employees who stay in the same city ---");
		sameCityList.forEach((k, v) -> {
			System.out.println(k);
			v.forEach(obj -> {
				System.out.println("\t" + obj.getName() + ", salary: " + obj.getSalary() + "ks.");
			});
		});
 	}
}
