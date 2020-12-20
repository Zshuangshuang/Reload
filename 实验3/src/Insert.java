import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @Auther:ZouSS
 * @Description:
 * @Date 2020-12-20 19:29
 */
public class Insert {
    public static void main(String[] args)throws ClassNotFoundException, SQLException {
        String url = "jdbc:mysql:///test";
        Class.forName("com.mysql.jdbc.Driver");
        Connection connection = DriverManager.getConnection(url,"root","261919Zss");
        String[] sql = new String[6];
        sql[0] = "insert into staff values(null,'李二二','男',18,555.5)";
        sql[1] = "insert into staff values(null,'王一一','女',48,1234.1)";
        sql[2] = "insert into staff values(null,'蔡文姬','女',25,4567.2)";
        sql[3] = "insert into staff values(null,'小鲁班','男',38,1234.5)";
        sql[4] = "insert into staff values(null,'花仙子','女',45,1266.8)";
        Statement statement = connection.createStatement();
        for (int i = 0; i < 5; i++) {
            statement.executeUpdate(sql[i]);
        }
    }
}
