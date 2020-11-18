package com.lima.thread;

public class MesaJantar {

	public static final int QUANTIDADE_FILOSOFOS = 5;
	private boolean[] garfos;
	private Filosofo[] filosofos;
	
	public MesaJantar() {
		super();
		this.filosofos = new Filosofo[MesaJantar.QUANTIDADE_FILOSOFOS];
		this.garfos = new boolean[MesaJantar.QUANTIDADE_FILOSOFOS];
		for (int i = 0; i < filosofos.length; i++) {
			this.filosofos[i] = new Filosofo(this, "Filósofo" + i, i);
		}
		for (int i = 0; i < garfos.length ; i++) {
			this.garfos[i] = true;
		}
	}
	
	public void iniciarJantar() {
		for (int i = 0; i < this.filosofos.length; i++) {
			this.filosofos[i].start();
		}
	}
	
	private int getIndexGarfoDireita(int indexFilosofo) {
		return indexFilosofo;
	}
	
	private int getIndexGarfoEsquerda(int indexFilosofo) {
		return (indexFilosofo == (MesaJantar.QUANTIDADE_FILOSOFOS - 1)) ? 0 : (indexFilosofo + 1);
	}
	
	private int getIndexFilosofoDireita(int indexFilosofo) {
		return (indexFilosofo == 0) ? (MesaJantar.QUANTIDADE_FILOSOFOS - 1) : (indexFilosofo - 1);
	}
	
	private int getIndexFilosofoEsquerda(int indexFilosofo) {
		return (indexFilosofo == (MesaJantar.QUANTIDADE_FILOSOFOS - 1)) ? 0 : indexFilosofo + 1;
	}
	
	public synchronized void pegarGarfos(Filosofo filosofo) {
		int indexFilosofo = filosofo.getNumero();
		int indexGarfoDireita = this.getIndexGarfoDireita(indexFilosofo);
		int indexGarfoEsquerda = this.getIndexGarfoEsquerda(indexFilosofo);
		
		while ((this.garfos[indexGarfoDireita] == false) ||
				(this.garfos[indexGarfoEsquerda] == false)) {
			try {
				filosofo.setTentativasComer(filosofo.getTentativasComer() + 1);
				filosofo.setSituacao(SituacaoFilosofo.COM_FOME);
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		this.garfos[indexGarfoDireita] = false;
		this.garfos[indexGarfoEsquerda] = false;
		
		filosofo.setSituacao(SituacaoFilosofo.COMENDO);
		
		filosofo.setTentativasComer(0);
		
		this.imprimirSituacaoFilosofos();
		this.imprimirSituacaoGarfos();
		this.imprimirTentativasComer();
		
	}

	public synchronized void devolverGarfos(Filosofo filosofo) {
		int indexFilosofo = filosofo.getNumero();
		
		int indexGarfoDireita = this.getIndexGarfoDireita(indexFilosofo);
		int indexGarfoEsquerda = this.getIndexGarfoEsquerda(indexFilosofo);
		
		this.garfos[indexGarfoDireita] = true;
		this.garfos[indexGarfoEsquerda] = true;
		
		filosofo.setSituacao(SituacaoFilosofo.PENSANDO);
		
		int indexFilosofoDireita = this.getIndexFilosofoDireita(indexFilosofo);
		int indexFilosofoEsquerda = this.getIndexFilosofoEsquerda(indexFilosofo);
		
		if ((this.filosofos[indexFilosofoDireita].getSituacao() == SituacaoFilosofo.COM_FOME) ||
				(this.filosofos[indexFilosofoEsquerda].getSituacao() == SituacaoFilosofo.COM_FOME)) {
			this.notifyAll();
		}
		
		this.imprimirSituacaoFilosofos();
		this.imprimirSituacaoGarfos();
		this.imprimirTentativasComer();
	}
	
	private void imprimirSituacaoFilosofos() {
		System.out.printf("%-15s", "Filósofos = ");
		System.out.printf("%s", "[ ");
		for (int i = 0; i < this.filosofos.length; i++) {
			System.out.printf("%-8s ", this.filosofos[i].getSituacao().toString());
		}
		System.out.printf("%s%n", "]");
	}

	private void imprimirSituacaoGarfos() {
		System.out.printf("%-15s", "Garfos = ");
		System.out.printf("%s", "[ ");
		for (int i = 0; i < this.garfos.length; i++) {
			if (this.garfos[i] == false) {
				System.out.printf("%-8s ", "OCUPADO");
			} else {
				System.out.printf("%-8s ", "LIVRE");
			}
		}
		System.out.printf("%s%n", "]");
	}

	private void imprimirTentativasComer() {
		System.out.printf("%-15s", "Tentou comer = ");
		System.out.printf("%s", "[ ");
		for (int i = 0; i < this.filosofos.length; i++) {
			System.out.printf("%-8d ", this.filosofos[i].getTentativasComer());
		}
		System.out.printf("%s%n", "]");
	}
}
