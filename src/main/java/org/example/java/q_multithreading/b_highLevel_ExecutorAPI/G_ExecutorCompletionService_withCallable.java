package org.example.java.q_multithreading.b_highLevel_ExecutorAPI;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;


public class G_ExecutorCompletionService_withCallable {
	
	public static void main(String[] args) {
		Callable<Integer> task1 = ( () -> {Thread.sleep(4000); return 123;} );
		Callable<Integer> task2 = ( () -> {Thread.sleep(1000); return 456;} );
		Callable<Integer> task3 = ( () -> {Thread.sleep(8000); return 789;} );
		
		ExecutorService pool = Executors.newFixedThreadPool(3);
		CompletionService<Integer> completionService = new ExecutorCompletionService<>(pool);
		
		Future<Integer> future1 = completionService.submit(task1);
		Future<Integer> future2 = completionService.submit(task2);
		Future<Integer> future3 = completionService.submit(task3);
		
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
