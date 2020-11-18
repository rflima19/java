package com.lima.thread;

public class Contador implements Runnable {

	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			//System.out.println("Thread => " + i);
			System.out.println(Thread.currentThread().getThreadGroup().getName() + " - " +
					Thread.currentThread().getName() + " => " + i);
		}	
	}
}
