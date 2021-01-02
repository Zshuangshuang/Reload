import java.io.File;

/**
 * Author:ZouDouble
 * Description:在电脑的磁盘中新建一个目录，并打印出目录中的内容
 * 天气：晴天
 * 目标：Good Offer
 * Date    2021-01-02 9:30
 */
public class IODemo {
    private static void listAllFiles(File file){
        if (file.isDirectory()){
            File[] files = file.listFiles();
            for (File f:files){
                listAllFiles(f);
            }
        }else {
            System.out.println(file);
        }
    }
    public static void main(String[] args) {
        File file = new File("d:/test_dir");
        listAllFiles(file);
    }
}
