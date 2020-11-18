package com.lima.thread;

public class AplicacaoContador {

	public static void main(String[] args) {
		
		Contador c = new Contador();
		ThreadGroup grupo = new ThreadGroup("contadores");
		
		Thread t1 = new Thread(grupo, c);
		t1.start();
		
		Thread t2 = new Thread(grupo, c, "Thread cont 2");
		t2.start();
		
		for (int i = 0; i < 10; i++) {
			//System.out.println(i);
			System.out.println(Thread.currentThread().getName() + " => " + i);
		}
	}
}
