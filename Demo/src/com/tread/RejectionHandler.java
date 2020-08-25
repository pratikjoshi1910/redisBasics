package com.tread;

import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;

class RejectedTaskHandler implements RejectedExecutionHandler 
{ 
    @Override
    public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) 
    { 
    	System.out.println("RejectedTaskHandler: The task %s has been rejected"+r.toString());
        //System.out.println("RejectedTaskHandler: The task %s has been rejected", r.toString()); 
    }
}