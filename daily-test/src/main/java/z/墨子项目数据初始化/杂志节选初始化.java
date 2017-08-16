package z.墨子项目数据初始化;

import z.util.UUIDUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * TITLE:
 *
 * @author ZhongHe.Zh
 * @time 2017-07-05 19:50
 **/
public class 杂志节选初始化 {
    private static String driverName = "com.mysql.jdbc.Driver";
    private static String url = "jdbc:mysql://192.168.1.197:3306/size001?user=root&password=123456&useUnicode=true&characterEncoding=utf-8";
    private static String user = "root";
    private static String pwd = "123456";
    private static String monthly_sql = "select c_id from t_monthly";
    private static String base_char = "调查显示，《男人装》以21%的市场份额和76%的覆盖率牢牢占据着第一的宝座，成为国内最受男人欢迎的男性时尚类杂志，《男人装》是时尚集团在2004年推出的一本男性综合类时尚杂志，不仅填补了内地期刊市场男性杂志的空白，而且带来了男性杂志消费的新热潮，它开宗明义就是要做“男人的真性情杂志”，它填补了男性期刊市场的空缺，也填补了男性心理需要的空缺。到2012年8月，已经出版了整整一百期。而且在杂志网";
    private static String excerpt_sql = "insert into t_monthly_excerpt (c_id ,c_monthlyid,c_name,c_space,c_length,c_content,c_userid,c_audiourl,c_checkstatus ) values (?,?,?,?,?,?,?,?,?)";

    private static List<String> monthlyIds = new ArrayList<>();

    public static void main(String[] args) {
        Connection connection = null;
        try {
            Class.forName(driverName);
            connection = DriverManager.getConnection(url, user, pwd);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(monthly_sql);

            while (resultSet.next()) {
                String id = resultSet.getString("c_id");
                monthlyIds.add(id);
            }
            for (String monthlyId :
                    monthlyIds) {
                for (int i = 1; i < 20; i++) {
                    PreparedStatement preparedStatement = connection.prepareStatement(excerpt_sql);
                    String id = UUIDUtil.getUUID();
                    String name = "节选" + i;
                    String space = (int) (Math.random() * 100) + "";
                    String length = (int) (Math.random() * 1000) + "";
                    int cont = (int) (Math.random() * 20);
                    StringBuffer content = new StringBuffer(base_char);
                    for (int j = 0; j  < cont; j ++) {
                        content.append(base_char);
                    }
                    String userid = "-0012";
                    String url = "/ksyun/2017/07/04/3d668f788f154fae8d01578c9bd58caa.mp3";
                    preparedStatement.setString(1, id);
                    preparedStatement.setString(2, monthlyId);
                    preparedStatement.setString(3, name);
                    preparedStatement.setString(4, space);
                    preparedStatement.setString(5, length);
                    preparedStatement.setString(6, content.toString());
                    preparedStatement.setString(7, userid);
                    preparedStatement.setString(8, url);
                    preparedStatement.setString(9, "2");
                    preparedStatement.executeUpdate();
                    System.out.println("-=======================");
                    Thread.sleep(1000);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
