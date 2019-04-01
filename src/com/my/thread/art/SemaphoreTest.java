package com.my.thread.art;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class SemaphoreTest {

	private static final int THREAD_COUNT = 30;

	private static Semaphore s = new Semaphore(10);

	private static ExecutorService es = Executors.newFixedThreadPool(30);

	public static void main(String[] args) {
		for (int i = 0; i < THREAD_COUNT; i++) {
			es.execute(new Runnable() {
				@Override
				public void run() {
					try {
						s.acquire();
						System.out.println(Thread.currentThread().getName()
								+ "save data");
						s.release();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			});
		}
		// try {
		// Thread.currentThread().sleep(2000);
		// } catch (InterruptedException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }
		// System.out.println("end");
		es.shutdown();
	}

}
