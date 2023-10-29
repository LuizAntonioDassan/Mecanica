package tables;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import Db.DataBase;

public class FuncionarioDB { 
        Connection conn = null;
        Statement stm = null;
        PreparedStatement pstm = null;

        public void tabelaFuncionario(){
            try{
            DataBase data = new DataBase();
            conn = data.conectDb("mecanica", "postgres", "java");

            stm = conn.createStatement();
            String table = "CREATE TABLE IF NOT EXISTS Funcionario(idFunc serial PRIMARY KEY,nome VARCHAR(255) NOT NULL,numero VARCHAR(20),cpf VARCHAR(14) NOT NULL UNIQUE,endereco TEXT,email VARCHAR(255))";
            stm.executeUpdate(table);
            System.out.println("Tabela Funcionario criada com sucesso");
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
        public void insereFuncionario(String nome, String numero, String cpf, String endereco, String email){
            try{
                DataBase data = new DataBase();
                conn = data.conectDb("mecanica", "postgres", "java");
    
                String insertFuncionario = "INSERT INTO Funcionario (nome, numero, cpf, endereco, email) VALUES (?,?,?,?,?) ON CONFLICT (cpf) DO NOTHING";
                pstm = conn.prepareStatement(insertFuncionario);
    
                pstm.setString(1, nome);
                pstm.setString(2, numero);
                pstm.setString(3, cpf);
                pstm.setString(4, endereco);
                pstm.setString(5, email);
    
                int rows = pstm.executeUpdate();
    
                System.out.println("Inserção realizada com sucesso. Linhas afetadas: " + rows);
    
            }catch(SQLException e){
                e.printStackTrace();
            }finally{
                try{
                    if(pstm != null){
                        pstm.close();
                    }
                }catch(SQLException e){
                    e.printStackTrace();
                }
    
                try{
                    if(conn != null){
                        conn.close();
                    }
                }catch(SQLException e){
                    e.printStackTrace();
                }
            }
        }
        public void removeFuncionario(String cpf){
            try{
                DataBase data = new DataBase();
                conn = data.conectDb("mecanica", "postgres", "java");
    
                String removeFuncionario = "DELETE FROM funcionario where cpf = ?";
                pstm = conn.prepareStatement(removeFuncionario);
    
                pstm.setString(1, cpf);
    
                int rows = pstm.executeUpdate();
    
                System.out.println("Remoção Realizada com Sucesso. Linhas afetadas: "+ rows);
    
    
            }catch(SQLException e){
                e.printStackTrace();
            }finally{
                try{
                    if(pstm != null){
                        pstm.close();
                    }
                }catch(SQLException e){
                    e.printStackTrace();
                }
    
                try{
                    if(conn != null){
                        conn.close();
                    }
                }catch(SQLException e){
                    e.printStackTrace();
                }
            }
        }
}