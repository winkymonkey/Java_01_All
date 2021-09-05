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


public class E_Submit_multipleCallable {
	
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		usingSubmit();
		usingInvokeAll();
		usingInvokeAny();
	}
	
	
	private static void usingSubmit() {
		Callable<Integer> task1 = ( () -> {Thread.sleep(4000); return 123;} );
		Callable<Integer> task2 = ( () -> {Thread.sleep(1000); return 456;} );
		Callable<Integer> task3 = ( () -> {Thread.sleep(8000); return 789;} );
		
		ExecutorService pool = Executors.newFixedThreadPool(5);
		Future<Integer> future1 = pool.submit(task1);
		Future<Integer> future2 = pool.submit(task2);
		Future<Integer> future3 = pool.submit(task3);
		
		List<Future<Integer>> futureList = Arrays.asList(future1, future2, future3);
		for (Future<Integer> future : futureList) {
			try {
				Integer result = future.get(3, TimeUnit.SECONDS);
				System.out.println("result: " + result);
			}
			catch (InterruptedException | ExecutionException | TimeoutException e) {
				e.printStackTrace();
			}
		}
		
		pool.shutdown();
	}
	
	
	private static void usingInvokeAll() throws InterruptedException {
		Callable<Integer> task1 = ( () -> {Thread.sleep(4000); return 123;} );
		Callable<Integer> task2 = ( () -> {Thread.sleep(1000); return 456;} );
		Callable<Integer> task3 = ( () -> {Thread.sleep(8000); return 789;} );
		List<Callable<Integer>> taskList = Arrays.asList(task1, task2, task3);
		
		ExecutorService pool = Executors.newFixedThreadPool(5);
		List<Future<Integer>> futureList = pool.invokeAll(taskList);
		for (Future<Integer> future : futureList) {
			try {
				Integer result = future.get(3, TimeUnit.SECONDS);
				System.out.println("result: " + result);
			}
			catch (InterruptedException | ExecutionException | TimeoutException e) {
				e.printStackTrace();
			}
		}
		
		pool.shutdown();
	}
	
	
	private static void usingInvokeAny() throws InterruptedException, ExecutionException {
		Callable<Integer> task1 = ( () -> {Thread.sleep(4000); return 123;} );
		Callable<Integer> task2 = ( () -> {Thread.sleep(1000); return 456;} );
		Callable<Integer> task3 = ( () -> {Thread.sleep(8000); return 789;} );
		List<Callable<Integer>> taskList = Arrays.asList(task1, task2, task3);
		
		ExecutorService pool = Executors.newSingleThreadExecutor();
		Integer result = pool.invokeAny(taskList);
		System.out.println("result: " + result);
		
		pool.shutdown();
	}
	
}
