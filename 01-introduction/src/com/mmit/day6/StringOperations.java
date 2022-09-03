package com.mmit.day6;

public class StringOperations {

	public static void main(String[] args) {
		char[] data = {'Y', 'W', 'K'};
		String s1 = new String(data);
		String s2 = "Java Programming";
		
		System.out.format("string1 = %s, string2 = %s\n", s1, s2);
		System.out.println("No of chars in s1: " + s1.length());
		System.out.println("No of chars in s2: " + s2.length());
		
		var tmp = s1.toLowerCase();
		System.out.println("After change, s1 = " + s1);
		System.out.println("After change, tmp = " + tmp);
		tmp = s2.toUpperCase();
		System.out.println("After change, s2 = " + s2);
		System.out.println("After change, tmp = " + tmp);
		System.out.println("Uppercase of s2: " + tmp.toUpperCase());
		
//		substring (start, end) -> start, end-1
		tmp = s2.substring(0, 4);
		System.out.println("After substring, s2: " + s2);
		System.out.println("tmp = " + tmp);
		tmp = s2.substring(6);
		System.out.println("tmp = " + tmp);
		
//		replace
		tmp = s2.replace("a", "Php");
		System.out.println("After replace, s2 = " + s2);
		System.out.println("tmp = " + tmp);
	
//		concat
		System.out.println("Contains 'Java' in s2: " + s2.contains("java"));
		System.out.println("Start with 'abc': " + s2.startsWith("abc"));
		System.out.println("End with 'ing': " + s2.endsWith("ing"));
		
		var i  = s2.indexOf("a");
		System.out.println("index of a: " + i);
		System.out.println("index of 'Programming': " + s2.indexOf("Programming"));
		System.out.println("index of 'abc': " + s2.indexOf("abc"));
		System.out.println("index of a: " + s2.lastIndexOf("a"));
		
		
//		split
		char[] output = s2.toCharArray();
		for (var v : output)
			System.out.println(v);
		String[] array = s2.split(" ");
		System.out.println("No of words: " + array);
		}
}
