package com.example.java.q_multithreading.a_lowLevel;


public class J2_ThreadSafety_InheritableThreadLocal {
	
	public static void main(String[] args) throws InterruptedException {
		ThreadLocal<Integer> threadLocal = new InheritableThreadLocal<Integer>();
		threadLocal.set(9999);

		Thread t1 = new Thread(() -> {
			try {
				Thread.sleep(1000);
			}
			catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("threadLocal of t1 " + threadLocal.get());	//9999
		});
		
		Thread t2 = new Thread(() -> {
			try {
				Thread.sleep(1000);
			}
			catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("threadLocal of t2 " + threadLocal.get());	//9999
		});
		
		t1.start();
		t2.start();
	}
}

