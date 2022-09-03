package com.mmit.day5;

public class Array_3 {

	public static void main(String[] args) {
		int[][] data = { { 1, 2 }, { 1, 2, 3, 4 }, { 1, 2, 3 } };
		for (var i = 0; i < data.length; i++) {
			for (var j = 0; j < data[i].length; j++)
				System.out.print(data[i][j] + "\t");
			System.out.println();
		}
		
		System.out.println("---------------");
		for (int[] row : data) {
			for (int val : row) 
				System.out.print(val + "\t");
			System.out.println();
		}
	}
}
