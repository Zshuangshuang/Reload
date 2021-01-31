package com.ssz.数组中出现了一次的数字;

import java.util.*;

public class Main {
    private static void findNums(int[] array){
        ArrayList list = new ArrayList();
        if (array == null || array.length == 0){
            return;
        }
        Map<Integer,Integer> map = new HashMap<>();
        for (int x : array){
            if (map.containsKey(x)){
                map.put(x,map.get(x)+1);
            }else {
                map.put(x,1);
            }
        }
        for (Map.Entry<Integer,Integer> entry : map.entrySet()){
            if (entry.getValue()%2 != 0){
                list.add(entry.getKey());
            }
        }
        Collections.sort(list);
        for (int i = 0; i < list.size(); i++) {
            System.out.printf(list.get(i)+" ");
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            int num = scanner.nextInt();
            int[] array = new int[num];
            for (int i = 0; i < num; i++) {
                array[i] = scanner.nextInt();
            }
            findNums(array);

        }
    }
}
