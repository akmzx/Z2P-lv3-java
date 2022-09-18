package day11.inheritance;

public class Person {

	private String name;
	protected String phone;

	public Person(String name, String phone) {
		this.name = name;
		this.phone = phone;
	}

	public void display() {
		System.out.println("Name: " + name);
		System.out.println("Phone: " + phone);
	}
}
