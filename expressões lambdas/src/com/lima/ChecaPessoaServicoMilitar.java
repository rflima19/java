package com.lima;

import com.lima.Pessoa.Sexo;

public class ChecaPessoaServicoMilitar implements ChecaPessoa {

	@Override
	public boolean test(Pessoa pessoa) {
		return (pessoa.getGenero() == Pessoa.Sexo.MASCULINMO) && 
				((pessoa.getIdade() >= 18) && (pessoa.getIdade() <= 25)) ;
	}
}
