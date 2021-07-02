package com.example.java.p_multithreading.b_highLevel_ExecutorAPI;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;


public class H_ExecutorCompletionService_withCallable {
	
	public static void main(String[] args) {
		ExecutorService pool = Executors.newFixedThreadPool(3);
		CompletionService<Integer> executorCompletionService = new ExecutorCompletionService<>(pool);
		
		Future<Integer> future1 = executorCompletionService.submit(() -> {Thread.sleep(4000);return 123;});
		Future<Integer> future2 = executorCompletionService.submit(() -> {Thread.sleep(1000);return 456;});
		Future<Integer> future3 = executorCompletionService.submit(() -> {Thread.sleep(8000);return 789;});
		
		List<Future<Integer>> futures = Arrays.asList(future1, future2, future3);
		
		for (int i=0; i<futures.size(); i++) {
		    try {
		    	Future<Integer> future = executorCompletionService.take();
				Integer result = future.get();
				System.out.println("result: " + result);
			}
		    catch (InterruptedException | ExecutionException e) {
				e.printStackTrace();
			}
		    // Some processing here
		}
		pool.shutdown();
	}
}
