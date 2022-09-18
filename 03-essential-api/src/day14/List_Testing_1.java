package day14;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public class List_Testing_1 {
	
	public static void main(String[] args) {
		
		ArrayList<Integer> list = new ArrayList<>();
		
//		add
		list.add(100);
		list.add(50);
		list.add(90);
		
		System.out.println("Length: " + list.size());
		System.out.println("list[0]: " + list.get(0)); // retrieve item
		
		System.out.println("---- all numbers ----");
		for (int i = 0; i < list.size(); i++) 
			System.out.println(list.get(i));
		System.out.println("All data: " + list);
		
		list.add(1, 400);
		System.out.println("After add, " + list);
		
		System.out.println("---- all numbers ----");
		list.forEach(n -> System.out.println(n));
	
//		update
		list.set(0, 2000);
		System.out.println("After update: " + list);
		
//		remove
		list.remove(1);
		System.out.println("After delete, " + list);
		
		if(list.contains(20000))
			System.out.println("found");
		else 
			System.out.println("not found");
		
		System.out.println("is empty? " + list.isEmpty());
		
//		remove all
//		list.clear();
		System.out.println("is empty? " + list.isEmpty());
		System.out.println("length: " + list.size());
		
//		max
		System.out.println("Max value is " + Collections.max(list));
	
//		sort
		Collections.sort(list);
		System.out.println("After sorting, " + list);
	}
}
