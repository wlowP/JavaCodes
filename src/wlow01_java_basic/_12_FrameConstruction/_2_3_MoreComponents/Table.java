package wlow01_java_basic._12_FrameConstruction._2_3_MoreComponents;

import javax.swing.*;
import java.awt.*;

public class Table extends JFrame {
    public static void main(String[] args) {
        new Table();
    }

    JTable table;

    public Table(){
        initFrame();
        initView();
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    }

    private void initView() {
        //定义最上面的每日一记
        JLabel title = new JLabel("表格组件");
        title.setBounds(220, 20, 584, 50);
        title.setFont(new Font("宋体", Font.BOLD, 32));
        this.getContentPane().add(title);

        //定义表格的标题
        Object[] tableTitles = {"编号", "标题", "正文"};
        //定义表格的内容
        //二维数组中的每一个一维数组，是表格里面的一行数据
        Object[][] tabledatas = {
                {"编号1", "标题1", "正文1"},
                {"编号2", "标题2", "正文2"},
                {"编号3", "标题3", "正文3"},
                {"编号4", "标题4", "正文4"},
                {"编号5", "标题5", "正文5"},
                {"编号6", "标题6", "正文6"},
                {"编号7", "标题7", "正文7"},
                {"编号8", "标题8", "正文8"},
                {"编号9", "标题9", "正文9"},
                {"编号10", "标题10", "正文10"},
                {"编号11", "标题11", "正文11"},
                {"编号12", "标题12", "正文12"},
                {"编号13", "标题13", "正文13"},
                {"编号14", "标题14", "正文14"},
                {"编号15", "标题15", "正文15"},
                {"编号16", "标题16", "正文16"},
                {"编号17", "标题17", "正文17"},
                {"编号18", "标题18", "正文18"},
                {"编号19", "标题19", "正文19"},
                {"编号20", "标题20", "正文20"},
                {"编号21", "标题21", "正文21"},
                {"编号22", "标题22", "正文22"},
                {"编号23", "标题23", "正文23"},
                {"编号24", "标题24", "正文24"},
                {"编号25", "标题25", "正文25"},
                {"编号26", "标题26", "正文26"},
                {"编号27", "标题27", "正文27"},
                {"编号28", "标题28", "正文28"},
                {"编号29", "标题29", "正文29"},
                {"编号30", "标题30", "正文30"},
        };

        //定义表格组件
        //并给表格设置标题和内容
        table = new JTable(tabledatas, tableTitles);
        table.setBounds(40, 70, 504, 380);

        //创建可滚动的组件，并把表格组件放在滚动组件中间
        //好处：如果表格中数据过多，可以进行上下滚动
        JScrollPane jScrollPane = new JScrollPane(table);
        jScrollPane.setBounds(40,70,504,380);
        this.getContentPane().add(jScrollPane);
    }

    private void initFrame(){
        //界面属性初始化.
        setSize(603, 680);
        setLocationRelativeTo(null);
        setTitle("表格界面");
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        //取消隐藏容器的默认居中放置.
        setLayout(null);
    }

}
