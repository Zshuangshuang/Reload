import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 14342
 * Date: 2020-12-14
 * Time: 13:58
 **/
public class Frame {
    //设置文本边框标题
    JFrame frame = new JFrame("第四次JavaWeb实验");
    //设置复选框
    JCheckBox course1 = new JCheckBox("组件技术");
    JCheckBox course2 = new JCheckBox("操作系统");
    JCheckBox course3 = new JCheckBox("网络计算");
    //设置按钮
    JRadioButton boy = new JRadioButton("男");
    JRadioButton girl = new JRadioButton("女");
    //用于结果显示的文本区
    JTextArea view = new JTextArea();
    //用于写的文本区
    JTextArea write = new JTextArea();

    public void run(){
        JPanel course = new JPanel();
        JPanel sex = new JPanel();
        JPanel name = new JPanel();
        JPanel text = new JPanel();
        /**
         * 将三个复选框加入p1，并设置边框
         * */
        course.add(course1);
        course.add(course2);
        course.add(course3);
        Border etched = BorderFactory.createEtchedBorder();
        TitledBorder border = BorderFactory.createTitledBorder(etched,"JCheckBox");
        course.setBorder(border);
        //将两个单选按钮添加到sex，并且设置边框
        sex.add(boy);
        sex.add(girl);
        border = BorderFactory.createTitledBorder(etched, "JRadioButton Group" );
        sex.setBorder(border);
        //创建buttonGroup组，并且在里面添加按钮
        ButtonGroup group = new ButtonGroup();
        group.add(boy);
        group.add(girl);
        //设置为写文本区p6添加滚动窗格
        JScrollPane jScrollPane1 = new JScrollPane(write);
        text.setLayout(new BorderLayout());
        text.add(jScrollPane1);
        border =BorderFactory.createTitledBorder(etched,"write");
        text.setBorder(border);

        JScrollPane jScrollPane2 = new JScrollPane(view);
        text.setLayout(new BorderLayout());
        text.add(jScrollPane2);
        border =BorderFactory.createTitledBorder(etched,"Results");
        text.setBorder(border);

       write.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                super.keyTyped(e);
                view.setText(write.getText());
            }

            @Override
            public void keyPressed(KeyEvent e) {
                super.keyPressed(e);
                view.setText(write.getText());
            }

            @Override
            public void keyReleased(KeyEvent e) {
                super.keyReleased(e);
                view.setText(write.getText());
            }
        });

        ItemListener itemListener1 = new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                JCheckBox cb = (JCheckBox) e.getSource();	//取得事件源
                    if (cb == course1){
                        view.append("\n 组件技术"+ course1.isSelected());
                    }else if (cb == course2){
                        view.append("\n 操作系统"+ course2.isSelected());
                    }else {
                        view.append("\n 网络计算"+ course3.isSelected());
                    }
            }
        };
        course1.addItemListener(itemListener1);
        course2.addItemListener(itemListener1);
        course3.addItemListener(itemListener1);
        //为单选按钮，实现监听器接口，添加监听器
        ItemListener al = new ItemListener () {
            public void itemStateChanged(ItemEvent e){
                JRadioButton rb = (JRadioButton) e.getSource();	//取得事件源
                if (rb == boy) {
                    view.append("\n你选择了性别男"+ boy.isSelected());
                } else if (rb == girl){
                    view.append("\n你选择了性别女"+ girl.isSelected());
                }
            }
        };
        boy.addItemListener(al);
        girl.addItemListener(al);


        Container cp = frame.getContentPane();
        cp.setLayout(new GridLayout(0,1));
        cp.add(name);
        cp.add(course);
        cp.add(sex);
        cp.add(text);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
