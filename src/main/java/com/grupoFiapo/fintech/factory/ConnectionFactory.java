package com.grupoFiapo.fintech.factory;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

    private static final String URL = "jdbc:oracle:thin:@oracle.fiap.com.br:1521:orcl";
    private static final String USUARIO = "RM560885";
    private static final String SENHA = "080502";

    // Método para obter uma conexão com o banco de dados
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USUARIO, SENHA);
    }
}