package org.example.java.l_collection.e_queue_blocking;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * ****************************************************************
 * ArrayBlockingQueue
 * 	- blocking
 *  - bounded
 * ****************************************************************
 */

public class A_ArrayBlockingQueue {
	
	public static void main(String[] args) throws InterruptedException {
		ArrayBlockingQueue<String> queue = new ArrayBlockingQueue<>(2);
		
		Runnable producer = ()->{
			try {
				System.out.println("adding 1st element");
				queue.put("elem-1");
				
				System.out.println("adding 2nd element");
				queue.put("elem-2");
				
				System.out.println("adding 3rd element");
				queue.put("elem-3");						// as the queue is already full, this thread gets blocked until a consumer consumes
				
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
