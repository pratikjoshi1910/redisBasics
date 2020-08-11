package com.tread;

public class ThreadMain {

	public static void main(String[] args) {
		Object object = new Object();
		Demo1 demo = new Demo1(object);      
		Demo2 demo2 = new Demo2(object);  
		demo.setThread(demo2);
		demo2.setThread(demo);

		demo.start();
		demo2.start();
	}

}
