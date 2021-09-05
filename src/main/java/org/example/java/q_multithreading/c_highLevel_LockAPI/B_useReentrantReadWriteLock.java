package org.example.java.q_multithreading.c_highLevel_LockAPI;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;


/**
 * ----------------------------------------------------------------------------------------------------------------
 * This class demonstrates how to use ReadWriteLock to add concurrency features to a non-thread-safe collection
 * ----------------------------------------------------------------------------------------------------------------
 */
public class B_useReentrantReadWriteLock {
	static final int READER_SIZE = 5000;
	static final int WRITER_SIZE = 50;

	public static void main(String[] args) {
		Integer[] initialElements = { 33, 28, 86, 99, 38, 22, 76, 19, 50 };

		ReadWriteList<Integer> readWriteList = new ReadWriteList<>(initialElements);

		for (int i = 0; i < WRITER_SIZE; i++) {
			new Writer(readWriteList).start();
		}

		for (int i = 0; i < READER_SIZE; i++) {
			new Reader(readWriteList).start();
		}
	}
}


class ReadWriteList<E> {
	private List<E> list = new ArrayList<>();
    private ReadWriteLock lock = new ReentrantReadWriteLock();
 
    @SafeVarargs
	public ReadWriteList(E... initialElements) {
        list.addAll(Arrays.asList(initialElements));
    }
	
	public void add(E element) {
        Lock writeLock = lock.writeLock();
        writeLock.lock();
        try {
            list.add(element);
        } 
        finally {
            writeLock.unlock();
        }
    }
 
    public E get(int index) {
        Lock readLock = lock.readLock();
        readLock.lock();
        try {
            return list.get(index);
        } 
        finally {
            readLock.unlock();
        }
    }
 
    public int size() {
        Lock readLock = lock.readLock();
        readLock.lock();
        try {
            return list.size();
        } 
        finally {
            readLock.unlock();
        }
    }
}



/**
 * This thread randomly adds an element to a shared data structure
 */
class Writer extends Thread {
	private ReadWriteList<Integer> readWriteList;

	public Writer(ReadWriteList<Integer> readWriteList) {
		this.readWriteList = readWriteList;
	}

	public void run() {
		int number = new Random().nextInt(100);
		readWriteList.add(number);
		try {
			Thread.sleep(100);
			System.out.println(getName() + " -> [write]: " + number);
		}
		catch (InterruptedException ie) {
			ie.printStackTrace();
		}
	}
}



/**
 * This thread randomly read an element from a shared data structure
 */
class Reader extends Thread {
	private ReadWriteList<Integer> readWriteList;

	public Reader(ReadWriteList<Integer> readWriteList) {
		this.readWriteList = readWriteList;
	}

	public void run() {
		int index = new Random().nextInt(readWriteList.size());
		Integer number = readWriteList.get(index);
		System.out.println(getName() + " -> [read]: " + number);
		try {
			Thread.sleep(100);
		}
		catch (InterruptedException ie) {
			ie.printStackTrace();
		}
    }
}
