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
import model.Personagem;

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
        BufferedImage imageSoluco = null;
        BufferedImage imageAstrid = null;
        BufferedImage imageMelequento = null;
        try {
        	 imageSoluco = ImageIO.read(new File(".\\src\\img\\soluco.jpg"));
             imageAstrid = ImageIO.read(new File(".\\src\\img\\astrid1.jpg"));
             imageMelequento = ImageIO.read(new File(".\\src\\img\\melequento.jpg"));
        }catch(Exception e) {
        	System.out.println("Erro ao abrir imagens");
        }
       
        

        Personagem teste = new Personagem("Robson", 43, "Masculino", 1.70);
        criaCardDoPersonagem(imageSoluco, teste);
        criaCardDoPersonagem(imageAstrid, teste);
        criaCardDoPersonagem(imageMelequento, teste);
        criaCardDoPersonagem(imageSoluco, teste);
        criaCardDoPersonagem(imageSoluco, teste);
        criaCardDoPersonagem(imageSoluco, teste);
        criaCardDoPersonagem(imageSoluco, teste);
        criaCardDoPersonagem(imageSoluco, teste);
        criaCardDoPersonagem(imageSoluco, teste);
        criaCardDoPersonagem(imageSoluco, teste);
        criaCardDoPersonagem(imageSoluco, teste);
        criaCardDoPersonagem(imageSoluco, teste);
        criaCardDoPersonagem(imageSoluco, teste);
        criaCardDoPersonagem(imageSoluco, teste);
        criaCardDoPersonagem(imageSoluco, teste);
        criaCardDoPersonagem(imageSoluco, teste);
        
        
        gridPanel.setLayout(new GridLayout(2, 8));
        otherPanel.setLayout(null);
        
        add(gridPanel, BorderLayout.PAGE_START); 
        add(otherPanel, BorderLayout.SOUTH);
        
        setConfiguracoesDeTela();
        
        gridPanel.setPreferredSize(new Dimension(1280, 650));
        otherPanel.setPreferredSize(new Dimension(1280, 150));
        
        lPerguntaAnterior = setLabel("Pergunta Anterior:", 20, 50, 160, 30);
        lPerguntaAnterior.setFont(new Font("Serif", Font.PLAIN, 20));
        
        lRespostaAnterior = setLabel("Resposta Anterior:", 20, 100, 160, 30);
        lRespostaAnterior.setFont(new Font("Serif", Font.PLAIN, 20));
        
        
        buttonAdvinhar = new JButton("Advinhar");
        buttonAdvinhar.setBounds(700, 50, 100, 30);
        buttonAdvinhar.addActionListener(controller);
        otherPanel.add(buttonAdvinhar);
        
        lPergunta = setLabel("Fazer Pergunta:", 700, 100, 160, 30);
        lPergunta.setFont(new Font("Serif", Font.PLAIN, 20));
        tPergunta = setTextField(830, 105, 300, 25);
        
        buttonEnviar = new JButton("ENVIAR");
        buttonEnviar.setBounds(1150, 105, 100, 30);
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

    private void criaCardDoPersonagem(BufferedImage foto,Personagem personagem) {
    	ControllerCardPersonagem controllerCard = new ControllerCardPersonagem();
    	CardPersonagem card = new CardPersonagem(foto, personagem, controllerCard);
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
