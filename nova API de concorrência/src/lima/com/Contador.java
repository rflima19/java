package lima.com;

import java.util.concurrent.atomic.AtomicInteger;

public class Contador {

	private AtomicInteger valor;
	
	public Contador() {
		this.valor = new AtomicInteger(0);
	}
	
	public int incrementarMaisUm() {
		return this.valor.incrementAndGet();
	}
}
