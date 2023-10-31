package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import Db.DataBase;

public class Manutencao {
  private Long id;
  private String descricao;
  private String placa;
  private double custo;
  private Timestamp data;
  private String tipo;
  private Boolean finalizado;

  public Manutencao(String descricao, String placa, double custo, String tipo) {
    this.descricao = descricao;
    this.placa = placa;
    this.custo = custo;
    this.tipo = tipo;
    this.finalizado = false;
  }

  public Timestamp getdata() {
    return data;
  }

  public void setData(Timestamp data) {
    this.data = data;
  }

  public void setdata(Timestamp data) {
    this.data = data;
  }

  public String getDescricao() {
    return descricao;
  }

  public void setDescricao(String descricao) {
    this.descricao = descricao;
  }

  public double getcusto() {
    return custo;
  }

  public void setcusto(double custo) {
    this.custo = custo;
  }

  public String getTipo() {
    return tipo;
  }

  public void setTipo(String tipo) {
    this.tipo = tipo;
  }

  public Boolean getFinalizado() {
    return finalizado;
  }

  public void setFinalizado(Boolean finalizado) {
    this.finalizado = finalizado;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Long getId() {
    return this.id;
  }

  public String getPlaca() {
    return this.placa;
  }

  public void setPlaca(String placa) {
    this.placa = placa;
  }

  public double getCusto() {
    return custo;
  }

  public void setCusto(double custo) {
    this.custo = custo;
  }

  public Timestamp getData() {
    return data;
  }

  public static List<Manutencao> getAll() {
    List<Manutencao> manutencoes = new ArrayList<>();
    Connection conn = null;
    Statement stm = null;
    PreparedStatement pstm = null;

    try {
      DataBase data = new DataBase();
      conn = data.conectDb("mecanica", "postgres", "java");
      stm = conn.createStatement();
      String table = "SELECT * FROM manutencao";
      ResultSet rows = stm.executeQuery(table);

      while (rows.next()) {
        var m = new Manutencao(rows.getString("descricao"), rows.getString("placa"), rows.getDouble("custo"), rows.getString("tipo"));
        m.setId(rows.getLong("idmanut"));
        m.setData(rows.getTimestamp("hora"));
        m.setFinalizado(rows.getBoolean("finalizado"));

        manutencoes.add(m);
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

    return manutencoes;
  }
}
