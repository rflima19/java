package lima.com;

public class Carro {

	private boolean ligado;
	
	public Carro() {
		super();
		this.ligado = false;
	}
	
	public boolean isLigado() {
		return ligado;
	}
	
	public void ligarMotor() {
		Carro.Motor motor = this.new Motor();
		motor.ligar();
	}
	
	private class Motor {
		public void ligar() {
			Carro.this.ligado = true;
		}
	}
}
