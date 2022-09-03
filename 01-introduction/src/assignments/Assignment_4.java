package assignments;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Assignment_4 {
	public static void main(String[] args) {
		LocalDate now = LocalDate.now();
		DateTimeFormatter datetime = DateTimeFormatter.ofPattern("EEE, MMM dd yyyy");
		String date = now.format(DateTimeFormatter.ofPattern("EEEE"));
		System.out.println(now.format(datetime));
		System.out.println("***************");
		if (date.equalsIgnoreCase("Saturday") || date.equalsIgnoreCase("Sunday")) {
			System.out.println("Today is my holiday!");
		} else {
			System.out.println("I have no time. I am studying Programming Language.");
		}
	}
}
