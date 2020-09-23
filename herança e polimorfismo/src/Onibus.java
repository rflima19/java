
public class Onibus extends Veiculo {

	public Onibus(boolean ligado) {
		super(ligado);
	}

	@Override
	public void ligar() {
		super.ligar();
		System.out.println("Ônibus ligado");
	}
	
	@Override
	public void desligar() {
		super.desligar();
		System.out.println("Ônibus desligado");
	}
}
