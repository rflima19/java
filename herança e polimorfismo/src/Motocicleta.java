
public class Motocicleta extends Veiculo {

	public Motocicleta(boolean ligado) {
		super(ligado);
	}

	@Override
	public void ligar() {
		super.ligar();
		System.out.println("Motocicleta ligada");
	}

	@Override
	public void desligar() {
		super.desligar();
		System.out.println("Motocicleta desligada");
	}
}
