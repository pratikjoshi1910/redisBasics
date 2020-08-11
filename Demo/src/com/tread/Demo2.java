package com.tread;

public class Demo2 extends Thread{

	int count =1;
	Object object; 
	Thread thread;
	public Thread getThread() {
		return thread;
	}
	public void setThread(Thread thread) {
		this.thread = thread;
	}
	public Demo2(Object object)
	{
		this.object = object;
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
		System.out.println(Thread.currentThread().getName() + " "+ count);
		
		try {
			object.wait();
		} catch (InterruptedException e) {
			e.printStackTrace();
			break;
		}
		}
		}
	}
}
