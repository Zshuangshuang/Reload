import javax.swing.*;
import java.awt.*;
 class TargetDemo {
    int i;
    public static void main(String[] args){
        JFrame frame = new JFrame();
        frame.setVisible(true);
        frame.setBounds(600,400,500,400);
        TargetDemo t = new TargetDemo();
        frame.setLayout(new GridLayout(2,2));
        new MyThread("A",0,frame,t).start();
        new MyThread("B",1,frame,t).start();
        new MyThread("C",2,frame,t).start();
        new MyThread("D",3,frame,t).start();
    }
}

public class MyThread extends Thread{
    private int index;
    private JFrame frame;
    private JPanel panel;
    private TargetDemo t;
    public MyThread(String name,int index,JFrame frame,TargetDemo t){
        super(name);
        this.index = index;
        this.frame = frame;
        this.t = t;
        panel = new JPanel();
        panel.setVisible(true);
        JLabel label = new JLabel("标签："+(index+1));
        panel.add(label);
        panel.setVisible(false);
        frame.add(panel);
    }
    @Override
    public void run(){
        while(true){
            synchronized(frame){
                while (index != t.i){
                    try{
                        frame.wait();
                    }catch (InterruptedException e){
                        e.printStackTrace();
                    }
                }
                panel.setVisible(true);
                t.i = (++t.i)%4;
                try{
                   Thread.sleep(1000);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
                panel.setVisible(false);
                frame.notifyAll();
            }
        }
    }
}
