package day13.abstraction;

public class HasA_relationship {
	
	public static void main(String[] args) {
//		var book = new Book("War and Peace", 9000, new Author("Mya Than Tint", "Myaing"));
	var auth = new Author("Mya Than Tint", "Myaing");
	var book = new Book("War and Peace", 9000, auth);
	
	System.out.println("---- Book Info ----");
	System.out.println("Title: " + book.title);
	System.out.println("Price: " + book.price);
	System.out.println("---- Author Info ----");
	System.out.println("Name: " + book.author.name);
	System.out.println("Native Town: " + book.author.nativeTown);
	}
}

class Author {
	String name;
	String nativeTown;
	public Author(String name, String nativeTown) {
		super();
		this.name = name;
		this.nativeTown = nativeTown;
	}	
}

class Book {
	String title;
	int price;
	Author author; // book has an author object (book has a dependency(author))
	public Book(String title, int price, Author author) {
		super();
		this.title = title;
		this.price = price;
		this.author = author;
	}
}