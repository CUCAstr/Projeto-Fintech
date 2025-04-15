package com.grupoFiapo.fintech.models;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Usuario {
    private String nome;
    private String email;
    private String telefone;
    private String cpf;
    private String senha;
    private String complemento;
    private String logradouro;
    private String numero;
    private String bairro;
    private String cidade;
    private String estado;
    private String cep;

    // Scanner compartilhado para leitura interativa
    private static Scanner scanner = new Scanner(System.in);

    // Construtor que recebe os dados já validados
    public Usuario(String nome, String email, String telefone, String cpf, String senha, String complemento,
                   String logradouro, String numero, String bairro, String cidade, String estado, String cep) {
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.cpf = cpf;
        this.senha = senha;
        this.complemento = complemento;
        this.logradouro = logradouro;
        this.numero = numero;
        this.bairro = bairro;
        this.cidade = cidade;
        this.estado = estado;
        this.cep = cep;
    }

    // Método auxiliar para verificar se o campo não está vazio
    private static String validacaoVazio(String valor, String campo) {
        if (valor == null || valor.trim().isEmpty()) {
            throw new IllegalArgumentException("O campo " + campo + " é obrigatório.");
        }
        return valor.trim();
    }

    // ----------------- Métodos de validação interativos -----------------

    public static String validarNome() {
        while (true) {
            System.out.print("Digite seu nome: ");
            String nome = scanner.nextLine();
            try {
                nome = validacaoVazio(nome, "Nome");
                if (!nome.matches("^[A-Za-zÀ-ÿ\\s]+$")) {
                    throw new IllegalArgumentException("Nome deve conter apenas letras e espaços.");
                }
                return nome;
            } catch (IllegalArgumentException e) {
                System.out.println("Erro: " + e.getMessage());
            }
        }
    }

    public static String validarEmail() {
        while (true) {
            System.out.print("Digite seu email: ");
            String email = scanner.nextLine();
            try {
                email = validacaoVazio(email, "Email");
                if (!email.matches("^[\\w.-]+@[\\w.-]+\\.\\w+$")) {
                    throw new IllegalArgumentException("Email inválido. Formato esperado: exemplo@dominio.com.");
                }
                return email;
            } catch (IllegalArgumentException e) {
                System.out.println("Erro: " + e.getMessage());
            }
        }
    }

    public static String lerTelefone() {
        while (true) {
            System.out.print("Digite seu telefone (opcional): ");
            String telefone = scanner.nextLine();
            if (telefone.trim().isEmpty()) {
                return null;
            }
            try {
                telefone = validacaoVazio(telefone, "Telefone");
                if (!telefone.matches("^[0-9]+$")) {
                    throw new IllegalArgumentException("Telefone deve ser composto apenas de números.");
                }
                return telefone;
            } catch (IllegalArgumentException e) {
                System.out.println("Erro: " + e.getMessage());
            }
        }
    }

    public static String validarCPF() {
        while (true) {
            System.out.print("Digite seu CPF (11 dígitos): ");
            String cpf = scanner.nextLine();
            try {
                cpf = validacaoVazio(cpf, "CPF");
                if (!isCPF(cpf)) {
                    throw new IllegalArgumentException("CPF inválido.");
                }
                return cpf;
            } catch (IllegalArgumentException e) {
                System.out.println("Erro: " + e.getMessage());
            }
        }
    }

    // Validação do CPF usando os dígitos verificadores
    private static boolean isCPF(String CPF) {
        if (CPF.equals("00000000000") ||
                CPF.equals("11111111111") ||
                CPF.equals("22222222222") ||
                CPF.equals("33333333333") ||
                CPF.equals("44444444444") ||
                CPF.equals("55555555555") ||
                CPF.equals("66666666666") ||
                CPF.equals("77777777777") ||
                CPF.equals("88888888888") ||
                CPF.equals("99999999999") ||
                (CPF.length() != 11))
            return false;
        char dig10, dig11;
        int sm, i, r, num, peso;
        try {
            sm = 0;
            peso = 10;
            for (i = 0; i < 9; i++) {
                num = (int)(CPF.charAt(i) - 48);
                sm += num * peso;
                peso--;
            }
            r = 11 - (sm % 11);
            if ((r == 10) || (r == 11))
                dig10 = '0';
            else
                dig10 = (char)(r + 48);
            sm = 0;
            peso = 11;
            for (i = 0; i < 10; i++) {
                num = (int)(CPF.charAt(i) - 48);
                sm += num * peso;
                peso--;
            }
            r = 11 - (sm % 11);
            if ((r == 10) || (r == 11))
                dig11 = '0';
            else
                dig11 = (char)(r + 48);
            return (dig10 == CPF.charAt(9)) && (dig11 == CPF.charAt(10));
        } catch (InputMismatchException erro) {
            return false;
        }
    }

    public static String validarSenha() {
        while (true) {
            System.out.print("Digite sua senha: ");
            String senha = scanner.nextLine();
            try {
                senha = validacaoVazio(senha, "Senha");
                if (senha.length() < 6) {
                    throw new IllegalArgumentException("Senha deve conter ao menos 6 caracteres.");
                }
                return senha;
            } catch (IllegalArgumentException e) {
                System.out.println("Erro: " + e.getMessage());
            }
        }
    }

    public static String validarCEP() {
        while (true) {
            System.out.print("Digite seu CEP: ");
            String cep = scanner.nextLine();
            try {
                cep = validacaoVazio(cep, "CEP");
                if (!cep.matches("^\\d{5}-?\\d{3}$")) {
                    throw new IllegalArgumentException("CEP inválido. Formato: 12345-678 ou 12345678.");
                }
                return cep;
            } catch (IllegalArgumentException e) {
                System.out.println("Erro: " + e.getMessage());
            }
        }
    }

    public static String validarEstado() {
        while (true) {
            System.out.print("Digite seu estado (Ex: SP): ");
            String estado = scanner.nextLine();
            try {
                estado = validacaoVazio(estado, "Estado");
                String[] estadosBrasileiros = {"AC","AL","AP","AM","BA","CE","DF","ES","GO","MA","MT","MS","MG","PA","PB","PR","PE","PI","RJ","RN","RS","RO","RR","SC","SP","SE","TO"};
                if (!Arrays.asList(estadosBrasileiros).contains(estado.toUpperCase())) {
                    throw new IllegalArgumentException("Estado inválido. Ex: SP, RJ.");
                }
                return estado.toUpperCase();
            } catch (IllegalArgumentException e) {
                System.out.println("Erro: " + e.getMessage());
            }
        }
    }

    public static String validarCidade() {
        while (true) {
            System.out.print("Digite sua cidade: ");
            String cidade = scanner.nextLine();
            try {
                cidade = validacaoVazio(cidade, "Cidade");
                if (!cidade.matches("^[A-Za-zÀ-ÿ\\s]+$")) {
                    throw new IllegalArgumentException("Cidade deve conter apenas letras e espaços.");
                }
                return cidade;
            } catch (IllegalArgumentException e) {
                System.out.println("Erro: " + e.getMessage());
            }
        }
    }

    public static String validarBairro() {
        while (true) {
            System.out.print("Digite seu bairro: ");
            String bairro = scanner.nextLine();
            try {
                bairro = validacaoVazio(bairro, "Bairro");
                if (!bairro.matches("^[A-Za-zÀ-ÿ\\s]+$")) {
                    throw new IllegalArgumentException("Bairro deve conter apenas letras e espaços.");
                }
                return bairro;
            } catch (IllegalArgumentException e) {
                System.out.println("Erro: " + e.getMessage());
            }
        }
    }

    public static String validarLogradouro() {
        while (true) {
            System.out.print("Digite seu logradouro: ");
            String logradouro = scanner.nextLine();
            try {
                logradouro = validacaoVazio(logradouro, "Logradouro");
                if (!logradouro.matches("^[A-Za-zÀ-ÿ\\s]+$")) {
                    throw new IllegalArgumentException("Logradouro deve conter apenas letras e espaços.");
                }
                return logradouro;
            } catch (IllegalArgumentException e) {
                System.out.println("Erro: " + e.getMessage());
            }
        }
    }

    public static String validarNumero() {
        while (true) {
            System.out.print("Digite seu número: ");
            String numero = scanner.nextLine();
            try {
                numero = validacaoVazio(numero, "Número");
                if (!numero.matches("^[0-9]+$")) {
                    throw new IllegalArgumentException("Número deve ser composto apenas de números.");
                }
                return numero;
            } catch (IllegalArgumentException e) {
                System.out.println("Erro: " + e.getMessage());
            }
        }
    }

    public static String lerComplemento() {
        System.out.print("Digite seu complemento (opcional): ");
        String complemento = scanner.nextLine();
        if (complemento.trim().isEmpty()) {
            return null;
        }
        return complemento.trim();
    }

    // Getters
    public String getNome() {
        return nome;
    }
    public String getEmail() {
        return email;
    }
    public String getTelefone() {
        return telefone;
    }
    public String getCpf() {
        return cpf;
    }
    public String getSenha() {
        return senha;
    }
    public String getComplemento() {
        return complemento;
    }
    public String getLogradouro() {
        return logradouro;
    }
    public String getNumero() {
        return numero;
    }
    public String getBairro() {
        return bairro;
    }
    public String getCidade() {
        return cidade;
    }
    public String getEstado() {
        return estado;
    }
    public String getCep() {
        return cep;
    }
}
