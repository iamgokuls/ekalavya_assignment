//  write a java program using the Runnable interface to create threads.
//Set a user defined name for the threads.

package com.assignment;

class T_one implements Runnable{
	
	@Override
	public void run(){
		
		for(int i=0;i<5;i++) {
			
			System.out.println("Inside"+Thread.currentThread(). getName());
		}
		
	}
}

class T_two implements Runnable{
	
	@Override
	public void run(){
		
		for(int i=0;i<5;i++) {
			
			System.out.println("Inside"+Thread.currentThread(). getName());
		}
		
	}
}

public class A7_Thrad_Demo {

	public static void main(String[] args) throws InterruptedException {
		
																		// Generate two tread classes
		Thread t1=new Thread(new T_one());
		Thread t2=new Thread(new T_two());
		
		t1.setName("Thread-One");										// Set custom names
		t2.setName("Thread-two");
		
		t1.start();														// Start threads
		t2.start();
		
		for(int i=0;i<5;i++) {
			
			System.out.println("Inside Main Thread");
		}
		
		t1.join();
		t2.join();
																	// Bye statement will be executed only after both threads are completed
		System.out.println("Bye");
		

	}

}
