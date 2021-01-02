import java.io.*;

/**
 * Author:ZouDouble
 * Description:
 * 天气：晴天
 * 目标：Good Offer
 * Date    2021-01-02 10:17
 */
class Student implements Serializable{
    String name;
    int age;
    int score;
}
public class IODemo {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        /*Student student = new Student();
        student.name = "张三";
        student.age = 20;
        student.score = 99;
        serializable(student);*/
        Student s = deserializable();
        System.out.println(s.name);
        System.out.println(s.age);
        System.out.println(s.score);
    }

    private static void serializable(Student student) throws IOException {
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("d:/student.txt"));
        //objectOutputStream.writeObject集读写为一体
        objectOutputStream.writeObject(student);
        objectOutputStream.close();
    }
    private static Student deserializable() throws IOException, ClassNotFoundException {
        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("d:student.txt"));
        Student student = (Student)objectInputStream.readObject();
        return student;

    }
}
