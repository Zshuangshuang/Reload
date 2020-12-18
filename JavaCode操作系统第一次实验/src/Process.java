/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 14342
 * Date: 2020-12-12
 * Time: 16:59
 **/
//进程类
public class Process {
    private String name;//进程名称
    private double arriveTime;//到达时间
    private double serviceTime;//服务时间



    //构造方法赋值
    public Process(String name, double arriveTime, double serviceTime) {
        this.name = name;
        this.arriveTime = arriveTime;
        this.serviceTime = serviceTime;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getArriveTime() {
        return arriveTime;
    }

    public void setArriveTime(double arriveTime) {
        this.arriveTime = arriveTime;
    }

    public double getServiceTime() {
        return serviceTime;
    }

    public void setServiceTime(double serviceTime) {
        this.serviceTime = serviceTime;
    }

    @Override
    public String toString() {
        return "Process name=" + name + ", arriveTime=" + arriveTime + ", serviceTime=" + serviceTime ;
    }

}