package org.example.java.q_multithreading.c_highLevel_LockAPI;

import java.util.concurrent.Semaphore;


public class D_Semaphore {
	public static void main(String[] args) {
		Semaphore semaphore = new Semaphore(4);
		System.out.println("Total available Semaphore permits : " + semaphore.availablePermits());
		new MyThread("A", semaphore).start();
		new MyThread("B", semaphore).start();
		new MyThread("C", semaphore).start();
		new MyThread("D", semaphore).start();
	}
}


class MyThread extends Thread {
	private String name;
	private Semaphore semaphore;

	MyThread(String name, Semaphore semaphore) {
		this.name = name;
		this.semaphore = semaphore;
	}
	
	public void run() {
		try {
			System.out.println(name + " : acquiring lock... available permits=" + semaphore.availablePermits());
			semaphore.acquire();
			System.out.println(name + " : got the permit!");
			try {
				for (int i=1; i<=5; i++) {
					System.out.println(name + " : is operating " + i + ", available permits=" + semaphore.availablePermits());
					Thread.sleep(1000);
				}
			}
			finally {
				System.out.println(name + " : releasing lock...");
				semaphore.release();
				System.out.println(name + " : lock released... available permits=" + semaphore.availablePermits());
			}
		}
		catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
