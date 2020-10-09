package com.example.java.n_stream;

import java.time.LocalTime;
import java.util.stream.IntStream;


public class F_Laziness_in_sequentialStream {
	
	public static void main(String[] args) {
		IntStream stream = IntStream.range(1, 7);
		stream = stream.peek(num -> log("starting", num))
						.filter(num -> {log("filtering", num);return num % 2 == 0;});

		log("Invoking terminal method 'count()'");
		log("The count of elements in stream now", stream.count());
	}
	
	
	private static void log(Object... objects) {
		String timeNow = LocalTime.now().toString();
		for (Object obj : objects) {
			timeNow = timeNow + " - " + obj.toString();
		}
		System.out.println(timeNow);
		try {
			Thread.sleep(1);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}


