import java.io.*;

/**
 * Author:ZouDouble
 * Description:
 * 天气：晴天
 * 目标：Good Offer
 * Date    2021-01-02 10:28
 */
class Teacher implements Serializable {
    String name;
    int age;
    int salary;
}
public class IODemo2 {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        /*Teacher teacher = new Teacher();
        teacher.name = "鲁班";
        teacher.age = 90;
        teacher.salary = 1234;
        serializable(teacher);*/
        Teacher teacher = deserializable();
        System.out.println(teacher.name);
    }

    private static void serializable(Teacher teacher) throws IOException {
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("d:/teacher.txt"));
        objectOutputStream.writeObject(teacher);
        objectOutputStream.close();
    }
    private static Teacher deserializable() throws IOException, ClassNotFoundException {
        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("d:/teacher.txt"));
        Teacher teacher= (Teacher)objectInputStream.readObject();
        return teacher;

    }
}
