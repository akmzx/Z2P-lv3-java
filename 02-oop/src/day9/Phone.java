package day9;

public class Phone {
//	fields
	String brand;
	String color;
	int price;

//	constructors
	public Phone(String brand, String color, int price) {
		this.brand = brand;
		this.color = color;
		this.price = price;
	}

//	methods
	public void call() {
		System.out.println("This is phone calling method");
	}

	public void sendSms() {
		System.out.println("This is sending sms method");
	}
	
	public static void main(String[] args) {
//		creating obj
		Phone obj; // declare obj
		obj = new Phone("iPhone", "pink", 3100000); // create object
		
		Phone obj2 = new Phone("Samsung", "purple", 3200000);
		
		System.out.println("----- obj's data -----");
		System.out.println("Brand: " + obj.brand);
		System.out.println("Color: " + obj.color);
		System.out.println("Price: " + obj.price);
		obj.call();
		obj.sendSms();
		
		System.out.println("----- obj2's data -----");
		System.out.println("Brand: " + obj2.brand);
		System.out.println("Color: " + obj2.color);
		System.out.println("Price: " + obj2.price);
		obj2.call();
		obj2.sendSms();
	}
}
