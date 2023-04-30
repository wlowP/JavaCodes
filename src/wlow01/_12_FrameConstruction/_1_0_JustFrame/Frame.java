package wlow01._12_FrameConstruction._1_0_JustFrame;

import javax.swing.*;
import java.awt.*;

public class Frame {
    public static void main(String[] args) {
        JFrame jf = new JFrame("人生第一个自己建的界面");
        jf.setSize(400,600);
        jf.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        jf.setLocationRelativeTo(null);
        jf.setLayout(null);
        JLabel jl = new JLabel("文本测试文本测试文本测试文本测试");
        jl.setBounds(0, 0, 500, 250);
        jl.setFont(new Font("华文隶书", 0, 30));
        jf.add(jl);
        jf.setVisible(true);

    }
}
