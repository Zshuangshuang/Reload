import java.util.ArrayList;

/**
 * @Auther:ZouSS
 * @Description:事件源，主要的方法是有参数的构造方法和无参数的构造方法，添加学生人数，添加监听器，通知监听器和删除监听类
 * @Date 2020-12-20 17:45
 */
public class SelectCourse {
    public MyListener myListener;//定义一个监听对象
    public String courseName;//定义课程名字
    public int maxNum;//定义人数限额
    public int curNum;//定义当前人数
    public ArrayList<String> students = new ArrayList<>();//定义一个集合类来保存学生人数
    //无参构造方法
    public SelectCourse(){
        this.courseName = "组件技术";
    }
    //有参构造方法
    public SelectCourse(String courseName){
        this.courseName = courseName;
    }
    //添加选课学生
    public int addStudent(String name){
        students.add(name);
        curNum = students.size();
        return curNum;
    }
    //设置最大限额
    public void setMaxNum(int n){
        this.maxNum = n;
    }
    //添加监听器
    public void addListener(Listener listener){
        myListener = listener;
    }
    //通知监听器
    public void notifyListener(){
        MyEvent event = new MyEvent(this,maxNum,curNum);
        myListener.MyEvent(event);
    }
    //删除监听器
    public void deleteListener(){
        myListener = null;
    }
}
