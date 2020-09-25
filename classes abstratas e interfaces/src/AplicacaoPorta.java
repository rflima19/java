
public class AplicacaoPorta {

	public static void main(String[] args) {
		Porta p = new Porta(12.0, 3.0, false);

		p.abrir();
		p.fechar();
		p.abrir();

		try {
			Porta p2 = (Porta) p.clone();

			System.out.println(p);
			System.out.println(p2);
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}

	}
}
