import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @Auther:ZouSS
 * @Description:
 * @Date 2020-12-20 21:40
 */
public class Delete {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        String url = "jdbc:mysql:///test";
        Connection connection = DriverManager.getConnection(url,"root","261919Zss");
        Statement statement = connection.createStatement();
        String sql = "delete from staff where salary >= 1500";
        statement.executeUpdate(sql);
    }
}
