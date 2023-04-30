package wlow01._12_FrameConstruction._2_2_KeyListener;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Frame extends JFrame implements KeyListener {

    public Frame(){
        initJFrame();

        addKeyListener(this);
        this.setVisible(true);
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

    @Override
    public void keyTyped(KeyEvent e) {
        //System.out.println("识别到键入");
    }

    @Override
    public void keyPressed(KeyEvent e) {
        System.out.println("识别到按下按键");
    }

    @Override
    public void keyReleased(KeyEvent e) {
        System.out.println(e.getKeyChar());
        System.out.println(e.getKeyCode());
        System.out.println("识别到松开按键");
    }
}
