package org.example.java.q_multithreading.b_highLevel_ExecutorAPI;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;


@SuppressWarnings("unused")
public class C_Submit_multipleRunnable {
	
	public static void main(String[] args) {
		usingExecute();
		usingSubmit();
	}
	
	
	private static void usingExecute() {
		Runnable task1 = ( () -> {try {Thread.sleep(4000);} catch (InterruptedException e) {} System.out.println("task1");} );
		Runnable task2 = ( () -> {try {Thread.sleep(1000);} catch (InterruptedException e) {} System.out.println("task2");} );
		Runnable task3 = ( () -> {try {Thread.sleep(8000);} catch (InterruptedException e) {} System.out.println("task3");} );
		
		ExecutorService pool = Executors.newFixedThreadPool(3);
		pool.execute(task1);
		pool.execute(task2);
		pool.execute(task3);
		
		pool.shutdown();
	}
	
	
	private static void usingSubmit() {
		Runnable task1 = ( () -> {try {Thread.sleep(4000);} catch (InterruptedException e) {} System.out.println("task1");} );
		Runnable task2 = ( () -> {try {Thread.sleep(1000);} catch (InterruptedException e) {} System.out.println("task2");} );
		Runnable task3 = ( () -> {try {Thread.sleep(8000);} catch (InterruptedException e) {} System.out.println("task3");} );
		
		ExecutorService pool = Executors.newFixedThreadPool(3);
		Future<?> future1 = pool.submit(task1);
		Future<?> future2 = pool.submit(task2);
		Future<?> future3 = pool.submit(task3);
		
		pool.shutdown();
	}
	
}
