package org.example.java.l_collection.e_queue_blocking;

import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * ****************************************************************
 * DelayQueue
 *  - blocking
 *  - unbounded
 * ****************************************************************
 */

public class D_DelayQueue {
	
	public static void main(String[] args) throws InterruptedException {
		DelayQueue<DelayObject> queue = new DelayQueue<>();
		int numOfElemToProduce = 6;
		int numOfElemToConsume = 6;
		AtomicInteger consumeCount = new AtomicInteger(0);
		
		Runnable producer = ()->{
			for (int i = 0; i < numOfElemToProduce; i++) {
				DelayObject obj = new DelayObject(i, 2000);			// DelayedObject having 2000ms delay
				try {
					queue.put(obj);
					System.out.println("Producer put: " + obj);
					Thread.sleep(500);								// keep putting elements at every 500ms
				}
				catch (InterruptedException ie) {
					ie.printStackTrace();
				}
			}
		};
		
		
		Runnable consumer = ()->{
			for (int i = 0; i < numOfElemToConsume; i++) {
				try {
					DelayObject obj = queue.take();
					consumeCount.incrementAndGet();
					System.out.println("Consumer take: " + obj);
				}
				catch (InterruptedException ie) {
					ie.printStackTrace();
				}
			}
		};
		
		ExecutorService executor = Executors.newFixedThreadPool(2);
		executor.submit(producer);
		executor.submit(consumer);
		executor.awaitTermination(10, TimeUnit.SECONDS);
		executor.shutdown();
		
		System.out.println("consumer gets "+consumeCount+" messages");
	}
	
	
	static class DelayObject implements Delayed {
		private int id;
		private long startTime;
		
		DelayObject(int id, long delay) {
			this.id = id;
			this.startTime = System.currentTimeMillis() + delay;
		}
		
		@Override
		public int compareTo(Delayed o) {
			return (int)(startTime - ((DelayObject)o).startTime);
		}
		
		@Override
		public long getDelay(TimeUnit unit) {
			long diff = startTime - System.currentTimeMillis();
			return unit.convert(diff, TimeUnit.MILLISECONDS);
		}
		
		@Override
		public String toString() {
			StringBuilder builder = new StringBuilder();
			builder.append("DelayedObject [id=").append(id).append(", delay=").append(startTime).append("]");
			return builder.toString();
		}
	}
		
}
