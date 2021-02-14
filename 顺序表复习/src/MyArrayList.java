import java.util.Arrays;

/**
 * Author:ZouDouble
 * Description:
 * 天气：晴天
 * 目标：Good Offer
 * Date    2021-02-07 10:53
 */
public class MyArrayList {
    public int[] elem;
    public int usedSize;//有效长度
    public static final int CAPACITY = 100;//初始容量
    public MyArrayList() {
        this.elem = new int[CAPACITY];
        this.usedSize = 0;
    }

    public void display() {
        for (int i = 0; i < this.usedSize; i++) {
            System.out.print(this.elem[i]+" ");
        }
    }
    private boolean isFull(){
        if (this.elem.length == this.usedSize){
            return true;
        }
        return false;
    }
    public void add(int pos, int data) {
        //扩容
        if (isFull()){
            this.elem = Arrays.copyOf(this.elem,this.elem.length*2);
        }
        //(1)判断pos位置的合法性
        if (pos < 0 || pos > this.usedSize){
            return;
        }

        //(2)让pos位置后面的元素向后挪
        for (int i = this.usedSize-1; i >= pos; i--) {
            this.elem[i+1] = this.elem[i];
        }
        this.elem[pos] = data;
        this.usedSize++;
    }

    public boolean contains(int toFind) {
        for (int i = 0; i < this.usedSize; i++) {
            if (this.elem[i] == toFind){
                return true;
            }
        }
        return false;
    }

    public int search(int toFind) {
        for (int i = 0; i < this.usedSize; i++) {
            if (this.elem[i] == toFind){
                return i;
            }
        }
        return -1;
    }

    public Integer getPos(int pos) {
        if (this.elem == null){
            return null;
        }
        if (pos <0 || pos >= this.usedSize){
            return null;
        }
        return this.elem[pos];
    }

    public void remove(int toRemove) {
       int ret = search(toRemove);
       if (ret == -1){
           return;
       }
        for (int i = ret; i < this.usedSize-1; i++) {
            this.elem[i] = this.elem[i+1];
        }
        this.usedSize--;
    }

    public int size() {
        return this.usedSize;
    }

    public void clear() {
        this.usedSize = 0;
    }

    public static void main(String[] args) {
        MyArrayList myArrayList = new MyArrayList();
        myArrayList.add(0,1);
        myArrayList.add(1,2);
        myArrayList.add(2,5);
        myArrayList.add(2,3);
        myArrayList.add(3,4);
        myArrayList.add(0,7);
        myArrayList.display();
        System.out.println();
        System.out.println(myArrayList.contains(2));
        System.out.println(myArrayList.search(3));
        System.out.println(myArrayList.size());
        System.out.println(myArrayList.getPos(6));
        myArrayList.remove(99);
    }
}
