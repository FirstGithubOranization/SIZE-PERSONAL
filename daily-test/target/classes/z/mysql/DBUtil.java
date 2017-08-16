package z.mysql;

import java.sql.*;
import java.util.Properties;

/**
 * TITLE:
 *
 * @author ZhongHe.Zh
 * @time 2017-07-28 15:26
 **/
public class DBUtil {
    private static Connection conn = null;
    private static Properties pro = new Properties();

    static {
        try {
            pro.load(DBUtil.class.getClassLoader().getResourceAsStream("DBUtil.properties"));
            Class.forName("com.mysql.jdbc.Driver");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static Connection getConn() {
        try {
            conn = DriverManager.getConnection(
                    "jdbc:mysql://192.168.1.197:3306/size001?useUnicode=true&amp;characterEncoding=utf-8&amp;zeroDateTimeBehavior=convertToNull",
                    "root",
                    "123456");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }

    public static void close(ResultSet rs, PreparedStatement ps, Connection conn) {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (ps != null) {
            try {
                ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        Connection connection = getConn();
        System.out.println(connection);
    }

}
