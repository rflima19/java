
public class AplicacaoVeiculo {

	public static void main(String[] args) {
			Veiculo a = new Automovel(true);
			Veiculo m = new Motocicleta(true);
			Veiculo o = new Onibus(true);
			
			a.ligar();
			System.out.println(a.isLigado());
			a.desligar();
			System.out.println(a.isLigado());
			
			m.ligar();
			System.out.println(m.isLigado());
			m.desligar();
			System.out.println(m.isLigado());
			
			o.ligar();
			System.out.println(o.isLigado());
			o.desligar();
			System.out.println(o.isLigado());
	}
}
