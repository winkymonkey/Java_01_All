package com.example.java.q_multithreading.b_highLevel_ExecutorAPI;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;
import java.util.concurrent.RecursiveTask;


/********************************************************/
/**				using RecursiveAction					*/
/********************************************************/
class MyRecursiveAction extends RecursiveAction {
	private static final long serialVersionUID = -1196634661607379734L;
	private long workLoad = 0;

	public MyRecursiveAction(long workLoad) {
		this.workLoad = workLoad;
	}

	@Override
	protected void compute() {
		if (workLoad > 16) {
			System.out.println("Splitting workLoad : " + workLoad);

			MyRecursiveAction subtask1 = new MyRecursiveAction(workLoad / 2);
			MyRecursiveAction subtask2 = new MyRecursiveAction(workLoad / 2);
			subtask1.fork();
			subtask2.fork();
			subtask1.join();
			subtask2.join();
		}
		else {
			System.out.println("Doing workLoad myself: " + workLoad);
		}
	}
}

class Test13 {
	public static void main(String[] args) {
		ForkJoinPool pool = new ForkJoinPool(4);
		RecursiveAction action = new MyRecursiveAction(80);
		pool.invoke(action);
	}
}







/********************************************************/
/**					using RecursiveTask					*/
/********************************************************/
class MyRecursiveTask extends RecursiveTask<Long> {
	private static final long serialVersionUID = -8234765183164066152L;
	private long workLoad = 0;

	public MyRecursiveTask(long workLoad) {
		this.workLoad = workLoad;
	}

	@Override
	protected Long compute() {
		long result = 0;
		if (this.workLoad > 16) {
			System.out.println("Splitting workLoad : " + this.workLoad);

			MyRecursiveTask subtask1 = new MyRecursiveTask(this.workLoad / 2);
			MyRecursiveTask subtask2 = new MyRecursiveTask(this.workLoad / 2);
			subtask1.fork();
			subtask2.fork();
			result += subtask1.join();
			result += subtask2.join();
			return result;
		}
		else {
			System.out.println("Doing workLoad myself: " + this.workLoad);
			return workLoad;
		}
	}
}

class Test14 {
	public static void main(String[] args) {
		ForkJoinPool pool = new ForkJoinPool(4);
		MyRecursiveTask task = new MyRecursiveTask(80);
		long result = pool.invoke(task);
		System.out.println("result = "+result);
	}
}




