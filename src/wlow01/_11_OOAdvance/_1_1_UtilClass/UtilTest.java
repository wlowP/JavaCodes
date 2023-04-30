package wlow01._11_OOAdvance._1_1_UtilClass;

public class UtilTest {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15};
        System.out.println(ArrayUtil.printArr(arr));

        double[] arr1 = {1,2,3,4,5,6,7,8,9,10};
        System.out.println(ArrayUtil.getAverage(arr1));
    }
}
