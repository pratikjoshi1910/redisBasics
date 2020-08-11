package com.lock;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Counter {

	volatile Lock locki;
	Condition condition;
	Condition isFull;

	public Counter() {
		locki = new ReentrantLock();
		condition = locki.newCondition();
	}

	public void printEven(Lock lock, CountDownLatch latch) throws InterruptedException {
		Integer count = 0;
		System.out.println("even " + Thread.currentThread().getName() + ' ');
		locki.lock();

		try {
			while (true) {
				if (count < 1000) {
					System.out.println(count);
					latch.countDown();
					count = count + 2;
					condition.signal();
					condition.await();
				} else {
					condition.signal();

					break;
				}
			}
		} finally {
			System.out.println("I am called even");

			locki.unlock();
		}
	}

	public void printOdd(Lock lock) throws InterruptedException {

		Integer count = 1;
		System.out.println("odd " + Thread.currentThread().getName());

		locki.lock();

		try {
			while (true) {
				if (count < 1000) {
					System.out.println(count);
					count = count + 2;

					condition.signal();
					condition.await();
				} else {
					condition.signal();
					System.out.println("else block odd");
					break;
				}
			}
		} finally {
			System.out.println("I am called");
			locki.unlock();

		}

	}

}
