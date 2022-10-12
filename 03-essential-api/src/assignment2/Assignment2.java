package assignment2;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Assignment2 {

	private static List<String> categoryList = new ArrayList<>();
	private static List<Author> authorList = new ArrayList<Author>();
	private static List<Book> bookList = new ArrayList<Book>();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		boolean exit = false;
		initialize();
		do {
			String data = """
					1. View Authors
					2. View Books
					3. View Categories
					4. Add Book
					5. Exist
					Enter number of the action you want to take: """;
			System.out.print(data);
			int functionNo = sc.nextInt();
			sc.nextLine();
			switch (functionNo) {
			case 1: {
				System.out.println("Name\t Country");
				for (Author author : authorList) {
					System.out.println(author.getName() + "\t" + author.getCountry());
				}
				break;
			}
			case 2: {
				viewBook(sc);
				break;
			}
			case 3: {
				for (String category : categoryList) {
					System.out.println(category);
				}
				break;
			}
			case 4: {
				inputData(sc);
				break;
			}
			case 5:
				exit = true;
				System.out.println("Thanks for using our service");
				sc.close();
				break;
			default:
				throw new IllegalArgumentException("Unexpected value: " + functionNo);
			}
			System.out.println("-----------------------------");
		} while (!exit);

	}

	private static void inputData(Scanner sc) {
		int code;
		String title;
		LocalDate publishDate;
		int year;
		int month;
		int day;
		String category;
		String author;

		code = bookList.get(bookList.size() - 1).getCode() + 1;
		System.out.print("Enter title: ");
		title = sc.nextLine();
		System.out.print("Enter publish year: ");
		year = sc.nextInt();
		sc.nextLine();
		System.out.println("Enter publish month: ");
		month = sc.nextInt();
		sc.nextLine();
		System.out.println("Enter publish day: ");
		day = sc.nextInt();
		sc.nextLine();
		publishDate = LocalDate.of(year, month, day);
		System.out.println("Enter Category name: ");
		category = sc.nextLine();
		System.out.println("Enter Author's name: ");
		author = sc.nextLine();

		addBook(code, title, publishDate, category, author);
	}

	private static void addBook(int code, String title, LocalDate publishDate, String category, String author) {
		Scanner sc = new Scanner(System.in);
		boolean categoryExist = false;
		boolean authorExist = false;
		for (String categoryName : categoryList) {
			if (categoryName.equalsIgnoreCase(category)) {
				categoryExist = true;
				break;
			}
		}
		if (!categoryExist) {
			categoryList.add(category);
		}

		for (Author authorobj : authorList) {
			if (authorobj.getName().equalsIgnoreCase(author)) {
				authorExist = true;
				break;
			}
		}
		if (!authorExist) {
			String country;
			System.out.println("This is new author. Please enter author’s country name");
			country = sc.nextLine();
			authorList.add(new Author(author, country));
		}

		Book addedbook = new Book(code, title, publishDate, category, authorList.get(authorList.size() - 1));
		bookList.add(addedbook);
		System.out.println("Book added");
	}

	private static void viewBook(Scanner sc) {
		String input = """
				1. View All
				2. View With Category
				3. View With Author
				Enter number of the action you want to take: """;
		System.out.print(input);
		int inputNo = sc.nextInt();
		sc.nextLine();
		switch (inputNo) {
		case 1: {
			System.out.println("Code\t Title\t Publish Date\t Category\t Author");
			for (Book book : bookList) {
				System.out.println(book.getCode() + "\t " + book.getTitle() + "\t " + book.getPublishDate() + "\t "
						+ book.getCategory() + "\t " + book.getAuthor().getName());
			}
			break;
		}
		case 2: {
			viewByCategory(sc);
			break;
		}
		case 3: {
			ViewByAuthor(sc);
			break;
		}
		default:
			throw new IllegalArgumentException("Unexpected value: " + inputNo);
		}
	}

	private static void ViewByAuthor(Scanner sc) {
		boolean exist = false;

		System.out.print("Enter Author's name: ");
		String authorName = sc.nextLine();

		for (Author author : authorList) {
			if (author.getName().equalsIgnoreCase(authorName)) {

				exist = true;
				boolean found = false;

				for (Book book : bookList) {
					if (book.getAuthor().getName().equalsIgnoreCase(authorName)) {
						found = true;
						searchBookByAuthor(authorName);
						break;
					}
				}
				if (!found) {
					System.out.println("There is no book data for this author");
				}
			}
		}
		if (!exist) {
			System.out.println("This author does not exist");
		}
	}

	private static void searchBookByAuthor(String authorName) {
		for (Book book : bookList) {
			if (book.getAuthor().getName().equalsIgnoreCase(authorName)) {
				System.out.println("Code: " + book.getCode() + "\nTitle: " + book.getTitle() + "\nPublish Date: "
						+ book.getPublishDate() + "\nCategory: " + book.getCategory());
			}
		}
	}

	private static void viewByCategory(Scanner sc) {

		boolean exist = false;

		System.out.print("Enter Category name: ");
		String categoryName = sc.nextLine();

		for (String category : categoryList) {
			if (category.equalsIgnoreCase(categoryName)) {
				exist = true;
				boolean found = false;
				for (Book book : bookList) {
					if (book.getCategory().equalsIgnoreCase(categoryName)) {
						found = true;
						searchBookByCategory(categoryName);
						break;
					}
				}
				if (!found) {
					System.out.println("There is no book data for this category");
				}
			}
		}
		if (!exist) {
			System.out.println("This category does not exist");
		}
	}

	private static void searchBookByCategory(String categoryName) {
		for (Book book : bookList) {
			if (book.getCategory().equalsIgnoreCase(categoryName)) {
				System.out.println("Code: " + book.getCode() + "\nTitle: " + book.getTitle() + "\nPublish Date: "
						+ book.getPublishDate() + "\nAuthor: " + book.getAuthor().getName());
			}
		}
	}

	private static void initialize() {
//		initialize category
		categoryList.add("Sports");
		categoryList.add("Business");
		categoryList.add("Horror");
		categoryList.add("Art");

//		initialize author
		authorList.add(new Author("Alex Ferguson", "England"));
		authorList.add(new Author("Stephen King", "America"));
		authorList.add(new Author("Zaw Gyi", "Myanmar"));

//		initialize book
		Book book1 = new Book(1001, "My Autobiography", LocalDate.of(2013, 10, 24), categoryList.get(0),
				authorList.get(0));
		Book book2 = new Book(1002, "Beida Lan", LocalDate.of(2013, 10, 1), categoryList.get(3), authorList.get(2));
		Book book3 = new Book(1003, "The Green Mile", LocalDate.of(1996, 8, 29), categoryList.get(2),
				authorList.get(1));

		bookList.add(book1);
		bookList.add(book2);
		bookList.add(book3);
	}
}
