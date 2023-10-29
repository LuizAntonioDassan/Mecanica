package tables;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import Db.DataBase;

public class AdministradorDB {
    Connection conn = null;
    Statement stm = null;
    PreparedStatement pstm = null;
    
    public void tabelaAdministrador(){
        try{
            DataBase data = new DataBase();
            conn = data.conectDb("mecanica", "postgres", "java");

            stm = conn.createStatement();
            String table = "CREATE TABLE IF NOT EXISTS Administrador(idAdm serial PRIMARY KEY,nome VARCHAR(255) NOT NULL,numero VARCHAR(20),cpf VARCHAR(14) NOT NULL UNIQUE,endereco TEXT,email VARCHAR(255))";
            stm.executeUpdate(table);
            System.out.println("Tabela Administrador criada com sucesso");
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

    public void InsereAdministrador(String nome, String numero, String cpf, String endereco, String email){
        try{
            DataBase data = new DataBase();
            conn = data.conectDb("mecanica", "postgres", "java");

            String insertAdministrador = "INSERT INTO Administrador (nome, numero, cpf, endereco, email) VALUES (?,?,?,?,?) ON CONFLICT (cpf) DO NOTHING";
            pstm = conn.prepareStatement(insertAdministrador);

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
    public void removeAdministrador(String cpf){
        try{
            DataBase data = new DataBase();
            conn = data.conectDb("mecanica", "postgres", "java");

            String removeAdministrador = "DELETE FROM administrador where cpf = ?";
            pstm = conn.prepareStatement(removeAdministrador);

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