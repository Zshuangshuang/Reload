import java.io.*;

/**
 * Author:ZouDouble
 * Description:
 * 天气：晴天
 * 目标：Good Offer
 * Date    2021-01-04 9:19
 */
class Cat  implements Serializable {
    public String name;
    public int age;
    public String color;
}
public class IODemo {
    private static Cat deSerializable() throws IOException, ClassNotFoundException {
        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("d:/Cat.txt"));
        Cat cat = (Cat) objectInputStream.readObject();
        return cat;
    }
    private static void serializable(Cat cat) throws IOException {
       ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("d:/Cat.txt"));
       objectOutputStream.writeObject(cat);
       objectOutputStream.close();
    }
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Cat cat = deSerializable();
        /*cat.age = 2;
        cat.color = "牛奶色";
        cat.name = "一一";
        serializable(cat);*/
        System.out.println(cat.name);
        System.out.println(cat.age);
        System.out.println(cat.color);
    }
}
