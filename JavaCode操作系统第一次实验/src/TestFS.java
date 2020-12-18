import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 14342
 * Date: 2020-12-12
 * Time: 17:29
 **/
public class TestFS {
    public static void main(String[] args) {
        //建立Process类型的集合类
        List<Process> list = new ArrayList<>();
        Process p1 = new Process("A",0.0,8.0);
        Process p2 = new Process("B",1.0,4.0);
        Process p3 = new Process("C",2.0,9.0);
        Process p4 = new Process("D",3.0,5.0);
        list.add(p1);
        list.add(p2);
        list.add(p3);
        list.add(p4);
        //实例化调度算法对象
        DispatcherWithFs dispatcher = new FirCFirS(list);
        dispatcher.solve(list);
    }
}