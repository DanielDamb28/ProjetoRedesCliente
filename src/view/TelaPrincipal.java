package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controller.ControllerCardPersonagem;
import controller.ControllerTelaPrincipal;

public class TelaPrincipal extends JFrame {
    private JPanel gridPanel; // Panel for the GridLayout
    private JPanel otherPanel; // Panel for other components
    
    private JLabel lPerguntaAnterior;
    private JLabel lRespostaAnterior;
    private JLabel lPergunta;
    private JTextField tPergunta;
    private JButton buttonAdvinhar;
    private JButton buttonEnviar;
    ControllerTelaPrincipal controller;
    
    List<CardPersonagem> cards = new ArrayList<CardPersonagem>();

    public TelaPrincipal(ControllerTelaPrincipal ctrl) throws IOException{
        gridPanel = new JPanel();
        gridPanel.setSize(800,600);
        otherPanel = new JPanel();
        
        controller = ctrl;
        BufferedImage image = null;
        image = ImageIO.read(new File(".\\src\\img\\soluco.jpg"));
        
        criaCardDoPersonagem(image, "Thomas", 21, "Masculino", "Preto");
        criaCardDoPersonagem(image, "Fernanda", 43, "Feminino", "Preto");
        criaCardDoPersonagem(image, "Bianca", 22, "Feminino", "Amarelo");
        criaCardDoPersonagem(image, "Robson", 57, "Masculino", "Preto");
        criaCardDoPersonagem(image, "Robson", 57, "Masculino", "Preto");
        criaCardDoPersonagem(image, "Robson", 57, "Masculino", "Preto");
        criaCardDoPersonagem(image, "Robson", 57, "Masculino", "Preto");
        criaCardDoPersonagem(image, "Robson", 34, "Masculino", "Preto");
        criaCardDoPersonagem(image, "Thomas", 21, "Masculino", "Preto");
        criaCardDoPersonagem(image, "Fernanda", 43, "Feminino", "Preto");
        criaCardDoPersonagem(image, "Bianca", 22, "Feminino", "Amarelo");
        criaCardDoPersonagem(image, "Robson", 57, "Masculino", "Preto");
        criaCardDoPersonagem(image, "Robson", 57, "Masculino", "Preto");
        criaCardDoPersonagem(image, "Robson", 57, "Masculino", "Preto");
        criaCardDoPersonagem(image, "Robson", 57, "Masculino", "Preto");
        criaCardDoPersonagem(image, "Robson", 34, "Masculino", "Preto");
        
        
        gridPanel.setLayout(new GridLayout(2, 8));
        otherPanel.setLayout(null);
        
        add(gridPanel, BorderLayout.PAGE_START); 
        add(otherPanel, BorderLayout.SOUTH);
        
        setConfiguracoesDeTela();
        
        gridPanel.setPreferredSize(new Dimension(1280, 600));
        otherPanel.setPreferredSize(new Dimension(1280, 200));
        
        lPerguntaAnterior = setLabel("Pergunta Anterior:", 20, 100, 160, 30);
        lPerguntaAnterior.setFont(new Font("Serif", Font.PLAIN, 20));
        
        lRespostaAnterior = setLabel("Resposta Anterior:", 20, 150, 160, 30);
        lRespostaAnterior.setFont(new Font("Serif", Font.PLAIN, 20));
        
        
        buttonAdvinhar = new JButton("Advinhar");
        buttonAdvinhar.setBounds(700, 100, 100, 30);
        buttonAdvinhar.addActionListener(controller);
        otherPanel.add(buttonAdvinhar);
        
        lPergunta = setLabel("Fazer Pergunta:", 700, 150, 160, 30);
        lPergunta.setFont(new Font("Serif", Font.PLAIN, 20));
        tPergunta = setTextField(830, 155, 300, 25);
        
        buttonEnviar = new JButton("ENVIAR");
        buttonEnviar.setBounds(1150, 155, 100, 30);
        buttonEnviar.addActionListener(controller);
        otherPanel.add(buttonEnviar);
        
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void setConfiguracoesDeTela() {
    	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1280, 720);
        setTitle("Main Screen");

    }

    private void criaCardDoPersonagem(BufferedImage foto,String name, Integer idade, String Sexo, String corDoCabelo) {
    	ControllerCardPersonagem controllerCard = new ControllerCardPersonagem();
    	CardPersonagem card = new CardPersonagem(10, 10, foto, name, idade, Sexo, corDoCabelo, controllerCard);
    	controllerCard.setTela(card);
    	cards.add(card);
    	gridPanel.add(card);
    }
    private JLabel setLabel(String mensagem, int xLabel, int yLabel, int width, int height) {
    	JLabel lbl = new JLabel();
    	lbl = new JLabel(mensagem);
    	lbl.setBounds(xLabel,yLabel,width,height);
    	lbl.setFont(new Font("Serif", Font.PLAIN, 20));
    	otherPanel.add(lbl);
    	return lbl;
    }
    
    private JTextField setTextField(int xText, int yText, int width, int height) {
    	JTextField txt = new JTextField();
    	txt = new JTextField();
    	txt.setBounds(xText,yText,width,height);
    	txt.setFont(new Font("Serif", Font.PLAIN, 15));
    	otherPanel.add(txt);
    	return txt;
    }
    
    public List<CardPersonagem> getCards(){
    	return cards;
    }
    
    public JButton getButtonAdvinhar() {
    	return buttonAdvinhar;
    }
    
    public JButton getButtonEnviar() {
    	return buttonEnviar;
    }
    
    public JTextField getTPergunta() {
    	return tPergunta;
    }
}
