package org.example.java.q_multithreading.a_lowLevel;


class C2_Interruption_threadWorking {
	
	public static void main(String[] args) throws InterruptedException {
		Thread t1 = new Thread(() -> {
			while (!Thread.interrupted()) {
				System.out.println("t1::No one interruped me till now");
			}
			System.out.println("t1::Someone interrupted me");
		});
		t1.start();
		
		Thread.sleep(1);								//main thread waits for 1ms before interrupting t1
		t1.interrupt();									//main thread interrupts t1
		System.out.println(t1.isInterrupted());	//true	//main thread checks interrupted status of t1
		Thread.sleep(1000);								//main thread wait for 1s more
		System.out.println(t1.isInterrupted());	//false	//main thread again checks interrupted status of t1
	}
	
}
