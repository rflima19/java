package lima.com;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Corrida {

	private List<Sapo> sapos;
	private int distancia;
	private Lock lock;

	public Corrida(int distancia) {
		super();
		this.sapos = new ArrayList<Sapo>();
		this.distancia = distancia;
		this.lock = new ReentrantLock(true);
	}

	public int getDistancia() {
		return distancia;
	}
	
	public void terminarCorrida(Sapo sapo) {
		this.lock.lock();
		try {
			this.sapos.add(sapo);
		} finally {
			this.lock.unlock();
		}
	}
	
	public void exibirResultado() {
		int aux = 1;
		for (Sapo sapo : sapos) {
			System.out.println(aux + "° colocado = " + sapo.getNome());
			++aux;
		}
	}

}
