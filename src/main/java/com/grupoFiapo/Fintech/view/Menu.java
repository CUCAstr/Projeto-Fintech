import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Certifique-se de importar as classes do pacote correto, por exemplo:
import com.grupoFiapo.Fintech.models.Usuario;
import com.grupoFiapo.Fintech.models.Transacao;
import com.grupoFiapo.Fintech.models.Despesa;
import com.grupoFiapo.Fintech.models.Receita;

public class Menu {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Usuario usuario = null;
        List<Transacao> transacoes = new ArrayList<>(); // Armazena todas as transações

        int op;
        do {
            System.out.println("\n===== MENU FINANCEIRO =====");
            System.out.println("1 - Cadastrar Usuário");
            System.out.println("2 - Exibir Usuário");
            System.out.println("3 - Realizar Login");
            System.out.println("4 - Cadastrar Despesa");
            System.out.println("5 - Exibir Histórico de Despesas");
            System.out.println("6 - Controle de Saldo (Depositar/Sacar)");
            System.out.println("7 - Cadastrar Receita");
            System.out.println("8 - Exibir Histórico de Receitas");
            System.out.println("9 - Finalizar Programa");
            System.out.print("Escolha uma opção: ");
            op = Integer.parseInt(sc.nextLine());

            switch (op) {
                case 1:
                    // Cadastrar Usuário
                    System.out.println("\n--- Cadastro de Usuário ---");
                    System.out.print("Digite o nome do usuário: ");
                    String nome = sc.nextLine();
                    System.out.print("Digite o email do usuário: ");
                    String email = sc.nextLine();
                    System.out.print("Digite o telefone do usuário: ");
                    String telefone = sc.nextLine();
                    System.out.print("Digite o CPF do usuário (11 dígitos): ");
                    String cpf = sc.nextLine();
                    System.out.print("Digite a senha do usuário (mínimo 6 caracteres): ");
                    String senha = sc.nextLine();
                    System.out.print("Digite o complemento (opcional): ");
                    String complemento = sc.nextLine();
                    System.out.print("Digite o logradouro: ");
                    String logradouro = sc.nextLine();
                    System.out.print("Digite o número: ");
                    String numero = sc.nextLine();
                    System.out.print("Digite o bairro: ");
                    String bairro = sc.nextLine();
                    System.out.print("Digite a cidade: ");
                    String cidade = sc.nextLine();
                    System.out.print("Digite o estado (ex: SP): ");
                    String estado = sc.nextLine();
                    System.out.print("Digite o CEP: ");
                    String cep = sc.nextLine();

                    try {
                        usuario = new Usuario(nome, email, telefone, cpf, senha, complemento,
                                logradouro, numero, bairro, cidade, estado, cep);
                        System.out.println("Usuário cadastrado com sucesso!");
                    } catch (IllegalArgumentException e) {
                        System.out.println("Erro ao cadastrar usuário: " + e.getMessage());
                    }
                    break;

                case 2:
                    // Exibir Usuário
                    System.out.println("\n--- Dados do Usuário ---");
                    if (usuario == null) {
                        System.out.println("Nenhum usuário cadastrado.");
                    } else {
                        System.out.println("Nome: " + usuario.getNome());
                        System.out.println("Email: " + usuario.getEmail());
                        System.out.println("Telefone: " + usuario.getTelefone());
                        System.out.println("CPF: " + usuario.getCpf());
                        System.out.println("Endereço: " + usuario.getLogradouro() + ", "
                                + usuario.getNumero() + ", " + usuario.getBairro() + ", "
                                + usuario.getCidade() + " - " + usuario.getEstado() + ", "
                                + usuario.getCep());
                        System.out.println("Saldo atual: R$" + calcularSaldo(transacoes));
                    }
                    break;

                case 3:
                    // Realizar Login
                    System.out.println("\n--- Login ---");
                    if (usuario == null) {
                        System.out.println("Nenhum usuário cadastrado.");
                    } else {
                        System.out.print("Digite o email: ");
                        String loginEmail = sc.nextLine();
                        System.out.print("Digite a senha: ");
                        String loginSenha = sc.nextLine();
                        // Supondo que os getters existam
                        if (usuario.getEmail().equals(loginEmail) && usuario.getSenha().equals(loginSenha)) {
                            System.out.println("Login efetuado com sucesso!");
                        } else {
                            System.out.println("Email ou senha incorretos.");
                        }
                    }
                    break;

                case 4:
                    // Cadastrar Despesa
                    System.out.println("\n--- Cadastro de Despesa ---");
                    if (usuario == null) {
                        System.out.println("Cadastre um usuário primeiro.");
                    } else {
                        System.out.print("Digite a descrição da despesa: ");
                        String descDespesa = sc.nextLine();
                        System.out.print("Digite o valor da despesa: ");
                        double valorDespesa = Double.parseDouble(sc.nextLine());
                        System.out.print("Digite a categoria da despesa: ");
                        String categoriaDespesa = sc.nextLine();
                        System.out.print("Digite a data da despesa (yyyy-MM-dd): ");
                        LocalDate dataDespesa = LocalDate.parse(sc.nextLine());

                        Despesa despesa = new Despesa(descDespesa, valorDespesa, categoriaDespesa, dataDespesa);
                        // A despesa inicia como não paga (pago = false)
                        transacoes.add(despesa);
                        System.out.println("Despesa cadastrada com sucesso!");
                    }
                    break;

                case 5:
                    // Exibir Histórico de Despesas
                    System.out.println("\n--- Histórico de Despesas ---");
                    boolean existeDespesa = false;
                    for (Transacao t : transacoes) {
                        if (t instanceof Despesa) {
                            t.exibirInformacoes();
                            existeDespesa = true;
                        }
                    }
                    if (!existeDespesa) {
                        System.out.println("Nenhuma despesa cadastrada.");
                    }
                    break;

                case 6:
                    // Controle de Saldo: mostrar saldo e permitir depósito/saque
                    System.out.println("\n--- Controle de Saldo ---");
                    double saldoAtual = calcularSaldo(transacoes);
                    System.out.println("Saldo atual: R$" + saldoAtual);
                    System.out.println("1 - Depositar");
                    System.out.println("2 - Sacar");
                    System.out.print("Escolha uma operação: ");
                    int opSaldo = Integer.parseInt(sc.nextLine());
                    if (opSaldo == 1) {
                        System.out.print("Digite o valor para depositar: ");
                        double valorDep = Double.parseDouble(sc.nextLine());
                        // Depositar é tratado como uma Receita com descrição fixa
                        Receita deposito = new Receita("Depósito", valorDep, LocalDate.now(), "Sistema", "Depósito");
                        transacoes.add(deposito);
                        System.out.println("Depósito realizado com sucesso!");
                    } else if (opSaldo == 2) {
                        System.out.print("Digite o valor para sacar: ");
                        double valorSaque = Double.parseDouble(sc.nextLine());
                        if (saldoAtual >= valorSaque) {
                            // Sacar é tratado como uma Despesa com descrição fixa; marcamos como paga
                            Despesa saque = new Despesa("Saque", valorSaque, "Saque", LocalDate.now());
                            saque.marcarComoPago();
                            transacoes.add(saque);
                            System.out.println("Saque realizado com sucesso!");
                        } else {
                            System.out.println("Saldo insuficiente para saque.");
                        }
                    } else {
                        System.out.println("Opção inválida para controle de saldo.");
                    }
                    break;

                case 7:
                    // Cadastrar Receita
                    System.out.println("\n--- Cadastro de Receita ---");
                    if (usuario == null) {
                        System.out.println("Cadastre um usuário primeiro.");
                    } else {
                        System.out.print("Digite a descrição da receita: ");
                        String descReceita = sc.nextLine();
                        System.out.print("Digite o valor da receita: ");
                        double valorReceita = Double.parseDouble(sc.nextLine());
                        System.out.print("Digite a data da receita (yyyy-MM-dd): ");
                        LocalDate dataReceita = LocalDate.parse(sc.nextLine());
                        System.out.print("Digite a fonte da receita (ex: Salário): ");
                        String fonte = sc.nextLine();
                        System.out.print("Digite a categoria da receita: ");
                        String categoriaReceita = sc.nextLine();

                        Receita receita = new Receita(descReceita, valorReceita, dataReceita, fonte, categoriaReceita);
                        transacoes.add(receita);
                        System.out.println("Receita cadastrada com sucesso!");
                    }
                    break;

                case 8:
                    // Exibir Histórico de Receitas
                    System.out.println("\n--- Histórico de Receitas ---");
                    boolean existeReceita = false;
                    for (Transacao t : transacoes) {
                        if (t instanceof Receita) {
                            t.exibirInformacoes();
                            existeReceita = true;
                        }
                    }
                    if (!existeReceita) {
                        System.out.println("Nenhuma receita cadastrada.");
                    }
                    break;

                case 9:
                    System.out.println("Finalizando Programa.");
                    break;

                default:
                    System.out.println("Opção inválida.");
            }
        } while (op != 9);

        sc.close();
    }

    // Método auxiliar para calcular o saldo atual com base nas transações cadastradas.
    public static double calcularSaldo(List<Transacao> transacoes) {
        double saldo = 0.0;
        for (Transacao t : transacoes) {
            if (t instanceof Receita) {
                saldo += t.getValor();
            } else if (t instanceof Despesa) {
                saldo -= t.getValor();
            }
        }
        return saldo;
    }
}
