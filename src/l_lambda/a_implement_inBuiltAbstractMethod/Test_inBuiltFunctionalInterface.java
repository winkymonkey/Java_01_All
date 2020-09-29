package l_lambda.a_implement_inBuiltAbstractMethod;


public class Test_inBuiltFunctionalInterface {
	public static void main(String[] args) {
		// Before Java-8
		Thread th = new Thread(new Runnable() {
			public void run() {
				System.out.println("thread is running");
			}
		});
		th.start();
		
		// After Java-8
		Thread t = new Thread(() -> System.out.println("New thread created"));
		t.start();
	}
}
