import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Author:ZouDouble
 * Description:实现自己复制字节流文件
 * 天气：晴天
 * 目标：Good Offer
 * Date    2021-01-02 9:38
 */
public class IODemo2 {
    //安全版本
    private static void myFileCopy2(){
        try(FileInputStream fileInputStream = new FileInputStream("d:/study/deng.jpg");
            FileOutputStream fileOutputStream = new FileOutputStream("d:/study/deng1.jpg")
        ){
            byte[] buffer = new byte[1024];
            int len = -1;
            while((len = fileInputStream.read(buffer)) != -1){
                fileOutputStream.write(buffer,0,len);
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }
    //这个是初始版本，存在文件资源泄露的安全问题
    private static void myCopyFile(String srcPath,String destPath) throws IOException {
        //1、打开文件，创建FileInputStream、 FileOutputStream实例对象
        FileInputStream fileInputStream = new FileInputStream(srcPath);
        FileOutputStream fileOutputStream = new FileOutputStream(destPath);
        //2、读文件
        byte[] buffer = new byte[1024];
        int len = -1;
        while((len = fileInputStream.read(buffer)) != -1){
            //3、写文件
            fileOutputStream.write(buffer,0,len);
        }
        //4、关闭资源
        //如果不关闭资源可能会导致一段时间过后，该文件将文件标识符表写满，导致后续文件无法读写
        //此处由于电脑磁盘中可能找不到对应的文件而导致空指针异常
        fileInputStream.close();
        fileOutputStream.close();
    }
    public static void main(String[] args) {
        myFileCopy2();
    }
}
