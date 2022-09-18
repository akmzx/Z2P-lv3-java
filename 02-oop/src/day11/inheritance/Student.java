package day11.inheritance;

public class Student extends Person {
	
	private int rno;
	static int mark;
	
	// 1, "Jeon", "09123456"
	public Student(int rno, String name, String phone) {
		super(name, phone);
		this.rno = rno;
	}
	
	public int getRno() {
		return rno;
	}
	
	@Override
	public void display() {
		System.out.println("Roll number: " + rno);
//		System.out.println("Name: " + name);
		super.display();
	}
	
	public void show() {
		super.display();
		mark = 100;
	}
	
}
