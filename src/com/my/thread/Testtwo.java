package com.my.thread;

import java.util.concurrent.Semaphore;
import java.util.concurrent.SynchronousQueue;

/**
 * 　Semaphore也是一个线程同步的辅助类，可以维护当前访问自身的线程个数，并提供了同步机制。
 * 使用Semaphore可以控制同时访问资源的线程个数，例如，实现一个文件允许的并发访问数。
    Semaphore的主要方法摘要：
　　void acquire():从此信号量获取一个许可，在提供一个许可前一直将线程阻塞，否则线程被中断。
　　void release():释放一个许可，将其返回给信号量。

Semaphore是一件可以容纳N人的房间，如果人不满就可以进去，如果人满了，就要等待有人出来。
对于N=1的情况，称为binary semaphore。一般的用法是，用于限制对于某一资源的同时访问


SynchronousQueue是这样 一种阻塞队列，其中每个 put 必须等待一个 take，
反之亦然。同步队列没有任何内部容量，甚至连一个队列的容量都没有。
 不能在同步队列上进行 peek，因为仅在试图要取得元素时，该元素才存在；
 除非另一个线程试图移除某个元素，否则也不能（使用任何方法）添加元素；
 也不能迭代队列，因为其中没有元素可用于迭代。队列的头是尝试添加到队列中的首个已排队线程元素；
  如果没有已排队线程，则不添加元素并且头为 null。

 *
 */
public class Testtwo {
	/***
	 * 现成程序中的Test类中的代码在不断地产生数据，然后交给TestDo.doSome()方法去处理，
      就好像生产者在不断地产生数据，消费者在不断消费数据。
      请将程序改造成有10个线程来消费生成者产生的数据，
      这些消费者都调用TestDo.doSome()方法去进行处理，故每个消费者都需要一秒才能处理完，
      程序应保证这些消费者线程依次有序地消费数据，只有上一个消费者消费完后，
      下一个消费者才能消费数据，下一个消费者是谁都可以，但要保证这些消费者线程拿到的数据是有顺序的
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
		for(int i=0;i<10;i++){  //这行不能改动
			String input = i+"";  //这行不能改动
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
    //不能改动此TestDo类
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