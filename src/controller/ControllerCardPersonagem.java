package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

import view.CardPersonagem;

public class ControllerCardPersonagem implements ActionListener{
	CardPersonagem view;
	BufferedImage image;
	BufferedImage imageX;
	ImageIcon tirar;
	ImageIcon voltar;

    public CardPersonagem getTela(){
        return view;
    }

    public void setTela(CardPersonagem card){
        this.view = card;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    	System.out.println("aa	");
    	try {
			imageX = ImageIO.read(new File(".\\src\\img\\solucoDescarte.jpg"));
			image = ImageIO.read(new File(".\\src\\img\\soluco.jpg"));
			tirar= new ImageIcon(".\\src\\img\\sair30.png");
			voltar = new ImageIcon(".\\src\\img\\voltar30.png");
		} catch (IOException e1) {
			e1.printStackTrace();
		}
        if(e.getSource() == view.getButton()) {
        	if (view.getFlag() == 1) {
        		view.setImage(imageX);
        		view.setButtonIcon(voltar);
        		view.setFlag(0);
        	}
        	else if(view.getFlag() == 0) {
        		view.setImage(image);
        		view.setButtonIcon(tirar);
        		view.setFlag(1); 
        	}
        }
        
    }
}
