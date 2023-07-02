package wlow02._9_XML;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.File;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;

// dom4j解析xml文件
public class _1_readXML {
    public static void main(String[] args) throws MalformedURLException, DocumentException {
        // dom4j先基于SAX逐行解析xml, 再创建出document对象
        // 1.创建SAX解析器
        SAXReader reader = new SAXReader();
        // 2.读取xml文件, 并返回Document对象, 即是xml文件的整体
            // read方法也可以传递字节/字符流对象
        Document document = reader.read(new File("files/xml/xml.xml"));

        // 获取根标签对象
        Element root = document.getRootElement();
        System.out.println(root.getName());

        System.out.println("=======");

        // 获取子标签的名字, 属性名, 属性值
        for (Element element : root.elements()) {
            System.out.print(element.getName() + " ");
            for (Attribute attribute : element.attributes()) {
                System.out.printf("%s=%s", attribute.getName(), attribute.getValue());
            }
            System.out.println();
        }

        System.out.println(parse(document));

/*        // 用迭代器遍历标签对象
        Element el;
        for (Iterator<Element> it = root.elementIterator(); it.hasNext(); ){
            el = it.next();
            System.out.println(el.getName());
        }*/
    }

    // 将xml转换成对象列表
    static List<Person> parse(Document doc){
        Element root = doc.getRootElement();
        List<Person> list = new ArrayList<>();
        // 根标签内有各种名字的标签时, 别忘了可以指定名称获取person标签:
        for (Element el : root.elements("person")) {
            list.add(new Person(
                    // 没有进行非空判断, 要是xml格式不规范的话会出错
                    el.attribute("type").getValue(),
                    el.element("id").getText(),
                    el.element("name").getText()
            ));
        }
        return list;
    }
}

class Person{
    String id, type, name;
    public Person(String id, String type, String name) {
        this.id = id;
        this.type = type;
        this.name = name;
    }
    @Override
    public String toString() {
        return "Person{" +
                "id='" + id + '\'' +
                ", type='" + type + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}