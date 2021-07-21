package org.example.java.l_collection.e_queue_blocking;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedTransferQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * ****************************************************************
 * TransferQueue - blocking - unbounded
 * ****************************************************************
 */

public class F_TransferQueue {

	public static void main(String[] args) throws InterruptedException {
		LinkedTransferQueue<String> queue = new LinkedTransferQueue<>();
		int numOfElemToProduce = 3;
		int numOfElemToConsume = 3;
		AtomicInteger numOfProducedElem = new AtomicInteger(0);
		AtomicInteger numOfConsumedElem = new AtomicInteger(0);

		Runnable producer = () -> {
			for (int i = 0; i < numOfElemToProduce; i++) {
				try {
					boolean added = queue.tryTransfer("MSG-"+i, 4000, TimeUnit.MILLISECONDS);	// if the producer is not able to transfer the message within 4s, it returns false and moves on to the next message.
					if (added) {
						numOfProducedElem.incrementAndGet();
					}
				}
				catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		};

		Runnable consumer = () -> {
			for (int i = 0; i < numOfElemToConsume; i++) {
				try {
					queue.take();
					numOfConsumedElem.incrementAndGet();
					Thread.sleep(500);
				}
				catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		};

		ExecutorService executor = Executors.newFixedThreadPool(2);
		executor.execute(producer);
		executor.execute(consumer);
		executor.awaitTermination(500, TimeUnit.MILLISECONDS);
		executor.shutdown();
		
		System.out.println("producer put: "+numOfProducedElem+" messages");
		System.out.println("consumer take: "+numOfConsumedElem+" messages");
	}

}
