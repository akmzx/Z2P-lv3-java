package com.mmit.day4;

import java.util.Arrays;

public class Array_1 {
	public static void main(String[] args) {
		int[] arr1 = { 100, 20, 200, 40, 90 };

		for (int a : arr1)
			System.out.println(a);

//		copy
		int[] arr2 = Arrays.copyOf(arr1, arr1.length);
		System.out.println("After copy, arr2 : " + Arrays.toString(arr2));

		int[] arr3 = Arrays.copyOfRange(arr1, 1, 3);
		System.out.println("After copy, arr2 : " + Arrays.toString(arr3));

//		equals
		System.out.println("arr1 == arr2 : " + Arrays.equals(arr1, arr2));
		System.out.println("arr1 == arr3 : " + Arrays.equals(arr1, arr3));

		Arrays.sort(arr1);
		System.out.println("After sort, arr1 : " + Arrays.toString(arr1));

//		search
		System.out.println("Contains 90?: " + (Arrays.binarySearch(arr1, 90) < 0 ? "False" : "True"));
		System.out.println("Contains 190?: " + (Arrays.binarySearch(arr1, 190) < 0 ? "False" : "True"));

		Arrays.fill(arr1, 7);
		System.out.println("After fill, arr1: " + Arrays.toString(arr1));

		int total = Arrays.stream(arr1).sum();
		int min = Arrays.stream(arr1).min().getAsInt();
		int max = Arrays.stream(arr1).max().getAsInt();
		double avg = Arrays.stream(arr1).average().getAsDouble();
		System.out.println("Total: " + total);
		System.out.println("Min value: " + min);
		System.out.println("Max value: " + max);
		System.out.println("Average value: " + avg);

		System.out.println("Before calling, arr1: " + Arrays.toString(arr1));
		changeValue(arr1);
		System.out.println("After calling, arr1: " + Arrays.toString(arr1));

		String data = "Aung Aung";
		System.out.println("Before, data = " + data);
		change(data);
		System.out.println("After, data = " + data);

		Song s = new Song();
		s.name = "Love Yourself";
		System.out.println("Before, name: " + s.name);
		passObject(s);
		System.out.println("After, name: " + s.name);
	}

	private static void passObject(Song obj) {
		obj.name = "Fake Love";
		System.out.println("Inside : name = " + obj.name);
	}

	private static void change(String data) {
		data = "Cherry";
	}

	private static void changeValue(int[] input) { // input = arr1
		input[1] = 100;
	}
}

class Song {
	String name;
}
