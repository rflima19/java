package com.lima.thread;

public class Semaforo {

	private int count = 0;
    
    public Semaforo(int valorIni){
        count = valorIni;
    }
    
    public synchronized void P(){//operação down
        while(count <= 0){//espera para poder entrar na zona crítica
            try {
                wait();
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
        count--;//processo pode entrar na zona crítica
    }
    
    public synchronized void V(){//operação up
        count++;
        notify();//acorda o processo
    }
}
