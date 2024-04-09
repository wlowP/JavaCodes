package wlow01_java_basic._8_string;

public class _2_1_ArrToString {
    //遍历数组, 并把数组拼接成字符串.
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20};
        System.out.println(arr2String(arr));
    }




    public static String arr2String (int[] arr){
        //*****过滤不合理数组的措施:
        if (arr == null) {
            return "null";
        } else if (arr.length == 0){
            return "[]";
        }

        //将数字直接拼接到字符串上.
        String result = "[";
        for (int i = 0; i < arr.length; i++) {
            if (i < arr.length-1){
                result = result + arr[i] + ", ";
            }else {
                result = result + arr[i] + "]";
            }
        }
        return result;
    }
}
