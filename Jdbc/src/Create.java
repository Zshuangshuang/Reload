import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @Auther:ZouSS
 * @Description:
 * @Date 2020-12-22 18:37
 */
public class Create {

    public static void main(String[] args)throws ClassNotFoundException, SQLException {
      Class.forName("com.mysql.jdbc.Driver");
      String url = "jdbc:mysql:///demo";
      Connection  connection = DriverManager.getConnection(url,"root","261919Zss");
      Statement statement = connection.createStatement();
      String sql = "create table student (id int primary key auto_increment,name varchar(20),sex varchar(3),age int)";
      statement.executeUpdate(sql);
    }
}
