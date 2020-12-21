import java.util.*;
class MyEvent extends EventObject {
    int maxNum;
    int curNum;
    public MyEvent(Object source,int maxNum,int curNum) {
        super(source);
        this.maxNum = maxNum;
        this.curNum = curNum;
    }
}
interface MyListener extends EventListener {
     void MyEvent(MyEvent event);
}
class Listener implements MyListener{
    public void MyEvent(MyEvent myEvent){
        if (myEvent.curNum > myEvent.maxNum){
            System.out.println("超出人数限额");
            System.out.println("当前人数为："+myEvent.curNum);
            System.out.println("限额人数为："+myEvent.maxNum);
            System.out.println("请重新设置限额人数：");
            SelectCourse sc = new SelectCourse();
            Scanner scanner = new Scanner(System.in);
            sc.setMaxNum(scanner.nextInt());
        }
    }
}
class SelectCourse {
    public MyListener myListener;
    public String courseName;
    public int maxNum;
    public int curNum;
    public ArrayList<String > students = new ArrayList<>();

    public SelectCourse() {
    }

    public SelectCourse(String courseName) {
        this.courseName = courseName;
    }
    public void setMaxNum(int n){
        this.maxNum = n;
    }
    public int addStudent(String name){
        students.add(name);
        curNum = students.size();
        return curNum;
    }
    public void addListener(Listener listener){
        myListener = listener;
    }
    public void notifyListener(){
        MyEvent event = new MyEvent(this,maxNum,curNum);
        myListener.MyEvent(event);
    }
    public void removeListener(){
        myListener = null;
    }
}
public class Test {
    public static void main(String[] args) {
        SelectCourse sc = new SelectCourse("操作系统");
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入限额人数：");
        int max = scanner.nextInt();
        sc.setMaxNum(max);
        sc.addStudent("张三");
        sc.addStudent("李四");
        sc.addStudent("王五");
        sc.addListener(new Listener());
        sc.notifyListener();
    }
}
