
import java.util.Scanner;


public class Main {
    public static String maxNumStr(String str){
        if (str == null){
            return null;
        }
        char[] ch = str.toCharArray();
        int count = 0;
        String result = "";
        for (int i = 0; i < ch.length; i++) {
            if (ch[i] >= '0' && ch[i] <= '9'){
                int index = i;
                count = 1;
                for (int j = i+1; j < ch.length; j++) {
                    if (ch[j] >= '0' && ch[j] <= '9'){
                        count++;
                        index++;
                    }else {
                        break;
                    }
                }
                if (count > result.length()){
                    result = str.substring(i,index+1);
                }
            }else {
                continue;
            }

        }
        return result;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            String str = scanner.nextLine();
            System.out.println(maxNumStr(str));
        }
    }
}
