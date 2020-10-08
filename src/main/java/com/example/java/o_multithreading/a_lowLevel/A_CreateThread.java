package com.example.java.o_multithreading.a_lowLevel;


class Test1 {
	public static void main(String[] args) {
		Thread t1 = new Thread() {
			@Override
			public void run() {
				//... code to be executed by this thread ...
			}
		};
		t1.start();
	}
}


class Test2 {
	public static void main(String[] args) {
		Thread t2 = new Thread(new Runnable() {
			@Override
			public void run() {
				//... code to be executed by this thread ...
			}
		});
		t2.start();
	}
}


class Test3 {
	public static void main(String[] args) {
		Thread t3 = new Thread(() -> {/*... code to be executed by this thread ...*/} );
		t3.start();
	}
}