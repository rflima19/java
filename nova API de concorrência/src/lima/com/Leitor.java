package lima.com;

public class Leitor implements Runnable {

	private Info info;
	private String nome;

	public Leitor(Info info, String nome) {
		super();
		this.info = info;
		this.nome = nome;
	}

	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			String texto = this.info.getInfo();
			System.out.println(this.nome + " leu : " + texto);
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
