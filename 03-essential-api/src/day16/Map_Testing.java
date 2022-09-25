package day16;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class Map_Testing {

	public static void main(String[] args) {
		Map<String, String> foods = new HashMap<>();
//		add value
		foods.put("Orange", "Fruit");
		foods.put("Grape", "Fruit");
		
		Map<String, String> another = Map.of("Mango", "Fruit", "Potato", "Vegetable");
		
		foods.putAll(another);
		
		System.out.println(foods);
		
		Map<String, String> another2 = Map.ofEntries(
				Map.entry("Coffee", "Juice"),
				Map.entry("Milk Tea", "Juice")
				);
		foods.putAll(another2);
		
		System.out.println("---- All Items ----");
		foods.forEach((k,v) -> {
			System.out.println(k + " -> " + v);
		});
		
//		retrieve a single value with 'key'
		System.out.println("foods[Grape]: " + foods.get("Grape"));
		
		foods.putIfAbsent("kiwi", "Fruit");
//		foods.putIfAbsent("Grape", "Vegetable");
//		foods.put("Grape", "Vegetable");
		System.out.println("After add, " + foods);
		
		System.out.println("Coffee? " + foods.containsKey("Coffee"));
		System.out.println("Dessert? " + foods.containsValue("Dessert"));
		
//		get only keys
		Set<String> keys = foods.keySet();
		System.out.println("Keys: " + keys);
		
//		get only values
		Collection<String> values = foods.values();
		System.out.println("Values: " + values);
		
//		get key + value (entry)
		Set<Entry<String, String>> entries = foods.entrySet();
		
		System.out.println("entries: " + entries);
		
////		remove
//		foods.remove("Potato");
//		System.out.println("After remove: " + foods);
//		
////		remove key with removeif
//		foods.keySet().removeIf(s -> s.contains("i"));
//		System.out.println("After remove: " + foods);
//	
////		remove value with removeif
//		foods.values().removeIf(s -> s.equals("Fruit"));
//		System.out.println("After remove: " + foods);
		
//		update
		foods.replace("Grape", "Juice");
		System.out.println("After replace: " + foods);
		
//		compute (if exist, update. If not exist, auto put new)
		foods.compute("Coffee", (k,v) -> "Fruit");
		System.out.println("value of coffee: " + foods.get("Coffee"));
		
		foods.compute("Tea", (k,v) -> "Dessert");
		System.out.println(foods);
		
//		computeIfAbsent (if exist, no-effect. If not exist, auto put new)
		foods.computeIfAbsent("Coffee", k -> "Dessert");
		foods.computeIfAbsent("Yogurt", k -> "Abc");
		System.out.println("Coffee: " + foods.get("Coffee"));
		System.out.println(foods);
		
//		computeIfPresent (If exist, update. If no exist, no-effect)
		foods.computeIfPresent("Yogurt", (k,v) -> "AAA");
		foods.computeIfPresent("Pizza", (k,v) -> "Italian food");
		System.out.println("Yogurt: " + foods.get("Yogurt"));
		System.out.println("Pizza: " + foods.get("Pizza"));
		
		
		
		
	}

}
