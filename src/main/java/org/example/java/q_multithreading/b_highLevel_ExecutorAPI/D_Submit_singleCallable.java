package org.example.java.q_multithreading.b_highLevel_ExecutorAPI;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;


public class D_Submit_singleCallable {
	
	public static void main(String[] args) {
		usingSubmit();
		usingInvokeAll();
	}
	
	
	private static void usingSubmit() {
		Callable<Integer> task1 = ( () -> {Thread.sleep(2000); return 123;} );
		
		ExecutorService pool = Executors.newSingleThreadExecutor();
		Future<Integer> future = pool.submit(task1);
		try {
			Integer result = future.get(4, TimeUnit.SECONDS);
			System.out.println("result: " + result);
		}
		catch (InterruptedException | ExecutionException | TimeoutException e) {
			e.printStackTrace();
		}
		
		pool.shutdown();
	}
	
	
	private static void usingInvokeAll() {
		Callable<Integer> task1 = ( () -> {Thread.sleep(2000); return 123;} );
		List<Callable<Integer>> taskList = Arrays.asList(task1);
		
		ExecutorService pool = Executors.newSingleThreadExecutor();
		try {
			List<Future<Integer>> futureList = pool.invokeAll(taskList);
			for (Future<Integer> future : futureList) {
				try {
					Integer result = future.get(4, TimeUnit.SECONDS);
					System.out.println("result: " + result);
				}
				catch (InterruptedException | ExecutionException | TimeoutException e) {
					e.printStackTrace();
				}
			}
		}
		catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		pool.shutdown();
	}
	
}
