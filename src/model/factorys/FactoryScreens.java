package model.factorys;

import java.io.IOException;

import controller.ControllerTelaPrincipal;
import view.TelaPrincipal;

public class FactoryScreens {
    public void chamaTelaPrincipal(ControllerTelaPrincipal ctrl) throws IOException{
        TelaPrincipal tela = new TelaPrincipal(ctrl);
        ctrl.setTela(tela);
    }
}
