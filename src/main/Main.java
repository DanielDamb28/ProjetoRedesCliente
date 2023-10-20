package main;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

import controller.ControllerTelaPrincipal;
import model.Cliente;
import model.ClienteRecebe;
import model.factorys.FactoryScreens;


public class Main {
    public static void main(String[] args) throws UnknownHostException, IOException {
       
    
    	try {
    		Cliente cl = new Cliente("127.0.0.1",12345);
        	Socket cliente = new Socket(cl.getHost(), cl.getPorta());
            System.out.println("O cliente se conectou ao servidor!");
            
            ControllerTelaPrincipal controller = new ControllerTelaPrincipal(cliente);
            FactoryScreens factory = new FactoryScreens();
            factory.chamaTelaPrincipal(controller);
            
            
    	}catch(Exception e) {
    		System.out.println("Problema na criacao de conexao com o servidor");
    	}
    	
           
	
    }
}