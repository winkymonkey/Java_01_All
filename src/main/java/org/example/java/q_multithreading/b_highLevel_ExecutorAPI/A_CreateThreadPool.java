package org.example.java.q_multithreading.b_highLevel_ExecutorAPI;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;


public class A_CreateThreadPool {
	
	public static void main(String[] args) {
		ExecutorService pool1 = Executors.newSingleThreadExecutor();
		ExecutorService pool2 = Executors.newCachedThreadPool();
		ExecutorService pool3 = Executors.newFixedThreadPool(5);
		ScheduledExecutorService pool4 = Executors.newSingleThreadScheduledExecutor();
		ScheduledExecutorService pool5 = Executors.newScheduledThreadPool(5);
		ExecutorService pool6 = Executors.newWorkStealingPool();
		
		pool1.shutdown();
		pool2.shutdown();
		pool3.shutdown();
		pool4.shutdown();
		pool5.shutdown();
		pool6.shutdown();
	}
	
}
