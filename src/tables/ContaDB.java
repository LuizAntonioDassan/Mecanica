package tables;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import Db.DataBase;

public class ContaDB {
    Connection conn = null;
    Statement stm = null;

    public void tabelaConta(){
        try{
            DataBase data = new DataBase();
            conn = data.conectDb("mecanica", "postgres", "java");

            stm = conn.createStatement();
            String table = "CREATE TABLE IF NOT EXISTS conta(idConta serial PRIMARY KEY, idManut INT, formaPagamento VARCHAR(50), valor FLOAT, CONSTRAINT fk_idManut FOREIGN KEY (idManut) REFERENCES manutencao(idManut))";
            stm.executeUpdate(table);
            System.out.println("Tabela Conta criada com sucesso");
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

    
}
