import java.io.File;
import java.io.IOException;

/**
 * Author:ZouDouble
 * Description:
 * 天气：晴天
 * 目标：Good Offer
 * Date    2021-01-03 10:12
 */
public class IODemo3 {
    public static void main(String[] args) throws IOException {
        File file = new File("d:/example/1/2/3/4");
        file.mkdirs();
        File f = new File("d:/example/hello.txt");
        //注意：这里在新建文件时要处理异常，因为此处可能由于路径问题引发IOException
        f.createNewFile();
        File f1 = new File("d:/example/2");
        System.out.println(f1.getParent());
    }
}
