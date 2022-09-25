package day18;

import java.util.Arrays;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

class Student {
	private int rno;
	private String name;
	private String city;
	
	public Student(int rno, String name, String city) {
		super();
		this.rno = rno;
		this.name = name;
		this.city = city;
	}

	public int getRno() {
		return rno;
	}

	public void setRno(int rno) {
		this.rno = rno;
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
}

public class Collecting_1 {

	public static void main(String[] args) {
		
		Student[] students = {
				new Student(10, "cherry", "yangon"),
				new Student(2, "cherry", "mandalay"),
				new Student(5, "khaing", "monywa"),
				new Student(1, "htet", "mandalay"),
				new Student(11, "htet yadana", "yangon")
		};
		
		Set<String> hashSet = Arrays.stream(students)
								.map(s -> s.getName())
								.collect(Collectors.toSet());
		
		TreeSet<String> treeSet = Arrays.stream(students)
									.map(s -> s.getName())
									.collect(Collectors.toCollection(TreeSet::new));
		System.out.println("hashSet: " + hashSet);
		System.out.println("TreeSet: " + treeSet);
		
//		convert to Map<k, v>
		Map<Integer, String> map1 = Arrays.stream(students)
										.collect(Collectors.toMap(s -> s.getRno(), s -> s.getName()));
		Map<Integer, Student> map2 = Arrays.stream(students)
										.filter(obj -> !obj.getCity().equals("yangon"))
										.collect(Collectors.toMap(s -> s.getRno(), s -> s));
		
		System.out.println("map1: " + map1);
		
		map2.forEach((k, obj) -> {
			System.out.println("Rno: " + k);
			System.out.println("Name: " + obj.getName());
			System.out.println("City: " + obj.getCity());
			System.out.println("-----------------------------------");
		});
	}
}
