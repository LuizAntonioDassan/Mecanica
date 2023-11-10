package tables;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import Db.DataBase;

public class ManutencaoDB {
    Connection conn = null;
    Statement stm = null;
    PreparedStatement pstm = null;

    public void tabelaManutencao(){
        try{
            DataBase data = new DataBase();
            conn = data.conectDb("mecanica", "postgres", "java");

            stm = conn.createStatement();
            String table = "CREATE TABLE IF NOT EXISTS manutencao(idManut serial PRIMARY KEY,placa VARCHAR(15), descricao VARCHAR(255), custo FLOAT, hora TIMESTAMP, tipo VARCHAR(255), finalizado BOOLEAN)";
            stm.executeUpdate(table);
            System.out.println("Tabela Manutencao criada com sucesso");
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

    
    public void removeManutencao(Integer idManut){
        try{
            DataBase data = new DataBase();
            conn = data.conectDb("mecanica", "postgres", "java");

            String removeVeiculo = "DELETE FROM manutencao where idManut = ?";
            pstm = conn.prepareStatement(removeVeiculo);

            pstm.setInt(1, idManut);

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
