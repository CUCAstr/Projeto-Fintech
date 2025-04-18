package com.grupoFiapo.fintech;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TestConexao {

    private static final String URL = "jdbc:oracle:thin:@oracle.fiap.com.br:1521:orcl";
    private static final String USUARIO = "RM560885";
    private static final String SENHA = "080502";

    public static void main(String[] args) {

        try {
            Connection conexao = DriverManager.getConnection("jdbc:oracle:thin:@oracle.fiap.com.br:1521:orcl","RM560885","080502");
            System.out.println("Conectado com sucesso!");
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }
}


