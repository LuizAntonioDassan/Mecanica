package scripts;
import tables.FuncionarioDB;

public class InsereFuncionario {
    public InsereFuncionario(){
        FuncionarioDB insereFuncionario = new FuncionarioDB();

        insereFuncionario.insereFuncionario("Beatriz", "7877877877", "33399999999", "Amanda", "beatriz@example.com");
        insereFuncionario.insereFuncionario("Renan", "1234123412", "98765432109", "Karina", "renan@example.com");
        insereFuncionario.insereFuncionario("Caroline", "6546546546", "77711111111", "Marcos", "caroline@example.com");
        insereFuncionario.insereFuncionario("Eduarda", "5555555555", "55555555555", "Thiago", "eduarda@example.com");
        insereFuncionario.insereFuncionario("Rita", "9879879879", "44422222222", "Eduardo", "rita@example.com");
        insereFuncionario.insereFuncionario("Luana", "7657657657", "22244444444", "Lucas", "luana@example.com");
        insereFuncionario.insereFuncionario("Camila", "4324324324", "33366666666", "Marcelo", "camila@example.com");
        insereFuncionario.insereFuncionario("Anderson", "1231231231", "66688888888", "Simone", "anderson@example.com");
    }
}