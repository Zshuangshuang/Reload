import java.util.Arrays;

public class Heap {
    public static void shiftDown(int[] array,int size,int index){
        int parent = index;
        int child = (parent*2)+1;
        while (child < size){
            //找到左子树和右子树中较小的值
            if (child+1 < size && array[child+1] < array[child]){
                child = child+1;
            }
           if (array[child] < array[parent]){
               swap(array,parent,child);
           }else {
               break;
           }
           parent = child;
           child = (parent*2)+1;
        }
    }

    private static void swap(int[] array, int parent, int child) {
        int tmp = array[parent];
        array[parent] = array[child];
        array[child] = tmp;
    }

    public static void creatHeap(int[] array,int size){
        for (int i = size-1; i >= 0; i--) {
            shiftDown(array,size,i);
        }

    }
    public static void main(String[] args) {
        int[] array = {9,5,2,7,3,6,8};
        creatHeap(array,array.length-1);
        System.out.println(Arrays.toString(array));
    }
}
