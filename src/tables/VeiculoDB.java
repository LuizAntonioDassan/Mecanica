package tables;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import Db.DataBase;

public class VeiculoDB {
    Connection conn = null;
    Statement stm = null;
    PreparedStatement pstm = null;

    public void tabelaVeiculo(){
        try{
            DataBase data = new DataBase();
            conn = data.conectDb("mecanica", "postgres", "java");

            stm = conn.createStatement();
            String table = "CREATE TABLE IF NOT EXISTS veiculo(idVeiculo serial PRIMARY KEY,cpf VARCHAR(14) ,placa VARCHAR(255) NOT NULL UNIQUE, marca VARCHAR(155), modelo VARCHAR(155), ano VARCHAR(5), cor VARCHAR(60), CONSTRAINT fk_cpf FOREIGN KEY (cpf) REFERENCES cliente(cpf))";
            stm.executeUpdate(table);
            System.out.println("Tabela Veiculo criada com sucesso");
        }
        catch(SQLException e){
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
    public void InsereVeiculo(String cpf, String placa, String marca, String modelo, String ano, String cor){
        try{
            DataBase data = new DataBase();
            conn = data.conectDb("mecanica", "postgres", "java");

            String insertVeiculo = "INSERT INTO veiculo (cpf, placa, marca, modelo, ano, cor) VALUES (?,?,?,?,?,?)";
            pstm = conn.prepareStatement(insertVeiculo);

            pstm.setString(1, cpf);
            pstm.setString(2, placa);
            pstm.setString(3, marca);
            pstm.setString(4, modelo);
            pstm.setString(5, ano);
            pstm.setString(6, cor);

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
    public void removeVeiculo(String placa){
        try{
            DataBase data = new DataBase();
            conn = data.conectDb("mecanica", "postgres", "java");

            String removeVeiculo = "DELETE FROM veiculo where placa = ?";
            pstm = conn.prepareStatement(removeVeiculo);

            pstm.setString(1, placa);

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
