package lima.com;

public class Sapo implements Runnable {

	private String nome;
	private Corrida corrida;
	private int distanciaPercorrida;

	public Sapo(String nome, Corrida corrida) {
		super();
		this.nome = nome;
		this.corrida = corrida;
		this.distanciaPercorrida = 0;
	}

	public String getNome() {
		return nome;
	}
	
	public void pular() {
		final int maxPulo = 50;
		int distanciaPulo = this.gerarNumeroIntervalo(0, maxPulo + 1);
		this.distanciaPercorrida += distanciaPulo;
		System.out.println(this.nome + " já percorreu " + this.distanciaPercorrida + " cm.");
	}

	public void descasar() {
		try {
			int tempoDescanso = this.gerarNumeroIntervalo(0, 10) * 100;
			System.out.println(this.nome + " está descansando.");
			Thread.sleep(tempoDescanso);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	private int gerarNumeroIntervalo(int inicio, int fim) {
		int intervalo = fim - inicio;
		int num = (int) (Math.random() * intervalo) + inicio;
		return num;
	}

	public void run() {
		while (true) {
			this.pular();

			if (this.distanciaPercorrida >= this.corrida.getDistancia()) {
				System.out.println(this.nome + " terminou a corrida.");
				this.corrida.terminarCorrida(this);
				break;
			}
			
			this.descasar();
		}
	}
}
