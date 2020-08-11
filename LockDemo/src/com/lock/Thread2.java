package com.lock;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.Lock;

public class Thread2 extends Thread {

	Lock lock;

	Counter counter; 
	
	CountDownLatch latch;

	public Thread2(Lock lock,Counter counter, CountDownLatch latch)

	{
		this.lock = lock;
		this.counter = counter;
	}

	@Override
	public void run() {
        try {
			counter.printOdd(lock);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
