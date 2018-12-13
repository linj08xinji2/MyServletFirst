package com.classloader;

/**
 * 后台启动一条线程不断加载实现热加载功能的类
 *
 */
public class MsgHandler implements Runnable {

	@Override
	public void run() {
		while (true) {
			BaseManager manager = ManagerFactory
					.getManager(ManagerFactory.MY_MANAGER);
			manager.logic();
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
