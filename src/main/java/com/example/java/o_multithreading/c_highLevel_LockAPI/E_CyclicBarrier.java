package com.example.java.o_multithreading.c_highLevel_LockAPI;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;


public class E_CyclicBarrier {
	public static void main(String[] args) {
		CyclicBarrier barrier = new CyclicBarrier(3);
		new ExampleThread("A", barrier).start();
		new ExampleThread("B", barrier).start();
		new ExampleThread("C", barrier).start();
	}
}


class ExampleThread extends Thread {
	private String name;
	private CyclicBarrier barrier;

	ExampleThread(String name, CyclicBarrier barrier) {
		this.name = name;
		this.barrier = barrier;
	}
	
	public void run() {
		try {
			Thread.sleep(1000);
			System.out.println(name + " waiting at barrier");
			barrier.await();
			System.out.println(name + " done!");
		}
		catch (BrokenBarrierException | InterruptedException e) {
			e.printStackTrace();
		}
	}
}
