import db.DBUtil;

import java.sql.Connection;

public class Main {
    public static void main(String[] args) {
        Connection conn = DBUtil.getConnection();

        if (conn != null) {
            System.out.println("数据库连接成功！");
            DBUtil.close(conn);
        } else {
            System.out.println("数据库连接失败！");
        }
    }
}