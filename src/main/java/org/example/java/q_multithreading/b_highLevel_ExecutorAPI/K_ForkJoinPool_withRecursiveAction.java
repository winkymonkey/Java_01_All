package org.example.java.q_multithreading.b_highLevel_ExecutorAPI;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;


/********************************************************/
/**				using RecursiveAction					*/
/********************************************************/
@SuppressWarnings("serial")
public class K_ForkJoinPool_withRecursiveAction {
	
	public static void main(String[] args) {
		RecursiveAction action = new MyRecursiveAction(80);
		
		ForkJoinPool pool = new ForkJoinPool(4);
		pool.invoke(action);
		System.out.println("work completed");
	}
	
	
	static class MyRecursiveAction extends RecursiveAction {
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
	
}
