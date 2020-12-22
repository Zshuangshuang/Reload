import java.sql.*;
import java.util.Scanner;

/**
 * @Auther:ZouSS
 * @Description:
 * @Date 2020-12-22 18:47
 */
public class Insert {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        String url = "jdbc:mysql:///demo";
        Connection connection = DriverManager.getConnection(url,"root","261919Zss");
        Statement statement = connection.createStatement();
        String[] sql = new String[5];
        sql[0] = "insert into student values(null,'张三','男',12)";
        sql[1] = "insert into student values(null,'李四','男',21)";
        sql[2] = "insert into student values(null,'李依依','女',20)";
        for (int i = 0; i < 3; i++) {
            statement.executeUpdate(sql[i]);
        }
    }
}
