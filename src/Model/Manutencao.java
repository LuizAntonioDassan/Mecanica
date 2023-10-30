package Model;

import java.sql.Timestamp;

public class Manutencao {
    private String descricao;
    private double custo;
    private Timestamp data;
    private String tipo;
    private Boolean finalizado;

    public Manutencao(String descricao, double custo, String tipo){
        this.descricao = descricao;
        this.custo = custo;
        this.tipo = tipo;
        this.data = new Timestamp(System.currentTimeMillis());
        this.finalizado = false;
    }
    
    public Timestamp getdata() {
        return data;
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
    
    

}
