package wlow01_java_basic._4_array;

import java.util.Random;

public class _2_3_NumDisarrange {
            //***随机打乱一个数组中元素的顺序
    public static void main(String[] args) {

        Random r = new Random();

        int[] arr1 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20};

        for (int i = 0; i < arr1.length; i++) {
            //缓存初始的元素.
            int tempi = arr1[i];
            //***生成随机索引:
            int ranIndex = r.nextInt(arr1.length);
            //***逐个往后随机找元素交换顺序,
            //就可确保完全打乱且结果不重复.
            arr1[i] = arr1[ranIndex];
            arr1[ranIndex] = tempi;
        }

        //看看结果.
        for (int i = 0; i < arr1.length; i++) {
            System.out.print(arr1[i] + " ");
        }


    }
}
