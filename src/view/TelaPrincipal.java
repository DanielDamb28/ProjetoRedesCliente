package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

import controller.ControllerCardPersonagem;
import controller.ControllerTelaPrincipal;
import javax.swing.JTextArea;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.DropMode;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class TelaPrincipal extends JFrame {
    private JPanel gridPanel; // Panel for the GridLayout
    ControllerTelaPrincipal controller;
    private JPanel panel;
    private JTextField textMsg;
    private JButton btnEnviar;
    
    
    public String getMensagem() {
		return textMsg.getText();
	}


	public void setMensagem(JTextField mensagem) {
		this.textMsg = mensagem;
	}


	public JButton getBotEnviar() {
		return btnEnviar;
	}


	public void setBotEnviar(JButton botEnviar) {
		this.btnEnviar = botEnviar;
	}


    public TelaPrincipal(ControllerTelaPrincipal ctrl) throws IOException{
    	setBackground(new Color(255, 255, 255));
        gridPanel = new JPanel();
        gridPanel.setBackground(new Color(255, 255, 255));
        gridPanel.setSize(800,600);
        
        controller = ctrl;
        BufferedImage image = null;
        try {
        	image = ImageIO.read(new File(".\\src\\img\\soluco.jpg"));
        }catch(IOException e){    	
        	System.out.println("não abriu imagem");
        }
        
        criaCardDoPersonagem(image, "Thomas", 21, "Masculino", "Preto");
        criaCardDoPersonagem(image, "Fernanda", 43, "Feminino", "Preto");
        criaCardDoPersonagem(image, "Bianca", 22, "Feminino", "Amarelo");
        criaCardDoPersonagem(image, "Robson", 57, "Masculino", "Preto");
        criaCardDoPersonagem(image, "Robson", 57, "Masculino", "Preto");
        criaCardDoPersonagem(image, "Robson", 57, "Masculino", "Preto");
        criaCardDoPersonagem(image, "Robson", 57, "Masculino", "Preto");
        criaCardDoPersonagem(image, "Robson", 34, "Masculino", "Preto");
        
        gridPanel.setLayout(new GridLayout(2, 4));
        
        getContentPane().add(gridPanel, BorderLayout.EAST);
        
        setConfiguracoesDeTela();
        
        gridPanel.setPreferredSize(new Dimension(1280, 600));
        
        panel = new JPanel();
        gridPanel.add(panel);
        panel.setBackground(new Color(128, 255, 255));
        
        textMsg = new JTextField();
        panel.add(textMsg);
        textMsg.setColumns(10);
        
        btnEnviar = new JButton("Enviar");
        btnEnviar.addActionListener(ctrl);
        panel.add(btnEnviar);

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void setConfiguracoesDeTela() {
    	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1183, 657);
        setTitle("Main Screen");

    }
    
    private void criaCardDoPersonagem(BufferedImage foto,String name, Integer idade, String Sexo, String corDoCabelo) {
    	ControllerCardPersonagem controllerCard = new ControllerCardPersonagem();
    	CardPersonagem card = new CardPersonagem(10, 10, foto, name, idade, Sexo, corDoCabelo, controllerCard);
    	controllerCard.setTela(card);
    	gridPanel.add(card);
    }
}
