package org.example.java.q_multithreading.a_lowLevel;


public class A_CreateThread {
	
	public static void main(String[] args) {
		Thread t1 = new Thread() {
			@Override
			public void run() {
				//... code to be executed by this thread ...
			}
		};
		t1.start();
		
		
		Thread t2 = new Thread(new Runnable() {
			@Override
			public void run() {
				//... code to be executed by this thread ...
			}
		});
		t2.start();
		
		
		Thread t3 = new Thread(() -> {/*... code to be executed by this thread ...*/} );
		t3.start();
	}
}
