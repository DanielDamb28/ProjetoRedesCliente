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
    String nomePersonagem;
    Integer idade;
    String sexo;
    String corDoCabelo;
    JButton button;
    ControllerCardPersonagem controller;
    Integer flag;

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
        
        ImageIcon iconX = new ImageIcon(".\\src\\img\\sair30.png");

        button = new JButton("", iconX);
        button.addActionListener(controller);
        add(button);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        button.setBounds(120, 230, 25, 25);

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
    
    public JButton getButton() {
    	return button;
    }
    
    public Integer getFlag() {
    	return flag;
    }
    
    public void setFlag(Integer flag) {
    	this.flag = flag;
    }
}
