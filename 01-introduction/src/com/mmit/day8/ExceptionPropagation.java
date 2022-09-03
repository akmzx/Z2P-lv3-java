package com.mmit.day8;

public class ExceptionPropagation {

	public static void main(String[] args) {
		test1();
	}

	private static void test1() {
		test2();
		
	}

	private static void test2() {
		test3();
	}

	private static void test3() {
	System.out.println((100/10));
	}
}
