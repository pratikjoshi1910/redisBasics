package com.tread;

import java.util.Arrays;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

public class ThreaddFactory implements ThreadFactory{
	
    private static final ThreadFactory defaultFactory = Executors.defaultThreadFactory();
    private final Thread.UncaughtExceptionHandler handler;
    
    public ThreaddFactory(Thread.UncaughtExceptionHandler handler) {
        this.handler = handler;
    }

	@Override
	public Thread newThread(Runnable run) {
		Thread thread = defaultFactory.newThread(run);
        thread.setUncaughtExceptionHandler(handler);
        return thread;
	}

	
}
