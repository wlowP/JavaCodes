package wlow01._12_FrameConstruction._2_1_MouseListener;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;

public class Frame extends JFrame implements MouseListener {

    JButton bt1 = new JButton("你点我呀~");
    JButton bt2 = new JButton("你点不到我~");
    Random r = new Random();
    public Frame(){
        initJFrame();
        initButton();

        setVisible(true);
    }

    private void initJFrame() {
        //界面属性初始化.
        setSize(603, 680);
        setLocationRelativeTo(null);
        setTitle("界面");
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        //取消隐藏容器的默认居中放置.
        setLayout(null);
    }

    private void initButton(){
        bt1.setBounds(300, 170, 100,100);
        bt2.setBounds(300, 510, 100,100);

        bt1.addMouseListener(this);
        bt2.addMouseListener(this);

        getContentPane().add(bt1);
        getContentPane().add(bt2);
    }

    @Override
    public void mouseClicked(MouseEvent e) {        Object source = e.getSource();
        if (source == bt1){
            System.out.println("鼠标点击了按钮1");
        }else if(source == bt2){
            System.out.println("鼠标点击了按钮2");
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        Object source = e.getSource();
        if (source == bt1){
            System.out.println("鼠标按住了按钮1");
        }else if(source == bt2){
            System.out.println("鼠标按住了按钮2");
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        Object source = e.getSource();
        if (source == bt1){
            System.out.println("鼠标松开了按钮1");
        }else if(source == bt2){
            System.out.println("鼠标松开了按钮2");
        }
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        Object source = e.getSource();
        if (source == bt1){
            bt1.setBounds(r.nextInt(500), r.nextInt(620), r.nextInt(50,200),r.nextInt(50,200));
        }else if(source == bt2){
            bt2.setBounds(r.nextInt(500), r.nextInt(620), r.nextInt(50,200),r.nextInt(50,200));
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
/*        Object source = e.getSource();
        if (source == bt1){
            System.out.println("鼠标离开了按钮1");
        }else if(source == bt2){
            System.out.println("鼠标离开了按钮2");
        }*/
    }
}
