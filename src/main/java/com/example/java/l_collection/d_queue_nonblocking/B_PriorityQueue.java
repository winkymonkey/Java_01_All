package com.example.java.l_collection.d_queue_nonblocking;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * ****************************************************************
 * PriorityQueue
 * 	- non blocking
 *  - optionally bounded
 * ****************************************************************
 */

public class B_PriorityQueue {

	public static void main(String[] args) {
		PriorityQueue<String> queue = new PriorityQueue<>();			// unbounded & natural priority (as per natural ordering)
		queue.add("Bob");
		queue.add("Bob");
		queue.add("Brendon");
		queue.add("Alice");
		System.out.println("initially-----"+queue);		
		System.out.println("Remove--------"+queue.remove());
		System.out.println("After remove--"+queue);
		System.out.println("current head--"+queue.element());
		
		
		PriorityQueue<String> queue2 = new PriorityQueue<>(2);			// bounded & natural priority (as per natural ordering)
		queue2.add("Bob");
		queue2.add("Bob");
		System.out.println(queue2);
		queue2.add("Brendon");
		System.out.println(queue2);
		queue2.add("Alice");
		System.out.println(queue2);
		
		
		PriorityQueue<String> queue3 = new PriorityQueue<>(Comparator.comparing(String::length));		// unbounded & custom priority (as per given comparator)
		queue3.add("Bob");
		queue3.add("Bob");
		queue3.add("Brendon");
		queue3.add("Alice");
		System.out.println("initially-----"+queue3);		
		System.out.println("Remove--------"+queue3.remove());
		System.out.println("After remove--"+queue3);
		System.out.println("current head--"+queue3.element());
	}
	
}
