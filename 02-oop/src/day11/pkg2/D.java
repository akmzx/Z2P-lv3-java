package day11.pkg2;

import day11.pkg1.A;

public class D {
	
	public void test() {
		A obj = new A();
//		System.out.println("j = " + obj.j); // different pkg, can't access
//		System.out.println("k = " + obj.k);  // different pkg, non-subclass
		System.out.println("x = " + obj.x);  // ok (public)
	}
}
