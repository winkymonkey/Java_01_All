package org.example.java.q_multithreading.a_lowLevel;


public class Z1_PrintEvenOddNumber {
	
	private static final Object obj = new Object();
	private static final int MAX = 1000;
	
	
	public static void main(String[] args) {
		Thread t1 = new Thread(() -> printEven(1), "t1");
		Thread t2 = new Thread(() -> printOdd(2), "t2");
		
		t1.start();
		t2.start();
	}
	
	
	private static void printOdd(int n) {
		String name = Thread.currentThread().getName();
		synchronized(obj) {
			while (n < MAX) {
				System.out.println(name + " printing --- " +n);
				
				System.out.println(name + " incrementing");
				n+=2;
				
				System.out.println(name + " calling notify");
				obj.notify();
				
				try {
					System.out.println(name + " calling wait");
					obj.wait();
				}
				catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	
	private static void printEven(int n) {
		String name = Thread.currentThread().getName();
		synchronized(obj) {
			while (n < MAX) {
				System.out.println(name + " printing --- " +n);
				
				System.out.println(name + " incrementing");
				n+=2;
				
				System.out.println(name + " calling notify");
				obj.notify();
				
				try {
					System.out.println(name + " calling wait");
					obj.wait();
				}
				catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
}
