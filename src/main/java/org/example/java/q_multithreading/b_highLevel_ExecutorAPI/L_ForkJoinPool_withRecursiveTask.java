package org.example.java.q_multithreading.b_highLevel_ExecutorAPI;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;


@SuppressWarnings("serial")
public class L_ForkJoinPool_withRecursiveTask {
	
	public static void main(String[] args) {
		MyRecursiveTask task = new MyRecursiveTask(80);
		
		ForkJoinPool pool = new ForkJoinPool(4);
		long result = pool.invoke(task);
		System.out.println("result = "+result);
	}
	
	
	static class MyRecursiveTask extends RecursiveTask<Long> {
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
	
}
