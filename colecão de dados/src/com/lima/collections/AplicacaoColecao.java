package com.lima.collections;

public class AplicacaoColecao {

	public static void main(String[] args) {
		Produto p1 = new Produto("Laranja", 2.50);
		Produto p2 = new Produto("Laranja", 2.70);
		Produto p3 = new Produto("Ma��", 1.45);
		Produto p4 = new Produto("Mam�o", 4.95);
		Produto p5 = new Produto("Lim�o", 2.30);
		
		System.out.printf("OPERA��ES COM A PILHA%n");
		
		Pilha p = new Pilha();
//		Pilha p = new Pilha(2);
//		Pilha p = new Pilha(new Object[]{new Object(), new Object()});
		p.inserirItem(p1);
		p.inserirItem(p2);
		p.inserirItem(p3);
		p.inserirItem(p4);
		p.inserirItem(p5);
		p.inserirItem(p1);
		p.inserirItem(p2);
		p.inserirItem(p3);
		p.inserirItem(p4);
		p.inserirItem(p5);
		p.inserirItem(p1);
		p.inserirItem(p2);
		p.inserirItem(p3);
		p.inserirItem(p4);
		p.inserirItem(p5);
		p.inserirItem(p1);
		p.inserirItem(p2);
		p.inserirItem(p3);
		p.inserirItem(p4);
		p.inserirItem(p5);
		
		System.out.println(p);
		
		for (int i = 0; i < 20; i++) {
			p.removerItem();
			System.out.println(p);
		}
		
		System.out.printf("%n%nOPERA��ES COM A FILA%n");
		
		Fila f = new Fila();
//		Fila f = new Fila(2);
//		Fila f = new Fila(new Object[]{new Object(), new Object()});
		f.inserirItem(p1);
		f.inserirItem(p2);
		f.inserirItem(p3);
		f.inserirItem(p4);
		f.inserirItem(p5);
		f.inserirItem(p1);
		f.inserirItem(p2);
		f.inserirItem(p3);
		f.inserirItem(p4);
		f.inserirItem(p5);
		f.inserirItem(p1);
		f.inserirItem(p2);
		f.inserirItem(p3);
		f.inserirItem(p4);
		f.inserirItem(p5);
		f.inserirItem(p1);
		f.inserirItem(p2);
		f.inserirItem(p3);
		f.inserirItem(p4);
		f.inserirItem(p5);
		
		System.out.println(f);
		
		for (int i = 0; i < 20; i++) {
			f.removerItem();
			System.out.println(f);
		}
	}
}
