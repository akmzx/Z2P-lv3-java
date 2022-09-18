package day10;

import java.time.LocalDate;

public class BookDemo {

	public static void main(String[] args) {
		LocalDate  pub_date = LocalDate.of(1986, 10, 16);
		var book1 = new Book("Detectiv U San Shar", pub_date, 6500);
		
		System.out.println("book1 = " + book1);
		
		var book2 = new Book(book1);
		System.out.println("book2 = " + book2);
	}
}
