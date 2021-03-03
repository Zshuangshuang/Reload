
public class MyPriorityQueue {
    private int[] array = new int[100];
    private int size = 0;


    public void offer(int x){
        array[size] = x;
        size++;
        //将新加入的元素进行向上调整
        shitUp(array,size-1);
    }
    public void shitUp(int[] array,int index){
        int child = index;
        int parent = (child-1)/2;
        while (child > 0){
            if (array[child] > array[parent]){
                swap(array,child,parent);
            }else {
                break;
            }
            child = parent;
            parent = (child-1)/2;
        }
    }

    private void swap(int[] array, int child, int parent) {
        int tmp = array[child];
        array[child] = array[parent];
        array[parent] = tmp;
    }
    public int poll(){
        //首先取出堆顶元素,将堆中的最后一个元素赋值给堆顶元素,size--;最后在对堆顶元素进行向下调整
        int oldValue = array[0];
        array[0] = array[size-1];
        size--;
        shiftDown(array,size,0);
        return oldValue;
    }
    public int peek(){
        return array[0];
    }

    private void shiftDown(int[] array, int size, int index) {
        int parent = index;
        int child = (parent*2)+1;
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
            child = (parent*2)+1;
        }
    }
    public boolean isEmpty(){
        return size == 0;
    }

    public static void main(String[] args) {
        MyPriorityQueue priorityQueue = new MyPriorityQueue();
        priorityQueue.offer(9);
        priorityQueue.offer(5);
        priorityQueue.offer(2);
        priorityQueue.offer(7);
        priorityQueue.offer(3);
        priorityQueue.offer(6);
        priorityQueue.offer(8);
        while (!priorityQueue.isEmpty()){
            int cur = priorityQueue.poll();
            System.out.println(cur);
        }
    }
}
