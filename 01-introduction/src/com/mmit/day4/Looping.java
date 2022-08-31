package com.mmit.day4;

public class Looping {

	public static void main(String[] args) {
		String[] languages = { "Java", "JavaScript", "PHP", "CSS" };
		for (String lang : languages) {
			if ("php".equalsIgnoreCase(lang))
				break;
			System.out.println(lang);
		}
	}
}
