package com.lima.listacompras;

import java.util.Comparator;

public class OrdenacaoDataCompra implements Comparator<Compra> {

	@Override
	public int compare(Compra o1, Compra o2) {
		if (o1.getData().isBefore(o2.getData())) {
			return -1;
		} else if (o1.getData().isAfter(o2.getData())) {
			return 1;
		}
		return 0;
	}
}
