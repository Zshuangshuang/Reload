import java.util.Scanner;

/**
 * Author:ZouDouble
 * Description:
 * 天气：晴天
 * 目标：Good Offer
 * Date    2021-01-20 8:23
 */
public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            String str = scanner.nextLine();
            char[] ch = str.toCharArray();
            for (int i = 0; i < ch.length; i++) {
                char ret = ch[i];
                if (ret >= 'A'){
                    ret = (char) (ret > 'E' ? (ret-5) : (ret+21));
                    ch[i] = ret;
                }

            }
            System.out.println(new String(ch));
        }
    }
}
