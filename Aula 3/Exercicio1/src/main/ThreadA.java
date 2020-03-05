package main;

public class ThreadA {
 
	public static void main(String[] args) throws InterruptedException{
		Runnable runnableQ = new ThreadQ();
		Runnable runnableC = new ThreadC();
		
		Thread threadQ = new Thread(runnableQ);
		Thread threadC = new Thread(runnableC);
		
		threadQ.start();
		threadC.start();
	}
}
 
