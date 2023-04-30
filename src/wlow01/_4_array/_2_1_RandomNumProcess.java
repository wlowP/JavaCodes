package wlow01._4_array;

import java.util.Random;

public class _2_1_RandomNumProcess {
    //对一系列随机数进行处理.
    public static void main(String[] args) {

        Random r = new Random();
        int[] arr1 = new int[10];
        int sum = 0;
        int count = 0;

        //对随机数求和.
        for (int i = 0; i < arr1.length; i++) {
            arr1[i] = r.nextInt(1, 101);
            sum += arr1[i];
            //让我看看都是那些数据.
            System.out.println(arr1[i]);
        }
        System.out.println("随机数求和:" + sum);

        //计算并打印出平均值.
        int average = sum / arr1.length;
        System.out.println("求平均数:" + average);

        //找出其中小于平均值的数.
        for (int i = 0; i < arr1.length; i++) {
            count += arr1[i] < average ? 1 : 0;
        }
        System.out.println("其中有" + count + "个数比平均值小.");

    }
}
