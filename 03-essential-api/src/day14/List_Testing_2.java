package day14;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class List_Testing_2 {

	public static void main(String[] args) {
		String[] data = {"Aung Aung", "Jeon", "Yuki", "Maung Maung"};
		
//		List<String> lst = Arrays.asList(data);
//		ArrayList<String> names = new ArrayList<>(lst);
		ArrayList<String> names = new ArrayList<>(Arrays.asList(data));
		
		names.add("Jeon");
		System.out.println(names);
		
//		sort
		Collections.sort(names);
		System.out.println("After sort, " + names);
		
//		sort desc
		Collections.reverse(names);
		System.out.println("After sort, " + names);
		
		int result = Collections.binarySearch(names, "Naung");
		System.out.println((result < 0 ? "Not found" : "Found"));
		
		System.out.println(Collections.binarySearch(names, "Jeon") < 0 ?  "Not found" : "Found");
		
		if(names.contains("Yuki"))
			System.out.println("Yuki is found");
		
//		remove with index
		names.remove(0);
		System.out.println("After remove, " + names);
		
//		remove with object
//		names.remove("Aung Aung");
//		System.out.println("After remove, " + names);
	
		names.removeIf(str -> str.endsWith("ung"));
		System.out.println(names);
	}

}
