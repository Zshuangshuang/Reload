import java.util.Scanner;

/**
 * Author:ZouDouble
 * Description:密文转换
 * 天气：晴天
 * 目标：Good Offer
 * Date    2021-01-19 21:41
 */
public class Main3 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            String a = scanner.nextLine();
            char[] b = a.toCharArray();
            for (int i = 0; i < b.length; i++){
                char ch = b[i];
                if (ch -'A' >= 0){
                    ch = (char)( ch > 'E' ? (ch-5) : (ch+ 21));
                    b[i] = ch;
                }
            }
            System.out.println(new String(b));
        }

    }
}
