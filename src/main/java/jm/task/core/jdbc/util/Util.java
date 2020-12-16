package jm.task.core.jdbc.util;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Util {

    private Connection connection;

    final String url = "jdbc:mysql://localhost:3306/jm_jdbc_test" +
            "?verifyServerCertificate=false" +
            "&useSSL=false" +
            "&requireSSL=false" +
            "&useLegacyDatetimeCode=false" +
            "&amp" +
            "&serverTimezone=UTC";
    final String userName = "root";
    final String pass = "1234";

    public Util() {
        try {
            connection = DriverManager.getConnection(url, userName, pass);
//            System.out.println("Соединение с БД установлено");
        } catch (SQLException e) {
            System.out.println("Не удалось поднять соединение с БД");
        }
    }

    public Connection getConnection() {
        return connection;
    }

    public void closeConnection() {
        try {
            connection.close();
        } catch (SQLException e) {
            System.out.println("Не удалось закрыть соединение");
        }
    }



}
