import java.math.BigDecimal;
import java.sql.*;

/**
 * @Auther:ZouSS
 * @Description:
 * @Date 2020-12-20 21:41
 */
public class Sort {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        String url = "jdbc:mysql:///test";
        Connection connection = DriverManager.getConnection(url,"root","261919Zss");
        Statement statement = connection.createStatement();
        String sql1 = "select * from staff order by salary desc limit 3 offset 0";
        String sql2 = "select * from staff order by salary desc limit 3 offset 3";
        ResultSet resultSet1 = statement.executeQuery(sql1);

        while(resultSet1.next()){
            int id = resultSet1.getInt("id");
            String name = resultSet1.getString("name");
            String sex = resultSet1.getString("sex");
            int age = resultSet1.getInt("age");
            BigDecimal salary = resultSet1.getBigDecimal("salary");
            System.out.println("id:"+" "+id + "name:"+" "+name+"sex:"+" "+sex+"age:"+" "+age+"salary:"+" "+salary);

        }
        ResultSet resultSet2 = statement.executeQuery(sql2);
        while(resultSet2.next()){
            int id = resultSet2.getInt("id");
            String name = resultSet2.getString("name");
            String sex = resultSet2.getString("sex");
            int age = resultSet2.getInt("age");
            BigDecimal salary = resultSet2.getBigDecimal("salary");
            System.out.println("id:"+" "+id + "name:"+" "+name+"sex:"+" "+sex+"age:"+" "+age+"salary:"+" "+salary);
        }

    }
}
