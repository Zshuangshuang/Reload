import java.io.File;
import java.io.IOException;

/**
 * Author:ZouDouble
 * Description:
 * 天气：晴天
 * 目标：Good Offer
 * Date    2021-01-03 9:56
 */
public class IODemo2 {
    public static void main(String[] args) throws IOException {
        File file = new File("d:/test/lib.txt");
        System.out.println("file是否存在："+file.exists());
        System.out.println("file是否为目录："+file.isDirectory());
        System.out.println("file是否为普通文件："+file.isFile());
        file.delete();
        System.out.println("file是否存在："+file.exists());

    }
}
