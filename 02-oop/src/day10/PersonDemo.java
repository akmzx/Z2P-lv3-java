package day10;

public class PersonDemo {
	
	public static void main(String[] args) {
		var person1 = new Person();
		var person2 = new Person("Cherry", 20, true);
		
		person1.display();
		System.out.println("-------------");
		person2.display();
	}
}