package main;
import model.Cliente;
import model.Recebedor;
import model.factorys.FactoryScreens;


import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;


import controller.ControllerTelaPrincipal;


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