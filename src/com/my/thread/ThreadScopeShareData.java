/**
 * 
 */
package com.my.thread;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * 线程范围内共享变量的概念与作用
 * 
 * @author linj
 *
 */
public class ThreadScopeShareData {

//	private static int data ;
    
	private static Map<Thread,Integer> threadData=new HashMap<Thread,Integer>();
	
	public static void main(String[] args) {
		// 3个线程 才有区别
		for (int i = 0; i < 3; i++) {
			new Thread(new Runnable() {
				@Override
				public void run() {
					int	data = new Random().nextInt();
					System.out.println(Thread.currentThread().getName()
							+ " has put data :" + data);
					threadData.put(Thread.currentThread(), data);
					new A().get();
					new B().get();
				}
			}).start();
		}
	}

	static class A {
		int data=threadData.get(Thread.currentThread());
		public void get() {
			System.out.println("A from " + Thread.currentThread().getName()
					+ " get data :" + data);
		}
	}

	static class B {
		public void get() {
			int data=threadData.get(Thread.currentThread());
			System.out.println("B from " + Thread.currentThread().getName()
					+ " get data :" + data);
		}
	}
}
