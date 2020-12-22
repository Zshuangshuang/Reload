import javax.swing.*;
import java.awt.*;

/**
 * @Auther:ZouSS
 * @Description:
 * @Date 2020-12-22 18:22
 */
public class Target {
    int i;

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setVisible(true);
        frame.setBounds(400,500,400,500);
        Target target = new Target();
        frame.setLayout(new GridLayout(2,2));
        new MyThread("A",0,frame,target).start();
        new MyThread("B",1,frame,target).start();
        new MyThread("C",2,frame,target).start();
        new MyThread("D",3,frame,target).start();
    }
}
