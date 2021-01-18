import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Author:ZouDouble
 * Description:
 * 天气：晴天
 * 目标：Good Offer
 * Date    2021-01-18 15:35
 */
public class FileDemo5 {
    public static void main(String[] args) throws IOException {
        //读取字符流文件
        File file = new File("D:\\test\\hello.txt");
        FileReader fileReader = new FileReader(file);
        char[] buffer = new char[4096];
        int len = 0;
        //记住一定不能把read()中的参数忘记了
        while((len = fileReader.read(buffer)) != -1){
           String str = new String(buffer,0,len);
           System.out.println(str);
        }

        fileReader.close();
    }
}
