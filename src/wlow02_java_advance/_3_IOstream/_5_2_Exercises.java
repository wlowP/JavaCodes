package wlow02_java_advance._3_IOstream;

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;

public class _5_2_Exercises {
    public static void main(String[] args) throws IOException {
        sortText();
    }

    private static void sortText() throws IOException {
        // 对文件中的文本进行排序
        BufferedReader br = new BufferedReader(new FileReader("IOPractice/csb.txt"));
        String str;
        // 也可以用TreeMap, 键名是序号, 键值是句子内容
        ArrayList<String> sentences = new ArrayList<>();
        while ((str = br.readLine()) != null)
            sentences.add(str);
        // 排序, 然后写到新文件中
        sentences.sort(Comparator.comparingInt(s -> Integer.parseInt(s.substring(0, 1))));
        System.out.println(sentences);

        BufferedWriter bw = new BufferedWriter(new FileWriter("IOPractice/csb_sorted"));
        for (String sentence : sentences) {
            bw.write(sentence);
            bw.newLine();
        }

        bw.close();
        br.close();
    }
}
