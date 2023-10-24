package controller;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.net.Socket;

import model.ClienteRecebe;
import view.CardPersonagem;
import view.TelaPrincipal;

public class ControllerTelaPrincipal implements ActionListener {
    private TelaPrincipal tela;
    private Socket cliente;
    private ControllerMain controlMain;
    
    public ControllerTelaPrincipal(Socket cliente) {
    	this.cliente = cliente;
    }
    
    public TelaPrincipal getTela(){
        return tela;
    }

    public void setTela(TelaPrincipal tela){
        this.tela = tela;
    }
    
    
    public ControllerMain getControlMain() {
		return controlMain;
	}

	public void setControlMain(ControllerMain controlMain) {
		this.controlMain = controlMain;
	}
	
	public void mudaButtonsAdvinhar() {
		for(CardPersonagem card: tela.getCards()) {
			card.addButtonAdvinhar();
		}
	}

	@Override
    public void actionPerformed(ActionEvent e){
    	PrintWriter out = null;
        OutputStream outputStream;
		try {
			outputStream = cliente.getOutputStream();
			out = new PrintWriter(outputStream, true);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		Thread receiveThread = new Thread(new ClienteRecebe(cliente, tela));
        receiveThread.start();

    	if(e.getSource()== tela.getButtonEnviar()  && !tela.getTPergunta().getText().isEmpty()) {
    		
    		if(controlMain.getSuaJogada() == true) {
    			PrintStream saida;
    			try {
    				saida = new PrintStream(cliente.getOutputStream());
    				String msg = "%jogada%%pergunta%";
    				msg = msg + tela.getTPergunta().getText();
    				msg = msg + "%/pergunta%%/jogada%";
    				saida.println(msg);
    			} catch (IOException e1) {
    				System.out.println("Problema na criacao de conexao com o servidor e enviar msg");
    			}
    		}
			
		}
    	if(e.getSource() == tela.getButtonAdvinhar()) {
    		if(controlMain.getSuaJogada() == true) {
    			mudaButtonsAdvinhar();
    		}
    	}
    }
}
