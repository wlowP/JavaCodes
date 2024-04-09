package wlow01_java_basic._13_SomeAPI._2_System;

import java.util.Arrays;

//系统类的一些方法.
public class _1_0_SomeFunctions {
    public static void main(String[] args) {
        System.out.println(System.currentTimeMillis());

        double[] arr = {1.1, 2.2, 3.3, 4.4, 5.5};
        double[] arr1 = new double[5];
        System.arraycopy(arr, 0, arr1, 2, 2);
        System.out.println(Arrays.toString(arr1)); //[0.0, 0.0, 1.1, 2.2, 0.0]
    }
}
