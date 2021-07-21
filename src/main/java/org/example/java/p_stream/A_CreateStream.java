package org.example.java.p_stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Random;
import java.util.Set;
import java.util.stream.IntStream;
import java.util.stream.Stream;


@SuppressWarnings("unused")
public class A_CreateStream {
	
	public static void main(String[] args) {
		// Stream from collection
		Stream<String> stream1 = new ArrayList<String>().stream();
		Stream<String> stream2 = new HashSet<String>().stream();
		Stream<String> stream3 = new PriorityQueue<String>().stream();
		
		
		// Arrays.stream(T[])
		IntStream stream4 = Arrays.stream(new int[] { 1, 2, 3, 4 });
		Stream<String> stream5 = Arrays.stream(new String[] { "A", "B" });
		Stream<Employee> stream6 = Arrays.stream(new Employee[] { new Employee("tom"), new Employee("jack") });
		
		
		// Stream.of(T...)
		Stream<Integer> stream7 = Stream.of( 1, 2, 3, 4 );
		Stream<String> stream8 = Stream.of( "A", "B" );
		Stream<Employee> stream9 = Stream.of( new Employee("tom"), new Employee("jack") );
		
		
		// Stream.generate()
		Stream<Integer> stream10 = Stream.generate(()->new Random().nextInt()).limit(5);
		
		
		// Stream.iterate()
		Stream<Integer> stream11 = Stream.iterate(0, i->i+1).limit(5);
		
		
		// IntStream.range()
		IntStream stream12 = IntStream.range(4, 10);
	
	}
	
	
	static class Employee {
		String name;
		Employee(String name) {
			this.name = name;
		}
	}
	
}
