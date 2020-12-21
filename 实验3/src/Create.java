import java.math.BigDecimal;
import java.sql.*;

public class Create {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        String url = "jdbc:mysql:///test";
        Connection connection = DriverManager.getConnection(url,"root","261919Zss");
        Statement statement = connection.createStatement();
        String sql  = "create table staff(id int primary key  auto_increment,name varchar(20),sex varchar(5),age int,salary decimal(5,1))";
        statement.executeUpdate(sql);
    }
}
class Insert {
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
class Update {
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
class Delete {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        String url = "jdbc:mysql:///test";
        Connection connection = DriverManager.getConnection(url,"root","261919Zss");
        Statement statement = connection.createStatement();
        String sql = "delete from staff where salary >= 1500";
        statement.executeUpdate(sql);
    }
}
class Sort {
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

