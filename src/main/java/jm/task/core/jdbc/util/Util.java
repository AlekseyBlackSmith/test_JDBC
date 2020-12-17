package jm.task.core.jdbc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Util {
    private static Connection connection;

    final static String url = "jdbc:mysql://localhost:3306/jm_jdbc_test" +
            "?verifyServerCertificate=false" +
            "&useSSL=false" +
            "&requireSSL=false" +
            "&useLegacyDatetimeCode=false" +
            "&amp" +
            "&serverTimezone=UTC";
    final static String userName = "root";
    final static String pass = "1234";

    public Util() {
    }

    public static Connection getConnection() {
        if (connection == null) {
            try {
                connection = DriverManager.getConnection(url, userName, pass);
            } catch (SQLException e) {
                System.out.println("Не удалось создать соединение с БД");
            }
        }
        return connection;

    }

}
