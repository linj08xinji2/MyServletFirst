package com.my.thread;

/**
 * 互斥
 * @author 管理员
 *
 */
public class TraditionalThreadSynchronized {

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
					out.output("一二三四五");
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
		private synchronized void output(String name) {
			for (int i = 0; i < name.length(); i++) {
				System.out.print(name.charAt(i));
			}
			System.out.println();
		}
	}
}
