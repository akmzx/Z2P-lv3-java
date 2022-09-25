package day17;

import java.util.List;

public class Matching {

	public static void main(String[] args) {
		
		List<Integer> numbers = List.of(2, 4, 6, 8, 10, 13, 11);
		
		var result1 = numbers.stream().allMatch(n -> n%2 == 0);
		
		System.out.println("Result1: " + result1);
		System.out.println("Result2: " + numbers.stream().anyMatch(n -> n%2 == 0));
		System.out.println("Result3: " + numbers.stream().noneMatch(n -> n%2 == 0));
		
		
	}
}
