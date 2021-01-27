package 密码验证;

import java.util.Scanner;

public class Main {
   private static boolean checkLength(String str){
       if (str.length() <= 8 ){
           return false;
       }
       return true;
   }
   private static boolean isLegal(String str){
       String[] ret = new String[4];
       int count = 0;
       char[] chars = str.toCharArray();
       for (char ch : chars){
           if (ch >= '0' && ch <= '9'){
               ret[0] = "true";
           }else if (ch >= 'a' && ch <= 'z'){
               ret[1] = "true";
           }else if (ch >= 'A' && ch <= 'Z'){
               ret[2] = "true";
           }else {
               ret[3] = "true";
           }
       }
       for (int i = 0; i < ret.length; i++) {
           if ("true".equals(ret[i])){
               count++;
           }
       }
       if (count >= 3){
           return true;
       }
       return false;
   }
   private static boolean checkString(String str){
       for (int i = 0; i < str.length()-3; i++) {
           if (str.substring(i+3).contains(str.substring(i,i+3))){
               return false;
           }
       }
       return true;
   }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            String str = scanner.nextLine();
            if (checkLength(str) && isLegal(str) && checkString(str)){
                System.out.println("OK");
            }else {
                System.out.println("NG");
            }
        }
    }
}
