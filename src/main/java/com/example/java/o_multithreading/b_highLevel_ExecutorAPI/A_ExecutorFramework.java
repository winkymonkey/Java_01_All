package com.example.java.o_multithreading.b_highLevel_ExecutorAPI;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;


/************************************************************/
/**				Obtain ExecutorService Instance				*/
/************************************************************/
class Test01 {
	public static void main(String[] args) {
		ExecutorService pool1 = Executors.newSingleThreadExecutor();	//thread-pool (Single thread)
		ExecutorService pool2 = Executors.newCachedThreadPool();		//thread-pool (Cached)
		ExecutorService pool3 = Executors.newFixedThreadPool(5); 		//thread-pool (Fixed N threads)

		ExecutorService pool4 = Executors.newWorkStealingPool(); 		//WorkStealing Pool (use ForkJoinPool)
		
		ExecutorService pool5 = Executors.newSingleThreadScheduledExecutor(); 	//Scheduled thread-pool (Single thread)
		ExecutorService pool6 = Executors.newScheduledThreadPool(5); 			//Scheduled thread-pool (Fixed N threads)
		
		pool1.shutdown();
		pool2.shutdown();
		pool3.shutdown();
		pool4.shutdown();
		pool5.shutdown();
		pool6.shutdown();
	}
}




/************************************************************/
/**				Submit (SINGLE) Runnable Task				*/
/************************************************************/
class Test02 {
	public static void main(String[] args) {
		ExecutorService pool = Executors.newSingleThreadExecutor();
		pool.execute(() -> System.out.println("execute -- "+Thread.currentThread().getName()));
		pool.shutdown();
	}
}




/************************************************************/
/**				Submit (MULTIPLE) Runnable Tasks			*/
/************************************************************/
class Test03 {
	public static void main(String[] args) {
		ExecutorService pool = Executors.newFixedThreadPool(3);
		pool.execute(() -> System.out.println("execute 1 -- "+Thread.currentThread().getName()));
		pool.execute(() -> System.out.println("execute 2 -- "+Thread.currentThread().getName()));
		pool.submit(() -> System.out.println("submit 1 -- "+Thread.currentThread().getName()));
		pool.execute(() -> System.out.println("execute 3 -- "+Thread.currentThread().getName()));
		pool.submit(() -> System.out.println("submit 2 -- "+Thread.currentThread().getName()));
		pool.shutdown();
	}
}




/************************************************************/
/**				Submit (SINGLE) Callable Task				*/
/************************************************************/
class Test04 {
	public static void main(String[] args) {
		ExecutorService pool = Executors.newSingleThreadExecutor();
		Future<Integer> future = pool.submit(() -> 123);
		
		while(!future.isDone()) {
			System.out.println("task is not done yet");
		}
		System.out.println("task is completed");
		try {
			Integer result = future.get(1, TimeUnit.SECONDS);
			System.out.println("result: " + result);
		}
		catch (InterruptedException | ExecutionException | TimeoutException e) {
			e.printStackTrace();
		}
		pool.shutdown();
	}
}




/************************************************************/
/**				Submit (MULTIPLE) Callable Tasks			*/
/************************************************************/
class Test05 {
	public static void main(String[] args) {
		ExecutorService pool = Executors.newFixedThreadPool(5);
		Future<Integer> future1 = pool.submit(() -> {Thread.sleep(4000);return 123;});
		Future<Integer> future2 = pool.submit(() -> {Thread.sleep(1000);return 456;});
		Future<Integer> future3 = pool.submit(() -> {Thread.sleep(8000);return 789;});
		
		List<Future<Integer>> futures = Arrays.asList(future1, future2, future3);
		
		for(Future<Integer> future : futures) {
			try {
				Integer result = future.get(10, TimeUnit.SECONDS);
				System.out.println("result: " + result);
			}
			catch (InterruptedException | ExecutionException | TimeoutException e) {
				e.printStackTrace();
			}
		}
		pool.shutdown();
	}
}




/************************************************************/
/**				Submit (MULTIPLE) Callable Tasks			*/
/**						-- invokeAll() --					*/
/************************************************************/
class Test06 {
	public static void main(String[] args) {
		ExecutorService pool = Executors.newFixedThreadPool(5);
		Callable<Integer> c1 = (() -> {Thread.sleep(4000);return 123;});
		Callable<Integer> c2 = (() -> {Thread.sleep(1000);return 456;});
		Callable<Integer> c3 = (() -> {Thread.sleep(8000);return 789;});
		
		List<Callable<Integer>> taskList = Arrays.asList(c1, c2, c3);
		
		try {
			List<Future<Integer>> futureList = pool.invokeAll(taskList);
			futureList.forEach(future -> {
				try {
					Integer result = future.get();
					System.out.println("result: " + result);
				}
				catch (InterruptedException | ExecutionException e) {
					e.printStackTrace();
				}
			});
		}
		catch (InterruptedException e) {
			e.printStackTrace();
		}
		pool.shutdown();
	}
}




