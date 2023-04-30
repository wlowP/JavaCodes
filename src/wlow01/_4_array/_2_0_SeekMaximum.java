package wlow01._4_array;

public class _2_0_SeekMaximum {
            //找出数组中的最大值.
    public static void main(String[] args) {
        int[] arr = {11, 99, 66, 999, 44, 77, 55, 88, 22, 100};

        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            //运用三元运算符. if也可以.
            max = arr[i] > max ? arr[i] : max ;
        }
        System.out.println("最大值为:" + max);

    }

}
