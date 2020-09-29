package n_multithreading.a_lowLevel;


class Test12 {
	public static void main(String[] args) throws InterruptedException {
		ThreadLocal<Integer> threadLocal = new ThreadLocal<Integer>();

		Thread t1 = new Thread(() -> {
			try {
				Thread.sleep(1000);
			}
			catch (InterruptedException e) {
				e.printStackTrace();
			}
			threadLocal.set((int) (Math.random() * 100D));
			System.out.println(threadLocal.get());
		});
		Thread t2 = new Thread(() -> {
			try {
				Thread.sleep(1000);
			}
			catch (InterruptedException e) {
				e.printStackTrace();
			}
			threadLocal.set((int) (Math.random() * 100D));
			System.out.println(threadLocal.get());
		});
		t1.start();
		t2.start();
	}
}


//ThreadLocal<Integer> threadLocal2 = ThreadLocal.withInitial(() -> {return 100;});