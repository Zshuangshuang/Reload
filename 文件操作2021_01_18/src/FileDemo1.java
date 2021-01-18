import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Author:ZouDouble
 * Description:
 * 天气：晴天
 * 目标：Good Offer
 * Date    2021-01-18 9:10
 */
public class FileDemo1 {

    //文件的遍历操作
    public static List<File> listDir(File dir){
        List<File> list = new ArrayList<>();
            File[] children = dir.listFiles();
            if (children != null){
                for (File child : children){
                    /*if (child.isDirectory()){
                        list.addAll(listDir(child));
                    }else {
                        list.add(child);
                    }*/
                    //打印文件目录和文件
                    list.add(child);
                    if (child.isDirectory()){
                        list.addAll(listDir(child));
                    }
                }
        }
        return list;
    }
   /* public static List<File> listDir(File dir){
       List<File> list = new ArrayList<>();
        if (dir.isDirectory()){
            File[] children = dir.listFiles();
            if (children != null){
                for (File child : children){
                    List<File> files = listDir(child);
                    list.addAll(files);
                }
            }
       }
        return list;
    }*/
    public static void main(String[] args) {
        File file = new File("D:\\demo");
        List<File> files = listDir(file);
        files.stream()
                .forEach(System.out::println);
    }
}
