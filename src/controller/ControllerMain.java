package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

import model.Personagem;
import model.factorys.FactoryPersonagem;
import model.factorys.FactoryScreens;
import view.TelaDeEspera;

public class ControllerMain implements ActionListener{
	private Socket cliente;
	private TelaDeEspera telaEspera;
	private List<Personagem> listaDePersonagens;
	private Integer personagemSorteado;
	private Boolean suaJogada;
	
	public ControllerMain(Socket cliente) {
    	this.cliente = cliente;
    	this.suaJogada = false;
    }
	
    public void mandaMensagem(String mensagem) throws IOException {
    	PrintWriter out = null;
        OutputStream outputStream = null;
		try {
			outputStream = cliente.getOutputStream();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		out = new PrintWriter(outputStream, true);
    	
    	System.out.println(mensagem);
    	if(mensagem.equals("%esperandoJogador%")) {
    		setTelaEspera();
    	}
    	if(mensagem.equals("%esperandoPronto%")) {
    		telaEspera.mostrarButton();
    	}
    	if(mensagem.contains("%listaPersonagens%")) {
    		personagemSorteado = retornaPersonagemSorteado(mensagem);
    		listaDePersonagens = decodificaPersonagens(mensagem);
    		if(listaDePersonagens.size() == 16) {
    			out.println("%todosPersonagensRecebidos%");
    		}
    	}
    	if(mensagem.equals("%iniciarJogo%")) {
    		telaEspera.dispose();
    		setTelaPrincipal(listaDePersonagens,personagemSorteado);
    	}
    	if(mensagem.equals("%esperandoJogada%")) {
    		setTelaSuaVezDeJogar();
    		suaJogada = true;
    	}
    	if recebeu
    }
    
    public void setTelaEspera() throws IOException {
    	ControllerTelaDeEspera controller = new ControllerTelaDeEspera(cliente);
		FactoryScreens factory = new FactoryScreens();
		this.telaEspera = factory.chamaTelaDeEspera(controller);
    }
    
    public void setTelaPrincipal(List<Personagem> listaPersonagens, Integer personagemSorteado) throws IOException {
    	ControllerTelaPrincipal controller = new ControllerTelaPrincipal(cliente);
        FactoryScreens factory = new FactoryScreens();
        factory.chamaTelaPrincipal(listaPersonagens, personagemSorteado, controller, this);
    }
    
    public List<Personagem> decodificaPersonagens(String mensagem){
    	List<Personagem> lista;
    	List<String> stringPersonagens = criaListaComAsInformacoesDosPersonagensSeparadas(mensagem);
    	for(String item: stringPersonagens) {
    		System.out.println(item);
    	}
    	lista = criaPersonagensComListaDeStrings(stringPersonagens);
    	return lista;
    }
    
    public Integer retornaPersonagemSorteado(String mensagem) {
    	int inicio = mensagem.indexOf("%personagemSorteado%");
    	int inicioPalavra = inicio + 20;
    	int fim = mensagem.indexOf("%/personagemSorteado%");
    	int numeroSorteado = Integer.parseInt(mensagem.substring(inicioPalavra, fim));
    	return numeroSorteado;
    }
    
    public List<String> criaListaComAsInformacoesDosPersonagensSeparadas(String mensagem){
    	List<String> stringPersonagens = new ArrayList<String>();
    	while(mensagem.contains("%personagem%")){
    		int inicio = mensagem.indexOf("%personagem%");
        	int inicioPalavra = inicio + 12;
        	int fim = mensagem.indexOf("%/personagem%");
        	String infoPersonagem = mensagem.substring(inicioPalavra, fim);
        	stringPersonagens.add(infoPersonagem);
        	mensagem = mensagem.substring(fim + 13);
    	}
    	return stringPersonagens;
    }
    
    public List<Personagem> criaPersonagensComListaDeStrings(List<String> stringPersonagens){
    	List<Personagem> listaPersonagens = new ArrayList<Personagem>();
    	for(String string:stringPersonagens) {
    		int inicioNome = string.indexOf("%nome%") + 6;
    		int fimNome = string.indexOf("%/nome%");
    		String nome = string.substring(inicioNome, fimNome);
    		int inicioIdade = string.indexOf("%idade%") + 7;
    		int fimIdade = string.indexOf("%/idade%");
    		int idade = Integer.parseInt(string.substring(inicioIdade, fimIdade));
    		int inicioSexo = string.indexOf("%sexo%") + 6;
    		int fimSexo = string.indexOf("%/sexo%");
    		String sexo = string.substring(inicioSexo, fimSexo);
    		int inicioAltura = string.indexOf("%altura%") + 8;
    		int fimAltura = string.indexOf("%/altura%");
    		Double altura = Double.parseDouble(string.substring(inicioAltura, fimAltura));
    		listaPersonagens.add(FactoryPersonagem.criaPersonagem(nome, idade, sexo, altura));
    	}
    	return listaPersonagens;
    }
    
    public void setTelaSuaVezDeJogar() {
    	FactoryScreens factory = new FactoryScreens();
        factory.chamaTelaSuaVezDeJogar();
    }
    
    
    
	public Boolean getSuaJogada() {
		return suaJogada;
	}

	public void setSuaJogada(Boolean suaJogada) {
		this.suaJogada = suaJogada;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
