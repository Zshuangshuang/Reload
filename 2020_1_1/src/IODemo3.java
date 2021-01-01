import java.io.*;

/**
 * Author:ZouDouble
 * Description:字符流拷贝文件
 * 天气：晴天
 * 目标：Good Offer
 * Date    2021-01-01 22:18
 */
public class IODemo3 {
    private static void copyFile2() {
        //带缓冲区的字符流读取的时候可以按照行来读取
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("d:/test/lib.txt"));
             BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("d:/test/lib3.txt"))

        ) {
            String line = "";
            while((line = bufferedReader.readLine()) != null){
                //此处需要加一个换行符，否则会将所有的内容读到一行
                bufferedWriter.write(line+"\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void copyFile() {
        try (FileReader fileReader = new FileReader("d:/test/lib.txt");
             FileWriter fileWriter = new FileWriter("d:test/lib2.txt")
        ) {
            char[] buffer = new char[1024];
            int len = -1;
            while ((len = fileReader.read(buffer)) != -1) {
                fileWriter.write(buffer, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        copyFile2();
    }
}
