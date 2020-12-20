import java.util.ArrayList;

/**
 * @Auther:ZouSS
 * @Description:
 * @Date 2020-12-20 19:02
 */
public class SelectCourse {
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
