package Model;

import java.sql.Connection;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Db.DataBase;

public class Cliente extends Pessoa{
    private List<Veiculo> veiculos;
    
    public List<Veiculo> getVeiculo() {
        return veiculos;
    }
  
  
    public void setVeiculo(List<Veiculo> veiculo) {
        this.veiculos = veiculo;
    }

    public Cliente(String nome, String numero, String cpf, String endereco, String email){
        super(nome,numero,cpf,endereco,email);
    }
    

    public static List<Cliente> getAll() {
    List<Cliente> clientes = new ArrayList<>();
    Connection conn = null;
    Statement stm = null;

    try {
      DataBase data = new DataBase();
      conn = data.conectDb("mecanica", "postgres", "java");
      stm = conn.createStatement();
      String table = "SELECT * FROM cliente";
      ResultSet rows = stm.executeQuery(table);

      while (rows.next()) {
        var m = new Cliente(rows.getString("nome"), rows.getString("numero"), rows.getString("cpf"), rows.getString("endereco"), rows.getString("email"));
        m.setNome(rows.getString("nome"));
        m.setNumero(rows.getString("numero"));
        m.setCpf(rows.getString("cpf"));
        m.setEndereco(rows.getString("endereco"));
        m.setEmail(rows.getString("email"));
        

        clientes.add(m);
      }
    } catch (SQLException e) {
      e.printStackTrace();
    } finally {
      try {
        if (stm != null) {
          stm.close(); // Fechar a declaração
        }
      } catch (SQLException e) {
        e.printStackTrace();
      }

      try {
        if (conn != null) {
          conn.close(); // Fechar a conexão
        }
      } catch (SQLException e) {
        e.printStackTrace();
      }
    }

    return clientes;
  }

}