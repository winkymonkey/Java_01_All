package org.example.java.q_multithreading.b_highLevel_ExecutorAPI;

import java.util.Arrays;
import java.util.Collection;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


/************************************************************/
/**				Submit (MULTIPLE) Callable Tasks			*/
/**						pool.invokeAny(...)					*/
/************************************************************/
public class G_Submit_multipleCallable_poolInvokeAny {
	
	public static void main(String[] args) {
		ExecutorService pool = Executors.newSingleThreadExecutor();
		Callable<Integer> c1 = (() -> {Thread.sleep(4000);return 123;});
		Callable<Integer> c2 = (() -> {Thread.sleep(1000);return 456;});
		Callable<Integer> c3 = (() -> {Thread.sleep(8000);return 789;});
		
		Collection<Callable<Integer>> taskList = Arrays.asList(c1, c2, c3);
		
		try {
			Integer i = pool.invokeAny(taskList);
			System.out.println(i);
		}
		catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}
		pool.shutdown();
	}
}
