package com.example.java.o_multithreading.a_lowLevel;


class Test20 {
	public static void main(String[] args) {
		Thread t1 = new Thread(() -> {
			for(int i=0; i<50; i++) {
				System.out.println("[t1] "+i);
			}
		});
		
		Thread t2 = new Thread(() -> {
			for(int i=50; i>0; i--) {
				System.out.println("t2 "+i);
			}
		});
		
		t1.start();
		//t1.join();
		
		t2.start();
	}
}

