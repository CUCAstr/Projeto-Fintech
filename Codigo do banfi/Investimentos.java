public class Investimentos {
    private double valorInicial;
    private double valorRetornado;
    private String descricao;

    public Investimentos(double valorInicial, double valorRetornado, String descricao) {
        this.valorInicial = valorInicial;
        this.valorRetornado = valorRetornado;
        this.descricao = descricao;
    }

    public double getLucro() {
        return valorRetornado - valorInicial;
    }

    public String getDescricao() {
        return descricao;
    }
}
