package com.grupoFiapo.fintech;  // Pacote de testes

import com.grupoFiapo.fintech.models.Despesa;
import com.grupoFiapo.fintech.models.Receita;

import java.time.LocalDate;

public class TestTransacao {
    public static void main(String[] args) {
        // Teste de criação de objeto Despesa
        System.out.println("==== Teste de Despesa ====");
        Despesa despesa = new Despesa("Supermercado", 250.00, "Alimentação", LocalDate.of(2025, 3, 20));
        despesa.exibirInformacoes();

        // Teste de alteração de despesa
        System.out.println("\nAlterando a despesa...");
        despesa.setValor(300.00);
        despesa.setCategoria("Saúde");
        despesa.marcarComoPago();  // Marcando como paga
        despesa.exibirInformacoes();

        // Teste de criação de objeto Receita
        System.out.println("\n==== Teste de Receita ====");
        Receita receita = new Receita("Salário", 3500.00, LocalDate.of(2025, 3, 15), "Empresa XYZ", "categoria");
        receita.exibirInformacoes();

        // Teste de alteração de receita
        System.out.println("\nAlterando a receita...");
        receita.setValor(4000.00);
        receita.setDescricao("Salário Março");
        receita.exibirInformacoes();

        // Teste de valores negativos para verificar exceções
        try {
            System.out.println("\n==== Teste de valores negativos ====");
            despesa.setValor(-50.00);  // Definir um valor negativo (deve lançar exceção ou ser tratado)
        } catch (IllegalArgumentException e) {
            System.out.println("Erro ao definir valor negativo: " + e.getMessage());
        }

        // Teste de status de pagamento da despesa
        System.out.println("\nVerificando status de pagamento da despesa...");
        if (despesa.isPago()) {
            System.out.println("A despesa foi paga com sucesso.");
        } else {
            System.out.println("A despesa ainda está pendente.");
        }

        // Teste de exibição de informações de despesa com status
        System.out.println("\nInformações finais da despesa após testes:");
        despesa.exibirInformacoes();

        // Teste de exibição de informações de receita
        System.out.println("\nInformações finais da receita após testes:");
        receita.exibirInformacoes();
    }
}
