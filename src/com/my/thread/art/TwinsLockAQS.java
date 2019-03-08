package com.my.thread.art;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

public class TwinsLockAQS implements Lock {
	private final Syn syn = new Syn(2);

	private static final class Syn extends AbstractQueuedSynchronizer {

		Syn(int count) {
			if (count <= 0) {
				throw new IllegalArgumentException(
						"count must large than zero.");
			}
			setState(count);
		}

		@Override
		protected int tryAcquireShared(int reduceCount) {
			for (;;) {
				int current = getState();
				int newCount = current - reduceCount;
				if (newCount < 0 || compareAndSetState(current, newCount)) {
					return newCount;
				}
			}

		}

		@Override
		protected boolean tryReleaseShared(int returnCount) {
			for (;;) {
				int current = getState();
				int newCount = current + returnCount;
				if (compareAndSetState(current, newCount)) {
					return true;
				}
			}
		}

	}

	@Override
	public void lock() {
		syn.acquireShared(1);
	}

	@Override
	public void unlock() {
		syn.releaseShared(1);
	}

	
	@Override
	public void lockInterruptibly() throws InterruptedException {

	}

	@Override
	public boolean tryLock() {
		return false;
	}

	@Override
	public boolean tryLock(long time, TimeUnit unit)
			throws InterruptedException {
		return false;
	}

	
	@Override
	public Condition newCondition() {
		return null;
	}

}
