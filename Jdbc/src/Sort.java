import java.sql.*;

/**
 * @Auther:ZouSS
 * @Description:
 * @Date 2020-12-22 18:56
 */
public class Sort {
    public static void main(String[] args)throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        String url = "jdbc:mysql:///demo";
        Connection connection = DriverManager.getConnection(url,"root","261919Zss");
        Statement statement = connection.createStatement();
        String sql = "select * from student";
        statement.executeQuery(sql);
        ResultSet resultSet = statement.executeQuery(sql);
        while(resultSet.next()){
            int id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            String sex = resultSet.getString("sex");
            int age = resultSet.getInt("age");
            System.out.println("id:"+" "+id + "name:"+" "+name+"sex:"+" "+sex+"age:"+" "+age);
        }
    }
}
