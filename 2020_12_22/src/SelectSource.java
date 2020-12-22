import java.util.ArrayList;

/**
 * @Auther:ZouSS
 * @Description:
 * @Date 2020-12-22 18:13
 */
public class SelectSource {
    public MyListener myListener;
    public int maxNum;
    public int curNum;
    public String courseName;
    public ArrayList<String> students = new ArrayList<>();
    public SelectSource(){
        this.courseName = "组件技术";
    }
    public SelectSource(String courseName){
        this.courseName = courseName;
    }
    public int addStudent(String name){
        students.add(name);
        curNum = students.size();
        return curNum;
    }
    public void setMaxNum(int n){
        this.maxNum = n;
    }
    public void addListener(Listener listener){
        myListener = listener;
    }
    public void notifyListener(){
        MyEvent event = new MyEvent(this,maxNum,curNum);
        myListener.MyEvent(event);
    }
}
