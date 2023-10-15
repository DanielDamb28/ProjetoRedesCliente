package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

import controller.ControllerCardPersonagem;
import controller.ControllerTelaPrincipal;

public class TelaPrincipal extends JFrame {
    private JPanel gridPanel; // Panel for the GridLayout
    private JPanel otherPanel; // Panel for other components
    ControllerTelaPrincipal controller;

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
        
        gridPanel.setLayout(new GridLayout(2, 4));
        otherPanel.setLayout(new BorderLayout());
        
        add(gridPanel); 
        add(otherPanel, BorderLayout.SOUTH);
        
        setConfiguracoesDeTela();
        
        gridPanel.setPreferredSize(new Dimension(1280, 600));
        otherPanel.setPreferredSize(new Dimension(1280, 200));

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
    	gridPanel.add(card);
    }
}
