package com.grupoFiapo.Fintech.models;

import java.time.LocalDate;

public class Despesa {
    private String descricao;
    private double valor;
    private String categoria;
    private LocalDate data;
    private boolean pago;

    // Construtor
    public Despesa(String descricao, double valor, String categoria, LocalDate data) {
        this.descricao = descricao;

        this.valor = valor;
        this.categoria = categoria;
        this.data = data;
        this.pago = false; // Por padrão, começa como não paga
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

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public boolean isPago() {
        return pago;
    }

    public void marcarComoPago() {
        this.pago = true;
    }

    // Metodo para exibir a despesa formatada
    @Override
    public String toString() {
        // Define o status da despesa: "Paga" se for verdadeira, "Pendente" se for falsa
        String status = pago ? "Paga" : "Pendente";

        // Retorna uma string com as informações formatadas
        return String.format("%s - R$%.2f (%s) | %s - %s",
                descricao, valor, categoria, data.toString(), status);
    }

    // Metodo para editar todos os campos de uma vez
    public void editarDespesa(double novoValor, String novaDescricao, LocalDate novaData) {
        this.valor = novoValor;
        this.descricao = novaDescricao;
        this.data = novaData;
    }
}
