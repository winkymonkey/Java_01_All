package com.example.java.p_multithreading.b_highLevel_ExecutorAPI;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;


public class J_ExecutorCompletionService_withRunnable {
	
	public static void main(String[] args) {
		ExecutorService pool = Executors.newFixedThreadPool(3);
		CompletionService<Integer> executorCompletionService = new ExecutorCompletionService<>(pool);
		
		Future<Integer> future1 = executorCompletionService.submit(() -> {try {Thread.sleep(4000);} catch (InterruptedException e) {/**/}}, 101);
		Future<Integer> future2 = executorCompletionService.submit(() -> {try {Thread.sleep(1000);} catch (InterruptedException e) {/**/}}, 202);
		Future<Integer> future3 = executorCompletionService.submit(() -> {try {Thread.sleep(8000);} catch (InterruptedException e) {/**/}}, 303);
		
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
