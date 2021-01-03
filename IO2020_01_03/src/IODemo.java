import java.io.File;

/**
 * Author:ZouDouble
 * Description:
 * 天气：晴天
 * 目标：Good Offer
 * Date    2021-01-03 9:47
 */
public class IODemo {
    public static void main(String[] args) {
        String pathname = "d:/test";
        File file = new File(pathname);
        String parent = "d:";
        String child = "/test";
        File file2 = new File(parent+child);
    }
}
