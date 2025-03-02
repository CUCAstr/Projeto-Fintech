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
            System.out.println("5 - Cadastrar Investimento");
            System.out.println("6 - Exibir Histórico de Gastos");
            System.out.println("7 - Exibir Histórico de Investimentos");
            System.out.println("8 - Controle de Saldo");
            System.out.println("9 - Finalizar Programa");
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

                    usuario.nome = nome;
                    usuario.email = email;
                    usuario.telefone = telefone;
                    usuario.cpf = cpf;
                    usuario.senha = senha;
                    usuario.saldo = saldo;

                    System.out.println("Digite as informações do endereço do usuário:");
                    System.out.println("Digite o logradouro do endereço do usuário: ");
                    String logradouro = sc.next() + sc.nextLine();
                    System.out.println("Digite o número do endereço do usuário: ");
                    String numero = sc.next() + sc.nextLine();
                    System.out.println("Digite o bairro do endereço do usuário: ");
                    String bairro = sc.next() + sc.nextLine();
                    System.out.println("Digite a cidade do endereço do usuário: ");
                    String cidade = sc.next() + sc.nextLine();
                    System.out.println("Digite o estado do endereço do usuário: ");
                    String estado = sc.next() + sc.nextLine();
                    System.out.println("Digite o CEP do endereço do usuário: ");
                    String cep = sc.next();

                    Endereco endereco = new Endereco(logradouro, numero, bairro, cidade, estado, cep);
                    usuario.endereco = endereco;
                    break;

                case 2:
                    System.out.println("Dados do Usuário:");
                    System.out.println("Nome: " + usuario.nome);
                    System.out.println("Email: " + usuario.email);
                    System.out.println("Telefone: " + usuario.telefone);
                    System.out.println("CPF: " + usuario.cpf);
                    System.out.println("Saldo: R$" + usuario.saldo);
                    System.out.println("\nEndereço:");
                    System.out.println("Logradouro: " + usuario.endereco.logradouro);
                    System.out.println("Número: " + usuario.endereco.numero);
                    System.out.println("Bairro: " + usuario.endereco.bairro);
                    System.out.println("Cidade: " + usuario.endereco.cidade);
                    System.out.println("Estado: " + usuario.endereco.estado);
                    System.out.println("CEP: " + usuario.endereco.cep);
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
                    controle.cadastrarGasto(valorGasto, descricaoGasto);
                    System.out.println("Gasto cadastrado com sucesso. Novo saldo: R$" + usuario.saldo);
                    break;

                case 5:
                    System.out.println("Digite o valor inicial do investimento:");
                    double valorInicial = sc.nextDouble();
                    System.out.println("Digite o valor retornado do investimento:");
                    double valorRetornado = sc.nextDouble();
                    System.out.println("Digite a descrição do investimento:");
                    String descricaoInvestimento = sc.next() + sc.nextLine();
                    controle.cadastrarInvestimento(valorInicial, valorRetornado, descricaoInvestimento);
                    double lucro = valorRetornado - valorInicial;
                    System.out.println("Investimento cadastrado com sucesso. Lucro: " + lucro + ". Novo saldo: R$" + usuario.saldo);
                    break;

                case 6:
                    System.out.println("Histórico de Gastos:");
                    if (controle.getGastos().isEmpty()) {
                        System.out.println("Nenhum gasto cadastrado.");
                    } else {
                        for (Gastos gasto : controle.getGastos()){
                            System.out.println("Valor: R$" + gasto.getValor() + " | Descrição: " + gasto.getDescricao());
                        }
                    }
                    break;

                case 7:
                    System.out.println("Histórico de Investimentos:");
                    if (controle.getInvestimentos().isEmpty()) {
                        System.out.println("Nenhum investimento cadastrado.");
                    } else {
                        for (Investimentos invest : controle.getInvestimentos()){
                            System.out.println("Descrição: " + invest.getDescricao() + " | Lucro: R$" + invest.getLucro());
                        }
                    }
                    break;

                case 8:
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
                            usuario.saldo += valorDeposito;
                            System.out.println("Depósito realizado. Novo saldo: R$" + usuario.saldo);
                            break;
                        case 2:
                            System.out.println("Digite o valor para sacar:");
                            double valorSaque = sc.nextDouble();
                            if (usuario.saldo >= valorSaque) {
                                usuario.saldo -= valorSaque;
                                System.out.println("Saque realizado. Novo saldo: R$" + usuario.saldo);
                            } else {
                                System.out.println("Saldo insuficiente para saque.");
                            }
                            break;
                        case 3:
                            System.out.println("Saldo atual: R$" + usuario.saldo);
                            break;
                        default:
                            System.out.println("Opção inválida para controle de saldo.");
                    }
                    break;

                case 9:
                    System.out.println("Finalizando Programa");
                    break;

                default:
                    System.out.println("Opção Inválida");
            }
        } while (op != 9);

        sc.close();
    }
}
