package com.tread;

import java.lang.Thread.UncaughtExceptionHandler;
import java.util.Arrays;

class MyExceptionHandler implements Thread.UncaughtExceptionHandler {
    @Override
    public void uncaughtException(Thread thread, Throwable t) {
    	System.out.println(thread.currentThread().getName());
        System.err.println("Uncaught exception ccccccis detected! " + t
                + " st: " + Arrays.toString(t.getStackTrace()));
        // ... Handle the exception
    }
}
