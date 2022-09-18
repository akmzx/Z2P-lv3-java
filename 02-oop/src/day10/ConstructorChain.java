package day10;

public class ConstructorChain {

	public ConstructorChain(int x, int y) {
		System.out.println("This is two arguments constructor");
	}
	
	public ConstructorChain(int i) {
		System.out.println("This is one argument constructor");
	}
	
	public ConstructorChain() {
		this(100);
		System.out.println("This is zero argumnt constructor");
	}
	
	public static void main(String[] args) {
//		var obj = new ConstructorChain();
		var obj = new Teacher("Mr. Kyaw", "Tutor");
		System.out.println("Name: " + obj.getName());
		System.out.println("Position: " + obj.getPosition());
	
//		var ani = new Animal();
	}
	
}

class Employee {
	private String name;

	public Employee() {
		
	}
	
	public Employee(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
}

// concrete
// abstract
// final 
// singleton
class Teacher extends Employee {
	
	private String position;
	
	public Teacher (String name, String pos) { // "Mr. Kyaw", "Tutor"
		super(name);
		this.position = pos;
	}
	
	public String getPosition() {
		return position;
	}
}

class Animal {
	private Animal() {
		
	}
}

//class Dog extends Animal {
//	
//}