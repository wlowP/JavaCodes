package wlow01._12_FrameConstruction._1_1_Menu;

import javax.swing.*;

public class FrameMenu extends JFrame{

    public FrameMenu(){
        initJFrame();
        initJMenuBar();

        setVisible(true);
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

    private void initJFrame() {
        //界面属性初始化.
        setSize(603, 680);
        setLocationRelativeTo(null);
        setTitle("拼图游戏");
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        //取消隐藏容器的默认居中放置.
        setLayout(null);
    }
}
