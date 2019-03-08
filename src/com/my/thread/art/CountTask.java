package com.my.thread.art;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.Future;
import java.util.concurrent.RecursiveTask;

public class CountTask extends RecursiveTask<Integer> {

	/**
	 * Fork就是把一个大任务切分为若干子任务并行的执行，
	 * Join就是合并这些子任务的执行结果，最后得到这个大任务的结果。
	 * 比如计算1+2+…+10000
	 * ，可以分割成10个子任务，每个子任务分别对1000个数进行求和，
	 * 最终汇总这10个子任务的结果。
	 */
	private static final long serialVersionUID = 1L;

	private static final int THRESHOLD = 2; // 阈值
	private int start;
	private int end;

	public CountTask(int start, int end) {
		// super();
		this.start = start;
		this.end = end;
		// System.out.println(Thread.currentThread().getName()+" 结果是：");
	}

	public static void main(String[] args) {
		ForkJoinPool pool = new ForkJoinPool();
		// // 生成一个计算任务，负责计算1+2+3+4
		CountTask countTask = new CountTask(1, 8);
		// 执行一个任务
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
		// 如果任务足够小就计算任务
		if (end - start <= THRESHOLD) {
			for (int i = start; i <= end; i++) {
				sum += i;
			}
		} else {
			// 如果任务大于阈值，就分裂成两个子任务计算
			int mid = (end + start) / 2;
			CountTask leftTask = new CountTask(start, mid);
			CountTask rigthTask = new CountTask(mid + 1, end);
			// 执行子任务
			leftTask.fork();
			rigthTask.fork();
			// 等待子任务执行完，并得到其结果
			int leftresult = leftTask.join();
			int rightresult = rigthTask.join();
			// 合并子任务
			sum = leftresult + rightresult;
			// System.out.println(Thread.currentThread().getName()+" 结果是："+sum);
		}
		return sum;
	}

	
}
