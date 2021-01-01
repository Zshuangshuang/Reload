import java.io.*;

/**
 * Author:ZouDouble
 * Description:fileInputStream和fileOutputStream类内无缓冲区
 * 天气：晴天
 * 目标：Good Offer
 * Date    2021-01-01 20:48
 */
public class IODemo {
    private static void myCopyFile(){
        //此处系统会自动调用close方法，前提是实现了closable接口，由于流自己已经实现了closable，因此不用手动实现
        try(FileInputStream fileInputStream = new FileInputStream("d:/test/lover.jpg");
        FileOutputStream fileOutputStream = new FileOutputStream("d:/test/lover5.jpg")){
        int len = -1;
        byte[] buffer = new byte[1024];
        while((len = fileInputStream.read(buffer)) != -1){
            fileOutputStream.write(buffer,0,len);
        }
        }catch (IOException e){
            e.printStackTrace();
        }
    }
    private static void myCopyFile(String srcPath,String destPath)  {
        FileInputStream fileInputStream = null;
        FileOutputStream fileOutputStream = null;
        try {
            fileInputStream = new FileInputStream(srcPath);
            fileOutputStream = new FileOutputStream(destPath);
            byte[] buffer = new byte[1024];
            int ret = -1;
            while((ret = fileInputStream.read(buffer)) != -1){
                fileOutputStream.write(buffer,0,ret);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            //此处的close方法可能会失效，因为一旦触发异常就有可能导致程序中途发生异常
            //因此会用到finally
            try {
                //由于在初始化过程中，内存中可能不存在要复制的文件，因此可能出现空指针异常
                //所以此处应该判断一下fileInputStream和fileOutputStream
                if (fileInputStream != null){
                    fileInputStream.close();
                }
                if (fileOutputStream != null){
                    fileOutputStream.close();
                }

            } catch (IOException e) {
                e.printStackTrace();
            }

        }

    }
    public static void main(String[] args) throws IOException {
       myCopyFile("d:/test/lover.jpg","d:/test/lover4.jpg");

    }
}
