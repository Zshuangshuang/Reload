import java.io.*;

/**
 * Author:ZouDouble
 * Description:
 * 天气：晴天
 * 目标：Good Offer
 * Date    2021-01-18 10:46
 */
public class FileRead {
    public static void main(String[] args) throws IOException {
        /*//1、文件字节流输入
        *//*File file = new File("D:\\study/lib.txt");
        FileInputStream fileInputStream = new FileInputStream(file);
        byte[] buffer = new byte[1024*8];
        int len = 0;
        while((len = fileInputStream.read(buffer)) != -1){
            //将字节数组转字符串
            String str = new String(buffer,0,len);
            System.out.println(str);
        }
        //关闭资源，防止造成文件资源泄露
        fileInputStream.close();*//*
        //2、文件字符流输入
        File file = new File("D:\\study/lib.txt");
        FileReader fileReader = new FileReader(file);
        char[] buffer = new char[1024];
        int len = 0;
        while((len = fileReader.read(buffer)) != -1){
            String str = new String(buffer,0,len);
            System.out.println(str);
        }
        //3、缓冲流:缓冲字节输入和输出
        FileInputStream fileInputStream = new FileInputStream(file);
        InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
        //Buffered带有缓冲区效率较高
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        String str;
        while((str = bufferedReader.readLine()) != null){
            System.out.println(str);
        }
        //反向释放资源
        bufferedReader.close();
        inputStreamReader.close();
        fileInputStream.close();*/
        File file = new File("d:/test/hello.txt");
        if (!file.exists()){
            file.createNewFile();
        }
        /*BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));
        bufferedWriter.write("\n");*/
        PrintWriter pw = new PrintWriter(new FileOutputStream(file));
        for (int i = 'a'; i <= 'z'; i++) {
            pw.println((char)i);
        }
        pw.flush();
    }
   /* private static char[] write(){
        char[] str = new char[26];
        for (int i = 0; i < 26; i++){
            char ch = (char)97;
            str[i] = ch;
            ch++;
        }
        return str;
    }*/
}
