package com.example.java.o_stream;

import java.time.LocalTime;
import java.util.stream.IntStream;


public class G_Laziness_in_parallelStream {
	
	public static void main(String[] args) {
		IntStream stream = IntStream.range(1, 7).parallel();
		stream = stream.peek(i -> log("starting", i))
				.filter(i -> {log("filtering", i);return i % 2 == 0;});

		log("Invoking terminal method 'count()'");
		log("The count of elements in stream now", stream.count());
	}
	
	
	private static void log(Object... objects) {
		String s = LocalTime.now().toString();
		for (Object object : objects) {
			s = s + " - " + object.toString();
		}
		System.out.println(s);
		try {
			Thread.sleep(1);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}


