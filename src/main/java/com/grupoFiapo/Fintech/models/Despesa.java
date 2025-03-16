package com.grupoFiapo.Fintech.models;

import java.time.LocalDate;

public class Despesa extends Transacao {
        private boolean pago;

    // Construtor
    public Despesa(String descricao, double valor, String categoria, LocalDate data) {
        super(descricao, valor, data, categoria);
        this.categoria = categoria;
        this.pago = false; // Por padrão, começa como não paga
    }

    // Getters e Setters

    public boolean isPago() {
        return pago;
    }

    public void marcarComoPago() {
        this.pago = true;
    }

    // Implementação do metodo exibirInformacoes()
    @Override
    public void exibirInformacoes() {
        System.out.println("===== DESPESA =====");
        System.out.println("Descrição: " + descricao);
        System.out.println("Valor: R$" + String.format("%.2f", valor));
        System.out.println("Categoria: " + categoria);
        System.out.println("Data: " + data);

        // Verificando se a despesa está paga ou não
        if (pago) {
            System.out.println("Status: Paga ✅");
        } else {
            System.out.println("Status: Pendente ❌");
        }

        System.out.println("====================");
    }
}
