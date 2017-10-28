package z.数据库优化;

import z.util.TimeUtil;

import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Random;

/**
 * TITLE:
 *
 * @author ZhongHe.Zh
 * @time 2017-09-16 15:56
 **/
public class DataBase {


    private static Connection getConn() {
        String driver = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/test";
        String username = "root";
        String password = "123456";
        Connection conn = null;
        try {
            Class.forName(driver); //classLoader,加载对应驱动
            conn = (Connection) DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }

    public static void main(String[] args) {
       new Thread(new InsertRun()).start();
       new Thread(new InsertRun()).start();
    }

    /**
     * 随机生成汉字
     *
     * @param startNum 大于多少字
     * @param endNum   小雨多少字
     *
     * @return 汉字字符串
     */
    private static String getRandomChar(int startNum, int endNum) {

        int times = (int) (Math.random() * (endNum - startNum)) + startNum;
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < times; i++) {
            int hightPos; //
            int lowPos;

            Random random = new Random();

            hightPos = (176 + Math.abs(random.nextInt(39)));
            lowPos = (161 + Math.abs(random.nextInt(93)));

            byte[] b = new byte[2];
            b[0] = (Integer.valueOf(hightPos)).byteValue();
            b[1] = (Integer.valueOf(lowPos)).byteValue();

            try {
                str.append(new String(b, "GBK"));
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
                System.out.println("错误");
            }
        }
        return str.toString();
    }

    private static String sql = "insert into person (name,info,dsc,time,isuse,one,two,three,fore,five,six,seven,eight,night,ten,eleven,twlf,thriteen,forteen,fivteen) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?); ";

    static class InsertRun implements Runnable {

        Connection connection = getConn();

        @Override
        public void run() {
            for (int i = 0; i < 1000000; i++)
                try {
                    PreparedStatement ps = connection.prepareStatement(sql);
                    ps.setString(1, getRandomChar(2, 3));
                    ps.setString(2, getRandomChar(10, 199));
                    ps.setString(3, getRandomChar(10, 199));
                    ps.setTimestamp(4, TimeUtil.getCurrentTimestamp());
                    ps.setInt(5, (int) (Math.random() * 2));
                    ps.setString(6, getRandomChar(100, 190));
                    ps.setString(7, getRandomChar(100, 190));
                    ps.setString(8, getRandomChar(100, 190));
                    ps.setString(9, getRandomChar(100, 190));
                    ps.setString(10, getRandomChar(100, 190));
                    ps.setString(11, getRandomChar(100, 190));
                    ps.setString(12, getRandomChar(100, 190));
                    ps.setString(13, getRandomChar(100, 190));
                    ps.setString(14, getRandomChar(100, 190));
                    ps.setString(15, getRandomChar(100, 190));
                    ps.setString(16, getRandomChar(100, 190));
                    ps.setString(17, getRandomChar(100, 190));
                    ps.setString(18, getRandomChar(100, 190));
                    ps.setString(19, getRandomChar(100, 190));
                    ps.setString(20, getRandomChar(100, 190));
                    ps.execute();
                    ps.close();
                    System.out.println("线程 " +Thread.currentThread().getName() +" 插入第  "+i+" 条数据完成....");
                } catch (SQLException e) {
                    e.printStackTrace();
                }
        }
    }
}

