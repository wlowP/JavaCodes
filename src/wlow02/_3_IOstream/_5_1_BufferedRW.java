package wlow02._3_IOstream;

import java.io.*;

// 字符缓冲流
public class _5_1_BufferedRW {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("IOPractice/济南的冬天.txt"));
        String line;
        // 一次读一整行字符, 返回值是String, 读完了返回null
        // 📌readLine方法不会读取换行符, 用print方法的话会全部打印到一行
        while ((line = br.readLine()) != null){
            System.out.println(line);
        }

        // 📌开启续写的话还是要在基本流FileWriter构造方法中打开.
        BufferedWriter bw = new BufferedWriter(new FileWriter("IOPractice/bw_target.txt", true));
        bw.write("line");
        // 📌用这个方法换行能适应不同的操作系统, 好过自己决定\r还是\n还是\r\n
        bw.newLine();
        bw.write("end");

        bw.close();
        br.close();
    }
}
