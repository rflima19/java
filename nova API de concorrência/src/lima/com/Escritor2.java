package lima.com;

public class Escritor2 implements Runnable {
	private int qtd;
	private String texto;

	public Escritor2(int qtd, String texto) {
		super();
		this.qtd = qtd;
		this.texto = texto;
	}

	@Override
	public void run() {
		for (int i = 0; i < this.qtd; i++) {
			System.out.println(Thread.currentThread().getName() + ": " + this.texto);
		}
	}
}
