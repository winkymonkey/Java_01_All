package org.example.java.q_multithreading.c_highLevel_LockAPI;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


public class A_useReentrantLock {
	
	public static void main(String[] args) {
		lockUnlock();
		trylock();
		lockInterruptibly();
	}
	
	
	private static void lockUnlock() {
		Lock lock = new ReentrantLock();
		lock.lock();
		System.out.println("hello world");
		lock.unlock();
	}
	
	private static void trylock() {
		Lock lock = new ReentrantLock();
		boolean isAvailable = lock.tryLock();		//lock.tryLock(100, TimeUnit.MILLISECONDS);
		if (isAvailable) {
			System.out.println("hello world");
			lock.unlock();
		}
		else {
			System.out.println("the lock is not available");
		}
	}
	
	private static void lockInterruptibly() {
		Lock lock = new ReentrantLock();
		try {
			lock.lockInterruptibly();
			System.out.println("hello world");
			lock.unlock();
		}
		catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
