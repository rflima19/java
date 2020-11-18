package com.lima.thread;

public class Semaforo {

	private int count = 0;
    
    public Semaforo(int valorIni){
        count = valorIni;
    }
    
    public synchronized void P(){//opera��o down
        while(count <= 0){//espera para poder entrar na zona cr�tica
            try {
                wait();
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
        count--;//processo pode entrar na zona cr�tica
    }
    
    public synchronized void V(){//opera��o up
        count++;
        notify();//acorda o processo
    }
}
