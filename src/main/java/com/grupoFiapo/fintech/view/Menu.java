package com.grupoFiapo.fintech.view;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import com.grupoFiapo.fintech.models.RegistroLogin;

// Certifique-se de importar as classes do pacote correto, por exemplo:
import com.grupoFiapo.fintech.models.Usuario;
import com.grupoFiapo.fintech.models.Transacao;
import com.grupoFiapo.fintech.models.Despesa;
import com.grupoFiapo.fintech.models.Receita;

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
                    RegistroLogin.registrarUsuario();
                    break;

                case 2:
                    // Exibir Usuário
                    RegistroLogin.exibirUsuario();
                    break;

                case 3:
                    // Realizar Login
                    RegistroLogin.realizarLogin();
                    break;

                case 4:
                    // Cadastrar Despesa
                    System.out.println("\n--- Cadastro de Despesa ---");

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
