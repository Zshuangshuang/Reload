import javax.swing.*;
public class SelCourse extends JFrame {
    public SelCourse(){
        super("选课信息");
        JPanel panel=new JPanel();
        JLabel name=new JLabel();
        name.setText("姓名：");
        final JTextField name1 = new JTextField(10);
        JLabel sex=new JLabel();
        sex.setText("性别：");
        final JRadioButton sex1 = new JRadioButton("男");
        sex1.setSelected(true);
        final JRadioButton sex2=new JRadioButton("女");
        sex1.addChangeListener(e -> {
            if(sex1.isSelected()){sex2.setSelected(false);
            }
        });
        sex2.addChangeListener(e -> {
            if(sex2.isSelected()){sex1.setSelected(false);
            }
        });
        final JCheckBox c=new JCheckBox("java web ");
        final JCheckBox java=new JCheckBox("操作系统");
        final JButton confirm=new JButton("确定");
        final JButton cancel=new JButton("取消");
        final JTextArea msg=new JTextArea(8,15);
        msg.setEditable(false);
        confirm.addActionListener(e -> {
            StringBuffer sb=new StringBuffer();
            sb.append("姓名：").append(name.getText()).append("\n");
            sb.append("性别：").append(sex1.isSelected()?"男":"女").append("\n");
            sb.append("所选课程如下：\n");sb.append(c.isSelected()?"java web\n":"");
            sb.append(java.isSelected()?"操作系统":"");
            msg.setText(sb.toString());
        });
        cancel.addActionListener(arg0 -> msg.setText(""));
        add(panel);
        panel.add(name,"Center");
        panel.add(name1,"Center");
        panel.add(sex,"Center");
        panel.add(sex1,"Center");
        panel.add(sex2,"Center");
        panel.add(c,"Center");
        panel.add(java,"Center");
        panel.add(confirm,"Center");
        panel.add(cancel,"Center");
        panel.add(msg,"Center");
        setSize(200,350);
        setLocation(500,100);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);}
        public static void main(String[] args) {
        new SelCourse();
    }
}