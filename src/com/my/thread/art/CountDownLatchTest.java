package com.my.thread.art;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchTest {
	static CountDownLatch c = new CountDownLatch(4);

	public static void main(String[] args) throws InterruptedException {
		new Thread(new Runnable() {

			@Override
			public void run() {
				System.out.println(1);
				c.countDown();
				System.out.println(2);
				c.countDown();
			}
		}).start();
		new Thread(new Runnable() {

			@Override
			public void run() {
				System.out.println(11);
				c.countDown();
				System.out.println(22);
				c.countDown();
			}
		}).start();
		c.await();
		System.out.println(3);
	}
}
