package org.example.java.q_multithreading.b_highLevel_ExecutorAPI;

import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;


@SuppressWarnings("unused")
public class H_TaskScheduling {
	
	public static void main(String[] args) {
		executeOnce();
		executeAtFixedRate();
		executeAtFixedDelay();
	}
	
	
	/**
	 * -----------------------------------------------------
	 * Execute Once --- Both Runnable and Callable
	 * -----------------------------------------------------
	 */
	public static void executeOnce() {
		Runnable task1 = ( () -> System.out.println("hello") );
		ScheduledExecutorService pool1 = Executors.newScheduledThreadPool(1);
		ScheduledFuture<?> future1 = pool1.schedule(task1, 3, TimeUnit.SECONDS);		// 3s initial delay
		
		Callable<Integer> task2 = ( () -> {return 123;} );
		ScheduledExecutorService pool2 = Executors.newScheduledThreadPool(1);
		ScheduledFuture<Integer> future2 = pool2.schedule(task2, 3, TimeUnit.SECONDS);	// 3s initial delay
	}
	
	
	/**
	 * -----------------------------------------------------
	 * Execute at Fixed rate --- Only Runnable
	 * -----------------------------------------------------
	 */
	public static void executeAtFixedRate() {
		Runnable task1 = ( () -> System.out.println("hello") );
		ScheduledExecutorService pool = Executors.newScheduledThreadPool(1);
		ScheduledFuture<?> future = pool.scheduleAtFixedRate(task1, 3, 1, TimeUnit.SECONDS);		// 3s initial delay, 1s period
	}
	
	
	/**
	 * -----------------------------------------------------
	 * Execute at Fixed delay --- Only Runnable
	 * -----------------------------------------------------
	 */
	public static void executeAtFixedDelay() {
		Runnable task1 = ( () -> System.out.println("hello") );
		ScheduledExecutorService pool = Executors.newScheduledThreadPool(1);
		ScheduledFuture<?> future = pool.scheduleWithFixedDelay(task1, 3, 1, TimeUnit.SECONDS);		// 3s initial delay, 1s delay
	}
	
}
