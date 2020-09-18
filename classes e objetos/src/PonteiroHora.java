
public class PonteiroHora extends Ponteiro {

	public PonteiroHora() {
		this(12);
	}
	
	public PonteiroHora(int posicao) {
		this.setPosicao(posicao);
	}
	
	@Override
	public void setPosicao(int posicao) {
		if (posicao < 1 || posicao > 12) {
			// this.posicao = 12;
			super.setPosicao(12);
		} else {
			this.posicao = posicao;
		}
	}
}
