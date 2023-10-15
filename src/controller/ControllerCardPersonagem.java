package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import view.CardPersonagem;

public class ControllerCardPersonagem implements ActionListener{
	CardPersonagem view;
	BufferedImage image;
	BufferedImage imageX;

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
		} catch (IOException e1) {
			e1.printStackTrace();
		}
        if(e.getSource() == view.getButton()) {
        	if (view.getFlag() == 1) {
        		view.setImage(imageX);
        		view.setFlag(0);
        	}
        	else if(view.getFlag() == 0) {
        		view.setImage(image);
        		view.setFlag(1); 
        	}
        }
    }
}
