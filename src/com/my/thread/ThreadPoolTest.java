package com.my.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPoolTest {
      public static void main(String[] args) {
//		ExecutorService threadPool=Executors.newFixedThreadPool(3);// 3¸öÏß³Ì
//    	ExecutorService threadPool = Executors.newCachedThreadPool();
    	  ExecutorService threadPool = Executors.newSingleThreadExecutor();
		for (int i = 0; i < 10; i++) {
			final int task = i;
			threadPool.execute(new Runnable() {
				@Override
				public void run() {
					for (int j = 1; j <=10; j++) {
						System.out.println(Thread.currentThread().getName() + " is looping of " + j + " for  task of " + task);
					}
				}
			});
		}
		System.out.println("all of 10 tasks have committed! ");
		threadPool.shutdownNow();
//		Executors.newScheduledThreadPool(3).scheduleAtFixedRate(new Runnable() {
//			@Override
//			public void run() {
//				System.out.println("bombing!");
//
//			}
//		}, 6, 2, TimeUnit.SECONDS);
      }
}
