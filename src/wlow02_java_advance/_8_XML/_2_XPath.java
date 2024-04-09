package wlow02_java_advance._8_XML;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;

import java.io.File;
import java.util.List;

// 利用XPath路径检索技术快速获取xml中某些节点的信息
public class _2_XPath {
    public static void main(String[] args) throws DocumentException {
        SAXReader reader = new SAXReader();
        Document doc = reader.read(new File("IOPractice/files/xml/students.xml"));
        Element root = doc.getRootElement();

        // 主要方法是selectSingleNode和selectNodes, 📌要传递xml中的路径表达式
        // selectSingleNode选择单独的一个节点. 有多个路径相同的节点的话返回第一个
        // selectNodes选择所有符合路径表达式的节点

        System.out.println("=======");

        // 1.使用绝对路径, 从根节点开始
        Node n = root.selectSingleNode("/students/student/book");
        System.out.println(((Element)n).element("title").getText());

        List<Node> nodes = root.selectNodes("/students/student/book/title");
        for (Node node : nodes) {
            System.out.println(node.getText());
        }

        System.out.println("=======");

        // 2.使用相对路径, 从当前节点开始. ./ ../表示当前节点, 当前节点的上一级节点
        System.out.println(n.selectSingleNode("./author").getText());
        System.out.println(n.selectSingleNode("../name").getText());

        System.out.println("=======");

        // 3.使用全文检索, 就算不同级的标签都能找出来
        List<Node> nodes1 = root.selectNodes("//score");
        List<Node> nodes2 = root.selectNodes("//student//price");
        System.out.println(nodes1);
        System.out.println(nodes2);

        System.out.println("=======");

        // 📌📌查找属性节点or带属性的标签节点, @...
        System.out.println(root.selectNodes("//@id"));
        System.out.println(root.selectSingleNode("//student[@attr]"));
        System.out.println(root.selectSingleNode("//score[@id='002']"));

        // 控制台输出:
/*      =======
        钢铁是怎样炼成的
        钢铁是怎样炼成的
        朝花夕拾
        围城
        =======
        尼古拉·奥斯特洛夫斯基
        张三
        =======
        [...三个分数标签节点...]
        [...两个price标签节点...]
        =======
        [...三个id属性节点, 📌注意是属性节点不是标签节点...]
        ...李四标签节点...
        ...JAVA程序设计标签节点...
        */
    }
}
