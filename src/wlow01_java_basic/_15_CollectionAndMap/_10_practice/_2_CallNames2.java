package wlow01_java_basic._15_CollectionAndMap._10_practice;

import java.util.Random;

// 用数组实现按概率分区间点名
// 70%从arr1中抽, 30%从arr2中抽
public class _2_CallNames2 {
    public static void main(String[] args) {
        Random r = new Random();
        int[] arr1 = {1, 2, 3, 4, 5},
              arr2 = {11, 22, 33, 44, 55, 66, 77, 88, 99},
              p = {1, 1, 1, 1, 1, 1, 1, 0, 0, 0},
              target;
        for (int i = 0; i < 50; i++) {
            if (p[r.nextInt(p.length)] == 1) target = arr1;
            else target = arr2;
            System.out.println(target[r.nextInt(target.length)]);
        }
    }
}
