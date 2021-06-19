package com.example.java.l_collection.d_queue_nonblocking;

import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * ****************************************************************
 * ConcurrentLinkedQueue
 * 	- non-blocking
 *  - unbounded
 * ****************************************************************
 */

public class A_ConcurrentLinkedQueue {
	
	public static void main(String[] args) throws InterruptedException {
		ConcurrentLinkedQueue<String> queue = new ConcurrentLinkedQueue<>();
		
		Runnable worker = ()->{
			System.out.println("retrieve from empty queue");
			queue.poll();
			
			System.out.println("adding elements");
			queue.add("msg-1");
			queue.add("msg-2");
			queue.add("msg-3");
			
			System.out.println("queue elements: "+queue);
		};
		ExecutorService executor = Executors.newFixedThreadPool(1);
		executor.submit(worker);
		executor.awaitTermination(2000, TimeUnit.MILLISECONDS);
		executor.shutdown();
	}
	
}
