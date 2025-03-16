package com.grupoFiapo.Fintech.models;

import java.time.LocalDate;

public abstract class Transacao {
    protected String descricao;
    protected double valor;
    protected LocalDate data;
    protected String categoria;

    // Construtor
    public Transacao(String descricao, double valor, LocalDate data, String categoria) {
        this.descricao = descricao;
        this.valor = valor;
        this.data = data;
        this.categoria = categoria;
    }

    // Getters e Setters
    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    // Metodo abstrato para exibir informações (será implementado nas subclasses)
    public abstract void exibirInformacoes();
}
