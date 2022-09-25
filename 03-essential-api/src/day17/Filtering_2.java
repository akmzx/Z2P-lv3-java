package day17;

import java.util.function.Predicate;
import java.util.stream.Stream;

public class Filtering_2 {
	public static void main(String[] args) {
		Stream<Integer> numbers = Stream.iterate(1, i -> i + 1).limit(20);

//		numbers.forEach(i -> System.out.print(i + " "));
		Predicate<Integer> even = a -> a % 2 == 0;
		numbers.filter(num -> num >= 1 && num <= 15)
				.filter(even)
				.forEach(num -> System.out.print(num + " "));
	}
}
