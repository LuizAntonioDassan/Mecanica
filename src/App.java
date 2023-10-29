import scripts.CriaTabelas;
import scripts.InsereAdministrador;
import scripts.InsereCliente;
import scripts.InsereFuncionario;
import scripts.InsereManutencao;
import scripts.InsereVeiculo;
import tables.ClienteDB;
import tables.ManutencaoDB;
import tables.VeiculoDB;

public class App {
    public static void main(String[] args) throws Exception {
        
        new CriaTabelas();
        //new InsereCliente();
        //new InsereAdministrador();
        //new InsereFuncionario();
        //new InsereVeiculo();
        //new InsereManutencao();
        

        //new ClienteDB().removeCliente("11111111111");
        //new VeiculoDB().removeVeiculo("ABC1234");
    }
}
