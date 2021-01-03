import java.io.*;

/**
 * Author:ZouDouble
 * Description:
 * 天气：晴天
 * 目标：Good Offer
 * Date    2021-01-03 11:15
 */
public class IODemo6 {
    private static void myCopyForCharStream2(){
        //还可以按行读取文件中的内容，注意一点就是需要自己换行，否则复制后会把源文件读到一行
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader("d:/study/lib.txt"));
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("d:/study/lib3.txt"));
        ){
            //(2)读文件
            String line = "";

            while((line = bufferedReader.readLine()) != null){
                //(3)写文件
                bufferedWriter.write(line+"\n");
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }
    private static void myCopyForCharStream(){

        //(1)实例化字符流对象
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader("d:/study/lib.txt"));
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("d:/study/lib2.txt"));
            ){
            //(2)读文件
            char[] buffer = new char[1024];
            int len = -1;
            while((len = bufferedReader.read(buffer)) != -1){
                //(3)写文件
                bufferedWriter.write(buffer,0,len);
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        myCopyForCharStream2();
    }
}
