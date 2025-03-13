public class Endereco   {
    String logradouro;
    String numero;
    String bairro;
    String cidade;
    String estado;
    String cep;

    public Endereco(String logradouro, String numero, String bairro, String cidade, String estado, String cep) {
        this.logradouro = logradouro;
        this.numero = numero;
        this.bairro = bairro;
        this.cidade = cidade;
        this.estado = estado;
        this.cep = cep;

    }


    public Endereco() {
    }
}
