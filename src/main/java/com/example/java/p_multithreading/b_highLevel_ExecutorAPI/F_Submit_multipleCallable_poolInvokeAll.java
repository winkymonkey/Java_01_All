package com.example.java.p_multithreading.b_highLevel_ExecutorAPI;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;


/************************************************************/
/**				Submit (MULTIPLE) Callable Tasks			*/
/**						pool.invokeAll(...)					*/
/************************************************************/
public class F_Submit_multipleCallable_poolInvokeAll {
	
	public static void main(String[] args) {
		ExecutorService pool = Executors.newFixedThreadPool(5);
		Callable<Integer> c1 = (() -> {Thread.sleep(4000);return 123;});
		Callable<Integer> c2 = (() -> {Thread.sleep(1000);return 456;});
		Callable<Integer> c3 = (() -> {Thread.sleep(8000);return 789;});
		
		List<Callable<Integer>> taskList = Arrays.asList(c1, c2, c3);
		
		try {
			List<Future<Integer>> futureList = pool.invokeAll(taskList);
			futureList.forEach(future -> {
				try {
					Integer result = future.get();
					System.out.println("result: " + result);
				}
				catch (InterruptedException | ExecutionException e) {
					e.printStackTrace();
				}
			});
		}
		catch (InterruptedException e) {
			e.printStackTrace();
		}
		pool.shutdown();
	}
}
