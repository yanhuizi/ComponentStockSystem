package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public final class DBUtil {
    private static final String URL = System.getProperty(
            "db.url",
            "jdbc:mysql://localhost:3306/component_stock_db?useSSL=false&serverTimezone=Asia/Shanghai&characterEncoding=utf8"
    );
    private static final String USER = System.getProperty("db.user", "root");
    private static final String PASSWORD = System.getProperty("db.password", "root");

    private DBUtil() {
    }

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
