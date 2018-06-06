package com.my.thread;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * BlockingQueue,如果BlockQueue是空的,从BlockingQueue取东西的操作将会被阻断进入等待状态,
 * 直到BlockingQueue进了东西才会被唤醒
 * .同样,如果BlockingQueue是满的,任何试图往里存东西的操作也会被阻断进入等待状态,
 * 直到BlockingQueue里有空间才会被唤醒继续操作
 *
 */
public class Testone {
	/**
     	 * 现有的程序代码模拟产生了16个日志对象，并且需要运行16秒才能打印完这些日志，
           请在程序中增加4个线程去调用parseLog()方法来分头打印这16个日志对象，
              程序只需要运行4秒即可打印完这些日志对象
	 */
	public static void main(String[] args){
		final BlockingQueue<String> queue=new	ArrayBlockingQueue<String>(1);
		// 16个日志，4秒打印完成， i是每 秒打印日志次数
		for (int i = 0; i < 4; i++) {
			new Thread(new Runnable() {
				@Override
				public void run() {
					while(true){
					try {
						String log = queue.take();
						parseLog(log);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					}
				}
			}).start();
		}
		
		
		System.out.println("begin:"+(System.currentTimeMillis()/1000));
		/*模拟处理16行日志，下面的代码产生了16个日志对象，当前代码需要运行16秒才能打印完这些日志。
		修改程序代码，开四个线程让这16个对象在4秒钟打完。
		*/
		for(int i=0;i<16;i++){  //这行代码不能改动
			final String log = ""+(i+1);//这行代码不能改动
			{
				try {
					queue.put(log);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
//				ToneTest.parseLog(log);
			}
		}
	}
	
	//parseLog方法内部的代码不能改动
	public static void parseLog(String log){
		System.out.println(log+":"+(System.currentTimeMillis()/1000));
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}		
	}
}
