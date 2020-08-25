package com.tread;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadMain {

	public static void main(String[] args) throws InterruptedException {

		RejectedExecutionHandler handler = new RejectedTaskHandler();
		ThreadPoolExecutor cachedPool = new ThreadPoolExecutor(100, 100, 1, TimeUnit.SECONDS,
				new ArrayBlockingQueue<Runnable>(1), new ThreaddFactory(new MyExceptionHandler()), handler);

		Runnable command = new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				System.out.println("thread is" + Thread.currentThread().getName());
				Thread.currentThread().setName("kkkkk" + System.currentTimeMillis());
				throw new ArithmeticException();

				
			}
		};
		cachedPool.execute(command);
		cachedPool.execute(command);
		cachedPool.execute(command);
		cachedPool.execute(command);
		cachedPool.execute(command);
		cachedPool.execute(command);
		cachedPool.execute(command);
		cachedPool.execute(command);
		cachedPool.execute(command);
		cachedPool.execute(command);
		cachedPool.execute(command);
		cachedPool.execute(command);
		cachedPool.execute(command);
		cachedPool.execute(command);
		cachedPool.execute(command);
		cachedPool.execute(command);
		cachedPool.execute(command);
		cachedPool.execute(command);
		cachedPool.execute(command);
		cachedPool.execute(command);
		cachedPool.execute(command);
		cachedPool.execute(command);
		cachedPool.execute(command);
		System.out.println("main thread is" + Thread.currentThread().getName());

	}

}
