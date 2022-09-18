package day11.pkg2;

import day11.pkg1.A;

public class E extends A {
	
//	protected int k = 10;
//	public int x = 10;
	public void test() {
		
		System.out.println("k = " + k); // ok, sub-class
//		System.out.println("j = " + j); // error(different pkg)
		System.out.println("x = " + x); // ok(public)
		
		A obj = new A();
//		System.out.println("A's k = " + obj.k);
//		System.out.println("j = " + obj.j); // different pkg
		System.out.println("x = " + obj.x); // ok (public)
	}
}
