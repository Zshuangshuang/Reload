import java.io.File;

/**
 * Author:ZouDouble
 * Description:
 * 天气：晴天
 * 目标：Good Offer
 * Date    2021-01-03 10:31
 */
public class IODemo4 {
    private static void listAllFiles(File file){
        //1、首先判断file文件是否为目录文件，如果是就遍历，不是就直接打印
        if (file.isDirectory()){
           //2、如果是当前file目录就调用它的listFiles()方法，找到它其中包含的文件信息
            File[] files = file.listFiles();
            //3、递归遍历files
            for (File f : files){
                listAllFiles(f);
            }
        }else {
            System.out.println(file);
        }
    }
    public static void main(String[] args) {
        File file = new File("d:/example");
        listAllFiles(file);
    }
}
