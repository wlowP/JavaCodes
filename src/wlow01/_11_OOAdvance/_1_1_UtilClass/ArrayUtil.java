package wlow01._11_OOAdvance._1_1_UtilClass;

public class ArrayUtil {
    //注意构造方法私有化.创建工具类的对象没有意义.
    private ArrayUtil() {}

    //打印整数数组的方法.
    public static String printArr(int[] arr){
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < arr.length; i++) {
            if (i < arr.length-1){
                sb.append(arr[i] + ", ");
            }else{
                sb.append(arr[i] + "]");
            }
        }
        return sb.toString();
    }

    //求浮点数组平均值的方法.
    public static double getAverage(double[] arr){
        float sum = 0f;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        sum /= arr.length;
        return sum;
    }
}
