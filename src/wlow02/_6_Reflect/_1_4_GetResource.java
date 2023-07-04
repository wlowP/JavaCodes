package wlow02._6_Reflect;

import java.io.*;
import java.net.URL;

// 利用反射读取文件 - CLass对象.getResource, getResourceAsStream
public class _1_4_GetResource {
    public static void main(String[] args) throws IOException {
        Class<_1_4_GetResource> clazz = _1_4_GetResource.class;

        // getResource的根目录从编译后本模块的字节码文件夹开始, 路径开头加"/"表示
        // 📌返回的是URL对象, 可以用其getFile方法获得路径字符串
        URL url = clazz.getResource("/logback.xml");
        System.out.println("url = " + url);
        // url = file:/F:/codes/practice/JavaCodes/out/production/JavaCodes/logback.xml

        // 相对路径从class对象对应的类的字节码文件所在文件夹开始, 开头加"./"表示, 也可以省略"./"
        URL url1 = clazz.getResource(""); // 实参等效于("./")
        System.out.println("url1 = " + url1);
        // url1 = file:/F:/codes/practice/JavaCodes/out/production/JavaCodes/wlow02/_6_Reflect/
        // "../"跳出一级目录
        URL url2 = clazz.getResource("../");
        System.out.println("url2 = " + url2);
        // url2 = file:/F:/codes/practice/JavaCodes/out/production/JavaCodes/wlow02/

        // 📌找不到对应文件的话返回null
        System.out.println(clazz.getResource("./a.txt")); // null, 实参等效于("a.txt")


        // 📌URL对象的getFile()方法返回路径字符串, 可以用来构造File对象
        System.out.println(url.getFile()); // /F:/codes/practice/JavaCodes/out/production/JavaCodes/logback.xml
        System.out.println(new File(url.getFile())); // F:\codes\practice\JavaCodes\out\production\JavaCodes\logback.xml


        // 📌📌getResourceAsStream相当于获取到文件再建立一个对应的字节输入流对象, 比较方便. 📌找不到文件的话返回null
        InputStream resource = clazz.getResourceAsStream("/logback.xml");
        BufferedReader reader = new BufferedReader(new InputStreamReader(resource));
        System.out.println(reader.readLine()); // 对应文件的第一行
    }
}
