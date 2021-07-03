package com.example.java.q_multithreading.a_lowLevel;


/********************************************************************/
/** 		One synchronized method is called from another			*/
/********************************************************************/
class Shared {
	synchronized void print1(Shared s) {
		System.out.println(Thread.currentThread().getName()+" print1-begin");
		s.print2(this);
		System.out.println(Thread.currentThread().getName()+" print1-end");
	}
	synchronized void print2(Shared s) {
		System.out.println(Thread.currentThread().getName()+" print2-begin");
		s.print1(this);
		System.out.println(Thread.currentThread().getName()+" print2-end");
	}
}

class Test17 {
	public static void main(String[] args) {
		Shared s1 = new Shared();
		Shared s2 = new Shared();
		
		Thread t1 = new Thread(() -> s1.print1(s2));
		Thread t2 = new Thread(() -> s2.print2(s1));
		
		t1.start();
		t2.start();
	}
}





/********************************************************************/
/** 					Nested synchronized block					*/
/********************************************************************/
class Test18 {
	public static void main(String[] args) {
		final Object obj1 = new Object();
		final Object obj2 = new Object();
		
		Thread t1 = new Thread(() -> {
			synchronized (obj1) {
				System.out.println(Thread.currentThread().getName()+" obtains obj1");
				synchronized (obj2) {
					System.out.println(Thread.currentThread().getName()+" obtains obj2");
				}
			}
		});
		Thread t2 = new Thread(() -> {
			synchronized (obj2) {
				System.out.println(Thread.currentThread().getName()+" obtains obj2");
				synchronized (obj1) {
					System.out.println(Thread.currentThread().getName()+" obtains obj1");
				}
			}
		});
		
		t1.start();
		t2.start();
	}
}


