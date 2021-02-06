package com.ssz.字母统计;

import java.util.*;

public class Main {
    public static void main(String[] args) {
       Scanner scanner = new Scanner(System.in);
       String str = scanner.nextLine();
       char[] chars = str.toCharArray();
       Map<Character,Integer> map = new HashMap<>();
       for (char ch : chars){
           if (map.containsKey(ch)){
               map.put(ch,map.get(ch)+1);
           }else {
               map.put(ch,1);
           }
       }
        for (int i = 0; i < 26; i++) {
            char ch = (char)('A'+i);
            if (map.containsKey(ch)){
                System.out.println(ch+":"+map.get(ch));
            }else {
                System.out.println(ch+":"+0);
            }
        }
    }
}
