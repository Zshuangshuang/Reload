
import java.util.*;
public class Main {

    public static int maxNumber(int[] arr,int start,int end) {
        int start1 = Math.min(start,end);
        end = Math.max(start,end);
        start = start1;
        start--;
        int temp = arr[start];
        for(int i = start;i < end;i++) {
            if(arr[i] > temp) {
                temp = arr[i];
            }
        }
        return temp;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while(in.hasNext()) {
            int nums1 = in.nextInt();
            int nums2 = in.nextInt();
            int[] arr = new int[nums1];
            for(int i = 0;i < nums1;i++) {
                arr[i] = in.nextInt();
            }
            String light = in.nextLine();
            String[] strarr = new String[nums2];
            for(int i = 0;i < nums2;i++) {
                strarr[i] = in.nextLine();
            }
            for(int i = 0;i < nums2;i++) {
                String[] strnew = strarr[i].split(" ");
                int start = Integer.parseInt(strnew[1]);
                int end = Integer.parseInt(strnew[2]);
                if(strnew[0].equals("Q")) {
                    int temp = maxNumber(arr,start,end);
                    System.out.println(temp);
                }
                if(strnew[0].equals("U")) {
                    arr[start - 1] = end;
                }
            }
        }
    }

}