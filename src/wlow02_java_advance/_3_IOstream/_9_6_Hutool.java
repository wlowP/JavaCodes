package wlow02_java_advance._3_IOstream;

import cn.hutool.core.io.FileUtil;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// 体验 Hutool 糊涂工具包
/*
* 官网：
* 	https://hutool.cn/
* API文档：
* 	https://apidoc.gitee.com/dromara/hutool/
*
* 中文使用文档：
* 	https://hutool.cn/docs/#/
* */
public class _9_6_Hutool {
    public static void main(String[] args) {
        // 体验Hutool中的FileUtil工具类
        // 创建File对象, 可以用可变参数
        File file = FileUtil.file("F:/", "aa", "bb", "cc.txt");
        System.out.println(file); // F:\aa\bb\cc.txt

        // 创建文件: touch方法即使父级路径不存在也能自动帮忙创建
        File touch = FileUtil.touch("F:/codes/practice/myIOPractice/touch.txt");
        System.out.println(touch);

        // 把集合中的数据写入到文件中.
        ArrayList<String> list = new ArrayList<>();
        Collections.addAll(list, "aaa", "bbb", "ccc");
        // 最后一个参数可开启续写
        //FileUtil.writeLines(list, touch, "UTF-8", true);
        //FileUtil.appendLines(list, touch, "UTF-8");

        // 读取文件中的每一行数据, 放到集合中并返回. 还能再传递一个集合, 让返回的数据追加到该集合中.
        List<String> res = FileUtil.readLines(touch, "UTF-8");
        System.out.println(res);
    }
}
