package wlow02._1_MethodReference;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;

public class _1_2_ReferenceThisAndSuper {
    public static void main(String[] args) {
        /*ArrayList<Integer> list = new ArrayList<>(List.of(1, 2, 3, 4, 5));
        System.out.println(new Something().process(list));
        // [0, 1, 2, 3, 4]*/
        new Frame();
    }
}
class ParentFrame extends JFrame{
    public void method(ActionEvent e){
        System.out.println("点击了button, 引用到父类中的方法");
    }
}
class Frame extends ParentFrame{
    JButton btn = new JButton("button");
    JButton btn1 = new JButton("button1");
    public Frame(){
        initFrame();
        initView();
        this.setVisible(true);
    }

    public void initView(){
        btn.setFont(new Font(null, 1, 20));
        btn.setBounds(120, 274, 150, 50);
        btn.setBackground(Color.WHITE);
        btn1.setFont(new Font(null, 1, 20));
        btn1.setBounds(120, 204, 150, 50);
        btn1.setBackground(Color.WHITE);
        // addActionListener的形参是ActionListener接口, 也是函数式接口
        // 于是可以用lambda表达式或者方法引用,
        btn.addActionListener(super::method);
        btn1.addActionListener(this::method1);
        this.getContentPane().add(btn);this.getContentPane().add(btn1);
    }
    // 方法引用时注意形参和返回值要跟函数接口里的方法一样.
    // ActionListener接口里的方法:
    // public void actionPerformed(ActionEvent e);
    private void method1(ActionEvent e){
        System.out.println("点击了button1");
    }

    public void initFrame(){
        this.setTitle("一个界面");
        this.setSize(400, 500);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setLayout(null);
        this.getContentPane().setBackground(Color.WHITE);
        this.setAlwaysOnTop(true);
    }
}

class Sth{
    public int subtract(Integer num){
        return num - 1;
    }
}
class Something extends Sth{
    public Something(){}
    public List<Integer> process(ArrayList<Integer> list){
        return list.stream().map(super::subtract).toList();
    }
    public int multiply(Integer num){
        return num * 10;
    }
}
