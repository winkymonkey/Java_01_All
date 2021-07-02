package com.example.java.p_multithreading.a_lowLevel;


public class Z_PrintEvenOddNumber {
	private static final Object obj = new Object();
	private static final int MAX = 1000;
	
	public static void main(String[] args) {
		Thread t1 = new Thread(() -> printEven(1), "t1");
		Thread t2 = new Thread(() -> printOdd(2), "t2");
		
		t1.start();
		t2.start();
	}
	
	private static void printOdd(int n) {
		synchronized(obj) {
			while (n < MAX) {
				System.out.println(Thread.currentThread().getName() + "--" +n);
				n+=2;
				obj.notify();
				try {
					obj.wait();
				}
				catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	private static void printEven(int n) {
		synchronized(obj) {
			while (n < MAX) {
				System.out.println(Thread.currentThread().getName() + "--" +n);
				n+=2;
				obj.notify();
				try {
					obj.wait();
				}
				catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
}


