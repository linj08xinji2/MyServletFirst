package com.my.thread;

/**
 * 多个线程之间共享数据的方式探讨
 * 
 * @author linj
 *
 */
public class MultiThreadShareData {
	private static SharaData data1 = new SharaData();

	public static void main(String[] args) {
		SharaData data2 = new SharaData();
		new Thread(new MyRunnable1(data2)).start();
		System.out.println("j:" + data1.j);
		new Thread(new MyRunnable2(data2)).start();
		System.out.println("j:" + data1.j);
		final SharaData data1 = new SharaData();
		new Thread(new Runnable() {
			@Override
			public void run() {
				data1.decrement();

			}
		}).start();
		System.out.println("j:" + data1.j);
		new Thread(new Runnable() {
			@Override
			public void run() {
				data1.increment();

			}
		}).start();
		System.out.println("j:" + data1.j);
	}
}

class MyRunnable1 implements Runnable {
	private SharaData data1;

	public MyRunnable1(SharaData data1) {
		this.data1 = data1;
	}

	public void run() {
		data1.decrement();

	}
}

class MyRunnable2 implements Runnable {
	private SharaData data1;

	public MyRunnable2(SharaData data1) {
		this.data1 = data1;
	}

	public void run() {
		data1.increment();
	}
}

class SharaData {
	public int j = 0;

	public synchronized void increment() {
		j++;
	}

	public synchronized void decrement() {
		j--;
	}

}
