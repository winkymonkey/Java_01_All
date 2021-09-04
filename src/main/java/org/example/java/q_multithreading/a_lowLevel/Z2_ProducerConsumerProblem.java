package org.example.java.q_multithreading.a_lowLevel;


public class Z2_ProducerConsumerProblem {
	
	private static String str = "";
	private static final Object obj = new Object();
	
	public static void main(String[] args) {
		Thread t1 = new Thread(() -> produce(), "producer");
		Thread t2 = new Thread(() -> consume(), "consumer");
		
		t1.start();
		t2.start();
	}
	
	private static void produce() {
		synchronized (obj) {
			str = "XX";
			System.out.println(Thread.currentThread().getName()+" produced "+str);
			obj.notifyAll();
			try {
				obj.wait();
			}
			catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	private static void consume() {
		synchronized (obj) {
			str = "";
			System.out.println(Thread.currentThread().getName()+" consumed "+str);
			obj.notifyAll();
			try {
				obj.wait();
			}
			catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
}
