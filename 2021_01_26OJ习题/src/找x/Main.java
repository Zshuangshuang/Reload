package 找x;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            int n = scanner.nextInt();
            int[] array = new int[n];
            for (int i = 0; i < n; i++) {
                array[i] = scanner.nextInt();
            }
            int x = scanner.nextInt();
            List<Integer> list = new ArrayList<>();
            for (int ret : array){
                list.add(ret);
            }
            if (list.contains(x)){
                System.out.println(list.indexOf(x));
            }else {
                System.out.println(-1);
            }
        }
    }
}
