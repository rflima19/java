
public class Automovel extends Veiculo {

	public Automovel(boolean ligado) {
		super(ligado);
	}

	@Override
	public void ligar() {
		super.ligar();
		System.out.println("Automóvel ligado");
	}

	@Override
	public void desligar() {
		super.desligar();
		System.out.println("Automóvel desligado");
	}
}
