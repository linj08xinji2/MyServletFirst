package com.my.thread;

import java.util.Random;

/**
 * ThreadLocal�༰Ӧ�ü���
 * 
 * @author linj
 *
 */
public class ThreadLocalTest {
	// 
//	private static ThreadLocal<Integer> x = new ThreadLocal<Integer>();
//	private static ThreadLocal<MyThreadScopeData> myThreadScopeData = new ThreadLocal<MyThreadScopeData>();
	public static void main(String[] args) {
		// 3���߳� ��������
		for (int i = 0; i < 3; i++) {
			new Thread(new Runnable() {
				@Override
				public void run() {
					int data = new Random().nextInt();
					System.out.println(Thread.currentThread().getName()
							+ " has put data :" + data);
//					x.set(data);
					MyThreadScopeData.getThreadInstance().setAge(data);
					MyThreadScopeData.getThreadInstance().setName(Thread.currentThread().getName());
					new A().get();
					new B().get();
				}
			}).start();
		}
	}

	static class A {
		public void get() {
		/*	int data = x.get();
			System.out.println("A from " + Thread.currentThread().getName()
					+ " get data :" + data);*/
			System.out.println("A:"+MyThreadScopeData.getThreadInstance());
		}
	}

	static class B {
		public void get() {
	/*	int data = x.get();
			System.out.println("B from " + Thread.currentThread().getName()
					+ " get data :" + data);*/
			System.out.println("B:"+MyThreadScopeData.getThreadInstance());
		}
	}
}


class MyThreadScopeData {
	private MyThreadScopeData() {
	}

	public static MyThreadScopeData getThreadInstance() {
		MyThreadScopeData instance = map.get();
		if (instance == null) {
			instance = new MyThreadScopeData(); // ����  ��Ҫ�ų�ʼ������������
			System.out.println("�ǲ���ֻ����һ�Σ�"); // ����
			map.set(instance);
		}
		return instance;
	}

	private static ThreadLocal<MyThreadScopeData> map = new ThreadLocal<MyThreadScopeData>();
	private String name;
	private int age;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "MyThreadScopeData [name=" + name + ", age=" + age + "]";
	}

}
	

