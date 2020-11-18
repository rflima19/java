package com.lima.thread;

public class AplicacaoProdutorConsumidor {

	public static void main(String[] args) {
		Buffer buffer = new BufferFila();
		//Buffer buffer = new BufferFilaArray();
		
		ThreadGroup grupoProdutores = new ThreadGroup("Produtores");
		ThreadGroup grupoConsumidores = new ThreadGroup("Consumidores");
		Thread[] threadsProdutores = new Thread[10];
		Thread[] threadsConsumidores = new Thread[10];
		
		for (int i = 0; i < threadsProdutores.length; i++) {
			threadsProdutores[i] = new Thread(grupoProdutores, new Produtor(buffer), "Produtor0" + i);
			threadsProdutores[i].start();
		}
		
		for (int i = 0; i < threadsConsumidores.length; i++) {
			threadsConsumidores[i] = new Thread(grupoConsumidores, new Consumidor(buffer), "Consumidor0" + i);
			threadsConsumidores[i].start();
		}
	}
}
