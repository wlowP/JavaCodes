package wlow01_java_basic._1_import;

import java.util.Random;

public class _2_Random {
    public static void main(String[] args) {

        Random r = new Random();
        for (int i = 0; i <= 100; i++) {
            int num = r.nextInt(1, 10);
            //*如果范围是r.nextInt(bound:10),
            //*则输出的数据真实范围是0~9.
            //包头不包尾, 包左不包右.
            System.out.println(num);
        }

    }
}
