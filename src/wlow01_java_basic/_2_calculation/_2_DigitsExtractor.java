package wlow01_java_basic._2_calculation;

import java.util.Scanner;

public class _2_DigitsExtractor {
    public static void main(String[] args) {
        //键盘录入四位数.
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入一个四位数>");
        int num = sc.nextInt();

        //开始提取个位十位百位.
        int ge = num % 10;
        int shi = num / 10 % 10;
        int bai = num / 100 % 10;
        int qian = num / 1000 % 10;

        //输出结果.
        System.out.println("个位:" + ge);
        System.out.println("十位:" + shi);
        System.out.println("百位:" + bai);
        System.out.println("千位:" + qian);

    }
}
