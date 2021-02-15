package lima.com;

public class Cliente implements Runnable {

	private ContaBancaria conta;

	public Cliente(ContaBancaria conta) {
		super();
		this.conta = conta;
	}
	
	@Override
	public void run() {
		for (int i = 0; i < 5; i++) {
			this.conta.depositar(100);
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			this.conta.sacar(100);
		}	
	}
}
