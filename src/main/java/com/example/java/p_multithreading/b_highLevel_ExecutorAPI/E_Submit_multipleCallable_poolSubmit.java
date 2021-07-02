package com.example.java.p_multithreading.b_highLevel_ExecutorAPI;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;


/************************************************************/
/**				Submit (MULTIPLE) Callable Tasks			*/
/**						pool.submit(...)					*/
/************************************************************/
public class E_Submit_multipleCallable_poolSubmit {
	
	public static void main(String[] args) {
		ExecutorService pool = Executors.newFixedThreadPool(5);
		Future<Integer> future1 = pool.submit(() -> {Thread.sleep(4000);return 123;});
		Future<Integer> future2 = pool.submit(() -> {Thread.sleep(1000);return 456;});
		Future<Integer> future3 = pool.submit(() -> {Thread.sleep(8000);return 789;});
		
		List<Future<Integer>> futures = Arrays.asList(future1, future2, future3);
		
		for (Future<Integer> future : futures) {
			try {
				Integer result = future.get(10, TimeUnit.SECONDS);
				System.out.println("result: " + result);
			}
			catch (InterruptedException | ExecutionException | TimeoutException e) {
				e.printStackTrace();
			}
		}
		pool.shutdown();
	}
	
}
