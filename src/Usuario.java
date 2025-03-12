import java.util.Objects;

public class Usuario {
    String nome;
    String email;
    String telefone;
    String cpf;
    String senha;
    double saldo;

    Endereco endereco;



    public Usuario(String nome, String email, String telefone, String cpf, String senha, double saldo) {
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.cpf = cpf;
        this.senha = senha;
        this.saldo = saldo;
    }
    public double getSaldo() {
        return saldo;
    }
    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
    public Usuario() {};

    public void Login(String loginEmail, String loginSenha) {
        if (!Objects.equals(loginEmail, email)){
            System.out.println("Email inválido, tente novamente!");
        } else if (!Objects.equals(loginSenha, senha)){
            System.out.println("Senha inválida, tente novamente!");
        } else {
            System.out.println("Login validado com sucesso! Seja bem-vindo usuário " + nome);
        }
    }
}
