package model;

import java.io.*;
import java.net.*;

public class ClienteRecebe implements Runnable {
    private Socket socket;

    public ClienteRecebe(Socket socket) {
        this.socket = socket;
    }

    public void run() {
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            while (true) {
                String message = in.readLine();
                System.out.println("Mensagem do servidor: " + message);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
