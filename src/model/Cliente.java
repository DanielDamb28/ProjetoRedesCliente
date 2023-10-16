package model;


public class Cliente {
	
	private String host;
	private int porta;
	
    public Cliente(String host, int porta){
        this.setHost(host);
        this.setPorta(porta);
    }

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public int getPorta() {
		return porta;
	}

	public void setPorta(int porta) {
		this.porta = porta;
	}
    

    
    /*
    public void executa() throws UnknownHostException, IOException{
        Socket cliente = new Socket(this.host, this.porta);
        System.out.println("O cliente se conectou ao servidor!");

        Recebedor r = new Recebedor(cliente.getInputStream());
        new Thread(r).start();

        ControllerTelaPrincipal controller = new ControllerTelaPrincipal();
        FactoryScreens factory = new FactoryScreens();
        factory.chamaTelaPrincipal(controller);

        Scanner teclado = new Scanner(System.in);
        PrintStream saida = new PrintStream(cliente.getOutputStream());
        while(teclado.hasNextLine()){
            saida.println(teclado.nextLine());
        }

        saida.close();
        teclado.close();
        cliente.close();
    }*/

}