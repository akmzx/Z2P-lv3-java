package day10;

public class BlockDemo {
	static final int MIN_LENGTH;
	String phone;
	
	public BlockDemo(String input_phone) {
		System.out.println("This is constructor block");
//		if (phone.length() >= MIN_LENGTH)
//			this.phone = phone;
	}
	{
//		instance block
		System.out.println("This is instance block");
	}
	
	static { // static block
		MIN_LENGTH = 9;
		System.out.println("This is static block");
	}
	
	public static void main(String[] args) {
		BlockDemo obj1 = new BlockDemo("09123456789");
		System.out.println("-------------");
		BlockDemo obj2 = new BlockDemo("123");
	}
}
