package day16;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class Set_Testing {
	
	public static void main(String[] args) {
		HashSet<String> set = new HashSet<>();
		
//		add
		set.add("Orange");
		set.add("Apple");
		set.add(null);
		set.add("Mango");
		set.add("Strawberry");
		
		System.out.println(set);
		
		set.remove("Mango");
		System.out.println("After remove: " + set);
//		System.out.println("[1]: " + set.);
		
		var set2 = Set.of("Potatos", "PineApple");
		
		set.addAll(set2);
		
		System.out.println("After add: " + set);
		
//		LinkHashset
		LinkedHashSet<String> set3 = new LinkedHashSet<>();
		
		set3.add("Aung Aung");
		set3.add("Yuki");
		set3.add("Jeon");
		
		System.out.println("Set3: " + set3);
		
		set3.removeIf(s -> s.contains("n"));
		System.out.println("After remove: " + set3);
		
//		TreeSet
		
		TreeSet<String> set4 = new TreeSet<>();
		
		set4.add("Orange");
		set4.add("Apple");
		set4.add("Mango");
		set4.add("Pineapple");
//		set4.add(null);
		
		System.out.println("Set4: " + set4);
		
		var set5 = set4.descendingSet();
		
		System.out.println("Desc set5: " + set5);
	}
}
