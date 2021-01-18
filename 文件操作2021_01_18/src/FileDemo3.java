import java.io.*;

/**
 * Author:ZouDouble
 * Description:
 * 天气：晴天
 * 目标：Good Offer
 * Date    2021-01-18 12:00
 */
public class FileDemo3 {
    public static void main(String[] args) throws IOException {
        //文件复制
        File input = new File("d:/test/爱豆.jpg");
        File output = new File("d:/test/爱豆2.jpg");
        if (!output.exists()){
            output.createNewFile();
        }
        FileInputStream fileInputStream = new FileInputStream(input);
        FileOutputStream fileOutputStream = new FileOutputStream(output);
       /* BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(fileOutputStream));*/
        byte[] buffer = new byte[4096];
        int len = 0;
        while((len = fileInputStream.read(buffer)) != -1){
            fileOutputStream.write(buffer,0,len);
        }


        /*while((len = fileInputStream.read(buffer)) != -1){
            fileOutputStream.write(buffer,0,len);
        }
        //fileOutputStream.flush();
        long end = System.currentTimeMillis();
        System.out.println(end-start);
        fileInputStream.close();
        fileOutputStream.close();*/
    }
}
