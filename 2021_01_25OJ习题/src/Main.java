import java.util.Scanner;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int N = sc.nextInt();
            int invalid = 0;
            // HashMap是无序的，这里用LinkedHashMap保证有序
            Map<String, Integer> map = new LinkedHashMap<>();
            for (int i = 0; i < N; i++) {
                map.put(sc.next(), 0);
            }
            map.put("Invalid", 0);
            int M = sc.nextInt();
            for (int i = 0; i < M; i++) {
                String s = sc.next();
                if (map.containsKey(s)) {
                    map.put(s, map.get(s) + 1);
                } else {
                    map.put("Invalid", map.get("Invalid") + 1);
                }
            }
            for (String key : map.keySet()) {
                System.out.println(key + " : " + map.get(key));
            }
        }
    }
}