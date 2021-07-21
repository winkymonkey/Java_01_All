package org.example.java.q_multithreading.a_lowLevel;


class C1_Interruption_threadSleepWaitJoin {
	
	public static void main(String[] args) throws InterruptedException {
		Thread t1 = new Thread(() -> {
			System.out.println("t1::I am going to sleep");
			try {
				Thread.sleep(5000);
			}
			catch (InterruptedException e) {
				System.out.println("t1::Someone interrupted me");
			}
			System.out.println("t1::I wake up");
		});
		t1.start();
		
		
		Thread.sleep(2000);								//main thread waits for 2s before interrupting t1
		t1.interrupt();									//main thread interrupts t1
		System.out.println(t1.isInterrupted());	//true	//main thread checks interrupted status of t1
		Thread.sleep(1000);								//main thread wait for 1s
		System.out.println(t1.isInterrupted());	//false	//main thread again checks interrupted status of t1
	}
}
