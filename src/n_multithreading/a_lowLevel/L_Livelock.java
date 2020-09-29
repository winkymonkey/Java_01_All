package n_multithreading.a_lowLevel;

//This is not a livelock example... 
//This is a simple recursive program where two methods call each other infinitely. 
class SharedObj {
	void print1(SharedObj s) {
		System.out.println(Thread.currentThread().getName()+" print1-begin");
		s.print2(this);
		System.out.println(Thread.currentThread().getName()+" print1-end");
	}
	void print2(SharedObj s) {
		System.out.println(Thread.currentThread().getName()+" print2-begin");
		s.print1(this);
		System.out.println(Thread.currentThread().getName()+" print2-end");
	}
}

class Test19 {
	public static void main(String[] args) {
		SharedObj s1 = new SharedObj();
		SharedObj s2 = new SharedObj();
		
		Thread t1 = new Thread(() -> s1.print1(s2));
		Thread t2 = new Thread(() -> s2.print2(s1));
		
		t1.start();
		t2.start();
	}
}

