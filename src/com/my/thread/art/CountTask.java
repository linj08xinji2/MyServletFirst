package com.my.thread.art;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.Future;
import java.util.concurrent.RecursiveTask;

public class CountTask extends RecursiveTask<Integer> {

	/**
	 * Fork���ǰ�һ���������з�Ϊ�����������е�ִ�У�
	 * Join���Ǻϲ���Щ�������ִ�н�������õ����������Ľ����
	 * �������1+2+��+10000
	 * �����Էָ��10��������ÿ��������ֱ��1000����������ͣ�
	 * ���ջ�����10��������Ľ����
	 */
	private static final long serialVersionUID = 1L;

	private static final int THRESHOLD = 2; // ��ֵ
	private int start;
	private int end;

	public CountTask(int start, int end) {
		// super();
		this.start = start;
		this.end = end;
		// System.out.println(Thread.currentThread().getName()+" ����ǣ�");
	}

	public static void main(String[] args) {
		ForkJoinPool pool = new ForkJoinPool();
		// // ����һ���������񣬸������1+2+3+4
		CountTask countTask = new CountTask(1, 8);
		// ִ��һ������
		Future<Integer> result = pool.submit(countTask);
		try {
			System.out.println(result.get());
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}
	}

	@Override
	protected Integer compute() {
		int sum = 0;
		// ��������㹻С�ͼ�������
		if (end - start <= THRESHOLD) {
			for (int i = start; i <= end; i++) {
				sum += i;
			}
		} else {
			// ������������ֵ���ͷ��ѳ��������������
			int mid = (end + start) / 2;
			CountTask leftTask = new CountTask(start, mid);
			CountTask rigthTask = new CountTask(mid + 1, end);
			// ִ��������
			leftTask.fork();
			rigthTask.fork();
			// �ȴ�������ִ���꣬���õ�����
			int leftresult = leftTask.join();
			int rightresult = rigthTask.join();
			// �ϲ�������
			sum = leftresult + rightresult;
			// System.out.println(Thread.currentThread().getName()+" ����ǣ�"+sum);
		}
		return sum;
	}

	
}
