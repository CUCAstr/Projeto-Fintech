package com.grupoFiapo.Fintech.models;

import java.time.LocalDate;

public class Receita extends Transacao {
    private String fonte;
    // Exemplo: Salário, Aluguel, Investimentos

    // Construtor
    public Receita(String descricao, double valor, LocalDate data, String fonte, String categoria) {
        super(descricao, valor, data, categoria);
        this.fonte = fonte;

    }

    // Getters e Setters
    public String getFonte() {
        return fonte;
    }

    public void setFonte(String fonte) {
        this.fonte = fonte;
    }

    // Implementação do metodo exibirInformacoes()
    @Override
    public void exibirInformacoes() {
        System.out.println("===== RECEITA =====");
        System.out.println("Descrição: " + descricao);
        System.out.println("Valor: R$" + String.format("%.2f", valor));
        System.out.println("Data: " + data);
        System.out.println("Fonte: " + fonte);
        System.out.println("====================");
    }
}
