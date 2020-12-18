import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 14342
 * Date: 2020-12-12
 * Time: 17:11
 **/
public class FirCFirS implements DispatcherWithFs, CalDataFs {

    private List<Process> list;//定义要操作的进程对象集合
    private int processCount;//进程数量


    //有参构造方法，一会儿给进程赋值
    public FirCFirS(List<Process> processes) {
        this.list = processes;
        this.processCount = processes.size();
    }

    @Override
    public void solve(List<Process> processes) {
        System.out.println("进程名"+" " + "开始执行时间" +" "+ "执行结束时间 "+" "
                + "周转时间"+" " + "带权周转时间");
        for (Process process : processes) {
            System.out.println(process.getName() + "\t"+"\t" + startTime(process) +
                    "\t"+"\t" + endTime(process) + "\t"+"\t"+"\t" + turnAroundTime(process) +
                    "\t"+"\t"+"\t" + turnAroundWithWeightTime(process));
        }
        System.out.println("---");
        System.out.println("平均周转时间 ：" + avgTurnAroundTime());
        System.out.println("平均带权周转时间 ：" + avgTurnAroundWithWeightTime());
    }

    @Override
    public Integer startTime(Process process) {
        int startTime = 0;
        for (int i = 0; i < processCount; i++) {
            //判断当前进场是哪个进程，第一个进程的开始时间就是0，i+1个进程是i-1进程的结束时间
                if (process.equals(list.get(i))){
                    startTime = (int) (i == 0 ? process.getArriveTime() : endTime(list.get(i - 1)));
                }
        }
        return startTime;
    }

    @Override
    public Integer endTime(Process process) {
        int endTime = 0;
        //结束时间 = 开始时间+运行时间
        for (int i = 0; i < processCount; i++) {
            endTime = (int) (startTime(process) + process.getServiceTime());
        }
        return endTime;
    }

    @Override
    public Integer turnAroundTime(Process process) {
        int turnAroundTime = 0;
        //运转时间 = 结束时间 - 到达时间
        for (int i = 0; i < processCount; i++) {
            if (process.equals(list.get(i))){
                turnAroundTime = (int)(endTime(process)-process.getArriveTime());
            }
        }
        return turnAroundTime;
    }

    @Override
    public Double turnAroundWithWeightTime(Process process) {
        double turnAroundWithWeightTime = 0.0;
        //带权周转时间 = 周转时间/运行时间
        for(int i = 0; i < processCount; i++) {
            if(process.equals(list.get(i))) {
                turnAroundWithWeightTime = turnAroundTime(process) / process.getServiceTime();
            }
        }
        return turnAroundWithWeightTime;
    }

    @Override
    public Double avgTurnAroundTime() {
        double sumTime = 0.0;
        for (int i = 0; i < processCount; i++) {
            sumTime += turnAroundTime(list.get(i));
        }
        return sumTime / processCount;
    }

    @Override
    public Double avgTurnAroundWithWeightTime() {
        double sumTime = 0.0;
        for (int i = 0; i < processCount; i++) {
            sumTime += turnAroundWithWeightTime(list.get(i));
        }
        return sumTime/processCount;
    }
}