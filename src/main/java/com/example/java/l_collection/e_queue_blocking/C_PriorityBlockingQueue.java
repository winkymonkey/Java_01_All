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
		Runnable consumer = ()->{
			try {
				System.out.println("retrieve from empty queue");
				queue.take();
				
				System.out.println("adding elements");
				queue.add("msg-1");
				queue.add("msg-2");
				queue.add("msg-3");
				
				System.out.println("queue elements: "+queue);
			}
			catch (InterruptedException e) {
				e.printStackTrace();
			}
		};
		ExecutorService executor = Executors.newFixedThreadPool(1);
		executor.submit(consumer);
		executor.awaitTermination(2000, TimeUnit.MILLISECONDS);
		executor.shutdown();
	}
		
}
