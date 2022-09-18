package day15.bms;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Start {

	private static List<String> categoryList = new ArrayList<>();
	private static List<Author> authorList = new ArrayList<>();
	private static List<Book> bookList = new ArrayList<>();

	public static void main(String[] args) {
//		initialize
		initialize();

//		choose option
		String inputs = """
				1. View Author
				2. View Category
				3. View Book
				4. Add Book
				Choose(1, 2, 3, 4): """;
		Scanner sc = new Scanner(System.in);
		System.out.println(inputs);
		var option = Integer.parseInt(sc.nextLine());

		switch (option) {
		case 1:
			viewAuthor();
			break;
		case 2:
			viewCategory();
			break;
		case 3:
			viewBook(sc);
			break;
		case 4:
			addBook(sc);
			break;
		default:
			System.err.println("Invalid number");

		}
		sc.close();
	}

	private static void addBook(Scanner sc) {
		// TODO Auto-generated method stub

	}

	private static void viewBook(Scanner sc) {
		var inputs = """
				1. View All
				2. View By Category
				3. View By Author
				Choose(1, 2, 3): """;
		System.out.println(inputs);
		var option = Integer.parseInt(sc.nextLine());

		if (option == 1)
			viewAll();
		else if (option == 2)
			viewByCategory(sc);
		else if (option == 3)
			viewByAuthor(sc);
		else
			System.err.println("Wrong Number");

	}

	private static void viewByAuthor(Scanner sc) {
		System.out.println("Enter author name: ");
		var name = sc.nextLine();

		var author = searchAuthor(name);
		if (author == null) {
			System.err.println("This author does not exist");
		} else { // found
			List<Book> resultList = new ArrayList<>();
			for (var b : bookList) {
				if (b.getAuthor().getName().equalsIgnoreCase(author.getName()))
					resultList.add(b);
			}
			
			if(resultList.size() == 0)
				System.err.println("There is no books related to this author");
			else {
				System.out.println("Code \t Title \t publishDate \t Category \t Author");
				System.out.println("-----------------------------------------");
				resultList.forEach(obj -> {
					System.out.print(obj.getCode() + "\t");
					System.out.print(obj.getTitle() + "\t");
					System.out.print(obj.getPublishDate() + "\t");
					System.out.print(obj.getCategory() + "\t");
					System.out.print(obj.getAuthor().getName() + "\n");
				});
			}
		}

	}

	private static Author searchAuthor(String name) {
		Author auth = null;
		for (var obj : authorList) {
			if (obj.getName().equalsIgnoreCase(name)) {
				auth = obj;
				break;
			}
		}
		return auth;
	}

	private static void viewByCategory(Scanner sc) {

	}

	private static void viewAll() {
		// TODO Auto-generated method stub

	}

	private static void viewCategory() {
		// TODO Auto-generated method stub

	}

	private static void viewAuthor() {
		System.out.println("Name\t Native Town");
		System.out.println("----------------------------");
		authorList.forEach(auth -> {
			System.out.println(auth.getName() + "\t" + auth.getCountry());
		});
	}

	private static void initialize() {
//		initialize category
		categoryList.add("Sports");
		categoryList.add("Musics");
		categoryList.add("Travels and Tour");
		categoryList.add("Skincares");

//		initialize author
		authorList.add(new Author("Jeon", "Korea"));
		authorList.add(new Author("Miki", "India"));
		authorList.add(new Author("Kyaw Kyaw", "Myanmar"));

//		initialize book
		var book1 = new Book();
		book1.setAuthor(authorList.get(1));
		book1.setCategory(categoryList.get(0));
		book1.setCode(1001);
		book1.setPublishDate(LocalDate.now());
		book1.setTitle("Title 1");

		var book2 = new Book();
		book2.setAuthor(authorList.get(0));
		book2.setCategory(categoryList.get(1));
		book2.setCode(1002);
		book2.setPublishDate(LocalDate.now());
		book2.setTitle("Title 2");

		var book3 = new Book();
		book3.setAuthor(authorList.get(0));
		book3.setCategory(categoryList.get(1));
		book3.setCode(1003);
		book3.setPublishDate(LocalDate.now());
		book3.setTitle("Title 3");

		bookList.add(book1);
		bookList.add(book2);
		bookList.add(book3);
	}
}
