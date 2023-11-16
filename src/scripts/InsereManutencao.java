package scripts;

import Controller.ManutecanoController;
import tables.ManutencaoDB;

public class InsereManutencao {
    public InsereManutencao(){
        ManutecanoController manut = new ManutecanoController();

        manut.agendarManutencao("Problema interno no motor", 250.25, "troca de oleo","aA");
        manut.agendarManutencao("Problema na junta", 150.00, "troca da junta do cabecote","aA");
        manut.agendarManutencao("problema no cambio", 652.65, "troca da caixa de cambio e limpeza da graxa dos cabos","aA");
    }
}
