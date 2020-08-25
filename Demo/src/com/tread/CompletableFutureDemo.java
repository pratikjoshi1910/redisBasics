package com.tread;
import java.util.concurrent.CompletableFuture;

public class CompletableFutureDemo {
	
	public static void main (String [] args)
	{ 
		CompletableFuture<Void> cf = CompletableFuture.supplyAsync(
				()-> getData(10)
				
			)
			.thenAccept(data -> System.out.println(data));
		   
		   
	
		/*
		 * try { //Thread.sleep(1000); } catch (InterruptedException e) { // TODO
		 * Auto-generated catch block e.printStackTrace(); }
		 */
		System.out.println(cf.isDone());
			
		
	}

	private static Object sendData(Object data) {
		// TODO Auto-generated method stub
		System.out.println("hi");
		return null;
	}

	private static Object getData(int i) {
		// TODO Auto-generated method stub
		return 99;
	}

	private static CompletableFuture<String> runFuture() {
		CompletableFuture<String> future =
		        CompletableFuture.supplyAsync(() -> {
		        	System.out.println(Thread.currentThread().getName());
		        	return "Hello"; 
		        });
		return future;
	}

}
