
public class Lampada {

	private boolean ligada;

	public Lampada(boolean ligada) {
		super();
		this.ligada = ligada;
	}
	
	public void ligar() {
		this.ligada = true;
	}
	
	public void desligar() {
		this.ligada = false;	
	}
	
	public void imprimir() {
		String resultado = this.ligada ? "L�mpada ligada" : "L�mpada desligada";
		System.out.println(resultado);
	}
}
