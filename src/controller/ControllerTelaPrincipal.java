package controller;

import view.TelaPrincipal;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControllerTelaPrincipal implements ActionListener {
    TelaPrincipal tela;

    public TelaPrincipal getTela(){
        return tela;
    }

    public void setTela(TelaPrincipal tela){
        this.tela = tela;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
