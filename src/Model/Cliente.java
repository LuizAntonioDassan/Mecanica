package Model;

public class Cliente extends Pessoa{
    private Veiculo veiculo;

    public Cliente(String nome, String numero, String cpf, String endereco, String email){
        super(nome,numero,cpf,endereco,email);
    }
    
    public Veiculo getVeiculo() {
        return this.veiculo;
    }

    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }

    public void calculaNota(){
        
    }
}