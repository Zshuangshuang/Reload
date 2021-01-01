import java.io.*;

/**
 * Author:ZouDouble
 * Description:BufferedInputStream和BufferedOutPutStream内置了缓冲区
 * 缓冲区：本质上是一块内存空间,可以缓和CPU和问磁盘间的矛盾，提高程序访问效率
 * 缓冲区越大，IO读写次数越少
 * 带缓冲区的比不带缓冲区的效率快很多
 * flush操作：(1)如果缓冲区满了，会出发flush操作自动刷新
 * (2)调用close方法时会调用flush操作
 * (3)手动调用flush操作刷新
 * 天气：晴天
 * 目标：Good Offer
 * Date    2021-01-01 21:21
 */
public class IODemo2 {
    public static void main(String[] args) throws IOException {
        myCopy();
    }
private static void myCopy() throws IOException {
        //首先需要创建BufferedInputStream和BufferedOutPutStream
        //创建BufferedInputStream和BufferedOutPutStream之前先需要创建FileInputStream和FileOutPutStream
    FileInputStream fileInputStream = new FileInputStream("d:/test/lover.jpg");
    FileOutputStream fileOutputStream = new FileOutputStream("d:/test/lover1.jpg");
    BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);
    BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
    byte[] buffer = new byte[1024];//用户指定的缓冲区
    int len = -1;
    while((len = bufferedInputStream.read(buffer)) != -1){
        System.out.println("len:"+len);
        bufferedOutputStream.write(buffer,0,len);
    }
    //关闭流对象，只需关闭与Buffered相关即可,调用他们时就会关闭与File的
    bufferedInputStream.close();
    bufferedOutputStream.close();
}
private static void myCopy2(){
       try(BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream("d:/test/Biu.jpg"));
           BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream("d:/test/Biu1.jpg"))
       ){
         byte[] buffer = new byte[1024];
         int len = -1;
         while((len = bufferedInputStream.read(buffer)) != -1){
             System.out.println("len:"+len);
             bufferedOutputStream.write(buffer,0,len);
         }
       }catch (IOException e){
           e.printStackTrace();
       }
}
}
