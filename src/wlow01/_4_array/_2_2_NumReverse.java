package wlow01._4_array;

public class _2_2_NumReverse {
            //将数组中的元素对称排列.
    public static void main(String[] args) {
        int[] arr1 =  {1, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20};
        for (int i = 0, j = arr1.length - 1; i < j; i++, j--) {
            //要交换数据, 为防止原来数据覆盖后消失, 先缓存一份
            int temp = arr1[i];
            //然后再开始交换:
            arr1[i] = arr1[j];
            arr1[j] = temp;
        }
        //输出结果:
        for (int i = 0; i < arr1.length; i++) {
            System.out.print(arr1[i] + " ");
        }

    }
}
