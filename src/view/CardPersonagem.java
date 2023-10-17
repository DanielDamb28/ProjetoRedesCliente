package view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

import controller.ControllerCardPersonagem;

public class CardPersonagem extends JPanel {
    Integer posX;
    Integer posY;
    BufferedImage foto;
    ImageIcon iconX;
    ImageIcon iconQuestion;
    String nomePersonagem;
    Integer idade;
    String sexo;
    String corDoCabelo;
    JButton buttonControle;
    JButton buttonAdvinhar;
    ControllerCardPersonagem controller;
    Integer flag;
    Integer flagAdv;
    
    public CardPersonagem(Integer posX, Integer posY, BufferedImage foto, String nomePersonagem, Integer idade, String sexo, String corDoCabelo, ControllerCardPersonagem controller) {
        this.posX = posX;
        this.posY = posY;
        this.foto = foto;
        this.nomePersonagem = nomePersonagem;
        this.idade = idade;
        this.sexo = sexo;
        this.corDoCabelo = corDoCabelo;
        this.controller = controller;
        flag = 1;
        
        iconX = new ImageIcon(".\\src\\img\\sair30.png");
        iconQuestion = new ImageIcon(".\\src\\img\\interrogacao30.png");

        buttonControle = new JButton("", iconX);
        buttonControle.addActionListener(controller);
        buttonAdvinhar = new JButton("", iconQuestion);
        buttonAdvinhar.addActionListener(controller);
        add(buttonControle);
        add(buttonAdvinhar);
        buttonAdvinhar.setVisible(false);
        flagAdv = 0;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        buttonControle.setBounds(120, 230, 25, 25);
        buttonAdvinhar.setBounds(90, 230, 25, 25);

        int larguraCard = 140; 
        int alturaCard = 250;

        int larguraFoto = larguraCard - 10;
        int alturaFoto = (int) (0.6 * alturaCard);

        int larguraCampoDeTexto = larguraCard;
        int alturaCampoDeTexto = alturaCard - alturaFoto;
        int posYCampoDeTexto = posY + alturaFoto;
        
        Graphics2D g2d = (Graphics2D) g;
        g2d.drawImage(foto, posX + 5, posY + 5, larguraFoto, alturaFoto, null);
        
        g.setColor(new Color(170, 170, 170));
        g.fillRect(posX, posYCampoDeTexto, larguraCampoDeTexto, alturaCampoDeTexto);

        g.setColor(Color.black);
        String text = "Nome: " + nomePersonagem;
        int textX = posX + 2;
        int textY = posYCampoDeTexto + 15;
        g.drawString(text, textX, textY);
        text = "Idade: " + idade;
        textY = textY + 15;
        g.drawString(text, textX, textY);
        text = "Sexo: " + sexo;
        textY = textY + 15;
        g.drawString(text, textX, textY);
        text = "Cor do Cabelo: " + corDoCabelo;
        textY = textY + 15;
        g.drawString(text, textX, textY);
    }
    
    public void setImage(BufferedImage newImage) {
        this.foto = newImage;
        repaint(); // Repaint the panel to reflect the change
    }
    
    public void setButtonIcon(ImageIcon icon) {
    	this.buttonControle.setIcon(icon);
    	repaint();
    }
    
    public JButton getButton() {
    	return buttonControle;
    }
    
    public Integer getFlag() {
    	return flag;
    }
    
    public void setFlag(Integer flag) {
    	this.flag = flag;
    }
    
    public void addButtonAdvinhar() {
    	if(flagAdv == 0) {
    		buttonAdvinhar.setVisible(true);
    		setFlagAdv(1);
    	}
    	else if (flagAdv == 1) {
    		buttonAdvinhar.setVisible(false);
    		setFlagAdv(0);
    	}
    }
    
    public Integer getFlagAdv() {
    	return flagAdv;
    }
    
    public void setFlagAdv(Integer flagAdv) {
    	this.flagAdv = flagAdv;
    }
    
    public ControllerCardPersonagem getController() {
    	return controller;
    }
}