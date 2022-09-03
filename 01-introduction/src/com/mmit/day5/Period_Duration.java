package com.mmit.day5;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Period;

public class Period_Duration {

	public static void main(String[] args) {
		LocalDate start_date = LocalDate.of(2019, 9, 25);
		LocalDate end_date = LocalDate.of(2021, 10, 31);
		
		int months = Period.between(start_date, end_date).getMonths();
		int years = Period.between(start_date, end_date).getYears();
		int days = Period.between(start_date, end_date).getDays();
		
		System.out.println("months: " + months);
		System.out.println("years: " + years);
		System.out.println("days: " + days);
		
		LocalTime time1 = LocalTime.of(11, 30);
		LocalTime time2 = LocalTime.of(12, 0);

	 	long seonds = Duration.between(time1, time2).getSeconds();
	 	System.out.println("Total seconds: " + seonds);
	}

}
