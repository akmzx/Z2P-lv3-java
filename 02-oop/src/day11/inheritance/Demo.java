package day11.inheritance;

public class Demo {

	public static void main(String[] args) {
		var std = new Student(1, "Jeon", "09123456");
		std.display();
		System.out.println("Rno: " + std.getRno());
		System.out.println("-----");
//		std.show();
		
		
		Person obj = new Person("Hla Hla", "0987654");
		obj.display(); // person's display
		
		obj = new Student(2, "Kyaw Kyaw", "234567");
		
		obj.display();
	}

}
