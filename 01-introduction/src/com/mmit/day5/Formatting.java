package com.mmit.day5;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

public class Formatting {

	public static void main(String[] args) {
//		1. predefined constants

		DateTimeFormatter f1 = DateTimeFormatter.ISO_LOCAL_DATE;
		DateTimeFormatter f2 = DateTimeFormatter.ISO_LOCAL_TIME;
		DateTimeFormatter f3 = DateTimeFormatter.ISO_LOCAL_DATE_TIME;

		LocalDate date = LocalDate.now();
		LocalTime time = LocalTime.now();
		LocalDateTime dateTime = LocalDateTime.now();

		System.out.println("Default date: " + date);
		System.out.println("ISO format: " + date.format(f1));
		System.out.println("ISO format: " + f1.format(date));

		// 2. custom format
		DateTimeFormatter f4 = DateTimeFormatter.ofPattern("MMM dd yyyy");
		DateTimeFormatter f5 = DateTimeFormatter.ofPattern("h-mm-ss a");
		DateTimeFormatter f6 = DateTimeFormatter.ofPattern("MMMM dd yyyy 'at' h:m:s a");
		// System.out.println("Format1: " + date.format(f4));
		System.out.println("Default: " + time);
		System.out.println("Format: " + time.format(f5));

		System.out.println("Default: " + dateTime);
		System.out.println("format: " + dateTime.format(f6));

		// 3. Localize style
		DateTimeFormatter f7 = DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL);

		System.out.println("Default: " + date);
		System.out.println("format1 : " + date.format(f7));
		System.out.println("format2: " + date.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.LONG)));
		System.out.println("format3: " + date.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM)));
		System.out.println("format4: " + date.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT)));

		System.out.println();
	}

}
