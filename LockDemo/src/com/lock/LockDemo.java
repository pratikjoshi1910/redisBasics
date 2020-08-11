package com.lock;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockDemo {

	public static void main(String[] args) throws InterruptedException {
		Lock lock = new ReentrantLock();
		CountDownLatch latch = new CountDownLatch(1);
		Counter counter = new Counter();
		Thread1 thread1 = new Thread1(lock, counter,latch);
		Thread2 thread2 = new Thread2(lock, counter,latch);
		thread1.start();
		latch.await();
		thread2.start();
	}

}
