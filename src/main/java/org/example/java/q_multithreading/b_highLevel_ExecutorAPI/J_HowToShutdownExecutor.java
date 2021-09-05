package org.example.java.q_multithreading.b_highLevel_ExecutorAPI;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;


public class J_HowToShutdownExecutor {
	
	public static void main(String[] args) {
		ExecutorService pool = Executors.newFixedThreadPool(5);
		// some processing

		pool.shutdown();
		try {
			if (!pool.awaitTermination(60, TimeUnit.SECONDS)) {
				pool.shutdownNow();
			}
		}
		catch (InterruptedException e) {
			e.printStackTrace();
			pool.shutdownNow();
		}
	}
	
}
