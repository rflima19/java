
public class Veiculo {

	private boolean ligado;

	public Veiculo(boolean ligado) {
		super();
		this.ligado = ligado;
	}

	public void ligar() {
		this.ligado = true;
	}
	
	public void desligar() {
		this.ligado = false;
	}
	
	public boolean isLigado() {
		return this.ligado;
	}
}
