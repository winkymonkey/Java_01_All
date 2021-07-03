package com.example.java.q_multithreading.a_lowLevel;


public class J1_ThreadSafety_Threadlocal {
	
	public static void main(String[] args) throws InterruptedException {
		ThreadLocal<Integer> threadLocal = new ThreadLocal<Integer>();

		Thread t1 = new Thread(() -> {
			try {
				Thread.sleep(1000);
			}
			catch (InterruptedException e) {
				e.printStackTrace();
			}
			threadLocal.set(100);
			System.out.println("threadLocal of t1 " + threadLocal.get());	//100
		});
		
		Thread t2 = new Thread(() -> {
			try {
				Thread.sleep(1000);
			}
			catch (InterruptedException e) {
				e.printStackTrace();
			}
			threadLocal.set(200);
			System.out.println("threadLocal of t2 " + threadLocal.get());	//200
		});
		
		t1.start();
		t2.start();
	}
}

