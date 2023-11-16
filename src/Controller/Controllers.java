package Controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Db.DataBase;

public class Controllers {
    /*
     * Seleciona Veiculo por Cliente
     * select c.nome, c.cpf, v.modelo, v.placa from cliente c join veiculo v on c.cpf = v.cpf;
     * 
     * Seleciona
     * 
     */
    Connection conn = null;
    Statement stm = null;
    PreparedStatement pstm = null;


     public void listaClientes(){
        ResultSet rows;
        try{
            DataBase data = new DataBase();
            conn = data.conectDb("mecanica", "postgres", "java");

            stm = conn.createStatement();
            String table = "SELECT * FROM cliente";
            rows = stm.executeQuery(table);
            System.out.println("Dados recuperados");
            while(rows.next()){
                System.out.println(rows.getString("idCliente")+ " | " +rows.getString("nome")+ " | " + rows.getString("numero")+ " | " + rows.getString("cpf")+ " | " + rows.getString("endereco")+ " | " + rows.getString("email"));
            }
        }catch(SQLException e){
            e.printStackTrace();
        }finally{
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

     }

     public void listaManutencao(){
        ResultSet rows;
        try{
            DataBase data = new DataBase();
            conn = data.conectDb("mecanica", "postgres", "java");

            stm = conn.createStatement();
            String table = "SELECT * FROM manutencao";
            rows = stm.executeQuery(table);
            System.out.println("Dados recuperados");
            while(rows.next()){
                System.out.println(rows.getString("idmanut")+ 
                " | " +rows.getString("placa")+ " | " 
                + rows.getString("descricao")+ " | " 
                + rows.getDouble("custo")+ " | " 
                + rows.getTimestamp("hora")+ " | " 
                + rows.getString("tipo") + " | "
                + rows.getBoolean("finalizado"));
            }
        }catch(SQLException e){
            e.printStackTrace();
        }finally{
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

     }

     public void listaVeiculo(){
        ResultSet rows;
        try{
            DataBase data = new DataBase();
            conn = data.conectDb("mecanica", "postgres", "java");

            stm = conn.createStatement();
            String table = "SELECT * FROM veiculo";
            rows = stm.executeQuery(table);
            System.out.println("Dados recuperados");
            while(rows.next()){
                System.out.println(rows.getString("idveiculo")+ 
                " | " +rows.getString("placa")+ " | " 
                + rows.getString("marca")+ " | " 
                + rows.getString("modelo")+ " | " 
                + rows.getString("ano")+ " | " 
                + rows.getString("cor"));
            }
        }catch(SQLException e){
            e.printStackTrace();
        }finally{
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

     }

     public void listaAdministrador(){
        ResultSet rows;
        try{
            DataBase data = new DataBase();
            conn = data.conectDb("mecanica", "postgres", "java");

            stm = conn.createStatement();
            String table = "SELECT * FROM administrador";
            rows = stm.executeQuery(table);
            System.out.println("Dados recuperados");
            while(rows.next()){
                System.out.println(rows.getString("idadm")+ 
                " | " +rows.getString("nome")+ " | " 
                + rows.getString("numero")+ " | " 
                + rows.getString("cpf")+ " | " 
                + rows.getString("endereco")+ " | " 
                + rows.getString("email"));
            }
        }catch(SQLException e){
            e.printStackTrace();
        }finally{
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

     }

     public void listaFuncionario(){
        ResultSet rows;
        try{
            DataBase data = new DataBase();
            conn = data.conectDb("mecanica", "postgres", "java");

            stm = conn.createStatement();
            String table = "SELECT * FROM funcionario";
            rows = stm.executeQuery(table);
            System.out.println("Dados recuperados");
            while(rows.next()){
                System.out.println(rows.getString("idfunc")+ 
                " | " +rows.getString("nome")+ " | " 
                + rows.getString("numero")+ " | " 
                + rows.getString("cpf")+ " | " 
                + rows.getString("endereco")+ " | " 
                + rows.getString("email"));
            }
        }catch(SQLException e){
            e.printStackTrace();
        }finally{
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
    }

     public void recuperaVeiculoCliente(String placa){
        ResultSet rows;        
        try{
            DataBase data = new DataBase();
            conn = data.conectDb("mecanica", "postgres", "java");
            
            String table = String.format("SELECT * FROM veiculo where placa = '%s'",placa);
            // String table = String.format("SELECT * FROM veiculo where placa LIKE '%%%s%%",placa); recupera todas as placas parecidas com esse nome
            stm = conn.createStatement();
            
            
            rows = stm.executeQuery(table);
            if (rows.isBeforeFirst() == false) {
                System.err.println("Nenhum Veiculo encontrado com essa placa");
            }else{            
                while(rows.next()){
                    System.out.println(rows.getString("idveiculo")+ 
                    " | " +rows.getString("placa")+ " | " 
                    + rows.getString("marca")+ " | " 
                    + rows.getString("modelo")+ " | " 
                    + rows.getString("ano")+ " | " 
                    + rows.getString("cor"));
            }
            }
        }catch(SQLException e){
            e.printStackTrace();
        }finally{
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
    }

     public void recuperaCliente(String cpf){
        ResultSet rows;        
        try{
            DataBase data = new DataBase();
            conn = data.conectDb("mecanica", "postgres", "java");
            
            String table = String.format("SELECT * FROM cliente where cpf = '%s'",cpf);
            stm = conn.createStatement();
            
            
            rows = stm.executeQuery(table);
            if (rows.isBeforeFirst() == false) {
                System.err.println("Nenhum Cliente encontrado com esse CPF");
            }else{            
                while(rows.next()){
                    System.out.println(rows.getString("idcliente")+ 
                    " | " +rows.getString("nome")+ " | " 
                    + rows.getString("numero")+ " | " 
                    + rows.getString("cpf")+ " | " 
                    + rows.getString("endereco")+ " | " 
                    + rows.getString("email"));
                }
            }
        }catch(SQLException e){
            e.printStackTrace();
        }finally{
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
    }

    public void pesquisa(String tabela, String conteudo){
        ResultSet rows;       
        String table;
        try{
            DataBase data = new DataBase();
            conn = data.conectDb("mecanica", "postgres", "java");

            if(tabela == "cliente"){
                table = String.format("SELECT * FROM %s where nome LIKE '%%%s%%'",tabela,conteudo);
                stm = conn.createStatement();
                rows = stm.executeQuery(table);
                if (rows.isBeforeFirst() == false) {
                    System.err.println("Nenhum Cliente encontrado com esse CPF");
                }else{            
                    while(rows.next()){
                    System.out.println(rows.getString("idcliente")+ 
                    " | " +rows.getString("nome")+ " | " 
                    + rows.getString("numero")+ " | " 
                    + rows.getString("cpf")+ " | " 
                    + rows.getString("endereco")+ " | " 
                    + rows.getString("email"));
                    }
                }
            }

            if(tabela == "veiculo"){
                table = String.format("SELECT * FROM %s where placa LIKE '%%%s%%'",tabela,conteudo);
                stm = conn.createStatement();
                rows = stm.executeQuery(table);
                if (rows.isBeforeFirst() == false) {
                    System.err.println("Nenhum Veiculo encontrado com essa Placa");
                }else{            
                    while(rows.next()){
                        System.out.println(rows.getString("idveiculo")+ 
                        " | " +rows.getString("placa")+ " | " 
                        + rows.getString("marca")+ " | " 
                        + rows.getString("modelo")+ " | " 
                        + rows.getString("ano")+ " | " 
                        + rows.getString("cor"));
                    }       
                }
            }
            
        }catch(SQLException e){
            e.printStackTrace();
        }finally{
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
    }
}
