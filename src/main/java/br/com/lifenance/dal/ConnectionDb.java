package br.com.lifenance.dal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Logger;

public class ConnectionDb {
    private static Connection connection = null;

    private ConnectionDb() {}

    public static Connection getConnection() {
        if (connection != null) return connection;

        String driver = "org.postgresql.Driver";
        String user = "postgres";
        String password = "admin";
        String url = "jdbc:postgresql://localhost:5432/lifenance_db";

        try {
            Class.forName(driver);
            connection = DriverManager.getConnection(url, user, password);
        } catch (SQLException | ClassNotFoundException error) {
            Logger.getLogger(ConnectionDb.class.getName()).log(java.util.logging.Level.SEVERE, null, error);
        }

        return connection;
    }
}
