package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public final class DBUtil {

    private static final String DEFAULT_URL =
            "jdbc:mysql://localhost:3306/component_stock_db"
                    + "?useSSL=false"
                    + "&serverTimezone=Asia/Shanghai"
                    + "&characterEncoding=utf8"
                    + "&allowPublicKeyRetrieval=true";

    private static final String URL = firstNonBlank(
            System.getProperty("db.url"),
            System.getenv("COMPONENT_STOCK_DB_URL"),
            DEFAULT_URL
    );

    private static final String USER = firstNonBlank(
            System.getProperty("db.user"),
            System.getenv("COMPONENT_STOCK_DB_USER"),
            "root"
    );

    private static final String PASSWORD = firstNonBlank(
            System.getProperty("db.password"),
            System.getenv("COMPONENT_STOCK_DB_PASSWORD"),
            ""
    );

    private DBUtil() {
    }

    public static Connection getConnection() {
        if (PASSWORD.isBlank()) {
            System.out.println("Missing database password. Set COMPONENT_STOCK_DB_PASSWORD or -Ddb.password.");
            return null;
        }

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (ClassNotFoundException e) {
            System.out.println("Database driver load failed.");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("Database connection failed.");
            e.printStackTrace();
        }

        return null;
    }

    public static void close(Connection conn) {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                System.out.println("Database connection close failed.");
                e.printStackTrace();
            }
        }
    }

    private static String firstNonBlank(String... values) {
        for (String value : values) {
            if (value != null && !value.isBlank()) {
                return value;
            }
        }
        return "";
    }
}
