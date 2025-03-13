import java.util.ArrayList;
import java.util.List;

public class ControleFinanceiro {
    private Usuario usuario;
    private List<Gastos> gastos;
    private List<Investimentos> investimentos;

    public ControleFinanceiro(Usuario usuario) {
        this.usuario = usuario;
        this.gastos = new ArrayList<>();
        this.investimentos = new ArrayList<>();
    }

    public void cadastrarGasto(double valor, String descricao) {
        Gastos novoGasto = new Gastos(valor, descricao);
        gastos.add(novoGasto);
        usuario.setSaldo(usuario.getSaldo() - valor);
    }

    public void cadastrarInvestimento(double valorInicial, double valorRetornado, String descricao) {
        Investimentos novoInvestimento = new Investimentos(valorInicial, valorRetornado, descricao);
        investimentos.add(novoInvestimento);
        usuario.setSaldo(usuario.getSaldo() + novoInvestimento.getLucro());
    }


    public List<Gastos> getGastos() {
        return gastos;
    }

    public List<Investimentos> getInvestimentos() {
        return investimentos;
    }
}