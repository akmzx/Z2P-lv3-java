package com.mmit.day5;

import java.time.LocalDateTime;
import java.time.LocalTime;

public class LocalTime_Testing {

	public static void main(String[] args) {
		LocalTime time1 = LocalTime.now();
		LocalTime time2 = LocalTime.of(8, 23);
		
		System.out.println(time1);
		System.out.println(time2);
		System.out.println("Prev hour: " + time1.minusHours(1).getHour());
		
//		LocalDateTime
		LocalDateTime now = LocalDateTime.now();
		System.out.println(now);
		System.out.println("Current year: " + now.getYear());
		System.out.println("Current hour: " + now.getHour());
	}

}
