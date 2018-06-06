package com.my.thread;

import java.util.concurrent.Semaphore;
import java.util.concurrent.SynchronousQueue;

/**
 * ��SemaphoreҲ��һ���߳�ͬ���ĸ����࣬����ά����ǰ����������̸߳��������ṩ��ͬ�����ơ�
 * ʹ��Semaphore���Կ���ͬʱ������Դ���̸߳��������磬ʵ��һ���ļ�����Ĳ�����������
    Semaphore����Ҫ����ժҪ��
����void acquire():�Ӵ��ź�����ȡһ����ɣ����ṩһ�����ǰһֱ���߳������������̱߳��жϡ�
����void release():�ͷ�һ����ɣ����䷵�ظ��ź�����

Semaphore��һ����������N�˵ķ��䣬����˲����Ϳ��Խ�ȥ����������ˣ���Ҫ�ȴ����˳�����
����N=1���������Ϊbinary semaphore��һ����÷��ǣ��������ƶ���ĳһ��Դ��ͬʱ����


SynchronousQueue������ һ���������У�����ÿ�� put ����ȴ�һ�� take��
��֮��Ȼ��ͬ������û���κ��ڲ�������������һ�����е�������û�С�
 ������ͬ�������Ͻ��� peek����Ϊ������ͼҪȡ��Ԫ��ʱ����Ԫ�زŴ��ڣ�
 ������һ���߳���ͼ�Ƴ�ĳ��Ԫ�أ�����Ҳ���ܣ�ʹ���κη��������Ԫ�أ�
 Ҳ���ܵ������У���Ϊ����û��Ԫ�ؿ����ڵ��������е�ͷ�ǳ�����ӵ������е��׸����Ŷ��߳�Ԫ�أ�
  ���û�����Ŷ��̣߳������Ԫ�ز���ͷΪ null��

 *
 */
public class Testtwo {
	/***
	 * �ֳɳ����е�Test���еĴ����ڲ��ϵز������ݣ�Ȼ�󽻸�TestDo.doSome()����ȥ����
      �ͺ����������ڲ��ϵز������ݣ��������ڲ����������ݡ�
      �뽫����������10���߳������������߲��������ݣ�
      ��Щ�����߶�����TestDo.doSome()����ȥ���д�����ÿ�������߶���Ҫһ����ܴ����꣬
      ����Ӧ��֤��Щ�������߳�����������������ݣ�ֻ����һ���������������
      ��һ�������߲����������ݣ���һ����������˭�����ԣ���Ҫ��֤��Щ�������߳��õ�����������˳���
	 */
	public static void main(String[] args) {
		 final Semaphore semaphore=new Semaphore(1);
		final SynchronousQueue<String> queue = new SynchronousQueue<String>();
		for (int i = 0; i < 10; i++) {
			new Thread(new Runnable() {
				@Override
				public void run() {
					try {
						semaphore.acquire();
						String input = queue.take();
						String output = TestDo.doSome(input);
						System.out.println(Thread.currentThread().getName()+ ":" + output);
						semaphore.release();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}).start();
		}
		
		
		System.out.println("begin:"+(System.currentTimeMillis()/1000));
		for(int i=0;i<10;i++){  //���в��ܸĶ�
			String input = i+"";  //���в��ܸĶ�
			try {
				queue.put(input);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
//			String output = TestDo.doSome(input);
//			System.out.println(Thread.currentThread().getName()+ ":" + output);
		}
	}
}
    //���ܸĶ���TestDo��
	class TestDo {
		public static String doSome(String input){
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			String output = input + ":"+ (System.currentTimeMillis() / 1000);
			return output;
		}
	}