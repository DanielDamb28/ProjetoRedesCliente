package model.factorys;

import java.io.IOException;
import java.util.List;

import controller.ControllerMain;
import controller.ControllerTelaDeEspera;
import controller.ControllerTelaPrincipal;
import model.Personagem;
import view.TelaDeEspera;
import view.TelaPrincipal;
import view.TelaSuaVezDeJogar;

public class FactoryScreens {
    public void chamaTelaPrincipal(List<Personagem> listaPersonagens, Integer personagemSorteado, ControllerTelaPrincipal ctrl, ControllerMain controlMain) throws IOException{
        TelaPrincipal tela = new TelaPrincipal(listaPersonagens,personagemSorteado,  ctrl, controlMain);
        ctrl.setTela(tela);
        ctrl.setControlMain(controlMain);
    }
    
    public TelaDeEspera chamaTelaDeEspera(ControllerTelaDeEspera ctrl) throws IOException{
        TelaDeEspera tela = new TelaDeEspera(ctrl);
        ctrl.setTela(tela);
        return tela;
    }
    
    public TelaSuaVezDeJogar chamaTelaSuaVezDeJogar() {
    	TelaSuaVezDeJogar tela = new TelaSuaVezDeJogar();
    	return tela;
    }
}
