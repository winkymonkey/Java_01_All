package org.example.java.q_multithreading.c_highLevel_LockAPI;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


/********************************************************/
/**					lock() - unlock()					*/
/********************************************************/
class Test01 {
	private final Lock lock = new ReentrantLock();
	
	void print() {
		lock.lock();
		System.out.println("hello world");
		lock.unlock();
	}
}



/********************************************************/
/**						trylock()						*/
/********************************************************/
class Test02 {
	private final Lock lock = new ReentrantLock();
	
	void print() {
		boolean isAvailable = lock.tryLock();	//lock.tryLock(100, TimeUnit.MILLISECONDS);
		if (isAvailable) {
			System.out.println("hello world");
			lock.unlock();
		}
		else
			System.out.println("the lock is not available");
	}
}



/********************************************************/
/**					lockInterruptibly()					*/
/********************************************************/
class Test03 {
	private final Lock lock = new ReentrantLock();
	
	void print() {
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



