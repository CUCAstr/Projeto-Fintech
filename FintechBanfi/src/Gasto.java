public class Gasto extends Transacao {

    public Gasto(double valor, String descricao) {
        super(valor, descricao);
    }

    @Override
    public void aplicar(Usuario usuario) {
        usuario.setSaldo(usuario.getSaldo() - getValor());
    }
}
