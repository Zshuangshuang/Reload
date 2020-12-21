import javax.swing.*;
import java.awt.*;

public class Tag {
        int i;
    public static void main(String[] args) throws Exception {
        //实例化JFrame对象
        JFrame frame=new JFrame();
        //让frame对象可见
        frame.setVisible(true);
        //设置frame的大小
        frame.setBounds(600,450,600,400);
        Tag a = new Tag();
        frame.setLayout(new GridLayout(2,2));
        new MyThread(0,"A",frame,a).start();
        new MyThread(1,"B",frame,a).start();
        new MyThread(2,"C",frame,a).start();
        new MyThread(3,"D",frame,a).start();
    }
}

