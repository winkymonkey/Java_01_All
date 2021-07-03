package com.example.java.q_multithreading.a_lowLevel;


/****************************************************/
/** 		Synchronized Instance Method			*/
/****************************************************/
@SuppressWarnings("unused")
class Test7 {
	private int count = 0;
	public synchronized void add(int value) {
		this.count += value;
	}
}



/****************************************************/
/** 		Synchronized Static Method				*/
/****************************************************/
@SuppressWarnings("unused")
class Test8 {
	private static int count = 0;
	public static synchronized void add(int value) {
		count += value;
	}
}



/************************************************************/
/** 		Synchronized block in Instance method			*/
/************************************************************/
class Test9 {
	public synchronized void log1(String msg1, String msg2) {
		System.out.println(msg1);
		System.out.println(msg2);
	}

	public void log2(String msg1, String msg2) {
		synchronized (this) {
			System.out.println(msg1);
			System.out.println(msg2);
		}
	}
}



/************************************************************/
/** 		Synchronized block in Static method				*/
/************************************************************/
class Test10 {
	public static synchronized void log1(String msg1, String msg2) {
		System.out.println(msg1);
		System.out.println(msg2);
	}

	public static void log2(String msg1, String msg2) {
		synchronized (Test10.class) {
			System.out.println(msg1);
			System.out.println(msg2);
		}
	}
}

