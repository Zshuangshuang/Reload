package com.ssz.说反话;


import java.util.Scanner;
import java.util.Stack;

public class Main {
    private static void reverse(String str){
        String[] strings = str.split(" ");
        int n = strings.length;
        Stack<String> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            stack.push(strings[i]);
        }
        while(!stack.isEmpty()){
            System.out.printf(stack.pop()+" ");
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            String str = scanner.nextLine();
            reverse(str);
        }
    }
}
