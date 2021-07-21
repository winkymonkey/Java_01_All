package org.example.java.q_multithreading.b_highLevel_ExecutorAPI;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


/************************************************************/
/**				Obtain ExecutorService Instance				*/
/************************************************************/
public class A_CreateThreadPool {
	
	public static void main(String[] args) {
		ExecutorService pool1 = Executors.newSingleThreadExecutor();	//thread-pool (Single thread)
		ExecutorService pool2 = Executors.newCachedThreadPool();		//thread-pool (Cached)
		ExecutorService pool3 = Executors.newFixedThreadPool(5); 		//thread-pool (Fixed N threads)

		ExecutorService pool4 = Executors.newWorkStealingPool(); 		//WorkStealing Pool (use ForkJoinPool)
		
		ExecutorService pool5 = Executors.newSingleThreadScheduledExecutor(); 	//Scheduled thread-pool (Single thread)
		ExecutorService pool6 = Executors.newScheduledThreadPool(5); 			//Scheduled thread-pool (Fixed N threads)
		
		pool1.shutdown();
		pool2.shutdown();
		pool3.shutdown();
		pool4.shutdown();
		pool5.shutdown();
		pool6.shutdown();
	}
}
