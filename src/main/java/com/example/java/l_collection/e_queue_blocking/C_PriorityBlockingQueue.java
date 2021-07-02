package com.example.java.l_collection.e_queue_blocking;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * ****************************************************************
 * PriorityBlockingQueue
 *  - blocking
 *  - optionally bounded
 * ****************************************************************
 */

public class C_PriorityBlockingQueue {
	
	public static void main(String[] args) throws InterruptedException {
		PriorityBlockingQueue<String> queue = new PriorityBlockingQueue<>();		// OR PriorityBlockingQueue<String> queue2 = new PriorityBlockingQueue<>(2);
																					// OR PriorityBlockingQueue<String> queue3 = new PriorityBlockingQueue<>(2, Comparator.comparing(String::length));
		Runnable producer = ()->{
			try {
				System.out.println("adding 1st element");
				queue.put("elem-1");
				
				System.out.println("adding 2nd element");
				queue.put("elem-2");
				
				System.out.println("adding 3rd element");
				queue.put("elem-3");
				
				System.out.println("adding 4th element");
				queue.put("elem-4");
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		};
		
		ExecutorService executor = Executors.newFixedThreadPool(1);
		executor.submit(producer);
		executor.awaitTermination(2000, TimeUnit.MILLISECONDS);
		executor.shutdown();
	}
	
}
