import java.util.ArrayList;


public class Solution {
    private static void  createHeap(int[] array){
        for (int i = 0; i < array.length; i++) {
            shiftDown(array,array.length-1,0);
        }
    }

    private static void shiftDown(int[] array, int size, int index) {
        int parent = index;
        int child = (2*parent)+1;
        while (child < size){
            if (child+1 < size && array[child+1] > array[child]){
                child = child+1;
            }
            if (array[parent] < array[child]){
                swap(array,parent,child);
            }else {
                break;
            }
            parent = child;
            child = 2*parent+1;
        }
    }

    private static void swap(int[] array, int parent, int child) {
        int tmp = array[child];
        array[child] = array[parent];
        array[parent] = tmp;
    }
    private static void heapSort(int[] array){
        createHeap(array);
        for (int i = 0; i < array.length; i++) {
            swap(array,array.length-1-i,0);
            shiftDown(array,array.length-1-i,0);
        }
    }
    public  static ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        ArrayList<Integer> result = new ArrayList<>();
        if (input == null || input.length == 0 || k<= 0 || k > input.length){
            return result;
        }
        heapSort(input);
        for (int i = 0; i < k; i++) {
            result.add(input[i]);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] array = {1,1,1,1,8};
        System.out.println(GetLeastNumbers_Solution(array, 3));
    }
}
