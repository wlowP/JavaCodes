package wlow01_java_basic._6_exercises;

import java.util.Random;

public class _6_Lottery {
            //模拟抽奖情况
    public static void main(String[] args) {
        int[] arr1 = {2, 588, 888, 1000, 10000};
        Random r = new Random();
        //***直接打乱原数组就好了!不要再创一个包含随机索引的数组!!
        for (int i = 0; i < arr1.length; i++) {
            int tempi = arr1[i];
            int p = r.nextInt(arr1.length);
            arr1[i] = arr1[p];
            arr1[p] = tempi;
        }
        for (int i = 0; i < arr1.length; i++) {
            System.out.println(arr1[i] + "元的奖金被抽出");
        }
    }


}
