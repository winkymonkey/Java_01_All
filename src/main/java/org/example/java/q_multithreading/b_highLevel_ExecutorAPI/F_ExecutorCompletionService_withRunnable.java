package org.example.java.q_multithreading.b_highLevel_ExecutorAPI;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;


public class F_ExecutorCompletionService_withRunnable {
	
	public static void main(String[] args) {
		Runnable task1 = ( () -> {try {Thread.sleep(4000);} catch (InterruptedException e) {}} );
		Runnable task2 = ( () -> {try {Thread.sleep(1000);} catch (InterruptedException e) {}} );
		Runnable task3 = ( () -> {try {Thread.sleep(8000);} catch (InterruptedException e) {}} );
		
		ExecutorService pool = Executors.newFixedThreadPool(3);
		CompletionService<Integer> completionService = new ExecutorCompletionService<>(pool);
		
		Future<Integer> future1 = completionService.submit(task1, 101);
		Future<Integer> future2 = completionService.submit(task2, 202);
		Future<Integer> future3 = completionService.submit(task3, 303);
		
		List<Future<Integer>> futureList = Arrays.asList(future1, future2, future3);
		for (int i=0; i<futureList.size(); i++) {
			try {
				Future<Integer> future = completionService.take();
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
