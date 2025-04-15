package com.grupoFiapo.fintech.models;

import java.util.Scanner;

public class RegistroLogin {
    private static final Scanner scanner = new Scanner(System.in);
    // Variável para armazenar o usuário registrado (simulação, sem persistência real)
    private static Usuario usuarioRegistrado;

    // Método para registrar o usuário interativamente (sem exibir os dados)
    public static void registrarUsuario() {
        System.out.println("== Registro de Usuário ==");
        String nome = Usuario.validarNome();
        String email = Usuario.validarEmail();
        String telefone = Usuario.lerTelefone();
        String cpf = Usuario.validarCPF();
        String senha = Usuario.validarSenha();
        String cep = Usuario.validarCEP();
        String estado = Usuario.validarEstado();
        String cidade = Usuario.validarCidade();
        String bairro = Usuario.validarBairro();
        String logradouro = Usuario.validarLogradouro();
        String numero = Usuario.validarNumero();
        String complemento = Usuario.lerComplemento();

        usuarioRegistrado = new Usuario(nome, email, telefone, cpf, senha, complemento,
                logradouro, numero, bairro, cidade, estado, cep);

        System.out.println("\nUsuário registrado com sucesso!");
    }

    // Método para exibir as informações do usuário
    public static void exibirUsuario() {
        System.out.println("\n--- Dados do Usuário ---");
        if (usuarioRegistrado == null) {
            System.out.println("Nenhum usuário cadastrado.");
        } else {
            System.out.println("Nome: " + usuarioRegistrado.getNome());
            System.out.println("Email: " + usuarioRegistrado.getEmail());
            System.out.println("Telefone: " + (usuarioRegistrado.getTelefone() == null ? "Não informado" : usuarioRegistrado.getTelefone()));
            System.out.println("CPF: " + usuarioRegistrado.getCpf());
            System.out.println("CEP: " + usuarioRegistrado.getCep());
            System.out.println("Estado: " + usuarioRegistrado.getEstado());
            System.out.println("Cidade: " + usuarioRegistrado.getCidade());
            System.out.println("Bairro: " + usuarioRegistrado.getBairro());
            System.out.println("Logradouro: " + usuarioRegistrado.getLogradouro());
            System.out.println("Número: " + usuarioRegistrado.getNumero());
            System.out.println("Complemento: " + (usuarioRegistrado.getComplemento() == null ? "Não informado" : usuarioRegistrado.getComplemento()));
        }
    }

    // Método para realizar login com loop até sucesso
    public static void realizarLogin() {
        System.out.println("== Login ==");
        if (usuarioRegistrado == null) {
            System.out.println("Nenhum usuário registrado. Por favor, registre primeiro.");
            return;
        }

        while (true) {
            System.out.print("Digite seu email: ");
            String email = scanner.nextLine();
            System.out.print("Digite sua senha: ");
            String senha = scanner.nextLine();

            if (usuarioRegistrado.getEmail().equals(email) && usuarioRegistrado.getSenha().equals(senha)) {
                System.out.println("Login realizado com sucesso! Bem-vindo(a), " + usuarioRegistrado.getNome() + "!");
                break;
            } else {
                System.out.println("Email ou senha incorretos. Tente novamente.");
            }
        }
    }

    // Método para retornar o usuário registrado (se necessário)
    public static Usuario getUsuarioRegistrado() {
        return usuarioRegistrado;
    }
}