/************************************************************/
/**				Submit (MULTIPLE) Callable Tasks			*/
/**						-- invokeAny() --					*/
/************************************************************/
class Test07 {
	public static void main(String[] args) {
		ExecutorService pool = Executors.newSingleThreadExecutor();
		Callable<Integer> c1 = (() -> {Thread.sleep(4000);return 123;});
		Callable<Integer> c2 = (() -> {Thread.sleep(1000);return 456;});
		Callable<Integer> c3 = (() -> {Thread.sleep(8000);return 789;});
		
		Collection<Callable<Integer>> taskList = Arrays.asList(c1, c2, c3);
		
		try {
			Integer i = pool.invokeAny(taskList);
			System.out.println(i);
		}
		catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}
		pool.shutdown();
	}
}




/************************************************************/
/**					ExecutorCompletionService				*/
/************************************************************/
class Test08 {
	public static void main(String[] args) {
		ExecutorService pool = Executors.newFixedThreadPool(3);
		CompletionService<Integer> executorCompletionService = new ExecutorCompletionService<>(pool);
		
		Future<Integer> future1 = executorCompletionService.submit(() -> {Thread.sleep(4000);return 123;});
		Future<Integer> future2 = executorCompletionService.submit(() -> {Thread.sleep(1000);return 456;});
		Future<Integer> future3 = executorCompletionService.submit(() -> {Thread.sleep(8000);return 789;});
		
		List<Future<Integer>> futures = Arrays.asList(future1, future2, future3);
		
		for (int i=0; i<futures.size(); i++) {
		    try {
		    	Future<Integer> future = executorCompletionService.take();
				Integer result = future.get();
				System.out.println("result: " + result);
			}
		    catch (InterruptedException | ExecutionException e) {
				e.printStackTrace();
			}
		    // Some processing here
		}
		pool.shutdown();
	}
}

class Test09 {
	public static void main(String[] args) {
		ExecutorService pool = Executors.newFixedThreadPool(3);
		CompletionService<Integer> executorCompletionService = new ExecutorCompletionService<>(pool);
		
		Future<Integer> future1 = executorCompletionService.submit(() -> {try {Thread.sleep(4000);} catch (InterruptedException e) {/**/}}, 101);
		Future<Integer> future2 = executorCompletionService.submit(() -> {try {Thread.sleep(1000);} catch (InterruptedException e) {/**/}}, 202);
		Future<Integer> future3 = executorCompletionService.submit(() -> {try {Thread.sleep(8000);} catch (InterruptedException e) {/**/}}, 303);
		
		List<Future<Integer>> futures = Arrays.asList(future1, future2, future3);
		
		for (int i=0; i<futures.size(); i++) {
		    try {
		    	Future<Integer> future = executorCompletionService.take();
		    	Integer result = future.get();
				System.out.println("result: " + result);
			}
		    catch (InterruptedException | ExecutionException e) {
				e.printStackTrace();
			}
		    // Some processing here
		}
		pool.shutdown();
	}
}









/********************************************************/
/**					Schedule Executor					*/
/********************************************************/
@SuppressWarnings("unused")
class Test10 {
	public static void main(String[] args) {
		ScheduledExecutorService pool1 = Executors.newScheduledThreadPool(1);
		ScheduledFuture<?> future1 = pool1.schedule(() -> System.out.println("hello"), 3, TimeUnit.SECONDS);
		
		ScheduledExecutorService pool2 = Executors.newScheduledThreadPool(1);
		ScheduledFuture<Integer> future2 = pool2.schedule(() -> {return 123;}, 3, TimeUnit.SECONDS);
	}
}

@SuppressWarnings("unused")
class Test11 {
	public static void main(String[] args) {
		ScheduledExecutorService pool = Executors.newScheduledThreadPool(1);
		ScheduledFuture<?> future = pool.scheduleAtFixedRate(() -> System.out.println("hello"), 3, 1, TimeUnit.SECONDS);
	}
}

@SuppressWarnings("unused")
class Test12 {
	public static void main(String[] args) {
		ScheduledExecutorService pool = Executors.newScheduledThreadPool(1);
		ScheduledFuture<?> future = pool.scheduleWithFixedDelay(() -> System.out.println("hello"), 3, 1, TimeUnit.SECONDS);
	}
}






