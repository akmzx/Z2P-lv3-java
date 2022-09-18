package day13.abstraction;

public interface NewInterface {
	
	void method1();
	
	default void method2() {
		System.out.println("This is default method");
	}
	
	static void method3() {
		System.out.println("This is static method");
	}
}

class MyClass implements NewInterface {

	@Override
	public void method1() {
		System.out.println("This is my own method");
	}
	
//	@Override
//	public void method2() {
//		System.out.println("This is overriding method");
//	}
//	
}
