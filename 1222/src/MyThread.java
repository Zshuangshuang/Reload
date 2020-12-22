import javax.swing.*;

/**
 * @Auther:ZouSS
 * @Description:
 * @Date 2020-12-22 18:23
 */
public class MyThread extends Thread{
    private int index;
    private Target t;
    private JFrame frame;
    private JPanel panel;
    public MyThread(String name,int index,JFrame frame,Target t){
        super(name);
        this.frame = frame;
        this.index = index;
        this.t = t;
        panel = new JPanel();
        panel.setVisible(true);
        JLabel label = new JLabel("标签"+(index+1));
        panel.add(label);
        panel.setVisible(false);
        frame.add(panel);
    }
        public void run(){
             while(true){
                 synchronized(frame){
                     while(t.i != index){
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
