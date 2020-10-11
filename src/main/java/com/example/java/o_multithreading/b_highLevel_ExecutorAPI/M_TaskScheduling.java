package com.example.java.o_multithreading.b_highLevel_ExecutorAPI;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;


@SuppressWarnings("unused")
public class M_TaskScheduling {
	
	public static void main(String[] args) {
		executeOnce();
		executeAtFixedRate();
		executeAtFixedDelay();
	}
	
	
	// Execute Once (3s initial delay) - Both Runnable and Callable
	public static void executeOnce() {
		ScheduledExecutorService pool1 = Executors.newScheduledThreadPool(1);
		ScheduledFuture<?> future1 = pool1.schedule(() -> System.out.println("hello"), 3, TimeUnit.SECONDS);
		
		ScheduledExecutorService pool2 = Executors.newScheduledThreadPool(1);
		ScheduledFuture<Integer> future2 = pool2.schedule(() -> {return 123;}, 3, TimeUnit.SECONDS);
	}
	
	
	// Execute at Fixed rate (3s initial delay, 1s period) - Only Runnable
	public static void executeAtFixedRate() {
		ScheduledExecutorService pool = Executors.newScheduledThreadPool(1);
		ScheduledFuture<?> future = pool.scheduleAtFixedRate(() -> System.out.println("hello"), 3, 1, TimeUnit.SECONDS);
	}
	
	
	// Execute at Fixed delay (3s initial delay, 1s delay) - Only Runnable
	public static void executeAtFixedDelay() {
		ScheduledExecutorService pool = Executors.newScheduledThreadPool(1);
		ScheduledFuture<?> future = pool.scheduleWithFixedDelay(() -> System.out.println("hello"), 3, 1, TimeUnit.SECONDS);
	}
}
