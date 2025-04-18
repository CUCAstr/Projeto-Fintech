package com.grupoFiapo.fintech.models;

import java.util.Date;

public class Metas {
    private Long id;
    private Long cpfUsuario;
    private String nome;
    private double valor;
    private Date dataMeta;
    private String descricao;

    //construtor

    public Metas(Long id, Long cpfUsuario, String nome, double valor, Date data, String descricao) {
        this.id = id;
        this.cpfUsuario = cpfUsuario;
        this.nome = nome;
        this.valor = valor;
        this.dataMeta = data;
        this.descricao = descricao;
    }

    public Metas(Long cpfUsuario, String nome, double valor, Date data, String descricao) {
        this(null, cpfUsuario, nome, valor, data, descricao);
    }

    //getters e setters

    public Metas() {
    }

    public long getId() {
        return id;
    }

    public long getCpfUsuario() {
        return cpfUsuario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public Date getDataMeta() {
        return dataMeta;
    }

    public void setDataMeta(Date dataMeta) {
        this.dataMeta = dataMeta;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

}
