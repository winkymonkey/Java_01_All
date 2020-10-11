package com.example.java.o_multithreading.b_highLevel_ExecutorAPI;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


/************************************************************/
/**				Submit (SINGLE) Runnable Task				*/
/************************************************************/
public class B_Submit_singleRunnable {
	
	public static void main(String[] args) {
		ExecutorService pool = Executors.newSingleThreadExecutor();
		pool.execute(() -> System.out.println("execute -- "+Thread.currentThread().getName()));
		pool.shutdown();
	}
}
