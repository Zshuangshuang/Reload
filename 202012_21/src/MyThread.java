import javax.swing.*;

class MyThread extends Thread{
    private  int index;
    private JFrame frame;
    private JPanel panel;
    private Tag select;
    
public MyThread(int index, String name, JFrame frame,Tag select) {
        super(name);
        this.index = index;
        this.frame = frame;
        this.select=select;
        //创建panel对象
        panel=new JPanel();
        //实例化button
        JButton button = new JButton("标签" + (index + 1));
        //将button添加到panel容器中
        panel.add(button);
        //让panel不可见
        panel.setVisible(false);
        //将panel添加到frame中去
        frame.add(panel);
    }
    @Override
    public void run() {
        while (true){
            synchronized (frame){
                while(index!=select.i){

                    try {
                        frame.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
                panel.setVisible(true);
                select.i=(++select.i)%4;
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                panel.setVisible(false);
                    frame.notifyAll();

            }
        }
    }
}
