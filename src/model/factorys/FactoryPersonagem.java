package model.factorys;

import model.Personagem;

public class FactoryPersonagem {
	
	public static Personagem criaPersonagem(String nome) {
		Personagem personagem = new Personagem(nome);
		return personagem;
	}
}
