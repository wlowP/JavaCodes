package wlow01_java_basic._4_array;

public class _1_2_DynamicInitial {
    //动态初始化. 只指定数组的长度.
    public static void main(String[] args) {
        String[] arr1 = new String[50];
        arr1[0] = "樱岛麻衣";
        arr1[1] = "梓川咲太";
        System.out.println(arr1[0]); //--
        System.out.println(arr1[1]); //--
        System.out.println(arr1[2]); //null

    }
}
