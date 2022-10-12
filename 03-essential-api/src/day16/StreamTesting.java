package day16;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

import assignment4.Salespeople;

public class StreamTesting {
	
	public static void main(String[] args) {
		int[] prices = {1700, 2000, 1000, 3000, 500, 2500, 4500, 5000};
		
//		withoutStream(prices);
		withStream(prices);
	
	}

	private static void withStream(int[] prices) {
//		create
		IntStream stream = Arrays.stream(prices);
		
//		inter-operation + terminal-operation
		stream.filter( v -> v > 1500) // inter operation
			.sorted()
			.forEach(price -> System.out.println(price));
	}

	private static void withoutStream(int[] prices) {
		
//		filter
		List<Integer> filterlist = new ArrayList<>();
		for (int price : prices) 
			if (price > 1500) {
				filterlist.add(price);
		}
		
//		sorted
		Collections.sort(filterlist);
		
//		display the sorted data
		System.out.println("---- Sorted data ----");
		filterlist.forEach(val -> System.out.println(val));
		
	
	}
}
