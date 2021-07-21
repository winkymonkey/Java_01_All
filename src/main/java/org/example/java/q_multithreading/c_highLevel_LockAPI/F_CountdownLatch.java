package org.example.java.q_multithreading.c_highLevel_LockAPI;

import java.util.concurrent.CountDownLatch;


public class F_CountdownLatch {	
	public static void main(String[] args) {
		CountDownLatch latch = new CountDownLatch(3);
		
		Thread waiter = new Thread(() -> {
			try {
				latch.await();
			}
			catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("Waiter Released");
		});
		waiter.start();
		
		Thread decrementer = new Thread(() -> {
			try {
				Thread.sleep(1000);
				latch.countDown();

				Thread.sleep(1000);
				latch.countDown();

				Thread.sleep(1000);
				latch.countDown();
			}
			catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("Decrementer calls countDown() 3 times");
		});
		decrementer.start();
	}
}
