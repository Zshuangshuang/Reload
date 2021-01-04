import java.io.*;

/**
 * Author:ZouDouble
 * Description:
 * 天气：晴天
 * 目标：Good Offer
 * Date    2021-01-04 9:28
 */
class People implements Serializable {
    public String name;
    public int age;
    public char sex;
}
public class IODemo2 {
    private static People deserializable() throws IOException, ClassNotFoundException {
        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("d:/people.txt"));
        People people = (People) objectInputStream.readObject();
        return people;
    }
    private static void serializable(People people) throws IOException {
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("d:/people.txt"));
        objectOutputStream.writeObject(people);
        objectOutputStream.close();
    }
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        People people = deserializable();
        System.out.println(people.sex);
        System.out.println(people.name);
        System.out.println(people.age);
        /*people.age = 99;
        people.name = "哈哈";
        people.sex = '男';
        serializable(people);*/
    }
}
