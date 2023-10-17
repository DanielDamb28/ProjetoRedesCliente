package controller;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;

import view.CardPersonagem;
import view.TelaPrincipal;

public class ControllerTelaPrincipal implements ActionListener {
    private TelaPrincipal tela;
    private Socket cliente;
    
    public ControllerTelaPrincipal(Socket cliente) {
    	this.cliente = cliente;
    }
    public ControllerTelaPrincipal() {
    	
    }
    
    public TelaPrincipal getTela(){
        return tela;
    }

    public void setTela(TelaPrincipal tela){
        this.tela = tela;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    	if(e.getSource()== tela.getButtonEnviar()  && !tela.getTPergunta().getText().isEmpty()) {
			//Declarando e criando um fluxo de dados
    		System.out.println("cliquei em enviar");
			PrintStream saida;
			try {
				saida = new PrintStream(cliente.getOutputStream());
				String msg = tela.getTPergunta().getText();
				saida.println(msg);
			    
				//mandei a mensagem para o seridor
			} catch (IOException e1) {
				System.out.println("Problema na criacao de conexao com o servidor e enviar msg");
			}
			
		}
    	if(e.getSource() == tela.getButtonAdvinhar()) {
    		for(CardPersonagem card: tela.getCards()) {
    			System.out.println("a");
    			card.addButtonAdvinhar();
    		}
    	}
    }
}
