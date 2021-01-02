import java.io.*;

/**
 * Author:ZouDouble
 * Description:实现自己的字符流文件的复制
 * 天气：晴天
 * 目标：Good Offer
 * Date    2021-01-02 9:50
 */
public class IODemo3 {
    //还可按行读取数据，必须要加换行符，如果不加换行符会将所有的字符流文件的内容读到一行
    private static void myCopyFile2(){
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader("d:/test/lib.txt"));
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("d:/test/lib4.txt"))
        ){
            String line = "";
            while((line = bufferedReader.readLine()) != null){
                bufferedWriter.write(line+"\n");
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }
    //BufferedReader 和BufferedWriter自带缓冲区，执行效率较高
    private static void myCopyFile(){
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader("d:/test/lib.txt"));
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("d:/test/lib4.txt"))
        ){
            char[] buffer = new char[1024];
            int len = -1;
            while((len = bufferedReader.read(buffer)) != -1){
                bufferedWriter.write(buffer,0,len);
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        myCopyFile2();
    }
}
