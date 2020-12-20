import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @Auther:ZouSS
 * @Description:
 * @Date 2020-12-20 19:36
 */
public class Update {
    public static void main(String[] args)throws ClassNotFoundException, SQLException {
        String url = "jdbc:mysql:///test";
        Class.forName("com.mysql.jdbc.Driver");
        Connection connection = DriverManager.getConnection(url,"root","261919Zss");
        Statement statement = connection.createStatement();
        String[] sql = new String[2];
        sql[0] = "update staff set salary = salary+ (salary*0.15) where age > 45";
        sql[1] = "update staff set salary = salary+(salary*0.1) where age <= 45";
        for (int i = 0; i < 2; i++) {
            statement.executeUpdate(sql[i]);
        }
    }
}
