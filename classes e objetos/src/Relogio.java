
public class Relogio {

	private Ponteiro ponteiroHora;
	private Ponteiro ponteiroMinuto;
	private Ponteiro ponteiroSegundo;
	
	public Relogio() {
		this(12, 12, 12);
	}
	
	public Relogio(int hora, int minuto, int segundo) {
		this.ponteiroHora = new PonteiroHora(hora);
		this.ponteiroMinuto = new PonteiroMinuto(minuto);
		this.ponteiroSegundo = new PonteiroSegundo(segundo);
	}
	
	public Relogio(PonteiroHora ponteiroHora, PonteiroMinuto ponteiroMinuto, PonteiroSegundo ponteiroSegundo) {
		this.ponteiroHora = ponteiroHora;
		this.ponteiroMinuto = ponteiroMinuto;
		this.ponteiroSegundo =ponteiroSegundo;
	}
	
	public Ponteiro getPonteiroHora() {
		return this.ponteiroHora;
	}
	
	public void setPonteiroHora(Ponteiro ponteiroHora) {
		this.ponteiroHora = ponteiroHora;
	}
	
	public Ponteiro getPonteiroMinuto() {
		return this.ponteiroMinuto;
	}
	
	public void setPonteiroMinuto(Ponteiro ponteiroMinuto) {
		this.ponteiroMinuto = ponteiroMinuto;
	}
	
	public Ponteiro getPonteiroSegundo() {
		return this.ponteiroSegundo;
	}
	
	public void setPonteiroSegundo(Ponteiro ponteiroSegundo) {
		this.ponteiroSegundo = ponteiroSegundo;
	}
	
	public void acertarRelogio(int hora, int minuto, int segundo) {
		this.ponteiroHora.setPosicao(hora);
		this.ponteiroMinuto.setPosicao(minuto);
		this.ponteiroSegundo.setPosicao(segundo);
	}
	
	public int lerHora() {
		return this.ponteiroHora.getPosicao();
	}
	
	public int lerMinuto() {
		return this.ponteiroMinuto.getPosicao();
	}
	
	public int lerSegundo() {
		return this.ponteiroSegundo.getPosicao();
	}
}
