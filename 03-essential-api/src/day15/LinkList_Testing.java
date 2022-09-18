package day15;

import java.util.LinkedList;

public class LinkList_Testing {

	public static void main(String[] args) {
		LinkedList<String> list = new LinkedList<>();

		list.add("Nilar");
		list.add("Kyaw Kyaw");
		list.add(0, "Cherry");

		System.out.println(list);

		list.addFirst("Jeon");
		list.addLast("Naung Naung");

		System.out.println(list);

		System.out.println("Last element: " + list.getLast());
		System.out.println("List[2]: " + list.get(2));

	}
}
