package com.example.java.o_multithreading.c_highLevel_LockAPI;

import java.util.concurrent.locks.StampedLock;


public class C_StampedLock {
	
	public void demoReadLock() {
		StampedLock lock = new StampedLock();
		long stamp = lock.readLock();
		try {
			//...
		}
		finally {
			lock.unlockRead(stamp);
		}
	}
	
	public void demoWriteLock() {
		StampedLock lock = new StampedLock();
		long stamp = lock.writeLock();
		try {
			//...
		}
		finally {
			lock.unlockWrite(stamp);
		}
	}
	
	public void demoOptimisticRead() {
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
