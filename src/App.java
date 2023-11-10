import java.util.Scanner;

import javax.management.Query;

import Controller.query;
import Db.DataBase;
import Model.Manutencao;
import scripts.CriaTabelas;
import scripts.InsereAdministrador;
import scripts.InsereCliente;
import scripts.InsereFuncionario;
import scripts.InsereManutencao;
import scripts.InsereVeiculo;
import tables.ClienteDB;
import tables.ManutencaoDB;
import tables.VeiculoDB;
import View.Screen;

public class App {
    public static void main(String[] args) throws Exception {
        // Scanner in = new Scanner(System.in);
        
        // String descricao = in.nextLine();
        // double custo = in.nextDouble();
        // String tipo = in.nextLine();


        // new Manutencao(descricao, custo, tipo);
        // new ManutencaoDB().criaManutencao(descricao, custo, tipo);

        
        DataBase data = new DataBase();
        data.conectDb("mecanica", "postgres", "java");
        
        // new CriaTabelas();
        // new InsereCliente();
        // new InsereAdministrador();
        // new InsereFuncionario();
        // new InsereVeiculo();
        // new InsereManutencao();

        new Screen();
        // new query().pesquisa("veiculo", "O");
        // new query().pesquisa("cliente", "Ca");
        // new query().recuperaVeiculoCliente("ABC1234");               

        //new ClienteDB().removeCliente("11111111111");
        //new VeiculoDB().removeVeiculo("ABC1234");
    }
}
