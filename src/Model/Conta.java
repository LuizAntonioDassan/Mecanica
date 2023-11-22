package Model;

public class Conta {
    private double valor;
    private String forma;

    public Conta(double valor, String forma){
        this.valor = valor;
        this.forma = forma;
    }

    public double getValor() {
        return valor;
    }
    public void setValor(double valor) {
        this.valor = valor;
    }
    public String getForma() {
        return forma;
    }
    public void setForma(String forma) {
        this.forma = forma;
    }

    
}
