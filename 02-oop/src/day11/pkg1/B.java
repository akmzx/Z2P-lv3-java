package day11.pkg1;

public class B {
	
	public void test() {
		A obj = new A();
//		System.out.println("i = " + obj.i); // private
		System.out.println("j = " + obj.j); // pkg, within the same pkg
		System.out.println("k = " + obj.k); // protected, within the same pkg
		System.out.println("x = " + obj.x); // public
	}
}
