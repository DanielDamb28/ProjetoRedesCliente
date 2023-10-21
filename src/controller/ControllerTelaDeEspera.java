package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.TelaDeEspera;

public class ControllerTelaDeEspera implements ActionListener{
	
	TelaDeEspera tela;
	
	public void setTela(TelaDeEspera tela) {
		this.tela = tela;
	}
	
	public TelaDeEspera getTela() {
		return tela;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}
