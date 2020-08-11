package com.lock;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.Lock;

public class Thread1 extends Thread {

	Lock lock;
	
	Counter counter; 
	
	CountDownLatch latch;

	public Thread1(Lock lock,Counter counter)

	{
		
	}

	public Thread1(Lock lock2, Counter counter2, CountDownLatch latch) {
		// TODO Auto-generated constructor stub
		this.lock = lock2;
		this.counter = counter2;
		this.latch = latch;
	}

	@Override
	public void run() {
		try {
			counter.printEven(lock,latch);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
