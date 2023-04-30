package wlow01._13_SomeAPI._9_Arrays;

import java.util.Arrays;
import java.util.Comparator;

public class _1_Basic {
    public static void main(String[] args) {
        int[] arr = {1, 4, 3, 56, 123, 6, 10};
        System.out.println(Arrays.toString(arr));

        Integer[] arr1 = {324, 67, 213, 9, 45, 11, 4, 1};
        Arrays.sort(arr1, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        System.out.println(Arrays.toString(arr1));

    }
}
