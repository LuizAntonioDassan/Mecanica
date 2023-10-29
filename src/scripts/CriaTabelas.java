package scripts;

import tables.AdministradorDB;
import tables.ClienteDB;
import tables.ContaDB;
import tables.FuncionarioDB;
import tables.ManutencaoDB;
import tables.VeiculoDB;

public class CriaTabelas {
    public CriaTabelas(){
        
        new FuncionarioDB().tabelaFuncionario();
        new AdministradorDB().tabelaAdministrador();
        new ClienteDB().tabelaCliente();
        new ManutencaoDB().tabelaManutencao();
        new VeiculoDB().tabelaVeiculo();
        new ContaDB().tabelaConta();
    }
}
