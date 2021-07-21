package org.example.java.q_multithreading.b_highLevel_ExecutorAPI;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


/************************************************************/
/**				Submit (MULTIPLE) Runnable Tasks			*/
/************************************************************/
public class C_Submit_multipleRunnable {
	
	public static void main(String[] args) {
		ExecutorService pool = Executors.newFixedThreadPool(3);
		pool.execute(() -> System.out.println("execute 1 -- "+Thread.currentThread().getName()));
		pool.execute(() -> System.out.println("execute 2 -- "+Thread.currentThread().getName()));
		pool.submit(() -> System.out.println("submit 1 -- "+Thread.currentThread().getName()));
		pool.execute(() -> System.out.println("execute 3 -- "+Thread.currentThread().getName()));
		pool.submit(() -> System.out.println("submit 2 -- "+Thread.currentThread().getName()));
		pool.shutdown();
	}
}
