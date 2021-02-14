import java.util.Arrays;

public class SeqList {
    public int[] elem;
    public int usedSize;
    public static final int CAPACITY = 100;
    public SeqList() {
        this.elem = new int[CAPACITY];
        this.usedSize =0;
    }

    public void display() {
        for (int i = 0; i < this.usedSize; i++) {
            System.out.print(this.elem[i]+" ");
        }
    }
private boolean isFull(){
        return this.elem.length == this.usedSize;
}
public void add(int pos, int data) {
        //扩容
    if (isFull()){
        this.elem = Arrays.copyOf(this.elem,this.elem.length*2);
    }
        if (pos < 0 || pos > this.usedSize){
            return;
        }
    for (int i = this.usedSize-1; i >= pos ; i--) {
            this.elem[i+1] = this.elem[i];
      }
    this.elem[pos] = data;
    this.usedSize++;
    }

public boolean contains(int toFind) {
    for (int i = 0; i < this.usedSize; i++) {
        if (toFind == this.elem[i]){
            return true;
        }
    }
    return false;
}


public int search(int toFind) {
    for (int i = 0; i < this.usedSize; i++) {
        if (toFind == this.elem[i]){
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
        System.out.println("没有当前要删除的元素");
        return;
    }
    for (int i = ret; i < this.usedSize-1; i++) {
        this.elem[i] = this.elem[i+1];
    }
    this.usedSize --;
}

public int size() {
    return this.usedSize;
}

public void clear() {
    this.usedSize = 0;
}

    public static void main(String[] args) {
      SeqList seqList = new SeqList();
        seqList.add(0,1);
        seqList.add(1,2);
        seqList.add(2,5);
        seqList.add(2,3);
        seqList.add(3,4);
        seqList.add(0,7);
        seqList.display();
        System.out.println();
        System.out.println(seqList.contains(2));
        System.out.println(seqList.search(3));
        System.out.println(seqList.size());
        System.out.println(seqList.getPos(6));
        seqList.remove(99);
    }
}