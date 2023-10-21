package model.factorys;

import java.io.IOException;

import controller.ControllerTelaDeEspera;
import controller.ControllerTelaPrincipal;
import view.TelaDeEspera;
import view.TelaPrincipal;

public class FactoryScreens {
    public void chamaTelaPrincipal(ControllerTelaPrincipal ctrl) throws IOException{
        TelaPrincipal tela = new TelaPrincipal(ctrl);
        ctrl.setTela(tela);
    }
    
    public TelaDeEspera chamaTelaDeEspera(ControllerTelaDeEspera ctrl) throws IOException{
        TelaDeEspera tela = new TelaDeEspera(ctrl);
        ctrl.setTela(tela);
        return tela;
    }
}
