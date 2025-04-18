package com.grupoFiapo.fintech;
import com.grupoFiapo.fintech.dao.EnderecoDao;
import com.grupoFiapo.fintech.models.Endereco;

import java.sql.SQLException;
import java.util.List;

public class TestEndereco {
    public static void main(String[] args) {
        EnderecoDao dao = null;

        try {
            dao = new EnderecoDao();

            System.out.println("Apagando registros...");
            // Apagar registros existentes
            dao.deleteAll();
            System.out.println("Registros apagados.");

            // Inserindo 5 registros
            dao.insert(new Endereco(1, 12345678, "Rua das Flores", "SP", "São Paulo", "Centro", "123", "Apto 10", 0));
            dao.insert(new Endereco(2, 87654321, "Av. Paulista", "SP", "São Paulo", "Bela Vista", "456", "Bloco B", 0));
            dao.insert(new Endereco(3, 11223344, "Rua das Palmeiras", "RJ", "Rio de Janeiro", "Copacabana", "789", "", 0));
            dao.insert(new Endereco(4, 99887766, "Av. Brasil", "MG", "Belo Horizonte", "Savassi", "321", "Casa", 0));
            dao.insert(new Endereco(5, 44556677, "Rua dos Lírios", "RS", "Porto Alegre", "Moinhos", "654", "Cobertura", 0));

            // Recuperando todos os registros
            List<Endereco> lista = dao.getAll();

            // Exibindo os dados
            for (Endereco e : lista) {
                System.out.println("ID: " + e.getIdEndereco());
                System.out.println("ID do Usuário: " + e.getIdUsuario());
                System.out.println("CEP: " + e.getCep());
                System.out.println("Logradouro: " + e.getLogradouro());
                System.out.println("Estado: " + e.getEstado());
                System.out.println("Cidade: " + e.getCidade());
                System.out.println("Bairro: " + e.getBairro());
                System.out.println("Residência: " + e.getResidencia());
                System.out.println("Complemento: " + e.getComplemento());
                System.out.println("-----------------------------");
            }

        } catch (SQLException e) {
            System.err.println("Erro no banco de dados: " + e.getMessage());
        } finally {
            // Garantir que a conexão seja fechada
            if (dao != null) {
                try {
                    dao.fechar();
                } catch (SQLException e) {
                    System.err.println("Erro ao fechar a conexão: " + e.getMessage());
                }
            }
        }
    }
}
