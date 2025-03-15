import java.util.Scanner;

public class Menu {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Usuario usuario = new Usuario();
        ControleFinanceiro controle = new ControleFinanceiro(usuario);

        int op;
        do {
            System.out.println("\nEscolha uma opção:");
            System.out.println("1 - Cadastrar Usuário");
            System.out.println("2 - Exibir Usuário");
            System.out.println("3 - Realizar Login");
            System.out.println("4 - Cadastrar Gasto");
            System.out.println("5 - Exibir Histórico de Gastos");
            System.out.println("6 - Controle de Saldo");
            System.out.println("7 - Finalizar Programa");
            op = sc.nextInt();

            switch (op) {
                case 1:
                    System.out.println("Digite o nome do usuário: ");
                    String nome = sc.next() + sc.nextLine();
                    System.out.println("Digite o email do usuário: ");
                    String email = sc.next() + sc.nextLine();
                    System.out.println("Digite o telefone do usuário: ");
                    String telefone = sc.next() + sc.nextLine();
                    System.out.println("Digite o CPF do usuário: ");
                    String cpf = sc.next() + sc.nextLine();
                    System.out.println("Digite a senha do usuário: ");
                    String senha = sc.next();
                    System.out.println("Digite o saldo inicial do usuário: ");
                    double saldo = sc.nextDouble();

                    usuario.setNome(nome);
                    usuario.setEmail(email);
                    usuario.setTelefone(telefone);
                    usuario.setCpf(cpf);
                    usuario.setSenha(senha);
                    usuario.setSaldo(saldo);

                    System.out.println("Digite as informações do endereço do usuário:");
                    System.out.println("Digite o logradouro: ");
                    String logradouro = sc.next() + sc.nextLine();
                    System.out.println("Digite o número: ");
                    String numero = sc.next() + sc.nextLine();
                    System.out.println("Digite o bairro: ");
                    String bairro = sc.next() + sc.nextLine();
                    System.out.println("Digite a cidade: ");
                    String cidade = sc.next() + sc.nextLine();
                    System.out.println("Digite o estado: ");
                    String estado = sc.next() + sc.nextLine();
                    System.out.println("Digite o CEP: ");
                    String cep = sc.next();

                    Endereco endereco = new Endereco();
                    endereco.setLogradouro(logradouro);
                    endereco.setNumero(numero);
                    endereco.setBairro(bairro);
                    endereco.setCidade(cidade);
                    endereco.setEstado(estado);
                    endereco.setCep(cep);

                    usuario.setEndereco(endereco);
                    break;

                case 2:
                    System.out.println("Dados do Usuário:");
                    System.out.println("Nome: " + usuario.getNome());
                    System.out.println("Email: " + usuario.getEmail());
                    System.out.println("Telefone: " + usuario.getTelefone());
                    System.out.println("CPF: " + usuario.getCpf());
                    System.out.println("Saldo: R$" + usuario.getSaldo());

                    if (usuario.getEndereco() != null) {
                        System.out.println("\nEndereço:");
                        System.out.println("Logradouro: " + usuario.getEndereco().getLogradouro());
                        System.out.println("Número: " + usuario.getEndereco().getNumero());
                        System.out.println("Bairro: " + usuario.getEndereco().getBairro());
                        System.out.println("Cidade: " + usuario.getEndereco().getCidade());
                        System.out.println("Estado: " + usuario.getEndereco().getEstado());
                        System.out.println("CEP: " + usuario.getEndereco().getCep());
                    } else {
                        System.out.println("Endereço não cadastrado.");
                    }
                    break;

                case 3:
                    System.out.println("Vamos realizar o login!");
                    System.out.println("Digite o email do usuário: ");
                    String loginEmail = sc.next() + sc.nextLine();
                    System.out.println("Digite a senha do usuário: ");
                    String loginSenha = sc.next();
                    usuario.Login(loginEmail, loginSenha);
                    break;

                case 4:
                    System.out.println("Digite o valor do gasto:");
                    double valorGasto = sc.nextDouble();
                    System.out.println("Digite a descrição do gasto:");
                    String descricaoGasto = sc.next() + sc.nextLine();

                    Gasto novoGasto = new Gasto(valorGasto, descricaoGasto);
                    controle.cadastrarTransacao(novoGasto);

                    System.out.println("Gasto cadastrado com sucesso. Novo saldo: R$" + usuario.getSaldo());
                    break;

                case 5:
                    System.out.println("Histórico de Gastos:");
                    if (controle.getTransacoes().isEmpty()) {
                        System.out.println("Nenhum gasto cadastrado.");
                    } else {
                        for (Transacao t : controle.getTransacoes()) {
                            if (t instanceof Gasto) {
                                System.out.println("Valor: R$" + t.getValor()
                                        + " | Descrição: " + t.getDescricao());
                            }
                        }
                    }
                    break;

                case 6:
                    System.out.println("Controle de Saldo:");
                    System.out.println("Escolha a operação: ");
                    System.out.println("1 - Depositar");
                    System.out.println("2 - Sacar");
                    System.out.println("3 - Exibir Saldo Atual");
                    int opSaldo = sc.nextInt();
                    switch(opSaldo) {
                        case 1:
                            System.out.println("Digite o valor para depositar:");
                            double valorDeposito = sc.nextDouble();
                            usuario.setSaldo(usuario.getSaldo() + valorDeposito);
                            System.out.println("Depósito realizado. Novo saldo: R$" + usuario.getSaldo());
                            break;
                        case 2:
                            System.out.println("Digite o valor para sacar:");
                            double valorSaque = sc.nextDouble();
                            if (usuario.getSaldo() >= valorSaque) {
                                usuario.setSaldo(usuario.getSaldo() - valorSaque);
                                System.out.println("Saque realizado. Novo saldo: R$" + usuario.getSaldo());
                            } else {
                                System.out.println("Saldo insuficiente para saque.");
                            }
                            break;
                        case 3:
                            System.out.println("Saldo atual: R$" + usuario.getSaldo());
                            break;
                        default:
                            System.out.println("Opção inválida para controle de saldo.");
                    }
                    break;

                case 7:
                    System.out.println("Finalizando Programa");
                    break;

                default:
                    System.out.println("Opção Inválida");
            }
        } while (op != 7);

        sc.close();
    }
}
