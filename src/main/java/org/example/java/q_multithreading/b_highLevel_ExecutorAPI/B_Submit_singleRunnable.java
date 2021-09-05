package org.example.java.q_multithreading.b_highLevel_ExecutorAPI;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;


@SuppressWarnings("unused")
public class B_Submit_singleRunnable {
	
	public static void main(String[] args) {
		usingExecute();
		usingSubmit();
	}
	
	
	private static void usingExecute() {
		Runnable task1 = ( () -> {try {Thread.sleep(4000);} catch (InterruptedException e) {} System.out.println("task1");} );
		
		ExecutorService pool = Executors.newSingleThreadExecutor();
		pool.execute(task1);
		
		pool.shutdown();
	}
	
	
	private static void usingSubmit() {
		Runnable task1 = ( () -> {try {Thread.sleep(4000);} catch (InterruptedException e) {} System.out.println("task1");} );
		
		ExecutorService pool = Executors.newSingleThreadExecutor();
		Future<?> future1 = pool.submit(task1);
		
		pool.shutdown();
	}
	
}
