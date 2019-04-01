package com.my.thread.art;


import java.util.Map.Entry;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class CyclicBarrierBankWaterService implements Runnable {

	/**
	 * ����4�����ϣ�������֮��ִ�е�ǰ���run����
	 */
	private CyclicBarrier c = new CyclicBarrier(4, this);
	/**
	 * ����ֻ��4��sheet������ֻ����4���߳�
	 */
	private Executor executor = Executors.newFixedThreadPool(4);

	/**
	 * ����ÿ��sheet��������������
	 */

	private ConcurrentHashMap<String, Integer> sheetbankwatercount = new ConcurrentHashMap<String, Integer>();

	public void count() {
		for (int i = 0; i < 4; i++) {
			executor.execute(new Runnable() {

				@Override
				public void run() {
					// ���㵱ǰsheet���������ݣ��������ʡ��
					System.out.println(Thread.currentThread().getName()+":�ۼӣ���");
					sheetbankwatercount
							.put(Thread.currentThread().getName(), 1);
					// ����������ɣ�����һ������
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
		// ����ÿ��sheet������Ľ��
		System.out.println(Thread.currentThread().getName()+":�ۼ�run");
		int result = 0;
		for (Entry<String, Integer> sheet : sheetbankwatercount.entrySet()) {
			result += sheet.getValue();
			System.out.println(Thread.currentThread().getName()+":�ۼ�2222");
		}
		// ��������
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
