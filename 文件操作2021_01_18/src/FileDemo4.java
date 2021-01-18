import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Author:ZouDouble
 * Description:遍历文件夹的目录
 * 天气：晴天
 * 目标：Good Offer
 * Date    2021-01-18 15:24
 */
public class FileDemo4 {
    public static void listAllFiles(File file){
        if (file.isDirectory()){
            File[] dir = file.listFiles();
            for (File files : dir){
                listAllFiles(files);
            }
        }else {
            System.out.println(file);
        }
    }
    public static void main(String[] args) {
        File file = new File("d:\\test");
        listAllFiles(file);
    }
    /*public static List<File> fileList(File file){
        //(1)首先先创建一个List用来保存文件中的内容
        List<File> list = new ArrayList<>();
        //(2)得到file的子目录看是否为空
        File[] children = file.listFiles();
        if (children != null){
            //遍历children目录
            for (File f : children){
                list.add(f);
                if (f.isDirectory()){
                    list.addAll(fileList(f));
                }
            }
        }
        return list;
    }
    public static void main(String[] args) {
        File file = new File("d:\\test");
        List<File> list = fileList(file);
        list.stream().forEach(System.out::println);
    }*/
}
