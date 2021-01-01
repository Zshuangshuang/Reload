import java.io.File;
import java.io.IOException;

/**
 * Author:ZouDouble
 * Description:
 * 天气：晴天
 * 目标：Good Offer
 * Date    2021-01-01 9:31
 */
public class IODemo {
    private static void allFilesList(File f){
        //先判断当前目录是不是目录，如果是目录就递归遍历目录，否则直接打印
            if (f.isDirectory()){
               File[] files = f.listFiles();
               for (File file : files){
                   allFilesList(file);
               }
            }else {
                System.out.println(f);
            }
        }

    public static void main(String[] args) throws IOException {
       /* File file = new File("d:/test_dir");
        System.out.println("文件是否存在:"+file.exists());
        System.out.println("当前文件是否为目录："+file.isDirectory());
        System.out.println("当前文件是否为普通文件："+file.isFile());
        file.delete();
        System.out.println("文件是否存在:"+file.exists());*/
        File file = new File("d:/test/1/2/3/4");
        System.out.println("目录是否存在："+file.exists());
        file.mkdirs();
        System.out.println(file.getParent());
        allFilesList(file);
    }
}
