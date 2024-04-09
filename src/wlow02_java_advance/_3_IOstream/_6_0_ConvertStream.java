package wlow02_java_advance._3_IOstream;

import java.io.*;
import java.nio.charset.Charset;

// 转换流
public class _6_0_ConvertStream {
    public static void main(String[] args) throws IOException {

        // JDK11以前利用字符转换流指定字符编码读取数据 (目标文本文件编码格式是GBK 不是默认的UTF-8)
       /*
        * ISR把字节流转换成字符流, 所以构造方法传递字节流输入流对象
        * 转换成字符流后就可以根据字符集一次读取多个字节, 就不会读出乱码了
        * ISR的构造方法传递第二个参数(📌字符串)指定字符集
        * FileReader 就继承了 ISR
        * */
        InputStreamReader isr = new InputStreamReader(new FileInputStream("IOPractice/济南的冬天_GBK.txt"), "GBK");
        int count;
        char[] buffer = new char[10];
        while ((count = isr.read(buffer)) != -1)
            System.out.print(new String(buffer, 0, count));
        isr.close();

        /*
         * OSR将字符流转换为字节流, 构造方法传递字节输出流对象, 再传递第二个字符串表示字符集
         * */
        OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream("IOPractice/osw_target.txt", true), "GBK");
        osw.write("铃仙·优昙华院·因幡");
        osw.close();



        // 更好的替代方案(JDK11) --> 字符流直接指定字符集
        // 📌JDK11之后FileReader和FileWriter就可以传递第二个Charset类型参数指定读取时的字符集
        // 调用Charset类的静态方法forName, 传递字符串表示的字符集.
        FileReader fr = new FileReader("IOPractice/济南的冬天_GBK.txt", Charset.forName("GBK"));
        int ch1;
        while ((ch1 = fr.read()) != -1)
            System.out.print((char)ch1);
        fr.close();

        FileWriter fw = new FileWriter("IOPractice/osw_target.txt", Charset.forName("GBK"), true);
        fw.write("铃仙·优昙华院·因幡");
        fw.close();
    }
}
