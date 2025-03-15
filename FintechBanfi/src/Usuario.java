import java.util.Objects;

public class Usuario {
    private String nome;
    private String email;
    private String telefone;
    private String cpf;
    private String senha;
    private double saldo;
    private Endereco endereco;

    public Usuario() {
    }

    public Usuario(String nome, String email, String telefone, String cpf, String senha, double saldo) {
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.cpf = cpf;
        this.senha = senha;
        this.saldo = saldo;
    }

    // Encapsulamento: getters e setters
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCpf() {
        return cpf;
    }
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getSenha() {
        return senha;
    }
    public void setSenha(String senha) {
        this.senha = senha;
    }

    public double getSaldo() {
        return saldo;
    }
    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public Endereco getEndereco() {
        return endereco;
    }
    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public void Login(String loginEmail, String loginSenha) {
        if (!Objects.equals(loginEmail, this.email)) {
            System.out.println("Email inválido, tente novamente!");
        } else if (!Objects.equals(loginSenha, this.senha)) {
            System.out.println("Senha inválida, tente novamente!");
        } else {
            System.out.println("Login validado com sucesso! Seja bem-vindo usuário " + this.nome);
        }
    }
}
