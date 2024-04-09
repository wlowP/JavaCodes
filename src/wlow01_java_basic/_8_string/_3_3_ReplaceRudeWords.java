package wlow01_java_basic._8_string;


import java.util.Scanner;

public class _3_3_ReplaceRudeWords {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入您的聊天内容>");
        String chat = sc.next();

        System.out.println(clean(chat));
    }

    public static String clean(String sentence){

        String[] rude = {"WTF" , "TMD" , "WDNMD" , "SB" , "食不食油饼"};
        for (int i = 0; i < rude.length; i++) {
            sentence = sentence.replace(rude[i] , "***");
        }

        return sentence;
    }
}
