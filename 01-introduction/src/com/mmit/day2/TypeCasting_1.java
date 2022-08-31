package com.mmit.day2;

public class TypeCasting_1 {

	public static void main(String[] args) {
		
		Person p = new Person();
		
		Student s = new Student();
		
		Person p1 = (Person)s; // p1 -> student (implicit casting)
		
		Teacher t = new Teacher();
		
		p1 = t; // p1 -> teacher (implicit casting)
		
		Student s1 = (Student) p1; // (explicit casting)
		System.out.println("Object Type Casting");
	}
}

class Person {
	private String name; // instance name
	private static int age; // static var
	
	void display() {
		System.out.println("name: " + name);
		System.out.println("age: " + age);
		test();
		show();
	}
	
	void test() {
		System.out.println("This is test");
	}
	
	static void show() { // static method
		System.out.println("This is static method");
//		System.out.println("name: " + name);
		System.out.println("age: " + age);
//		test();
		displayanother();
//		System.out.println("name: " + this.name);
		Person obj = new Person();
		obj.test();
	}
	
	static void displayanother() {
		
	}
}

class Student extends Person {
	
}

class Teacher extends Person {
	
}