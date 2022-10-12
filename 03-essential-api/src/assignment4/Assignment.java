package assignment4;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Assignment {

	public static void main(String[] args) {
		
		List<Salespeople> salepeoples = List.of(
				new Salespeople("Peel", "London", 0.12f),
				new Salespeople("Serres", "San Jose", 0.13f),
				new Salespeople("Motika", "London", 0.11f),
				new Salespeople("Rifkin", "Barcelona", 0.15f),
				new Salespeople("Axelrod", "New York", 0.10f)
			);
		
		System.out.println("Salespeople in London with a commission above .10\n");
		salepeoples.stream()
					.filter(obj -> obj.getComm() > 0.10f && obj.getCity().equals("London"))
					.forEach(obj -> {
						System.out.println("Name: " + obj.getName() + "\nCity: " + obj.getCity());
						System.out.println("-------------");
					});
		
		System.out.println("\nSalesperson details not having commission .10, .13 or .15\n");
		salepeoples.stream()
					.filter(obj -> obj.getComm() != 0.10f && obj.getComm() != 0.13f && obj.getComm() != 0.15f)
					.forEach(obj -> {
						System.out.println("Name: " + obj.getName() + "\nCity: " + obj.getCity() + "\nComm: " + obj.getComm());
						System.out.println("-------------");
					});
		
		System.out.println("Different city names");
		List<String> cities = salepeoples.stream()
										.map(s -> s.getCity())
										.distinct()
										.collect(Collectors.toList());
		System.out.println("Cities: " + cities);
		
		System.out.println();
		System.out.println("The top of (salespeople 3) records\n");
		salepeoples.stream().sorted(Comparator.comparingDouble(Salespeople::getComm)).limit(3).forEach(obj -> {
			System.out.println("Name: " + obj.getName() + "\nCity: " + obj.getCity() + "\nComm: " + obj.getComm());
			System.out.println("-------------");
		});
		
		salepeoples.stream()
		.filter(obj -> obj.getCity().equals("Rome"))
		.forEach(obj -> {
			System.out.println("Name: " + obj.getName() + "\nCity: " + obj.getCity());
			System.out.println("-------------");
		});
		
		
		long count = salepeoples.stream().filter(obj -> obj.getCity().equals("London")).count();
		System.out.println("Number of people who stay in London: " + count + "\n");
		
		System.out.println("List of salespeople in descending order of commission\n");
		salepeoples.stream().sorted(Comparator.comparingDouble(Salespeople::getComm).reversed()).forEach(obj -> {
			System.out.println("Name: " + obj.getName() + "\nCity: " + obj.getCity() + "\nComm: " + obj.getComm());
			System.out.println("-------------");
		});
		
	}
	
}
