package com.my.thread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * ����
 * 
 * @author ����Ա
 *
 */
public class LockTest {

	public static void main(String[] args) {
		final Outputer out = new Outputer();
		new Thread() {
			@Override
			public void run() {
				while (true) {
					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					out.output("һ��������");
				}

			}
		}.start();

		new Thread() {
			@Override
			public void run() {
				while (true) {
					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					out.output("BBBB");
				}
			}
		}.start();
		;
	}

	static class Outputer {
		// lock��synchronized ��������
		Lock lock = new ReentrantLock();
		private void output(String name) {
			lock.lock();
			try {
				for (int i = 0; i < name.length(); i++) {
					System.out.print(name.charAt(i));
				}
				System.out.println();
			} finally {
				lock.unlock();
			}

		}
	}
}
