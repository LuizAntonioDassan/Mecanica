package scripts;

import tables.ManutencaoDB;

public class InsereManutencao {
    public InsereManutencao(){
        ManutencaoDB manut = new ManutencaoDB();

        manut.criaManutencao("Problema interno no motor",250.25, "troca de oleo","ABC");
        manut.criaManutencao("Problema na junta",150.00, "troca da junta do cabecote","ABC");
        manut.criaManutencao("problema no cambio", 652.65, "troca da caixa de cambio e limpeza da graxa dos cabos","ABC");
    }
}
