package com.example.java.o_multithreading.b_highLevel_ExecutorAPI;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;


public class N_HowToShutdownExecutor {
	public static void main(String[] args) {
		ExecutorService executorService = Executors.newFixedThreadPool(5);
		// some processing

		executorService.shutdown();
		try {
			if(!executorService.awaitTermination(60, TimeUnit.SECONDS)) {
				executorService.shutdownNow();
			}
		}
		catch (InterruptedException e) {
			e.printStackTrace();
			executorService.shutdownNow();
		}
	}
}
