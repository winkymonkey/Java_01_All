package n_multithreading.c_highLevel_LockAPI;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;


class CustomList<E> {
	private final ReadWriteLock lock = new ReentrantReadWriteLock();
	private final Lock readLock = lock.readLock();
	private final Lock writeLock = lock.writeLock();
	
	private final List<E> list = new ArrayList<>();
	
	
	public static void main(String[] args) {
		CustomList<String> customList = new CustomList<>();
		customList.set("1");
		customList.set("2");
		customList.set("3");
		System.out.println("Printing First Element " + customList.get(1));
	}
	
	
	private void set(E o) {
		writeLock.lock();
		list.add(o);
		System.out.println("Add element by " + Thread.currentThread().getName());
		writeLock.unlock();
	}
	
	
	private E get(int i) {
		readLock.lock();
		System.out.println("fetch elements by " + Thread.currentThread().getName());
		readLock.unlock();
		return list.get(i);
	}
}
