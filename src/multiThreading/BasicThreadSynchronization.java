package multiThreading;

import java.util.Scanner;

class Processor extends Thread {
	private volatile boolean running = true;
	public void run() {
		while (running) {
			System.out.println("Hello!!!");
		}
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			
		}
	}
	
	public void stopThread() {
		running = false;
	}
}
public class BasicThreadSynchronization {
	
	
	public static void main(String args[]) {
		Processor p = new Processor();
		p.start();
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Press anything to stop");
		sc.nextLine();
		
		p.stopThread();
	}
}
