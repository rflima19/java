package lima.com;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ListaProdutorConsumidor3<T> implements Buffer<T> {

	private BlockingQueue<T> lista;
	
	public ListaProdutorConsumidor3(int tamanho) {
		this.lista = new ArrayBlockingQueue<>(tamanho);
	}
	
	public void escrever(T obj) {
		try {
			this.lista.put(obj);
			this.imprimir();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public T ler() {
		T obj = null;
		try {
			obj = this.lista.take();
			this.imprimir();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return obj;
	}
	
	public void imprimir() {
		this.lista.stream().forEach(obj -> System.out.printf("%02d ", obj));
		System.out.printf("%n");
	}
}
