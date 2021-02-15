package lima.com;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class AppContaBancaria {

	public static void main(String[] args) {
		
		ExecutorService e = Executors.newFixedThreadPool(2);
		
		ContaBancaria conta = new ContaBancaria(0.0);
		
		Cliente cliente = null;
		
		for (int i = 0; i < 2; i++) {
			cliente = new Cliente(conta);
			e.execute(cliente);
		}
		
		e.shutdown();
		
		while (e.isTerminated() == false) {
			try {
				Thread.sleep(200);
			} catch (InterruptedException ex) {
				ex.printStackTrace();
			}
		}
		
		System.out.println("Saldo final da conta: " + conta.getSaldo());
	}
}
