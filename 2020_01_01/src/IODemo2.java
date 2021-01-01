import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Author:ZouDouble
 * Description:
 * 天气：晴天
 * 目标：Good Offer
 * Date    2021-01-01 10:41
 */
public class IODemo2 {
    private static void copyFile(String srcPath,String destPath) throws IOException {
            //1、打开文件(创建InputStream/OutputStream对象)
            FileInputStream fileInputStream = new FileInputStream(srcPath);
            FileOutputStream fileOutputStream = new FileOutputStream(destPath);
            //2、读取src文件内容
            byte[] buffer = new byte[1024];
            //此处的len代表此次read操作实际读取的字节数，
            // 如果文件未写满返回值就是当前文件的字节数，当前文件如果读完了就返回-1
            int len = -1;
            //由于缓冲区的大小受限制，单词读取文件可能读不完，所以需要搭配循环使用
            while(( len = fileInputStream.read(buffer)) != -1){
                //3、读取成功就将读取的内容写入目的路径destPath
                fileOutputStream.write(buffer,0,len);
            }
        //4、关闭资源
        //目的是防止资源泄露
        //如果低吗没有关闭资源一直在打开文件，那么文件描述表可能就会写满，导致文件描述表呗写满，后续文件无法打开
        fileInputStream.close();
        fileOutputStream.close();
    }

    public static void main(String[] args) throws IOException {
        copyFile("d:/test/lover.jpg","d:test/lover2.jpg");
    }
}
