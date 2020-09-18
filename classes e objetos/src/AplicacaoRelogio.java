
public class AplicacaoRelogio {

	public static void main(String[] args) {
		
		PonteiroHora pHora = new PonteiroHora(5);
		PonteiroMinuto pMinuto = new PonteiroMinuto(30);
		PonteiroSegundo pSegundo = new PonteiroSegundo();
		pSegundo.setPosicao(45);
		
		Relogio r = new Relogio(pHora, pMinuto, pSegundo);
		
		System.out.printf("hora -> %02d:%02d:%02d\n", r.lerHora(), r.lerMinuto(), r.lerSegundo());
		
		r.acertarRelogio(8, 1, 12);
		
		System.out.println("Depois de acertar o relógio ...");

		System.out.printf("hora -> %02d:%02d:%02d\n", r.lerHora(), r.lerMinuto(), r.lerSegundo());
	}
}
