package com.example.java.o_multithreading.b_highLevel_ExecutorAPI;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;


/************************************************************/
/**				Submit (SINGLE) Callable Task				*/
/************************************************************/
public class D_Submit_singleCallable {
	
	public static void main(String[] args) {
		ExecutorService pool = Executors.newSingleThreadExecutor();
		Future<Integer> future = pool.submit(() -> 123);
		
		while(!future.isDone()) {
			System.out.println("task is not done yet");
		}
		System.out.println("task is completed");
		try {
			Integer result = future.get(1, TimeUnit.SECONDS);
			System.out.println("result: " + result);
		}
		catch (InterruptedException | ExecutionException | TimeoutException e) {
			e.printStackTrace();
		}
		pool.shutdown();
	}
}
