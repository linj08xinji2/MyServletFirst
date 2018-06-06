package com.my.thread;

public class TraditionalThread {

	public static void main(String[] args) {
		// 只能实现Thread 重写方法
		Thread thread = new Thread() {
			public void run() {
				while (true) {
					try {
						Thread.sleep(500);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					System.out.println("1:" + Thread.currentThread().getName());
					System.out.println("2:" + this.getName());
				}
			}
		};
		// thread.start();

		// 实现接口
		Thread thread2 = new Thread(new Runnable() {
			@Override
			public void run() {
				while (true) {
					try {
						Thread.sleep(500);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					System.out.println("1:" + Thread.currentThread().getName());
				}
			}
		});
		// thread2.start();

		// 两者一起来，结果是：thread ，相当于父类
		new Thread(new Runnable() {
			@Override
			public void run() {
				while (true) {
					try {
						Thread.sleep(500);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					System.out.println("runnable :"
							+ Thread.currentThread().getName());
				}
			}
		}) {
			@Override
			public void run() {
				while (true) {
					try {
						Thread.sleep(500);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					System.out.println("thread :"
							+ Thread.currentThread().getName());
				}
			}
		}.start();
		;
	}

}
