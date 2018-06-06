package com.my.thread;

public class TraditionalThread {

	public static void main(String[] args) {
		// ֻ��ʵ��Thread ��д����
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

		// ʵ�ֽӿ�
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

		// ����һ����������ǣ�thread ���൱�ڸ���
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
