package Controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;

import Db.DataBase;

public class ManutecanoController {
    Connection conn = null;
    Statement stm = null;
    PreparedStatement pstm = null;

    public void agendarManutencao(String descricao, Double custo, String tipo, String placa){
        Boolean finalizado = false;
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        try{
            DataBase data = new DataBase();
            conn = data.conectDb("mecanica", "postgres", "java");

            String insertVeiculo = "INSERT INTO manutencao (descricao, custo, hora, tipo, finalizado, placa) VALUES (?,?,?,?,?,?)";
            pstm = conn.prepareStatement(insertVeiculo);

            pstm.setString(1, descricao);
            pstm.setDouble(2, custo);
            pstm.setTimestamp(3, timestamp);
            pstm.setString(4, tipo);
            pstm.setBoolean(5, finalizado);
            pstm.setString(6, placa);

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
}
