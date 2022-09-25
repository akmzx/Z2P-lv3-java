package day16;

import java.util.LinkedHashMap;
import java.util.TreeMap;

public class Map_Testing_2 {

	public static void main(String[] args) {
		
		var students = new LinkedHashMap<Integer, String>();
		students.put(11, "Aung Aung");
		students.put(2, "May");
		students.put(3, "Paing Paing");
		
		System.out.println(students);
		students.replace(3, "Honey");
		System.out.println("[3]: " + students.get(3));
		
		students.remove(3);
		System.out.println("[3]: " + students.get(3));
		
//		Treemap
		var fileExtens = new TreeMap<String, String>();
		fileExtens.put("java", ".java");
		fileExtens.put("javascript", ".js");
		fileExtens.put("css", ".css");
		fileExtens.put("c++", "cpp");
		fileExtens.put("html", ".html");
//		fileExtens.put(null, ".php");
		
		System.out.println(fileExtens);
	}
}
