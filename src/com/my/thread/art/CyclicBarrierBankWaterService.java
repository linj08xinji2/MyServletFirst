package com.my.thread.art;


import java.util.Map.Entry;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class CyclicBarrierBankWaterService implements Runnable {

	/**
	 * 创建4个屏障，处理完之后执行当前类的run方法
	 */
	private CyclicBarrier c = new CyclicBarrier(4, this);
	/**
	 * 假设只有4个sheet，所以只启动4个线程
	 */
	private Executor executor = Executors.newFixedThreadPool(4);

	/**
	 * 保存每个sheet计算出的银流结果
	 */

	private ConcurrentHashMap<String, Integer> sheetbankwatercount = new ConcurrentHashMap<String, Integer>();

	public void count() {
		for (int i = 0; i < 4; i++) {
			executor.execute(new Runnable() {

				@Override
				public void run() {
					// 计算当前sheet的银流数据，计算代码省略
					System.out.println(Thread.currentThread().getName()+":累加！！");
					sheetbankwatercount
							.put(Thread.currentThread().getName(), 1);
					// 银流计算完成，插入一个屏障
					try {
						c.await();
					} catch (InterruptedException e) {
						e.printStackTrace();
					} catch (BrokenBarrierException e) {
						e.printStackTrace();
					}catch (Exception e){
						e.printStackTrace();
					}
				}
			});
		}

	}

	@Override
	public void run() {
		// 汇总每个sheet计算出的结果
		System.out.println(Thread.currentThread().getName()+":累加run");
		int result = 0;
		for (Entry<String, Integer> sheet : sheetbankwatercount.entrySet()) {
			result += sheet.getValue();
			System.out.println(Thread.currentThread().getName()+":累加2222");
		}
		// 将结果输出
		sheetbankwatercount.put("result", result);
		System.out.println(result);
//		executor.notifyAll();
		try {
			Thread.currentThread().sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("awake up");
//		Thread.currentThread().suspend();
	}

	public static void main(String[] args) {
		CyclicBarrierBankWaterService cc = new CyclicBarrierBankWaterService();
		cc.count();
	}
}
