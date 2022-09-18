package day10;

public class Person {
	String name;
	int age;
	boolean is_single;

//	default
	public Person() {

	}

//	parametrize
	public Person(String name, int age, boolean is_single) {
		super();
		this.name = name;
		this.age = age;
		this.is_single = is_single;
	}

	public void display() {
		System.out.println("Name: " + name);
		System.out.println("Age: " + age);
		System.out.println("Is single? " + (is_single ? "yes" : "no"));

	}

}
