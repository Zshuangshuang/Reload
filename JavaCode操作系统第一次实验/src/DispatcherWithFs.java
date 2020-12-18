import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 14342
 * Date: 2020-12-12
 * Time: 17:09
 **/
//进程调度接口，提供进程调度算法
public interface DispatcherWithFs {
    void solve(List<Process> processes);
}