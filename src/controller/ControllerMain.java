package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.Socket;

import model.factorys.FactoryScreens;
import view.TelaDeEspera;

public class ControllerMain implements ActionListener{
	private Socket cliente;
	private TelaDeEspera telaEspera;
	
	public ControllerMain(Socket cliente) {
    	this.cliente = cliente;
    }
	
    public void mandaMensagem(String mensagem) throws IOException {
    	System.out.println(mensagem);
    	if(mensagem.equals("%esperandoJogador%")) {
    		setTelaEspera();
    	}
    	if(mensagem.equals("%esperandoPronto%")) {
    		telaEspera.mostrarButton();
    	}
    	if(mensagem.equals("%iniciarJogo%")) {
    		telaEspera.dispose();
    		setTelaPrincipal();
    	}
    }
    
    public void setTelaEspera() throws IOException {
    	ControllerTelaDeEspera controller = new ControllerTelaDeEspera(cliente);
		FactoryScreens factory = new FactoryScreens();
		this.telaEspera = factory.chamaTelaDeEspera(controller);
    }
    
    public void setTelaPrincipal() throws IOException {
    	ControllerTelaPrincipal controller = new ControllerTelaPrincipal(cliente);
        FactoryScreens factory = new FactoryScreens();
        factory.chamaTelaPrincipal(controller);
    }
    
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
