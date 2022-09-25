package day17;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Filtering {

	public static void main(String[] args) {
		List<User> users = List.of(new User("Kyaw Kyaw", "Admin"), new User("Maung Maung", "Staff"),
				new User("Yuri", "Customer"), new User("Jeon", "Customer"), new User("Aung Aung", "Staff"));

//		users.stream() // create stream
//			.filter( u -> u.getRole().equals("Staff")) // intermediate operation
//			.forEach( u -> { // terminal operation
//				System.out.println("Name: " + u.getName());
//				System.out.println("Role: " + u.getRole());
//			});
		/*
		 * users.stream() // create stream .filter(User::IsStaff) // intermediate
		 * operation .forEach( u -> { // terminal operation System.out.println("Name: "
		 * + u.getName()); System.out.println("Role: " + u.getRole()); });
		 */

//		with multiple condition
		List<String> names = users.stream().filter(u -> u.getName().contains("aung") && u.getRole().equals("Staff"))
				.map(u -> u.getName()).collect(Collectors.toList());
		System.out.println(names);

//		without stream
		List<String> nameList = new ArrayList<>();
		for (User u : users) {
			if (u.getName().contains("aung") && u.getRole().equals("Staff"))
				nameList.add(u.getName());
		}
		System.out.println(nameList);
	}
}

class User {
	private String name;
	private String role;

	public User(String name, String role) {
		this.name = name;
		this.role = role;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	boolean IsStaff() {
		return this.role.equals("Staff");
	}

}
