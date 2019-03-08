package com.my.thread.art;

import java.util.concurrent.locks.Lock;

import org.junit.Test;

public class TwinsLockTest {
	@Test
	public void test() throws Exception {
		final Lock lock = new TwinsLockAQS();
		class Worker extends Thread {
			public void run() {
				while (true) {
					lock.lock();
					try {
//						SleepUtils.second(1);
						Thread.sleep(1000);
						System.out.println(Thread.currentThread().getName());
						Thread.sleep(1000);
					} catch (Exception e) {
						e.printStackTrace();
					} finally {
						lock.unlock();
					}
				}
			}
		}
		// 启动10个线程
		for (int i = 0; i < 10; i++) {
			Worker w = new Worker();
			w.setDaemon(true);
			w.start();
		}
		// 每隔1秒换行
		for (int i = 0; i < 10; i++) {
			Thread.sleep(1000);
			System.out.println();
		}
	}
}