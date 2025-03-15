import java.util.ArrayList;
import java.util.List;

public class ControleFinanceiro {
    private Usuario usuario;
    private List<Transacao> transacoes;

    public ControleFinanceiro(Usuario usuario) {
        this.usuario = usuario;
        this.transacoes = new ArrayList<>();
    }


    public void cadastrarTransacao(Transacao t) {
        transacoes.add(t);
        t.aplicar(usuario);
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public List<Transacao> getTransacoes() {
        return transacoes;
    }

    public void setTransacoes(List<Transacao> transacoes) {
        this.transacoes = transacoes;
    }
}
