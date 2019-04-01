package com.my.thread.art;

import java.util.concurrent.Exchanger;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExchangerTest {

	private static final Exchanger<String> exc = new Exchanger<String>();

	private static ExecutorService executor = Executors.newFixedThreadPool(2);

	public static void main(String[] args) {
		executor.execute(new Runnable() {
			public void run() {
				String A = "aaaa";
				try {
					exc.exchange(A);
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});

		executor.execute(new Runnable() {
			@Override
			public void run() {
				String B = "bbbb";
				try {
					String A = exc.exchange(B);
					Thread.sleep(2000);
					System.out.println("A= " + A);
					System.out.println("B= " + B);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});

		executor.shutdown();
	}

}
