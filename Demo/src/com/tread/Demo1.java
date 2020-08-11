package com.tread;

public class Demo1 extends Thread{

	int count =0;
	Thread thread;
	Object object; 
	public Demo1(Object object)
	{
		this.object = object;
	}
	public Thread getThread() {
		return thread;
	}
	public void setThread(Thread thread) {
		this.thread = thread;
	}
	@Override
	public  void run ()
	{
		synchronized(object)
		{
		while(true)
		{
		object.notify();
		count = count +2;
		if (count > 1000)
		{
			thread.interrupt();
			break;
		}
		System.out.println(Thread.currentThread().getName()+  " "+ count);
		
		try {
			object.wait();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		}
		}
	}
}
