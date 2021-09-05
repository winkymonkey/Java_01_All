package org.example.java.q_multithreading.c_highLevel_LockAPI;

import java.util.concurrent.locks.StampedLock;


public class C_useStampedLock {
	
	public static void main(String[] args) {
		demoReadLock();
		demoWriteLock();
		demoOptimisticRead();
	}
	
	
	private static void demoReadLock() {
		StampedLock lock = new StampedLock();
		long stamp = lock.readLock();
		try {
			//...
		}
		finally {
			lock.unlockRead(stamp);
		}
	}
	
	private static void demoWriteLock() {
		StampedLock lock = new StampedLock();
		long stamp = lock.writeLock();
		try {
			//...
		}
		finally {
			lock.unlockWrite(stamp);
		}
	}
	
	private static void demoOptimisticRead() {
		StampedLock lock = new StampedLock();
		long stamp = lock.tryOptimisticRead();
		//...read
		if (!lock.validate(stamp)) {		//if a write occurred, try again with a read lock
			stamp = lock.readLock();
			try {
				//...read
			}
			finally {
				lock.unlockRead(stamp);
			}
		}
	}
	
}
