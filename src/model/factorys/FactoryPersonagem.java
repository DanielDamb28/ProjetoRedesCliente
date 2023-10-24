package model.factorys;

import model.Personagem;

public class FactoryPersonagem {
	
	public static Personagem criaPersonagem(String nome, int idade, String sexo, Double altura) {
		Personagem personagem = new Personagem(nome, idade, sexo, altura);
		return personagem;
	}
}
