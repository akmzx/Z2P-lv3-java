package day17;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class FlatMapping {

	public static void main(String[] args) {
		List<String> drinks = Arrays.asList("Coffee", "Cola", "Pessi");
		List<String> foods = List.of("Pizza", "Burger", "Salad");
		List<String> desserts = List.of("Cake", "Ice cream");
		
		List<List<String>> items = new ArrayList<List<String>>();
		
		items.add(desserts);
		items.add(foods);
		items.add(drinks);
		
		System.out.println("No of elements: " + items.size());
		System.out.println("[0]" + items.get(0));
		
//		without stream
		List<String> resultList = new ArrayList<>();
		
		for (var i = 0; i < items.size(); i++) {
			List<String> tmp = items.get(i);
			for (int j = 0; j < tmp.size(); j++) {
				resultList.add(tmp.get(j));
			}
		}
		System.out.println("No of element in items: " + items);
		System.out.println(resultList);
		System.out.println("No of elements: " + resultList.size());
		
//		with stream
		System.out.println("---- using stream ----");
		
		Set<String> resultSet = items.stream()
									.flatMap(value -> value.stream())
									.collect(Collectors.toSet());
		System.out.println("No of elements: " + resultSet);
	}
}
