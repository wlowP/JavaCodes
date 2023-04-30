package wlow01._4_array;

//二维数组. 数组里面存数组.
public class _3_0_2DArray {
    public static void main(String[] args) {
        //可以初始化时赋值:
        int[][] arr = {null, {77, 33, 88}, {25, 45, 65}, {11, 66, 99}};
        //也可以以后赋值
        arr[0] = new int[]{22, 66, 44};
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            int sum1 = 0;
            for (int i1 = 0; i1 < arr[i].length; i1++) {
                sum1 += arr[i][i1];
            }
            sum += sum1;
            System.out.println("第" + (i+1) + "季度营业额:" + sum1);
        }
        System.out.println("全年营业额:" + sum);
    }
}
