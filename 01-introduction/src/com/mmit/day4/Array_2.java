package com.mmit.day4;

import java.util.Arrays;

public class Array_2 {

	public static void main(String[] args) {
		print_array();
		int[][] marks = { { 100, 30, 90, 40, 50 }, { 90, 90, 80, 70, 100 }, { 70, 100, 90, 100, 100 } };
		String[] names = {"Jeon", "Yuri", "Cherry"};
		int row = marks.length;
		int col = marks[0].length;
		
		for (var r = 0; r < row; r++) {
			int total = 0;
//			for (int c = 0; c < col; c++) {
//				total += marks[r][c];
//			}
			total = Arrays.stream(marks[r]).sum();
			double avg = Arrays.stream(marks[r]).average().getAsDouble();
			int min_mark = Arrays.stream(marks[r]).min().getAsInt();
			
			System.out.println("Total marks obtained by " + names[r] + ": " + total + " marks");
			System.out.println("Average mark: " + avg + " marks");
			System.out.println("Minum marks: " + min_mark);
			System.out.println("---------------");
		} 
	}

	private static void print_array() {
		int[][] marks = { { 100, 30, 90, 40, 50 }, { 90, 90, 80, 70, 100 }, { 70, 100, 90, 100, 100 } };

		System.out.println("----- Print with for loop -----");
		for (var r = 0; r < 3; r++) { // rows
			for (var c = 0; c < 5; c++) { // columns
				System.out.print(marks[r][c] + "\t");
			}
			System.out.println();
		}

		System.out.println("----- Print with for each loop -----");
		for (int[] arr : marks) {
			for (var m : arr) {
				System.out.print(m + "\t");
			}
			System.out.println();
		}
	}
}
