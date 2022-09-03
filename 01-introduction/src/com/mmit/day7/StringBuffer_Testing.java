package com.mmit.day7;

public class StringBuffer_Testing {

	public static void main(String[] args) {
		StringBuffer buffer = new StringBuffer("Java Programming");
		System.out.println("Original buffer = " + buffer);
		buffer.append(" language");
		System.out.println("After append, buffer = " + buffer);
		
		buffer.insert(5, " is a ");
		System.out.println("After insert, buffer = " + buffer);
		
		buffer.replace(0, 4, "Php");
		System.out.println("After replace, buffer = " + buffer);
		
		System.out.println("location of 'Programming': " + buffer.indexOf("Programming"));
		System.out.println("substring: " + buffer.substring(4));
		System.out.println("Length: " + buffer.length());
		
		buffer.delete(5, 10);
		System.out.println("After delete, buffer = " + buffer);
		System.out.println("length: " + buffer.length());
		
		String str = "abc";
		System.out.println("substring = " + str.substring(5));
		System.out.println("---- Final statement -----");
	}

}
