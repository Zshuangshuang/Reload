import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Author:ZouDouble
 * Description:
 * 天气：晴天
 * 目标：Good Offer
 * Date    2021-01-03 10:37
 */
public class IODemo5 {
    private static void myCopyForByteStream(){
        //不关闭资源的后果：
        //如果不关闭资源可能会导致一段时间过后，该文件将文件标识符表写满，导致后续文件无法读写
        //此处采用try包裹后，编译器会自己关闭资源，因此没有在代码中体现出来
        //(1)实例化流对象
      try(FileInputStream fileInputStream = new FileInputStream("d:/test/lover.jpg");
          FileOutputStream fileOutputStream = new FileOutputStream("d:/test/lover1.jpg");
              ) {
          //2、读取文件
          //用户自定义的缓冲区，每次读取1024字节个文件
          byte[] buffer = new byte[1024];
            int len = -1;
            //当len=-1的时候意味着流文件读取完毕
            while((len = fileInputStream.read(buffer)) != -1){
                //3、写文件
                fileOutputStream.write(buffer,0,len);
            }

      }catch (IOException e){
          e.printStackTrace();
      }
    }
    public static void main(String[] args) {
        myCopyForByteStream();
    }
}
