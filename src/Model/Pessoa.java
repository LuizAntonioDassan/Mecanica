package Model;
public class Pessoa {

    private String nome;
    private String numero;
    private String cpf;
    private String endereco;
    private String email;
    
    public Pessoa(String nome, String numero, String cpf, String endereco, String email){
        this.nome = nome;
        this.numero = numero;
        this.cpf = cpf;
        this.endereco = endereco;
        this.email = email;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getEndereco() {
        return endereco;
    }
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getNumero() {
        return numero;
    }
    public void setNumero(String numero) {
        this.numero = numero;
    }
    public String getCpf() {
        return cpf;
    }
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    
    
}
