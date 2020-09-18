
public class PonteiroMinuto extends Ponteiro {

	public PonteiroMinuto() {
		this(0);
	}
	
	public PonteiroMinuto(int posicao) {
		this.setPosicao(posicao);
	}
	
	@Override
	public void setPosicao(int posicao) {
		if (posicao < 0 || posicao > 60) {
			// this.posicao = 0;
			super.setPosicao(0);
		} else {
			this.posicao = posicao;
		}
	}
}
