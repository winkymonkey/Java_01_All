package org.example.java.q_multithreading.a_lowLevel;

import java.util.concurrent.TimeUnit;


public class B_SleepThread {
	
	public static void main(String[] args) {
		try {
			Thread.sleep(2000);					//Main thread will sleep
			TimeUnit.MILLISECONDS.sleep(2000);	//Main thread will sleep
			System.out.println("hello");
		}
		catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		Thread t1 = new Thread(() -> {
			try {
				Thread.sleep(1000);					//t1 thread will sleep
				TimeUnit.MILLISECONDS.sleep(2000);	//t1 thread will sleep
				System.out.println("bye");
			}
			catch (InterruptedException e) {
				e.printStackTrace();
			}
		});
		t1.start();
	}
	
}
