package wlow01._12_FrameConstruction._2_0_ActionListener_Button;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

//初步认识界面搭建.
public class Frame extends JFrame implements ActionListener {

    JButton bt1 = new JButton("点我呀~");
    JButton bt2 = new JButton("点我嘛~");
    Random r = new Random();

    public Frame() {
        initJFrame();
        initJMenuBar();
        initButton();

        setVisible(true);
    }

    private void initJFrame() {
        //界面属性初始化.
        setSize(603, 680);
        setLocationRelativeTo(null);
        setTitle("拼图游戏");
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        //取消隐藏容器的默认居中放置.
        setLayout(null);
    }

    private void initJMenuBar() {
        //初始化菜单. 创建菜单的对象.
        JMenuBar menuBar = new JMenuBar();

        //菜单上的选项. 创建选项的对象.
        JMenu menuFunction = new JMenu("功能");
        JMenu menuAbout = new JMenu("关于");

        //选项里的条目.
        JMenuItem itemRestart = new JMenuItem("重新开始");
        JMenuItem itemReLogin = new JMenuItem("重新登录");
        JMenuItem itemClose = new JMenuItem("退出游戏");

        JMenuItem itemAccount = new JMenuItem("V我50");

        //将选项应当包含的条目添加到选项当中.
        menuFunction.add(itemRestart);
        menuFunction.add(itemReLogin);
        menuFunction.add(itemClose);

        menuAbout.add(itemAccount);

        //将选项添加到菜单当中.
        menuBar.add(menuFunction);
        menuBar.add(menuAbout);

        //最后给整个界面设置菜单.
        setJMenuBar(menuBar);
    }

    private void initButton() {
        //给按钮设置位置和大小.
        bt1.setBounds(0, 100, 100, 50);
        bt2.setBounds(110, 100, 100, 50);
        //给按钮添加事件监听器. 由于在本类实现了ActionListener接口,
        //故可将本类对象直接传给下面add方法(形参为ActionListener).
        bt1.addActionListener(this);
        bt2.addActionListener(this);
        //***将按钮组件添加到界面. 别忘了先获取隐藏容器.
        //this.getContentPane().add(bt1);
        this.getContentPane().add(bt2);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //先获取被操作的那个组件对象并用祖宗类Object多态接收.(多态接收方便些)
        Object source = e.getSource();
        if (source == bt2){
            bt2.setSize(r.nextInt(50,200), r.nextInt(50, 200));
            bt2.setLocation(r.nextInt(504), r.nextInt(631));
        }
    }
}
