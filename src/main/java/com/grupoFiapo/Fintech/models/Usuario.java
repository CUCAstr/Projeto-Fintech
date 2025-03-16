package com.grupoFiapo.Fintech.models;
import java.util.Arrays;
import java.util.InputMismatchException;

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

    public Usuario(String nome, String email, String telefone, String cpf, String senha, String complemento, String logradouro, String numero, String bairro, String cidade, String estado, String cep) {
        
        // Validação de campos obrigatórios
        this.nome = validarNome(nome);
        this.email = validarEmail(email);
        this.cpf = validarCPF(cpf);
        this.senha = validarSenha(senha);
        this.logradouro = validarTexto(logradouro, "Logradouro");
        this.numero = validarSomenteNumeros(numero, "Número");
        this.bairro = validarTexto(bairro, "Bairro");
        this.cidade = validarTexto(cidade, "Cidade");
        this.estado = validarEstado(estado);
        this.cep = validarCEP(cep);

        // Campo opcional: se telefone não for nulo ou vazio, valida que contenha apenas números
        this.telefone = (telefone != null && !telefone.trim().isEmpty()) ? validarSomenteNumeros(telefone, "Telefone") : null;
        this.complemento = (complemento != null) ? complemento.trim() : null;
    }

    // Metodo para verificação de campo obrigatório
    private String validacaoVazio(String valor, String campo) {
        if (valor == null || valor.trim().isEmpty()) {
            throw new IllegalArgumentException("O campo " + campo + " é obrigatório.");
        }
        return valor.trim();
    }

    // Validação de texto genérico (apenas chama o método validacaoVazio)
    private String validarTexto(String valor, String campo) {
        return validacaoVazio(valor, campo);
    }

    // Método genérico para validação de campos que devem conter apenas números
    private String validarSomenteNumeros(String valor, String campo) {
        valor = validacaoVazio(valor, campo);
        if (!valor.matches("^[0-9]+$")) {
            throw new IllegalArgumentException(campo + " deve ser composto apenas de números.");
        }
        return valor;
    }

    // Validação de nome (apenas letras)
    private String validarNome(String nome) {
        nome = validacaoVazio(nome, "Nome");
        if (nome.matches(".*\\d.*")) {
            throw new IllegalArgumentException("Nome deve conter apenas letras.");
        }
        return nome;
    }

    // Validação de email
    private String validarEmail(String email) {
        email = validacaoVazio(email, "Email");
        if (!email.matches("^[\\w.-]+@[\\w.-]+\\.\\w+$")) {
            throw new IllegalArgumentException("Email inválido.");
        }
        return email;
    }

    // Validação de CPF: retorna o próprio CPF se for válido; caso contrário, lança exception.
    private String validarCPF(String cpf) {
        cpf = validacaoVazio(cpf, "CPF");
        if (!isCPF(cpf)) {
            throw new IllegalArgumentException("CPF inválido: " + cpf);
        }
        return cpf;
    }
    private boolean isCPF(String CPF) {
        // Verifica se o CPF é formado por uma sequência de números iguais ou não possui 11 dígitos
        if (CPF.equals("00000000000") ||
            CPF.equals("11111111111") ||
            CPF.equals("22222222222") || CPF.equals("33333333333") ||
            CPF.equals("44444444444") || CPF.equals("55555555555") ||
            CPF.equals("66666666666") || CPF.equals("77777777777") ||
            CPF.equals("88888888888") || CPF.equals("99999999999") ||
            (CPF.length() != 11))
            return false;

        char dig10, dig11;
        int sm, i, r, num, peso;

        try {
            // Cálculo do 1º dígito verificador
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

            // Cálculo do 2º dígito verificador
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

            // Verifica se os dígitos calculados conferem com os dígitos informados.
            return (dig10 == CPF.charAt(9)) && (dig11 == CPF.charAt(10));
        } catch (InputMismatchException erro) {
            return false;
        }
    }

    // Validação de senha
    private String validarSenha(String senha) {
        senha = validacaoVazio(senha, "Senha");
        if (senha.length() < 6) {
            throw new IllegalArgumentException("Senha deve conter ao menos 6 caracteres.");
        }
        return senha;
    }

    // Validação de estado (sigla de 2 letras e válido)
    private String validarEstado(String estado) {
        estado = validacaoVazio(estado, "Estado");
        String[] estadosBrasileiros = {"AC", "AL", "AP", "AM", "BA", "CE", "DF", "ES", "GO", "MA", "MT", "MS", "MG", "PA", "PB", "PR", "PE", "PI", "RJ", "RN", "RS", "RO", "RR", "SC", "SP", "SE", "TO"};
        if (!Arrays.asList(estadosBrasileiros).contains(estado)) {
            throw new IllegalArgumentException("Estado inválido. Ex: SP, RJ.");
        }
        return estado;
    }

    // Validação de CEP
    private String validarCEP(String cep) {
        cep = validacaoVazio(cep, "CEP");
        if (!cep.matches("^\\d{5}-?\\d{3}$")) {
            throw new IllegalArgumentException("CEP inválido.");
        }
        return cep;
    }





    
}
