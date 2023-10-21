package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.Socket;

import model.factorys.FactoryScreens;
import view.TelaDeEspera;

public class ControllerMain implements ActionListener{
	private Socket cliente;
	
	public ControllerMain(Socket cliente) {
    	this.cliente = cliente;
    }
	
	public void chamaTelaPrincipal() throws IOException {
        ControllerTelaPrincipal controller = new ControllerTelaPrincipal(cliente);
        FactoryScreens factory = new FactoryScreens();
        factory.chamaTelaPrincipal(controller);
	}
	
    public void mandaMensagem(String mensagem) throws IOException {
    	TelaDeEspera tela = null;
    	System.out.println(mensagem);
    	if(mensagem.equals("%esperandoJogador%")) {
    		ControllerTelaDeEspera controller = new ControllerTelaDeEspera();
    		FactoryScreens factory = new FactoryScreens();
    		tela = factory.chamaTelaDeEspera(controller);
    	}
    	if(mensagem.equals("%esperandoPronto%")) {
    		tela.mostrarButton();
    	}
    }
    
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
