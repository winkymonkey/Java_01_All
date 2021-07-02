package com.example.java.p_multithreading.a_lowLevel;


public class N_Join {
	
	public static void main(String[] args) throws InterruptedException {
		Thread t1 = new Thread(() -> {
			for (int i=0; i<50; i++) {
				System.out.println("[t1]:: "+i);
			}
		});
		
		Thread t2 = new Thread(() -> {
			for (int i=50; i>0; i--) {
				System.out.println("t2:: "+i);
			}
		});
		
		t1.start();
		t2.start();
		
		System.out.println("Main:: calling join");
		t1.join();
		System.out.println("Main:: last line");
	}
	
}
