package Db;

import java.sql.Connection;
import java.sql.DriverManager;

public class DataBase {
    public Connection conectDb(String dbName, String User, String senha){
            Connection conn=null;
            try{
                Class.forName("org.postgresql.Driver");
                conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/"+dbName, User, senha);
                if(conn!= null){
                    System.out.println("Sucesso");
                }else{
                    System.out.println("Erro");
                }
            }catch(Exception e){
                System.out.println("Erro: " + e);
            }
            return conn;
    }
}
