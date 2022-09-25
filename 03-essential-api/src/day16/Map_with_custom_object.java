package day16;

import java.util.HashMap;
import java.util.Map;

public class Map_with_custom_object {

	public static void main(String[] args) {
		Map<Integer, Employee> map = new HashMap<Integer, Employee>();
		
		var emp = new Employee(1001, "Aung Aung", "Yangon");
		map.put(1001, emp);
		map.put(1002, new Employee(1002, "Kyaw Kyaw", "Yangon"));
		map.put(1003, new Employee(1003, "Kyaw Kyaw", "Mandalay"));
		map.put(1004, new Employee(1004, "Cherry", "Mandalay"));
		
		System.out.println("---- Employee List ----");
		map.forEach((k,v) -> {
			System.out.print(v.getId() + "\t");
			System.out.print(v.getName() + "\t");
			System.out.print(v.getCity() + "\n");
		});
		
//		retrieve
//		Employee obj = map.get(1004);
		var obj = map.get(1004);
		System.out.println("obj: " + obj);
		
		System.out.println("---- emp in Yangon ----");
		map.forEach((k, o) -> {
			if (o.getCity().equalsIgnoreCase("yangon")) {
				System.out.println(o);
			}
		});
	}
}

class Employee {
	
	private int id;
	private String name;
	private String city;
	
	public Employee() {
		
	}
	
	public Employee(int id, String name, String city) {
		super();
		this.id = id;
		this.name = name;
		this.city = city;
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

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", city=" + city + "]";
	}
	
	
	
}