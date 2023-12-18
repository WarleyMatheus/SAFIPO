package com.wmsoftware.safipo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class conexaoSql {

    private static final String URL = "jdbc:mysql://localhost:3306/usuarios";
    private static final String USUARIO = "usuario";
    private static final String SENHA = "senha";

    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(URL, USUARIO, SENHA);
        } catch (SQLException e) {
            throw new RuntimeException("Falha na conexão com o banco de dados!", e);
        }
    }
}