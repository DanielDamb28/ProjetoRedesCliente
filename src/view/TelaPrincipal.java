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
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controller.ControllerCardPersonagem;
import controller.ControllerMain;
import controller.ControllerTelaPrincipal;
import model.Personagem;
import java.awt.Color;
import javax.swing.UIManager;

public class TelaPrincipal extends JFrame {
    private JPanel gridPanel; // Panel for the GridLayout
    private JPanel otherPanel; // Panel for other components
    
    private JLabel lPerguntaAnterior;
    private JLabel lRespostaAnterior;
    private JLabel lPergunta;
    private JTextField tPergunta;
    private JButton buttonAdvinhar;
    private JButton buttonEnviar;
    private JLabel lInformacoesPersonagemSorteado;
    private JTextField txt;
    private JLabel PerguntaAResp;
    private JButton btnSim;
    private JButton btnNao;
    
    private Boolean suaJogada;
    
    ControllerTelaPrincipal controller;
    ControllerMain controlMain;
    
    List<CardPersonagem> cards = new ArrayList<CardPersonagem>();

    public TelaPrincipal(List<Personagem> personagens, Integer personagemSorteado, ControllerTelaPrincipal ctrl, ControllerMain controlMain) throws IOException{
    	gridPanel = new JPanel();
        otherPanel = new JPanel();
        suaJogada = false;
        
        
        controller = ctrl;     
        this.controlMain = controlMain;

        for(Personagem personagem: personagens) {
        	BufferedImage image = null;
        	try {
        	image = ImageIO.read(new File("./src/img/"+personagem.getNome()+".png"));
        	} catch (Exception e) {
        		System.out.println("Imagem");
        	}
        	criaCardDoPersonagem(image, personagem);
        }
        
        Personagem personagem = personagens.get(personagemSorteado);
        gridPanel.setLayout(new GridLayout(2, 8));
        otherPanel.setLayout(null);
        
        getContentPane().add(gridPanel, BorderLayout.PAGE_START); 
        getContentPane().add(otherPanel, BorderLayout.SOUTH);
        
        setConfiguracoesDeTela();
        
        gridPanel.setPreferredSize(new Dimension(1280, 560));
        otherPanel.setPreferredSize(new Dimension(1280, 240));
        
        lPerguntaAnterior = setLabel("Pergunta Anterior:", 580, 25, 260, 30);
        lPerguntaAnterior.setFont(new Font("Serif", Font.PLAIN, 20));
        
        lRespostaAnterior = setLabel("Resposta Anterior:", 580, 75, 230, 30);
        lRespostaAnterior.setFont(new Font("Serif", Font.PLAIN, 20));
        
        
        buttonAdvinhar = new JButton("Advinhar");
        buttonAdvinhar.setBounds(1150, 178, 110, 30);
        buttonAdvinhar.addActionListener(controller);
        otherPanel.add(buttonAdvinhar);
        
        lPergunta = setLabel("Fazer Pergunta:", 580, 178, 160, 30);
        lPergunta.setFont(new Font("Serif", Font.PLAIN, 20));
        tPergunta = setTextField(710, 183, 300, 25);
        
        buttonEnviar = new JButton("ENVIAR");
        buttonEnviar.setBounds(1030, 178, 100, 30);
        buttonEnviar.addActionListener(controller);
        otherPanel.add(buttonEnviar);
        
        PerguntaAResp = new JLabel("pergunta");
        PerguntaAResp.setFont(new Font("Serif", Font.PLAIN, 20));
        PerguntaAResp.setBounds(750, 48, 508, 30);
        otherPanel.add(PerguntaAResp);
        PerguntaAResp.setVisible(false);
   	
        
        btnSim = new JButton("SIM");
        btnSim.setBounds(878, 116, 69, 30);
        btnSim.addActionListener(controller);
        otherPanel.add(btnSim);
        btnSim.setVisible(false); 
        
        btnNao = new JButton("NÃO");
        btnNao.setBounds(957, 116, 69, 30);
        btnNao.addActionListener(controller);
        otherPanel.add(btnNao);
        btnNao.setVisible(false);
        
        setPersonagemSorteado(personagem);
        
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
    	controllerCard.setControllerMain(controlMain);
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
    	txt = new JTextField();
    	txt = new JTextField();
    	txt.setBounds(xText,yText,width,height);
    	txt.setFont(new Font("Serif", Font.PLAIN, 15));
    	otherPanel.add(txt);
    	return txt;
    }
    
    private void setPersonagemSorteado(Personagem personagem) {
        ImageIcon imagemIcon = new ImageIcon(".\\src\\img\\"+personagem.getNome() +".png");
        ImageIcon imagemRedimensionada = new ImageIcon(imagemIcon.getImage().getScaledInstance(150, 195, java.awt.Image.SCALE_SMOOTH));
        JLabel imagemLabel = new JLabel(imagemRedimensionada);
        imagemLabel.setBounds(30, 30, 150, 195);
        otherPanel.add(imagemLabel);
        
        lInformacoesPersonagemSorteado = setLabel("Seu Personagem", 190, 25, 200, 30);
        JLabel lPersonagemSorteadoNome = setLabel("Nome: "+ personagem.getNome(), 190, 70, 150, 30);
        otherPanel.add(lInformacoesPersonagemSorteado);
        otherPanel.add(lPersonagemSorteadoNome);
       
        
    }
    
    public void mudaTelaResponder() {
    	System.out.println("Mudando tela para pergunta");
    	PerguntaAResp.setVisible(true);
		 btnSim.setVisible(true);
		 btnNao.setVisible(true);
	 
        lPerguntaAnterior .setVisible(false);
        lRespostaAnterior.setVisible(false);
        buttonAdvinhar.setVisible(false);
        lPergunta.setVisible(false);
        buttonEnviar.setVisible(false);
    }
    
	public void mudaTelaPergunta() {
		PerguntaAResp.setVisible(false);
		btnSim.setVisible(false);
		btnNao.setVisible(false);

		lPerguntaAnterior.setVisible(true);
		lRespostaAnterior.setVisible(true);
		buttonAdvinhar.setVisible(true);
		lPergunta.setVisible(true);
		buttonEnviar.setVisible(true);
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
    

	public String getTextoPergunta() {
		return tPergunta.getText();
	}

	public void setTextoPergunta(String pergunta) {
		this.tPergunta.setText(pergunta);
	}

	public JLabel getlPerguntaAnterior() {
		return lPerguntaAnterior;
	}

	public JLabel getlRespostaAnterior() {
		return lRespostaAnterior;
	}

	public JLabel getlPergunta() {
		return lPergunta;
	}

	public JTextField gettPergunta() {
		return tPergunta;
	}

	public JLabel getPerguntaAResp() {
		return PerguntaAResp;
	}

	public JButton getBtnSim() {
		return btnSim;
	}

	public JButton getBtnNao() {
		return btnNao;
	}

	public JTextField getTxt() {
		return txt;
	}

	public void setlPerguntaAnterior(String lPerguntaAnterior) {
		System.out.println("emtrei no set pergunta anterior");
		this.lPerguntaAnterior.setText("Pergunta anterior: " +lPerguntaAnterior);
		
	}

	public void setPerguntaAResp(String perguntaAResp) {
		this.PerguntaAResp.setText("Pergunta: "+perguntaAResp);
	}

	public void setlRespostaAnterior(String lRespostaAnterior) {
		this.lRespostaAnterior.setText("Resposta anterior: "+lRespostaAnterior);
	}

	public void setTxt(String tPergunta) {
		this.txt.setText(tPergunta);
	}

	

	
	
	
}
