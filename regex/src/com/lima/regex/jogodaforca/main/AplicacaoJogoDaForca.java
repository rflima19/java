package com.lima.regex.jogodaforca.main;

import com.lima.regex.jogodaforca.controller.Controller;
import com.lima.regex.jogodaforca.controller.ControllerConsole;

public class AplicacaoJogoDaForca {
	
	private Controller controller;

	public AplicacaoJogoDaForca(Controller controller) {
		super();
		this.controller = controller;
	}

	public static void main(String[] args) {		
		AplicacaoJogoDaForca app = new AplicacaoJogoDaForca(new ControllerConsole());
		app.controller.iniciarJogo();
	}
}
