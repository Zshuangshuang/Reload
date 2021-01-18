import java.io.*;

/**
 * Author:ZouDouble
 * Description:实现拷贝字节流文件
 * 天气：晴天
 * 目标：Good Offer
 * Date    2021-01-18 15:47
 */
public class FileDemo6 {
    public static void main(String[] args) throws IOException {
        File input = new File("d:/test/爱豆.jpg");
        File output = new File("d:/test/爱豆4.jpg");
        FileInputStream fileInputStream = new FileInputStream(input);
        FileOutputStream fileOutputStream = new FileOutputStream(output);
        byte[] buffer = new byte[4096];
        int len = 0;
        while((len = fileInputStream.read(buffer)) != -1){
            fileOutputStream.write(buffer,0,len);
        }
        fileOutputStream.close();
        fileInputStream.close();

    }
}
