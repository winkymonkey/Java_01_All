package com.example.java.l_collection.e_queue_blocking;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;

/**
 * ****************************************************************
 * SynchronousQueue
 *  - blocking
 *  - unbounded
 * ****************************************************************
 */

public class E_SynchronousQueue {
	
	public static void main(String[] args) throws InterruptedException {
		SynchronousQueue<Integer> queue = new SynchronousQueue<>();
		
		Runnable producer = () -> {
			Integer producedElem = new Random().nextInt();
			try {
				queue.put(producedElem);
				System.out.println("Producer put: "+producedElem);
			}
			catch (InterruptedException ex) {
				ex.printStackTrace();
			}
		};
		
		Runnable consumer = () -> {
			try {
				Integer consumedElem = queue.take();
				System.out.println("Consumer take: "+consumedElem);
			}
			catch (InterruptedException ex) {
				ex.printStackTrace();
			}
		};
		
		ExecutorService executor = Executors.newFixedThreadPool(2);
		executor.execute(producer);
		executor.execute(consumer);
		executor.awaitTermination(500, TimeUnit.MILLISECONDS);
		executor.shutdown();
		
		System.out.println(queue.size()+" elements in queue");			// 0
	}
		
}
